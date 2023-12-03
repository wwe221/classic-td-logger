package com.classic.td.logger.sidecontent.service;

import com.classic.td.logger.sidecontent.domain.FishingCount;
import com.classic.td.logger.sidecontent.domain.FishingGearPurchase;
import com.classic.td.logger.sidecontent.repository.FishingCountRepository;
import com.classic.td.logger.sidecontent.repository.FishingGearPurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SideContentService {
    final FishingCountRepository fishingCountRepository;
    final FishingGearPurchaseRepository fishingGearPurchaseRepository;

    @Transactional
    public List<FishingCount> createFishingCountHistory(List<FishingCount> fishingCounts){
        return fishingCountRepository.saveAll(fishingCounts);
    }

    @Transactional
    public List<FishingGearPurchase> createFishingGearPurchaseHistory(List<FishingGearPurchase> fishingGearPurchases) {
        return fishingGearPurchaseRepository.saveAll(fishingGearPurchases);
    }
}
