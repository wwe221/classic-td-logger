package com.classic.td.logger.store.repository;

import com.classic.td.logger.store.domain.GoldAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoldAccountRepository extends JpaRepository<GoldAccount, Integer> {
    GoldAccount findByUserIdAndFlag(String userId, boolean flag);
}