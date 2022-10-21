package com.carloscastor.ordermanager.controller;

import com.carloscastor.ordermanager.dto.ItemDTO;
import com.carloscastor.ordermanager.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("items")
public class ItemController {

    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDTO createItem(@RequestBody ItemDTO itemDTO){
        return itemService.create(itemDTO);
    }
    @GetMapping("/item-id")
    public ItemDTO retrieveItem(@PathVariable("item-id") Integer itemId){
        return itemService.findByID(itemId);
    }

    @PutMapping("/item-id")
    public ItemDTO updateItem(@PathVariable("item-id") Integer itemId, @RequestBody ItemDTO itemDTO){
        return itemService.update(itemId, itemDTO);
    }

    @DeleteMapping("/item-id")
    @ResponseStatus(HttpStatus.OK)
    public void deleteItem(@PathVariable("item-id") Integer itemId){
        itemService.delete(itemId);
    }
}
    