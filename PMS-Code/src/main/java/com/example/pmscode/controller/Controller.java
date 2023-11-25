package com.example.pmscode.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.pmscode.Utils.JwtUtils;
import com.example.pmscode.domain.User;

import com.example.pmscode.mapper.UserMapper;
import com.example.pmscode.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class Controller {

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;


    public User query(String username, String password){
        List<User> jun = userMapper.selectByUsernameAndPassword(username, password);
        if (jun.isEmpty()){
            return null;
        }
        return jun.get(0);
    }
    @GetMapping("/user/login")
    public Map<String,Object> login(User user)
    {
        HashMap<String, Object> map = new HashMap<>();

        User query_result = query(user.getUsername(), user.getPassword());

        if (query_result != null){

            logger.info("登陆成功");
            map.put("msg", "登录成功");
            map.put("code", 200);

            HashMap<String, String> payload = new HashMap<>();

            payload.put("name",query_result.getUsername());

            String token = JwtUtils.getToken(payload);

            map.put("token", token);
        }
        else {
            map.put("msg", "登录失败");
            map.put("code", 404);
        }

        return map;
    }
//
    @PostMapping("/test/verity")
    public  Map<String,String> verityToken(String token)
    {
        Map<String, String> map=new HashMap<>();

        map.put("msg","验证成功");
        map.put("code","200");

        return map;
    }


}
