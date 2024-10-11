package com.classic.td.logger.log.controller;

import com.classic.td.logger.log.domain.BugLog;
import com.classic.td.logger.log.domain.FreeLog;
import com.classic.td.logger.log.domain.MapleValley;
import com.classic.td.logger.log.service.LogService;
import com.classic.td.logger.store.domain.GoldHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LogController {
    final LogService service;

    @PostMapping("/api/v1/log")
    public Object createFreeLog(@RequestBody List<FreeLog> logs) {
        return service.createFreeLogs(logs);
    }

    @PostMapping("/api/v1/log/bug")
    public Object createBugLog(@RequestBody List<BugLog> logs) {
        return service.createBugLogs(logs);
    }

    @PostMapping("/api/v1/log/maplevalley")
    public Object createMapleValley(@RequestBody List<MapleValley> logs) {
        return service.createMapleValley(logs);
    }
}
