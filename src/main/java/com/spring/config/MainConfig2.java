package com.spring.config;


import com.spring.condition.LinuxCondition;
import com.spring.condition.WindowsCondition;
import com.spring.entity.Person;
import org.springframework.context.annotation.*;

//当这个注解在类上时，类中的全组件需要满足此条件才能注册
@Conditional({WindowsCondition.class})
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

    /**
     * 单实例的bean：默认在容器启动的时候创建对象
     *
     * @Lazy 懒加载：容器启动不创建对象，第一次使用（获取）bean才创建对象，并且初始化，并且只会创建一次。
     */
    @Lazy
    @Bean("lazyperson")
    public Person person1() {
        System.out.println("bean正在创建......");
        return new Person("李四", 20);
    }

    /**
     * @Condition({Condition}) ：SpringBoot底层大量使用的注解
     * 作用：当这个注解在方法上时，按照一定的条件今次那个判断，满足条件才给容器创建bean。
     * 如果系统是windows，给容器注册（“bill”），如果系统的linux，给容器注册（“linus”）
     */
    @Conditional({WindowsCondition.class})
    @Bean("bill")
    public Person person2() {
        return new Person("Bill Gates", 65);
    }

    @Conditional({LinuxCondition.class})
    @Bean("linus")
    public Person person3() {
        return new Person("Linus", 45);
    }
}
