package com.classic.td.logger.log.repository;

import com.classic.td.logger.log.domain.FreeLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreeLogRepository extends JpaRepository<FreeLog, Integer> {
}