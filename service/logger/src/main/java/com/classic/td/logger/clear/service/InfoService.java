package com.classic.td.logger.clear.service;

import com.classic.td.logger.clear.domain.ClearInfo;
import com.classic.td.logger.clear.domain.tower.TowerDamage;
import com.classic.td.logger.clear.repository.InfoRepository;
import lombok.RequiredArgsConstructor;
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
            /*  info 를 받아서
            ~~1. clearCount 를 저장한다.~~
            towerData 를 파싱해서
                2. tower Damage를 저장한다.
                3. towerCount 를 저장한다.
            4. clearInfo 를 저장한다.
            * */
            int version = info.getVersion();
            boolean flag = info.isFlag();
            countService.createClearCount(info.getUserId(), info.isFlag(), info.getTime());
            var towerData = info.getTowerData();
            var split1 = towerData.replaceAll("\\(", "")
                    .replaceAll("\\)", "")
                    .split(";");
            //이름1: 인덱스(int) : 데미지(int64) 로 타워데미지 테이블에 넣기
            List<TowerDamage> towerDamageList = new ArrayList<>();
            for (int i = 0; i < split1.length; i++) {
                var towerInfo = split1[i].split(":");
                var name = towerInfo[0];
                var index = Integer.parseInt(towerInfo[1]);
                var damage = Long.parseLong(towerInfo[2]);
                towerDamageList.add(createTowerDamage(version, flag, info.getTime(), index, damage));
            }
            var towerCounts = towerDamageList.stream()
                    .collect(Collectors.groupingBy(TowerDamage::getTowerIndex, Collectors.counting()));
            towerService.saveTowerDamages(towerDamageList);
            towerService.saveTowerCount(towerCounts, version, flag);
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
