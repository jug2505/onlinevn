package com.onlinevn.controller;

import com.onlinevn.entity.Frame;
import com.onlinevn.entity.Novel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/novel")
public class NovelController {

    // Тестовые поля ////
    private List<Novel> novels = new ArrayList<Novel>() {{
        add(new Novel("Name1", "Description1", 1, 1, 12, null));
    }};

    private List<Frame> frames = new ArrayList<Frame>() {{
        add(new Frame(novels.get(0).getId(), 1, "Text1", "Name1", null, null, null));
    }};
    ////////////////////////


    @GetMapping
    public List<Novel> list() {

        return novels;
    }

    @GetMapping("{id}")
    public Novel getOne(@PathVariable Integer id) {
        return novels.get(0);
    }

    @PostMapping
    public Novel create(@RequestBody Novel novel) {
        novels.add(novel);
        return novel;
    }

    @PutMapping("{id}")
    public Novel update(@PathVariable Integer id, @RequestBody Novel novel) {
        Novel novelFromDb = novels.get(0);
        return novel;
    }


}
