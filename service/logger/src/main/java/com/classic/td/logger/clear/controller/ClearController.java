package com.classic.td.logger.clear.controller;

import com.classic.td.logger.clear.domain.ClearInfo;
import com.classic.td.logger.clear.service.InfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClearController {
    final InfoService infoService;

    @GetMapping("/api/v1/clear/info")
    public List<ClearInfo> getClearInfo() {
        return infoService.getClearAllInfo();
    }

    @PostMapping("/api/v1/clear/info")
    public List<ClearInfo> saveClearInfos(@RequestBody List<ClearInfo> clearInfoList) {
        return infoService.saveClearInfo(clearInfoList);
    }
}
