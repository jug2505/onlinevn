package com.onlinevn.controller;

import com.onlinevn.entity.Novel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController()
@RequestMapping("/novel")
public class NovelController {

    @GetMapping
    public List<Novel> list() {
        return null;
    }

    @GetMapping("{id}")
    public Novel getOne(@PathVariable Integer id) {
        return null;
    }

    @PostMapping
    public Novel create(@RequestBody Novel novel) {
        return novel;
    }

    @PutMapping("{id}")
    public Novel update(@PathVariable Integer id, @RequestBody Novel novel) {
        return novel;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {

    }

}
