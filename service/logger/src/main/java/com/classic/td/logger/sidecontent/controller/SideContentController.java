package com.classic.td.logger.sidecontent.controller;

import com.classic.td.logger.sidecontent.domain.*;
import com.classic.td.logger.sidecontent.service.SideContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SideContentController {
    final SideContentService service;

    @PostMapping("/api/v1/fish/count")
    public Object createFishingCount(@RequestBody List<FishingCount> fishCounts) {
        return service.createFishingCountHistory(fishCounts);
    }

    @PostMapping("/api/v1/fish/purchase")
    public Object purchaseFishingCount(@RequestBody List<FishingGearPurchase> purchases) {
        return service.createFishingGearPurchaseHistory(purchases);
    }

    @PostMapping("/api/v1/award/badge")
    public Object createAwardBadgeHistory(@RequestBody List<AwardBadge> badges) {
        return service.createAwardBadgeHistory(badges);
    }

    @PostMapping("/api/v1/cardpack/use")
    public Object createCardPackUse(@RequestBody List<CardPackUseCount> cards) {
        return service.createCardPackUseCountHistory(cards);
    }

    @PostMapping("/api/v1/mine/upgrade")
    public Object createMineUpgrade(@RequestBody List<MineUpgrade> mineUpgrades) {
        return service.createMineUpgradeHistory(mineUpgrades);
    }
}
