package com.spring.config;


import com.spring.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MainConfig2 {
    /**
     * @Scope 调整作用域
     * prototype:多实例的:ioc容器启动不会调用创建对象的方法，每次获取的时候才会调用创建对象的方法，并且每次获取对象都会调用。
     * singleton:单实例的（默认值）：ioc容器启动就会调用创建对象的方法，将对象放进IOC容器中，以后使用就是直接从容器(map.get())取到。
     * request:同一个请求创建一个实例(WEB环境下)
     * session:同一个session创建一个实例(WEB环境下)
     */
    @Scope("prototype")
    //默认是单实例的
    @Bean("scopeperson")
    public Person person() {
        System.out.println("bean正在创建......");
        return new Person("张三", 20);
    }
}
