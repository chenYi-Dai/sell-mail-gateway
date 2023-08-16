package com.ruoyi.service.impl;

import com.ruoyi.dao.SystemLogDao;
import com.ruoyi.dao.model.SystemLogDto;
import com.ruoyi.service.SystemLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class SystemLogServiceImpl implements SystemLogService {
    @Resource
    private SystemLogDao systemLogDao;

    @Override
    public void add(SystemLogDto dto) {
        systemLogDao.add(dto);
    }
}
