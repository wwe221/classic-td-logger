package com.classic.td.logger.sidecontent.service;

import com.classic.td.logger.sidecontent.domain.*;
import com.classic.td.logger.sidecontent.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SideContentService {
    final FishingCountRepository fishingCountRepository;
    final FishingGearPurchaseRepository fishingGearPurchaseRepository;
    final AwardBadgeRepository awardBadgeRepository;
    final CardPackUseCountRepository cardPackUseCountRepository;
    final CardPackDestroyRepository cardPackDestroyRepository;
    final MineUpgradeRepository mineUpgradeRepository;

    @Transactional
    public List<FishingCount> createFishingCountHistory(List<FishingCount> fishingCounts){
        return fishingCountRepository.saveAll(fishingCounts);
    }

    @Transactional
    public List<FishingGearPurchase> createFishingGearPurchaseHistory(List<FishingGearPurchase> fishingGearPurchases) {
        return fishingGearPurchaseRepository.saveAll(fishingGearPurchases);
    }

    @Transactional
    public List<AwardBadge> createAwardBadgeHistory(List<AwardBadge> badges) {
        return awardBadgeRepository.saveAll(badges);
    }

    @Transactional
    public List<CardPackUseCount> createCardPackUseCountHistory(List<CardPackUseCount> cardPackUseCounts) {
        return cardPackUseCountRepository.saveAll(cardPackUseCounts);
    }

    @Transactional
    public List<MineUpgrade> createMineUpgradeHistory(List<MineUpgrade> mineUpgrade) {
        return mineUpgradeRepository.saveAll(mineUpgrade);
    }

    @Transactional
    public List<CardPackDestroy> createCardPackDestroyHistory(List<CardPackDestroy> cardPackDestroys) {
        return cardPackDestroyRepository.saveAll(cardPackDestroys);
    }
}
