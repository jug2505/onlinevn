package com.onlinevn.controller;

import com.onlinevn.entity.Item;
import com.onlinevn.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> list() {
        itemService.createItem(new Item(1, 12, 12, 1));
        return itemService.readAll();
    }

    @GetMapping("{id}")
    public Item getOne(@PathVariable Integer id) {
        return itemService.readItemById(id);
    }

    @PostMapping
    public Item create(@RequestBody Item item) {
        return itemService.createItem(item);
    }

    @PutMapping("{id}")
    public Item update(@PathVariable Integer id, @RequestBody Item item) {
        item.setId(id);
        return itemService.updateItem(item);
    }
}
