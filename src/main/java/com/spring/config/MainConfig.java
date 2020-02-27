package com.spring.config;

import com.spring.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//注册bean的第二种方式：使用配置类
@Configuration  //告诉Spring这个是一个配置类
public class MainConfig {

    //给容器中注册一个bean；类型为返回值的类型，bean的id默认为这个方法名
    @Bean
    public Person person() {
        return new Person("configname", 18);
    }
}
