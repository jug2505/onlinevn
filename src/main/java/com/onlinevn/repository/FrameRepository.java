package com.onlinevn.repository;

import com.onlinevn.entity.Frame;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FrameRepository extends JpaRepository<Frame, Integer> {
    List<Frame> findByNovelId(Integer novelId);
    long countByNovelId(Integer novelId);
}
