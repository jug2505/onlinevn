package com.onlinevn.repository;

import com.onlinevn.entity.Novel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NovelRepository extends JpaRepository<Novel, Integer> {
}
