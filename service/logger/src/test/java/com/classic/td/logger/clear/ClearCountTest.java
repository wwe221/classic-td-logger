package com.classic.td.logger.clear;
import com.classic.td.logger.clear.domain.ClearCount;
import com.classic.td.logger.clear.repository.CountRepository;
import com.classic.td.logger.clear.service.CountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class ClearCountTest {

    @Autowired
    private CountService countService;

    @Autowired
    private CountRepository countRepository;

    @Test
    public void testCreateClearCount() {
        String userId = "testUser";
        boolean flag = true;

        ClearCount clearCount = countService.readByUserIdAndFlag(userId, flag);

        assertNotNull(clearCount);
        assertEquals(userId, clearCount.getUserId());
        assertTrue(clearCount.isFlag());
        assertEquals(0, clearCount.getCount());
    }

    @Test
    @Transactional
    public void testIncreaseClearCount() {
        String userId = "testUser";
        boolean flag = true;

        ClearCount clearCountBefore = countService.readByUserIdAndFlag(userId, flag);
        int beforeCnt = clearCountBefore.getCount();
        // Increase count
        countService.increaseClearCount(userId, flag);

        ClearCount clearCountAfter = countRepository.findByUserIdAndFlag(userId, flag);

        assertNotNull(clearCountBefore);
        assertNotNull(clearCountAfter);
        assertEquals(beforeCnt + 1, clearCountAfter.getCount());
    }
}

