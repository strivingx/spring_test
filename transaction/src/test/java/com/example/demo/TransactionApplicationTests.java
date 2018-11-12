package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
// @Import(CDConfig.class)
@ImportResource(locations={"classpath:aa.xml"})
public class TransactionApplicationTests {

	/**
	 * 照样会从Spring容器中DI注入值进来
	 */
	@Resource
	private UserService userService;

	@Test
	public void contextLoads() {
		userService.test();
	}

}
