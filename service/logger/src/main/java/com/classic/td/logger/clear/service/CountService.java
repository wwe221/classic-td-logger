package com.classic.td.logger.clear.service;

import com.classic.td.logger.clear.domain.ClearCount;
import com.classic.td.logger.clear.repository.CountRepository;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * The type Count service.
 */
@Service
@RequiredArgsConstructor
public class CountService {
    /**
     * The Repository.
     */
    final CountRepository repository;

    @Transactional
    public ClearCount createClearCount(String userId, boolean flag, LocalDateTime time) {
        var target = repository.findFirstByUserIdAndFlagOrderByTimeDesc(userId, flag);
        if (target == null) {
            var newClearCount = ClearCount.builder()
                    .userId(userId)
                    .flag(flag)
                    .time(time)
                    .count(1)
                    .build();
            return repository.save(newClearCount);
        } else {
            var newClearCount = ClearCount.builder()
                    .userId(userId)
                    .flag(flag)
                    .count(target.getCount() + 1)
                    .time(time)
                    .build();
            return repository.save(newClearCount);
        }
    }
}
