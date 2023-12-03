package com.classic.td.logger.store.repository;


import com.classic.td.logger.store.domain.NormalStoreInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NormalStoreInfoRepository extends JpaRepository<NormalStoreInfo, Integer> {
}