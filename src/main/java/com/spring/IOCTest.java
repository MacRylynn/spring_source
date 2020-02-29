package com.spring;

import com.spring.config.MainConfig;
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
}
