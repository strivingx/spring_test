package com.yyy;

import com.yyy.service.UserService;
import com.yyy.service.XMLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@EnableTransactionManagement
@SpringBootApplication
//@ImportResource("classpath:spring-mybatis.xml")
@ImportResource("classpath:aa.xml") // 导入外部xml配置
// @RestController
@Controller // 表示为controller类
// @RestController == @Controller + @ResponseBody
public class SsmApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsmApplication.class, args);
	}

	@Autowired // 根据类型注入
	@Resource // 根据名称注入
	private XMLService	xmlService;
	@Autowired
	private UserService userService;

	@RequestMapping("/xml")
	@ResponseBody // 表示返回的结果直接放入body中
	public String testXMLConfig(){
		return xmlService.test();
	}

	@RequestMapping("/xml1")
	@ResponseBody // 表示返回的结果直接放入body中
	public String testXMLConfig1(){
		return xmlService.test();
	}

	@RequestMapping(value = "/transaction")
	@ResponseBody // 表示返回的结果直接放入body中
	public String testTransaction(Boolean isOpenTransaction){
		if(isOpenTransaction) {
			userService.testWithTransaction();
		} else {
			userService.testWithoutTransaction();
		}
		return "transaction";
	}

	@GetMapping(value = "/index")
	public String index(){
		return "index";
	}

}
