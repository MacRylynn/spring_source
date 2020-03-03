package com.spring.condition;

import com.spring.entity.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     *
     * @param annotationMetadata  当前类的注解信息
     * @param beanDefinitionRegistry Bean定义的注册类
     *                               把所有需要添加到容器中的bean：调用BeanDefinitionRegistry.registerBeanDefinition手动注册
     */
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        boolean blue = beanDefinitionRegistry.containsBeanDefinition("com.spring.entity.Red");
        boolean red = beanDefinitionRegistry.containsBeanDefinition("com.spring.entity.Blue");
        if (blue&&red){
            //指定Bean的定义信息
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);
            //注册一个Bean，指定Bean名
            beanDefinitionRegistry.registerBeanDefinition("rainbow",rootBeanDefinition);
        }


    }
}
