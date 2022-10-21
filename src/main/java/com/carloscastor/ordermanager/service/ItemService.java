package com.carloscastor.ordermanager.service;

import com.carloscastor.ordermanager.dto.ItemDTO;
import com.carloscastor.ordermanager.entity.ItemEntity;
import com.carloscastor.ordermanager.mapper.Mapper;
import com.carloscastor.ordermanager.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemService extends AbstractCRUDService<ItemEntity, ItemDTO, Integer, ItemRepository>{

    public ItemService(ItemRepository itemRepository, Mapper<ItemDTO, ItemEntity> mapper) {
        super(itemRepository, mapper);
    }
}
