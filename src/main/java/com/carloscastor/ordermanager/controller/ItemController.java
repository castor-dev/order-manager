package com.carloscastor.ordermanager.controller;

import com.carloscastor.ordermanager.dto.ItemDTO;

public interface ItemController {

    void createItem(ItemDTO item);
    ItemDTO retrieveItem(Integer itemId);
    void updateItem(Integer itemId, ItemDTO item);
    void deleteItem(Integer itemId);
}
