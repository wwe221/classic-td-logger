package com.classic.td.logger.store.service;

import com.classic.td.logger.store.domain.CashStoreInfo;
import com.classic.td.logger.store.domain.NormalStoreInfo;
import com.classic.td.logger.store.repository.CashStoreInfoRepository;
import com.classic.td.logger.store.repository.NormalStoreInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {
    final NormalStoreInfoRepository normalStoreRepository;
    final CashStoreInfoRepository cashStoreRepository;

    @Transactional
    public List<NormalStoreInfo> createStoreInfoLog(List<NormalStoreInfo> normalStoreInfo) {
        return normalStoreRepository.saveAll(normalStoreInfo);
    }

    @Transactional
    public List<CashStoreInfo> createCashStoreInfoLog(List<CashStoreInfo> cashStoreInfo) {
        return cashStoreRepository.saveAll(cashStoreInfo);
    }
}
