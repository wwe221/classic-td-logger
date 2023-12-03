package com.classic.td.logger.store.controller;

import com.classic.td.logger.store.domain.CashStoreInfo;
import com.classic.td.logger.store.domain.GoldHistory;
import com.classic.td.logger.store.domain.NormalStoreInfo;
import com.classic.td.logger.store.service.GoldService;
import com.classic.td.logger.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StoreController {
    final GoldService goldService;
    final StoreService storeService;

    @GetMapping("/api/v1/gold/history")
    public Object getGoldHistory(@RequestParam String userId, @RequestParam boolean flag) {
        return goldService.readByUserIdAndFlag(userId, flag);
    }

    @PostMapping("/api/v1/gold/history")
    public Object createGoldHistory(@RequestBody List<GoldHistory> history) {
        return goldService.createGoldHistory(history);
    }

    @PostMapping("/api/v1/store/normal")
    public Object createNormalStoreHistory(@RequestBody List<NormalStoreInfo> history) {
        return storeService.createStoreInfoLog(history);
    }

    @PostMapping("/api/v1/store/cash")
    public Object createCashStoreHistory(@RequestBody List<CashStoreInfo> history) {
        return storeService.createCashStoreInfoLog(history);
    }
}
