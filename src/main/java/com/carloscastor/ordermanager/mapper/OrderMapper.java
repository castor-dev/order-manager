package com.carloscastor.ordermanager.mapper;

import com.carloscastor.ordermanager.dto.ItemQuantityDTO;
import com.carloscastor.ordermanager.dto.OrderDTO;
import com.carloscastor.ordermanager.entity.OrderEntity;
import com.carloscastor.ordermanager.exception.OMNotFoundException;
import com.carloscastor.ordermanager.repository.ItemRepository;
import com.carloscastor.ordermanager.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper implements Mapper<OrderDTO, OrderEntity> {

    private UserRepository userRepository;
    private ItemRepository itemRepository;

    public OrderMapper(UserRepository userRepository, ItemRepository itemRepository) {
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public OrderDTO fromEntityToDTO(OrderEntity entity) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(entity.getId());
        ItemQuantityDTO itemQuantityDTO = new ItemQuantityDTO();
        itemQuantityDTO.setItemId(entity.getOrderItem().getId());
        itemQuantityDTO.setQuantity(entity.getOrderItemQuantity());
        orderDTO.setItemQuantity(itemQuantityDTO);
        orderDTO.setCreatedBy(entity.getCreatedBy().getId());
        orderDTO.setStatus(entity.getOrderStatus());
        orderDTO.setCreationDate(entity.getCreationDate());
        return orderDTO;
    }

    @Override
    public OrderEntity fromDTOToEntity(OrderDTO orderDTO) {
        OrderEntity entity = new OrderEntity();
        entity.setId(orderDTO.getId());
        entity.setOrderStatus(orderDTO.getStatus());
        entity.setCreationDate(orderDTO.getCreationDate());
        ItemQuantityDTO itemQuantity = orderDTO.getItemQuantity();
        entity.setOrderItemQuantity(itemQuantity.getQuantity());
        entity.setOrderItem(itemRepository.findById(itemQuantity.getItemId()).orElseThrow(() -> new OMNotFoundException("Item Not Found")));
        entity.setCreatedBy(userRepository.findById(orderDTO.getCreatedBy()).orElseThrow(() -> new OMNotFoundException("User Not Found")));
        return entity;
    }
}
