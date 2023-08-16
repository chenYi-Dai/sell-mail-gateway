package com.ruoyi.dao;

import com.ruoyi.dao.mapper.SystemLogMapper;
import com.ruoyi.dao.mapper.UserMapper;
import com.ruoyi.dao.model.SystemLogDto;
import com.ruoyi.dao.model.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Slf4j
@Repository
public class SystemLogDao {

    @Resource
    private SystemLogMapper systemLogMapper;

    public void add(SystemLogDto dto){
        systemLogMapper.add(dto);
    }

}
