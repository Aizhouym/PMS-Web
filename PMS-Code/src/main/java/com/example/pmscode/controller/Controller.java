package com.example.pmscode.controller;

import com.example.pmscode.domain.User;

import com.example.pmscode.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

public class Controller {

    @Autowired
    private UserService userService;

    @GetMapping("/user/login")
    public Map<String,Object> login(User user)
    {

        Map<String,Object> map=new HashMap<>();
        try {
            userService.login(user);
            map.put("msg","登录成功");
            map.put("code","200");
        }
        catch (Exception ex)
        {
            map.put("msg","登录失败");
        }

        return map;
    }


}
