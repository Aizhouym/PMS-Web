package com.example.pmscode;


import com.example.pmscode.Utils.JwtUtils;
import com.example.pmscode.domain.User;
import com.example.pmscode.mapper.UserMapper;
import com.example.pmscode.service.UserService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
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

	@Test
	public void test2(){
		System.out.println(("----- selectAll method test ------"));
		List<User> jun = userMapper.selectByUsernameAndId("jun", 1L);

	}

	public User query(String username, String password){
		List<User> jun = userMapper.selectByUsernameAndPassword(username, password);
		if (jun.isEmpty()){
			return null;
		}
		return jun.get(0);
	}

	@Test
	public void login(){

		HashMap<String, Object> map = new HashMap<>();

		User query_result = query("jun", "123");

		if (query_result != null){
			map.put("msg", "登录成功");
			map.put("code", 200);

			HashMap<String, String> payload = new HashMap<>();

			payload.put("name",query_result.getUsername());

			String token = JwtUtils.getToken(payload);

			map.put("token", token);
		}
	}



}
