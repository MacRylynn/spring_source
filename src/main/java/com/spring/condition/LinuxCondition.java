package com.spring.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

//判断是否Linux系统 要成为判断条件，必须实现Condition接口
public class LinuxCondition implements Condition {
    /**
     * @param conditionContext      判断条件能使用的上下文（环境）
     * @param annotatedTypeMetadata 当前标注了Conditional注解的注释信息
     * @return
     */
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //判断是否Linux系统
        //1. 能获取到ioc当前使用到的bean工厂
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        //2. 获取类加载器
        ClassLoader classLoader = conditionContext.getClassLoader();
        //3. 获取当前环境信息
        Environment environment = conditionContext.getEnvironment();
        //4. 获取到bean定义的注册类
        BeanDefinitionRegistry registry = conditionContext.getRegistry();
        //判断容器中是否包含某一个bean,即bean的注册情况
        boolean scopeperson = registry.containsBeanDefinition("scopeperson");

        String property = environment.getProperty("os.name");
        if (property.contains("Linux")) {
            return true;
        }
        return false;
    }
}
