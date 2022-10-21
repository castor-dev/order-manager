package com.carloscastor.ordermanager.mapper;

import com.carloscastor.ordermanager.dto.ItemDTO;
import com.carloscastor.ordermanager.entity.ItemEntity;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper implements Mapper<ItemDTO, ItemEntity>{
    @Override
    public ItemDTO fromEntityToDTO(ItemEntity entity) {
        ItemDTO dto = new ItemDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    @Override
    public ItemEntity fromDTOToEntity(ItemDTO itemDTO) {
        ItemEntity entity = new ItemEntity();
        entity.setId(itemDTO.getId());
        entity.setName(itemDTO.getName());
        return entity;
    }
}
