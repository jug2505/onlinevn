package com.onlinevn.service;

import com.onlinevn.entity.Frame;
import com.onlinevn.entity.Item;
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
public class ItemService {

    private final AssetRepository assetRepository;
    private final ItemRepository itemRepository;
    private final FrameRepository frameRepository;
    private final NovelRepository novelRepository;

    public ItemService(AssetRepository assetRepository, ItemRepository itemRepository, FrameRepository frameRepository, NovelRepository novelRepository) {
        this.assetRepository = assetRepository;
        this.itemRepository = itemRepository;
        this.frameRepository = frameRepository;
        this.novelRepository = novelRepository;
    }

    @Transactional
    public Item createItem(Item item) {
        if (!assetRepository.existsById(item.getAssetId())) throw new NotFoundException();
        return itemRepository.findById(item.getId())
                .orElse(itemRepository.save((item)));
    }

    public Item readItemById(Integer id) {
        return itemRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public List<Item> readAll() {
        return itemRepository.findAll();
    }

    public boolean existsById(Integer id) {
        return itemRepository.existsById(id);
    }

    @Transactional
    public Item updateItem(Item item) {
        if (itemRepository.existsById(item.getId())) {
            itemRepository.save(item);
        } else {
            throw new NotFoundException();
        }
        return item;
    }

    @Transactional
    public void delete(Integer id) {
        if (itemRepository.existsById(id)) {
            Item item = itemRepository.getById(id);
            Integer novelId = assetRepository.getById(item.getAssetId()).getNovelId();
            Integer nextFrame = novelRepository.getById(novelId).getFirstFrame();
            while (nextFrame != null) {
                Frame frame = frameRepository.getById(nextFrame);
                frame.getItems().remove(item.getId());
                frameRepository.save(frame);
                nextFrame = frame.getNextFrame();
            }
            itemRepository.delete(item);

        } else {
            throw new NotFoundException();
        }
    }
}
