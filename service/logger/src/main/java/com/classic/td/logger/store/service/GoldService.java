package com.classic.td.logger.store.service;

import com.classic.td.logger.store.domain.GoldAccount;
import com.classic.td.logger.store.repository.GoldAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GoldService {
    final GoldAccountRepository repository;

    public GoldAccount readByUserIdAndFlag(String userId, boolean flag) {
        return repository.findByUserIdAndFlag(userId, flag);
    }

    @Transactional
    public void updateGoldAccount(String userId, boolean flag, int changeAmount) {
        var account = readByUserIdAndFlag(userId, flag);
        account.setGold(account.getGold() + changeAmount);
    }
}
