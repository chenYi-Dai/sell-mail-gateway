package com.ruoyi.dao;

import com.ruoyi.dao.mapper.UserMapper;
import com.ruoyi.dao.model.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Repository
public class UserDao {

    @Resource
    private UserMapper userMapper;

    @Resource
    private ProductCategoryDao categoryDao;

    public void addUser(UserDto dto){
        userMapper.userAdd(dto);
    }

    public void deleteUserById(Long id){
        userMapper.deleteUser(id);
    }

    public void updateUser(UserDto dto){
        userMapper.updateUser(dto);
    }

    public UserDto userDetail(String  name){
        return userMapper.userByName(name);
    }

    public void queryList(){
        List<T> ts = userMapper.queryList();
        log.info("result | {}",ts);
        categoryDao.queryList();
    }
}
