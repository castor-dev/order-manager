package com.carloscastor.ordermanager.service;

import com.carloscastor.ordermanager.common.OrderStatus;
import com.carloscastor.ordermanager.dto.ItemQuantityDTO;
import com.carloscastor.ordermanager.dto.OrderDTO;
import com.carloscastor.ordermanager.entity.*;
import com.carloscastor.ordermanager.mapper.Mapper;
import com.carloscastor.ordermanager.repository.OrderRepository;
import com.carloscastor.ordermanager.repository.OrderStockMovementRepository;
import com.carloscastor.ordermanager.repository.StockMovementRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class OrderService extends AbstractCRUDService<OrderEntity, OrderDTO, Integer, OrderRepository> {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);
    private EmailService emailService;
    private StockMovementRepository stockMovementRepository;
    private OrderStockReportService orderStockReport;
    private UserService userService;

    public OrderService(OrderRepository orderRepository, Mapper<OrderDTO, OrderEntity> mapper, EmailService emailService, StockMovementRepository stockMovementRepository, OrderStockReportService orderStockReport, UserService userService) {
        super(orderRepository, mapper);
        this.emailService = emailService;
        this.stockMovementRepository = stockMovementRepository;
        this.orderStockReport = orderStockReport;
        this.userService = userService;
    }

    @Override
    public OrderDTO create(OrderDTO dto) {
        dto.setStatus(OrderStatus.PENDING);
        dto.setCreationDate(LocalDateTime.now());
        OrderDTO orderDTO = super.create(dto);
        return processOrder(orderDTO);
    }

    public OrderDTO processOrder(OrderDTO orderDTO){
        List<StockMovementEntity> availableStock = findAvailableStock(orderDTO.getItemQuantity());
        if(!CollectionUtils.isEmpty(availableStock)){
            Integer remainingOrderQuantity = orderDTO.getItemQuantity().getQuantity();
            for (StockMovementEntity stockMovement : availableStock) {
                Integer stockItemQuantity = stockMovement.getStockMovementItemQuantity();
                int diff = stockItemQuantity - remainingOrderQuantity;
                if(diff < 0){
                    Integer stockMovementItemQuantity = stockMovement.getStockMovementItemQuantity();
                    stockMovement.setStockMovementItemQuantity(0);
                    remainingOrderQuantity = -1*diff;
                    stockMovementRepository.save(stockMovement);
                    orderStockReport.registerOrderStockConsumption(orderDTO.getId(), stockMovement.getId(), stockMovementItemQuantity, orderDTO.getItemQuantity().getQuantity());
                }else{
                    stockMovement.setStockMovementItemQuantity(diff);
                    stockMovementRepository.save(stockMovement);
                    orderStockReport.registerOrderStockConsumption(orderDTO.getId(), stockMovement.getId(), remainingOrderQuantity,  orderDTO.getItemQuantity().getQuantity());
                    break;
                }
            }
            orderDTO.setStatus(OrderStatus.COMPLETED);
            LOGGER.info(String.format("Order %s completed", orderDTO.getId()));
            OrderEntity orderEntity = getRepository().save(getMapper().fromDTOToEntity(orderDTO));
            sendOrderCompletionEmail(orderEntity);
            orderDTO = getMapper().fromEntityToDTO(orderEntity);
        }

        return orderDTO;
    }

    public void processPendingOrders() {
        List<OrderEntity> pendingOrders = getRepository().findOrderByStatus(OrderStatus.PENDING);

        OrderStatus status;
        for (OrderEntity order : pendingOrders){
            OrderDTO pendingOrder = getMapper().fromEntityToDTO(order);
            OrderDTO orderDTO = processOrder(pendingOrder);
            status = orderDTO.getStatus();
            if(OrderStatus.PENDING.equals(status)){
                break;
            }
        }
    }


    public List<StockMovementEntity> findAvailableStock(ItemQuantityDTO itemQuantity) {
        List<StockMovementEntity> stockItems = Collections.emptyList();
        Integer availableItemsCount = stockMovementRepository.getAvailableStock(itemQuantity.getItemId());
        if (Objects.nonNull(availableItemsCount) && itemQuantity.getQuantity() <= availableItemsCount) {
            stockItems =stockMovementRepository.findBAvailableStock(itemQuantity.getItemId());
        }
        return stockItems;
    }

    private void sendOrderCompletionEmail(OrderEntity order){

        UserEntity createdBy = order.getCreatedBy();
        String email = createdBy.getEmail();
        String name = createdBy.getName();
        StringBuffer subjectStringBuffer = new StringBuffer();;
        subjectStringBuffer.append("Order ");
        subjectStringBuffer.append(order.getId());
        subjectStringBuffer.append(" completed");
        String subject = subjectStringBuffer.toString();

        String itemName = order.getOrderItem().getName();
        Integer orderItemQuantity = order.getOrderItemQuantity();
        String text = String.format("Hi %s, \n Your order for %s unit for the item %s is now completed.", name, orderItemQuantity, itemName);
        emailService.sendEmail(email, subject, text);

    }
}
