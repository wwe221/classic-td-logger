package com.classic.td.logger.sidecontent.controller;

import com.classic.td.logger.sidecontent.domain.FishingCount;
import com.classic.td.logger.sidecontent.domain.FishingGearPurchase;
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
}
