package com.spring.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;


//自定义的过滤规则
public class MyTypeFilter implements TypeFilter {
    /**
     * @param metadataReader        读取到的当前正在扫描类的信息
     * @param metadataReaderFactory 可以获取到其他任何类信息
     * @return
     * @throws IOException
     */
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前类注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前正在扫描类的类信息(类型、实现接口等)
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取当前类资源(类的路径、文件等)
        Resource resource = metadataReader.getResource();
        //注意这里的类型是全路径：com.spring.mapper.BookDao 写过滤规则时一定需要注意
        String name = classMetadata.getClassName();
        System.out.println("-->" + name);
        if (name.contains("mapper")) {
            return true;
        }
        return false;
    }
}
