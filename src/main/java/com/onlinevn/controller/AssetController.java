package com.onlinevn.controller;

import com.onlinevn.entity.Asset;
import com.onlinevn.service.AssetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/asset")
public class AssetController {

    private final AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @GetMapping
    public List<Asset> list(@RequestParam(name = "novelId", required = false) Integer novelId) {
        assetService.createAsset(new Asset(1, "1", "1", 1));

        List<Asset> result;
        if (novelId != null) {
            result = assetService.readAssetsByNovelId(novelId);
        } else {
            result = assetService.readAll();
        }
        return result;
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

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        assetService.delete(id);
    }
}
