package com.spring;

import com.spring.config.MainConfig;
import com.spring.config.MainConfig2;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest {

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
        Object bean= applicationContext.getBean("scopeperson");
        Object bean2= applicationContext.getBean("scopeperson");
        System.out.println(bean==bean2);
    }
}
