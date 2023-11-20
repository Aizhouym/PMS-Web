package com.example.pmscode;

import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.example.pmscode.dao.UserDao;
import com.example.pmscode.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PmsCodeApplicationTests {

	@Autowired
	private UserDao userDao;

	@Test
	public void testSelect() {
		System.out.println(("----- selectAll method test ------"));
		List<User> userList = userDao.selectList(null);
//		Assert.isTrue(5 == userList.size(), "");
		userList.forEach(System.out::println);
	}

}
