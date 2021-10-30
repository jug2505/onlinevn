package com.onlinevn.service;

import com.onlinevn.entity.Asset;
import com.onlinevn.exceptions.NotFoundException;
import com.onlinevn.repository.AssetRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AssetService {

    private AssetRepository assetRepository;

    public AssetService(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    public Asset createAsset(Asset asset) {
        return assetRepository.findById(asset.getId())
                .orElse(assetRepository.save(asset));
    }

    public List<Asset> readAssetsByNovelId(Integer novelId) {
        List<Asset> assets = assetRepository.findByNovelId(novelId);
        if (assets.isEmpty()) throw new NotFoundException();
        return assets;
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
