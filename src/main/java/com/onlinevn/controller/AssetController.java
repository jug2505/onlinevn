package com.onlinevn.controller;

import com.onlinevn.entity.Asset;
import com.onlinevn.service.AssetService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/asset")
public class AssetController {

    private final AssetService assetService;

    @Value("${upload.path}")
    private String uploadPath;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @GetMapping
    public List<Asset> list(@RequestParam(name = "novelId", required = false) Integer novelId,
                            @RequestParam(name = "type", required = false) String type) {

        if (novelId != null && type != null) return assetService.readAssetsByNovelIdAndType(novelId, type);
        if (novelId != null) return assetService.readAssetsByNovelId(novelId);
        if (type != null) return assetService.readAssetsByType(type);
        return assetService.readAll();
    }

    @GetMapping("{id}")
    public Asset getOne(@PathVariable Integer id) {
        return assetService.readAssetById(id);
    }

    @GetMapping("/count")
    public Map<String, Long> count() {
        return new HashMap<String, Long>(){{ put("count", assetService.count()); }};
    }

    @PostMapping
    public Asset create(@RequestBody Asset asset,
                        @RequestParam("file") MultipartFile file) throws IOException {
        if (file != null) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            asset.setFilename(resultFilename);
        }
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
