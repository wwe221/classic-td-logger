package com.classic.td.logger.clear.service;

import com.classic.td.logger.clear.domain.ClearInfo;
import com.classic.td.logger.clear.repository.InfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InfoService {
    final InfoRepository repository;

    @Transactional(readOnly = true)
    public List<ClearInfo> getClearAllInfo(){
        return repository.findAll();
    }

    @Transactional
    public List<ClearInfo> saveClearInfo(List<ClearInfo> clearInfos){
        return repository.saveAll(clearInfos);
    }
}
