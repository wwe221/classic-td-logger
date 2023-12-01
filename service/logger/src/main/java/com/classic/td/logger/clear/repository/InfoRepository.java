package com.classic.td.logger.clear.repository;

import com.classic.td.logger.clear.domain.ClearInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InfoRepository extends JpaRepository<ClearInfo, Integer> {
    List<ClearInfo> findByFlag(boolean flag);
}