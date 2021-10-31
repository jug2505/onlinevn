package com.onlinevn.service;

import com.onlinevn.entity.Asset;
import com.onlinevn.exceptions.NotFoundException;
import com.onlinevn.repository.AssetRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AssetService {

    private final AssetRepository assetRepository;

    public AssetService(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    @Transactional
    public Asset createAsset(Asset asset) {
        return assetRepository.findById(asset.getId())
                .orElse(assetRepository.save(asset));
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
    public void delete(Integer id) {
        if (assetRepository.existsById(id)) {
            assetRepository.deleteById(id);
        } else {
            throw new NotFoundException();
        }
    }
}
