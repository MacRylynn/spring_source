package com.spring.config;


import com.spring.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MainConfig2 {
    /**
     * @Scope
     * prototype:多实例的
     * singleton:单实例的
     * request:同一个请求创建一个实例(WEB环境下)
     * session:同一个session创建一个实例(WEB环境下)
     */
    @Scope("prototype")
    //默认是单实例的
    @Bean("scopeperson")
    public Person person() {
        return new Person("张三", 20);
    }
}
