package com.classic.td.logger.clear;

import com.classic.td.logger.clear.domain.ClearInfo;
import com.classic.td.logger.clear.repository.InfoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class ClearInfoRepositoryTest {

    @Autowired
    private InfoRepository clearInfoRepository;

    @Test
    public void testCreate() {
        ClearInfo clearInfo = createSampleClearInfo();
        ClearInfo savedClearInfo = clearInfoRepository.save(clearInfo);
        assertNotNull(savedClearInfo.getId());
    }

    @Test
    public void testRead() {
        ClearInfo clearInfo = createSampleClearInfo();
        ClearInfo savedClearInfo = clearInfoRepository.save(clearInfo);

        Optional<ClearInfo> retrievedClearInfo = clearInfoRepository.findById(savedClearInfo.getId());
        assertTrue(retrievedClearInfo.isPresent());
    }

    @Test
    public void testUpdate() {
        ClearInfo clearInfo = createSampleClearInfo();
        ClearInfo savedClearInfo = clearInfoRepository.save(clearInfo);

        ClearInfo updatedClearInfo = clearInfoRepository.findById(savedClearInfo.getId()).orElse(null);
        assertNotNull(updatedClearInfo);

        updatedClearInfo.setNickName("Updated Nick");
        clearInfoRepository.save(updatedClearInfo);

        ClearInfo checkUpdatedClearInfo = clearInfoRepository.findById(savedClearInfo.getId()).orElse(null);
        assertNotNull(checkUpdatedClearInfo);
        assertEquals("Updated Nick", checkUpdatedClearInfo.getNickName());
    }

    @Test
    public void testDelete() {
        ClearInfo clearInfo = createSampleClearInfo();
        ClearInfo savedClearInfo = clearInfoRepository.save(clearInfo);

        clearInfoRepository.deleteById(savedClearInfo.getId());
        assertFalse(clearInfoRepository.existsById(savedClearInfo.getId()));
    }

    private ClearInfo createSampleClearInfo() {
        return ClearInfo.builder()
            .version(1)
            .flag(true)
            .userId("testUser")
            .nickName("Test Nick")
            .roadType(1)
            .modeType(2)
            .difficult(3)
            .point(100L)
            .totalIngameGold(500)
            .towerData("Sample Tower Data")
            .week(1)
            .day(5)
            .time(LocalDateTime.now())
            .build();
    }
}