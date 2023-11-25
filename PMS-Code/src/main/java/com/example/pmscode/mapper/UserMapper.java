package com.example.pmscode.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.example.pmscode.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author linux
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-11-24 11:08:29
* @Entity com.example.pmscode.domain.User
*/
public interface UserMapper extends BaseMapper<User> {

    int insertSelective(User user);

    List<User> selectByUsernameAndId(@Param("username") String username, @Param("id") Long id);

    List<User> selectByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}




