package com.classic.td.logger.log.service;

import com.classic.td.logger.log.domain.BugLog;
import com.classic.td.logger.log.domain.FreeLog;
import com.classic.td.logger.log.repository.BugLogRepository;
import com.classic.td.logger.log.repository.FreeLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LogService {
    final FreeLogRepository freeLogRepository;
    final BugLogRepository bugLogRepository;

    @Transactional
    public List<FreeLog> createFreeLogs(List<FreeLog> freeLogs) {
        return freeLogRepository.saveAll(freeLogs);
    }

    @Transactional
    public List<BugLog> createBugLogs(List<BugLog> freeLogs) {
        return bugLogRepository.saveAll(freeLogs);
    }
}
