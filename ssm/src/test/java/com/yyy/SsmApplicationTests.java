package com.yyy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SsmApplicationTests {

	@Test
	public void contextLoads() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");

	}

}
