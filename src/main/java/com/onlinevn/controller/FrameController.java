package com.onlinevn.controller;

import com.onlinevn.entity.Frame;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/frame")
public class FrameController {

    @GetMapping
    public List<Frame> list() {
        return null;
    }

    @GetMapping("{id}")
    public Frame getOne(@PathVariable Integer id) {
        return null;
    }

    @PostMapping
    public Frame create(@RequestBody Frame frame) {
        return null;
    }

    @PutMapping("{id}")
    public Frame update(@PathVariable Integer id, @RequestBody Frame frame) {
        return null;
    }
}
