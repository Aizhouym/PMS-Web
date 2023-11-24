package com.example.pmscode;


import com.example.pmscode.domain.User;
import com.example.pmscode.mapper.UserMapper;
import com.example.pmscode.service.UserService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PmsCodeApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private UserMapper userMapper;

	@Test
	public void testSelect() {
		System.out.println(("----- selectAll method test ------"));
		List<User> jun = userMapper.selectByUsernameAndId("jun", 1L);

		System.out.println(jun);

	}



}
