package com.example.pmscode.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.pmscode.domain.User;
import com.example.pmscode.service.UserService;
import com.example.pmscode.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author linux
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-11-24 11:08:29
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Override
    public User login(User user) {
        return null;
    }
}




