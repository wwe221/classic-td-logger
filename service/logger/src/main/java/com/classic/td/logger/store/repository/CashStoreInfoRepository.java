package com.classic.td.logger.store.repository;

import com.classic.td.logger.store.domain.CashStoreInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashStoreInfoRepository extends JpaRepository<CashStoreInfo, Integer> {
}