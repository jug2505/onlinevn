package com.onlinevn.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asset")
public class AssetController {

    @GetMapping
    public List<AssetController> list() {
        return null;
    }

    @GetMapping("{id}")
    public AssetController getOne(@PathVariable Integer id) {
        return null;
    }

    @PostMapping
    public AssetController create(@RequestBody AssetController frame) {
        return null;
    }

    @PutMapping("{id}")
    public AssetController update(@PathVariable Integer id, @RequestBody AssetController frame) {
        return null;
    }
}
