package com.classic.td.logger.clear.repository;

import com.classic.td.logger.clear.domain.tower.TowerCount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TowerCountRepository extends JpaRepository<TowerCount, Integer> {
    TowerCount findByVersionAndFlagAndTowerIndex(Integer version, boolean flag, Integer towerIndex);

}