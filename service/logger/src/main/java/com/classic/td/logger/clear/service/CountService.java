package com.classic.td.logger.clear.service;

import com.classic.td.logger.clear.domain.ClearCount;
import com.classic.td.logger.clear.repository.CountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


    /**
     * Read by user id and flag clear count.
     * if not exist, create a new one
     *
     * @param userId the user id
     * @param flag   the flag
     * @return the clear_count
     */
    public ClearCount readByUserIdAndFlag(String userId, boolean flag) {
        var target = repository.findByUserIdAndFlag(userId, flag);
        if (target == null) {
            var newClearCount = ClearCount.builder()
                    .userId(userId)
                    .flag(flag)
                    .count(0)
                    .build();
            return repository.save(newClearCount);
        }
        return target;
    }

    @Transactional
    public void increaseClearCount(String userId, boolean flag) {
        var targetClearCount = readByUserIdAndFlag(userId, flag);
        targetClearCount.setCount(targetClearCount.getCount() + 1);
    }
}
