package com.spring;

import com.spring.config.MainConfig;
import com.spring.config.MainConfig2;
import com.spring.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

public class IOCTest {


    //包扫描测试
    @Test
    public void test1() {
        //第二种包扫描的方式
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        //找到容器中所有bean定义的名字
        String beanNames[] = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }

    //测试组件作用域
    @Test
    public void test2() {
        //第二种包扫描的方式
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        //找到容器中所有bean定义的名字
        String beanNames[] = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
        //在默认单实例的情况下，两个bean是相同的,当作用域设置为多实例的情况下两个bean就不相同了
        Object bean = applicationContext.getBean("lazyperson");
        Object bean2 = applicationContext.getBean("lazyperson");
        System.out.println(bean == bean2);
    }

    //按照条件注册bean测试
    @Test
    public void test3() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String names[] = applicationContext.getBeanNamesForType(Person.class);
        //动态获取获取当前环境的值
        ConfigurableEnvironment environment = ((AnnotationConfigApplicationContext) applicationContext).getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);
        for (String name : names) {
            System.out.println(name);
        }
        Map<String, Person> map = applicationContext.getBeansOfType(Person.class);
        System.out.println(map);
    }

}
