package com.onlinevn.repository;

import com.onlinevn.entity.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssetRepository extends JpaRepository<Asset, Integer> {
    List<Asset> findByNovelId(Integer novelId);
    List<Asset> findByNovelIdAndType(Integer novelId, String type);
    List<Asset> findByType(String type);
}
