package com.ruoyi.dao.mapper;

import com.ruoyi.dao.model.SystemLogDto;
import com.ruoyi.dao.model.UserDto;
import org.apache.ibatis.annotations.Param;

public interface SystemLogMapper {


    void add(SystemLogDto systemLogDto);

}
