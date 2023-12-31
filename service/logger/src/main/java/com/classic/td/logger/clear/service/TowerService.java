package com.classic.td.logger.clear.service;

import com.classic.td.logger.clear.domain.tower.TowerCount;
import com.classic.td.logger.clear.domain.tower.TowerDamage;
import com.classic.td.logger.clear.repository.TowerCountRepository;
import com.classic.td.logger.clear.repository.TowerDamageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TowerService {
    final TowerDamageRepository damageRepository;
    final TowerCountRepository countRepository;

    @Transactional
    public void saveTowerDamages(List<TowerDamage> towerDamageList) {
        damageRepository.saveAll(towerDamageList);
    }

    @Transactional
    public TowerCount getTowerCount(int version, boolean flag, int index, int diff) {
        var target = countRepository.findByVersionAndFlagAndTowerIndexAndDifficult(version, flag, index, diff);
        if (target == null) {
            var newTowerCount = TowerCount.builder()
                    .createCount(0)
                    .flag(flag)
                    .version(version)
                    .towerIndex(index)
                    .difficult(diff)
                    .build();
            return countRepository.save(newTowerCount);
        }
        return target;
    }

    @Transactional
    public void saveTowerCount(Map<Integer,Long> countMap, int version, boolean flag, int diff) {
        countMap.forEach((index, count) -> {
            var towerCnt = getTowerCount(version, flag, index, diff);
            towerCnt.setCreateCount(towerCnt.getCreateCount() + count.intValue());
        });
    }
}
