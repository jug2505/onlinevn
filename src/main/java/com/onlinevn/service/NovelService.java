package com.onlinevn.service;

import com.onlinevn.entity.Frame;
import com.onlinevn.entity.Novel;
import com.onlinevn.exceptions.NotFoundException;
import com.onlinevn.repository.FrameRepository;
import com.onlinevn.repository.NovelRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class NovelService {
    private final NovelRepository novelRepository;

    public NovelService(NovelRepository novelRepository) {
        this.novelRepository = novelRepository;
    }

    @Transactional
    public Novel createNovel(Novel novel) {
        return novelRepository.findById(novel.getId())
                .orElse(novelRepository.save(novel));
    }

    public List<Novel> readAll() {
        return novelRepository.findAll();
    }

    public Novel readNovelById(Integer id) {
        return novelRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public List<Novel> readNovelsByGenre(Integer genre) {
        return novelRepository.findByGenre(genre);
    }

    @Transactional
    public Novel updateNovel(Novel novel) {
        if (novelRepository.existsById(novel.getId())) {
            novelRepository.save(novel);
        } else {
            throw new NotFoundException();
        }
        return novel;
    }

    @Transactional
    public void delete(Integer id) {
        if (novelRepository.existsById(id)) {
            novelRepository.deleteById(id);
        } else {
            throw new NotFoundException();
        }
    }
}
