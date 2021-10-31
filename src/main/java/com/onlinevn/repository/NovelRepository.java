package com.onlinevn.repository;

import com.onlinevn.entity.Novel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NovelRepository extends JpaRepository<Novel, Integer> {
    List<Novel> findByGenre(Integer genre);
}
