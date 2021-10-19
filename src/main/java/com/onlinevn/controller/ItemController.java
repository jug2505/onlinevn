package com.onlinevn.controller;

import com.onlinevn.entity.Item;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/item")
public class ItemController {

    @GetMapping
    public List<Item> list() {
        return null;
    }

    @GetMapping("{id}")
    public Item getOne(@PathVariable Integer id) {
        return null;
    }

    @PostMapping
    public Item create(@RequestBody Item frame) {
        return null;
    }

    @PutMapping("{id}")
    public Item update(@PathVariable Integer id, @RequestBody Item frame) {
        return null;
    }
}
