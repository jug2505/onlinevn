package com.onlinevn.controller;

import com.onlinevn.entity.Asset;
import com.onlinevn.repository.AssetRepository;
import com.onlinevn.service.AssetService;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/asset")
public class AssetController {

    private AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @GetMapping
    public List<Asset> list() {
        return assetService.readAll();
    }

    @GetMapping
    public List<Asset> getByNovelId(@RequestParam(name = "novelId") Integer novelId) {
        return assetService.readAssetsByNovelId(novelId);
    }

    @GetMapping("{id}")
    public Asset getOne(@PathVariable Integer id) {
        return assetService.readAssetById(id);
    }

    @PostMapping
    public Asset create(@RequestBody Asset asset) {
        return assetService.createAsset(asset);
    }

    @PutMapping("{id}")
    public Asset update(@PathVariable Integer id, @RequestBody Asset asset) {
        asset.setId(id);
        return assetService.updateAsset(asset);
    }
}
