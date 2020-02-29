package com.spring.config;

import com.spring.entity.Person;
import com.spring.service.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

//注册bean的第二种方式：使用配置类
@Configuration  //告诉Spring这个是一个配置类

//第二种扫描包的方式，示例1
//@ComponentScan(value = "com.spring",excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class, Service.class})})
//第二种扫描包的方式，示例2
@ComponentScan(value = "com.spring", includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
//        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookService.class}),
        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})}, useDefaultFilters = false)
/**@ComponentScan  value指定要扫描的包
 * excludeFilter = Filter[] 需要排除的,示例1中表示排除@Controller和@Service的组件
 * includeFilter = Filter[] 指定需要包含的,示例2中表示只包含@Controller组件、BookService相关类的所有组件、自定义过滤的组件当MyTypeFilter返回false的时候就过滤掉，返回true就不过滤
 * FilterType.ANNOTATION：按照注解过滤
 * FilterType.ASSIGNABLE_TYPE：按照给定的类型过滤
 * FilterType.ASPECTJ：按照ASPECTJ表达式
 * FilterType.REGEX：按照正则表达式
 * FilterType.CUSTOM：按照自定义规则，自定义规则必须是TypeFilter的实现类
 * **/
public class MainConfig {
    //给容器中注册一个bean；类型为返回值的类型，bean的id默认为这个方法名
    @Bean("configperson")
    public Person person() {
        return new Person("configname", 18);
    }
}
