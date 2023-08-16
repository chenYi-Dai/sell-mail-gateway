package com.ruoyi.controller;


import com.ruoyi.dao.model.UserDto;
import com.ruoyi.vo.ResponseEntity;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/")
@Api(value = "LoginController",tags = "用户登陆")
public class LoginController {

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody UserDto dto, HttpServletRequest request){
        return ResponseEntity.builder().build();
    }


}
