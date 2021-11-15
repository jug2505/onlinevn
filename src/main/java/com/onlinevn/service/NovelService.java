package com.onlinevn.service;

import com.onlinevn.entity.Frame;
import com.onlinevn.entity.Item;
import com.onlinevn.entity.Novel;
import com.onlinevn.exceptions.NotFoundException;
import com.onlinevn.repository.AssetRepository;
import com.onlinevn.repository.FrameRepository;
import com.onlinevn.repository.ItemRepository;
import com.onlinevn.repository.NovelRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NovelService {
    private final AssetRepository assetRepository;
    private final ItemRepository itemRepository;
    private final FrameRepository frameRepository;
    private final NovelRepository novelRepository;

    public NovelService(AssetRepository assetRepository, ItemRepository itemRepository, FrameRepository frameRepository, NovelRepository novelRepository) {
        this.assetRepository = assetRepository;
        this.itemRepository = itemRepository;
        this.frameRepository = frameRepository;
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
            Novel novel = novelRepository.getById(id);
            Integer nextFrame = novel.getFirstFrame();
            while (nextFrame != null) {
                Frame frame = frameRepository.getById(nextFrame);
                List<Integer> itemsIds = frame.getItems();
                for (Integer itemId : itemsIds) {
                    itemRepository.findById(itemId).ifPresent(item -> assetRepository.deleteById(item.getAssetId()));
                    itemRepository.deleteById(itemId);
                }
                nextFrame = frame.getNextFrame();
                frameRepository.delete(frame);
            }
            novelRepository.delete(novel);
        } else {
            throw new NotFoundException();
        }
    }
}
