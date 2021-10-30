package com.onlinevn.controller;

import com.onlinevn.entity.Frame;
import com.onlinevn.entity.Item;
import com.onlinevn.service.FrameService;
import com.onlinevn.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/frame")
public class FrameController {

    private final FrameService frameService;
    private final ItemService itemService;

    public FrameController(FrameService frameService, ItemService itemService) {
        this.frameService = frameService;
        this.itemService = itemService;
    }

    @GetMapping
    public List<Frame> list() {
        return frameService.readAll();
    }

    @GetMapping("{id}")
    public Frame getOne(@PathVariable Integer id) {
        return frameService.readFrameById(id);
    }

    @PostMapping
    public Frame create(@RequestBody Frame frame) {
        List<Item> items = new ArrayList<>();
        for (Item item: frame.getItems()) {
            items.add(itemService.createItem(item));
        }
        frame.setItems(items);
        return frameService.createFrame(frame);
    }

    @PutMapping("{id}")
    public Frame update(@PathVariable Integer id, @RequestBody Frame frame) {
        frame.setId(id);
        return frameService.updateFrame(frame);
    }

    @PatchMapping("{id}")
    public Frame addItem(@PathVariable Integer id, @RequestParam(name = "itemId") Integer itemId) {
        Frame frame = frameService.readFrameById(id);
        Item item = itemService.readItemById(itemId);
        return frameService.addItemToFrame(frame, item);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id, @RequestParam(name = "itemId", required = false) Integer itemId) {
        if (itemId == null) {
            frameService.delete(id);
        } else {
            Frame frame = frameService.readFrameById(id);
            Item item = itemService.readItemById(itemId);
            frameService.deleteItemFromFrame(frame, item);
        }
    }
}
