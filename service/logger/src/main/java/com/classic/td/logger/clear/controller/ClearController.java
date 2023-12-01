package com.classic.td.logger.clear.controller;

import com.classic.td.logger.clear.domain.ClearCount;
import com.classic.td.logger.clear.domain.ClearInfo;
import com.classic.td.logger.clear.service.CountService;
import com.classic.td.logger.clear.service.InfoService;
import com.classic.td.logger.config.ApiUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClearController {
    final InfoService infoService;
    final CountService countService;

    @GetMapping("/api/v1/clear/info")
    public List<ClearInfo> getClearInfo() {
        return infoService.getClearAllInfo();
    }

    @PostMapping("/api/v1/clear/info")
    public List<ClearInfo> saveClearInfos(@RequestBody List<ClearInfo> clearInfoList) {
        return infoService.saveClearInfo(clearInfoList);
    }

    @GetMapping("/api/v1/clear/count")
    public ApiUtils.ApiResult<ClearCount> getCountByUserIdAndFlag(@RequestParam String userId, @RequestParam boolean flag){
        return ApiUtils.success(countService.readByUserIdAndFlag(userId, flag));
    }
}
