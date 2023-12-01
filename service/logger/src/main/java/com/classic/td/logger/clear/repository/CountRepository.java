package com.classic.td.logger.clear.repository;

import com.classic.td.logger.clear.domain.ClearCount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountRepository extends JpaRepository<ClearCount, Integer> {
    ClearCount findByUserIdAndFlag(String userId, boolean flag);
}