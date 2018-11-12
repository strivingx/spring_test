package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@SpringBootApplication
// @ImportResource("classpath:aa.xml")
 @RestController
public class TransactionApplication {

	/**
	 * 照样会从Spring容器中DI注入值进来
	 */

	@Autowired
	private UserService userService;


	public static void main(String[] args) {
		SpringApplication.run(TransactionApplication.class, args);
	}

	@RequestMapping("/abc")
	@ResponseBody
	public String test() {
		userService.test();
		return "1";
	}

}
