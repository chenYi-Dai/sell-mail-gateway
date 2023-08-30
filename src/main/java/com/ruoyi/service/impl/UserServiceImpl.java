package com.ruoyi.service.impl;

import com.ruoyi.dao.UserDao;
import com.ruoyi.dao.model.UserDto;
import com.ruoyi.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public UserDto userByName(String name) {
        return userDao.userDetail(name);
    }

    @Override
    public void userAdd(UserDto userDto) {
        userDao.addUser(userDto);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteUserById(id);
    }

    @Override
    public void updateUser(UserDto userDto) {
        userDao.updateUser(userDto);
    }

    @Override
    public void queryList() {
        userDao.queryList();
    }
}
