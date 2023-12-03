package com.classic.td.logger.sidecontent.repository;

import com.classic.td.logger.sidecontent.domain.FishingCount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FishingCountRepository extends JpaRepository<FishingCount, Integer> {
}