package com.ruoyi.service;

import com.ruoyi.dao.model.UserDto;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    UserDto userByName( String name);

    void userAdd(UserDto userDto);

    void deleteUser(Long id);

    void updateUser(UserDto userDto);
}
