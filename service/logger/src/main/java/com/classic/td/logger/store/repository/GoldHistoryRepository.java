package com.classic.td.logger.store.repository;

import com.classic.td.logger.store.domain.GoldHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoldHistoryRepository extends JpaRepository<GoldHistory, Integer> {
    List<GoldHistory> findByUserIdAndFlagOrderByTimeDesc(String userId, boolean flag);
}