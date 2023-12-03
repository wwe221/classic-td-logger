package com.classic.td.logger.store.service;

import com.classic.td.logger.store.domain.GoldHistory;
import com.classic.td.logger.store.repository.GoldHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GoldService {
    final GoldHistoryRepository repository;

    public List<GoldHistory> readByUserIdAndFlag(String userId, boolean flag) {
        return repository.findByUserIdAndFlagOrderByTimeDesc(userId, flag);
    }

    @Transactional
    public List<GoldHistory> createGoldHistory(List<GoldHistory> history) {
        return repository.saveAll(history);
    }
}
