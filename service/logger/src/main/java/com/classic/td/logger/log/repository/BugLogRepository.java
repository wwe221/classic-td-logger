package com.classic.td.logger.log.repository;

import com.classic.td.logger.log.domain.BugLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BugLogRepository extends JpaRepository<BugLog, Integer> {
}