package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // @Configuration注解表示定义一个配置类
public class CDConfig {
   /*         // 方法名heyGirl即是bean的name
    @Bean   // 将SgtPeppers注册为 SpringContext中的bean
    public User user() {
        return new User();  // CompactDisc类型的
    }
*/
    @Bean   // 将SgtPeppers注册为 SpringContext中的bean
    public UserService userService() {
        return new UserService();  // CompactDisc类型的
    }
}
