package com.spring;

import com.spring.config.MainConfig;
import com.spring.entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
    public static void main(String[] args) {
        //获取bean的第一种方式，通过xml文件
        ApplicationContext xmlContext = new ClassPathXmlApplicationContext("beans.xml");
        Person xmlPerson = (Person) xmlContext.getBean("xmlperson");
        System.out.println(xmlPerson);

        //获取bean的第二种方式，通过配置类
        ApplicationContext configContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person configPerson = (Person) configContext.getBean(Person.class);
        System.out.println(configPerson);

        //根据类型获取bean的id
        String names[] = configContext.getBeanNamesForType(Person.class);
        for (String name : names) {
            System.out.println(name);
        }
    }

}
