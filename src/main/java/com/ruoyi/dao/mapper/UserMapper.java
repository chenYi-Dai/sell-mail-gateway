package com.ruoyi.dao.mapper;

import com.ruoyi.dao.model.UserDto;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.formula.functions.T;

public interface UserMapper extends BaseMapper<T>{

    UserDto userByName(@Param("name") String name);

    void userAdd(UserDto userDto);

    void deleteUser(@Param("id") Long id);

    void updateUser(UserDto userDto);
}
