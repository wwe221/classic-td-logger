package com.classic.td.logger.clear.service;

import com.classic.td.logger.clear.domain.ClearInfo;
import com.classic.td.logger.clear.domain.tower.TowerDamage;
import com.classic.td.logger.clear.repository.InfoRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InfoService {
    final InfoRepository repository;
    final CountService countService;
    final TowerService towerService;

    @Transactional(readOnly = true)
    public List<ClearInfo> getClearAllInfo() {
        return repository.findAll();
    }

    @Transactional
    public List<ClearInfo> saveClearInfo(List<ClearInfo> clearInfos) {
        clearInfos.forEach(info -> {
            int version = info.getVersion();
            boolean flag = info.isFlag();
            countService.createClearCount(info.getUserId(), info.isFlag(), info.getTime());
            var towerData = info.getTowerData();
            if (StringUtils.isNotEmpty(towerData)) {
                var split1 = towerData.replaceAll("\\(", "")
                        .replaceAll("\\)", "")
                        .split(";");
                //이름1: 인덱스(int) : 데미지(int64) 로 타워데미지 테이블에 넣기
                List<TowerDamage> towerDamageList = new ArrayList<>();
                for (int i = 0; i < split1.length; i++) {
                    try {
                        var towerInfo = split1[i].split(":");
                        var name = towerInfo[0];
                        var index = Integer.parseInt(towerInfo[1]);
                        var damage = Long.parseLong(towerInfo[2]);
                        towerDamageList.add(createTowerDamage(version, flag, info.getTime(), index, damage));
                    } catch (ArrayIndexOutOfBoundsException ignored) {
                    }

                }
                var towerCounts = towerDamageList.stream()
                        .collect(Collectors.groupingBy(TowerDamage::getTowerIndex, Collectors.counting()));
                towerService.saveTowerDamages(towerDamageList);
                if (!towerCounts.isEmpty())
                    towerService.saveTowerCount(towerCounts, version, flag);
            }
        });
        return repository.saveAll(clearInfos);
    }

    private TowerDamage createTowerDamage(int version, boolean flag, LocalDateTime time, int index, Long damage) {
        return TowerDamage.builder()
                .version(version)
                .flag(flag)
                .time(time)
                .towerIndex(index)
                .damage(damage)
                .build();
    }
}