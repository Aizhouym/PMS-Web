//package com.example.pmscode.service1.impl;
//
//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.example.pmscode.dao.UserDao;
//import com.example.pmscode.entity.User;
//import com.example.pmscode.service1.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Service
//public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
//
//    @Autowired
//    private UserDao userDao;
//
//    @Override
//    public User login(User user) {
//        Map<String,Object> map=new HashMap<>();
//        map.put("username", user.getUsername());
//        List<User> userdb = userDao.selectByMap(map);
//        System.out.println(userdb);
//        return userdb.get(0);
//    }
//}
