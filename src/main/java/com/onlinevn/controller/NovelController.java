package com.onlinevn.controller;

import com.onlinevn.entity.Novel;
import com.onlinevn.exceptions.BadRequestException;
import com.onlinevn.service.FrameService;
import com.onlinevn.service.NovelService;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController()
@RequestMapping("/novel")
public class NovelController {

    private final NovelService novelService;
    private final FrameService frameService;

    public NovelController(NovelService novelService, FrameService frameService) {
        this.novelService = novelService;
        this.frameService = frameService;
    }

    @GetMapping
    public List<Novel> list(@RequestParam(name = "genre", required = false) Integer genre) {
        if (genre != null) return novelService.readNovelsByGenre(genre);
        return novelService.readAll();
    }

    @GetMapping("{id}/frame/count")
    public Map<String, Long> frameCount(@PathVariable Integer id) {
        return new HashMap<String, Long>() {{ put("count", frameService.countByNovelId(id)); }};

    }

    @GetMapping("/count")
    public Map<String, Long> count() {
        return new HashMap<String, Long>(){{ put("count", novelService.count()); }};
    }

    @GetMapping("{id}")
    public Novel getOne(@PathVariable Integer id) {
        return novelService.readNovelById(id);
    }

    @PostMapping
    public Novel create(@RequestBody Novel novel) {
        return novelService.createNovel(novel);
    }

    @PutMapping("{id}")
    public Novel update(@PathVariable Integer id, @RequestBody Novel novel) {
        novel.setId(id);
        return novelService.updateNovel(novel);
    }

    @PatchMapping("{id}")
    public Novel patch(@PathVariable Integer id, @RequestBody Map<String, Object> fields) {
        Novel novel = novelService.readNovelById(id);

        fields.remove("id");
        fields.forEach((k,v) ->{
            Field field = ReflectionUtils.findField(Novel.class, k);
            if (field == null) throw new BadRequestException();
            field.setAccessible(true);
            ReflectionUtils.setField(field, novel, v);
        });
        return novelService.updateNovel(novel);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        novelService.delete(id);
    }

}
