package com.onlinevn.repository;

import com.onlinevn.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    boolean existsByAssetId(Integer assetId);
    List<Item> findByAssetId(Integer assetId);
}
