package com.carloscastor.ordermanager.mapper;

import com.carloscastor.ordermanager.dto.ItemQuantityDTO;
import com.carloscastor.ordermanager.dto.StockMovementDTO;
import com.carloscastor.ordermanager.entity.ItemEntity;
import com.carloscastor.ordermanager.entity.StockMovementEntity;
import com.carloscastor.ordermanager.exception.OMNotFoundException;
import com.carloscastor.ordermanager.repository.ItemRepository;
import org.springframework.stereotype.Component;

@Component
public class StockMovementMapper implements Mapper<StockMovementDTO, StockMovementEntity> {

    private ItemRepository itemRepository;

    public StockMovementMapper(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public StockMovementDTO fromEntityToDTO(StockMovementEntity entity) {
        StockMovementDTO dto = new StockMovementDTO();
        dto.setId(entity.getId());
        ItemEntity stockMovementItem = entity.getStockMovementItem();
        ItemEntity itemEntity = itemRepository.findById(stockMovementItem.getId()).orElseThrow(() -> new OMNotFoundException("Item not found"));
        ItemQuantityDTO itemQuantityDTO = new ItemQuantityDTO();
        itemQuantityDTO.setItemId(itemEntity.getId());
        itemQuantityDTO.setQuantity(entity.getStockMovementItemQuantity());
        entity.setCreationDate(entity.getCreationDate());
        return dto;
    }

    @Override
    public StockMovementEntity fromDTOToEntity(StockMovementDTO stockMovementDTO) {
        StockMovementEntity entity = new StockMovementEntity();
        entity.setId(stockMovementDTO.getId());
        entity.setCreationDate(stockMovementDTO.getCreationDate());
        ItemQuantityDTO itemQuantity = stockMovementDTO.getItemQuantity();
        ItemEntity itemEntity = itemRepository.findById(itemQuantity.getItemId()).orElseThrow(() -> new OMNotFoundException("Item not found"));
        entity.setStockMovementItem(itemEntity);
        entity.setStockMovementItemQuantity(itemQuantity.getQuantity());

        return entity;
    }
}
