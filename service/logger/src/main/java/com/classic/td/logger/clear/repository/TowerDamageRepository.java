package com.classic.td.logger.clear.repository;

import com.classic.td.logger.clear.domain.tower.TowerDamage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TowerDamageRepository extends JpaRepository<TowerDamage, Integer> {
}