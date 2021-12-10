package com.onlinevn.service;

import com.onlinevn.entity.Asset;
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
public class AssetService {

    private final AssetRepository assetRepository;
    private final ItemRepository itemRepository;
    private final FrameRepository frameRepository;
    private final NovelRepository novelRepository;

    public AssetService(AssetRepository assetRepository, ItemRepository itemRepository, FrameRepository frameRepository, NovelRepository novelRepository) {
        this.assetRepository = assetRepository;
        this.itemRepository = itemRepository;
        this.frameRepository = frameRepository;
        this.novelRepository = novelRepository;
    }

    @Transactional
    public Asset createAsset(Asset asset) {
        return assetRepository.save(asset);
    }

    public List<Asset> readAssetsByNovelId(Integer novelId) {
        return assetRepository.findByNovelId(novelId);
    }

    public List<Asset> readAssetsByNovelIdAndType(Integer novelId, String type) {
        return assetRepository.findByNovelIdAndType(novelId, type);
    }

    public List<Asset> readAssetsByType(String type) {
        return assetRepository.findByType(type);
    }

    public Asset readAssetById(Integer id) {
        return assetRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public List<Asset> readAll() {
        return assetRepository.findAll();
    }

    public long count() {
        return assetRepository.count();
    }

    @Transactional
    public Asset updateAsset(Asset asset) {
        if (assetRepository.existsById(asset.getId())) {
            assetRepository.save(asset);
        } else {
            throw new NotFoundException();
        }
        return asset;
    }

    @Transactional
    public void delete(Integer assetId) {
        if (assetRepository.existsById(assetId)) {
            if (itemRepository.existsByAssetId(assetId)) {
                List<Item> items = itemRepository.findByAssetId(assetId);
                Integer nextFrame = novelRepository.getById(assetRepository.getById(assetId).getNovelId()).getFirstFrame();
                while (nextFrame != null) {
                    Frame frame = frameRepository.getById(nextFrame);
                    frame.getItems().removeAll(items.stream().map(Item::getId).collect(Collectors.toList()));
                    frameRepository.save(frame);
                    nextFrame = frame.getNextFrame();
                }
                itemRepository.deleteAll(items);
            }
            assetRepository.deleteById(assetId);

        } else {
            throw new NotFoundException();
        }
    }
}
