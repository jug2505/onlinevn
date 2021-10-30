package com.onlinevn.service;

import com.onlinevn.entity.Item;
import com.onlinevn.exceptions.NotFoundException;
import com.onlinevn.repository.AssetRepository;
import com.onlinevn.repository.ItemRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final AssetRepository assetRepository;

    public ItemService(ItemRepository itemRepository, AssetRepository assetRepository) {
        this.itemRepository = itemRepository;
        this.assetRepository = assetRepository;
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
            itemRepository.deleteById(id);
        } else {
            throw new NotFoundException();
        }
    }
}
