package com.spring.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

//自定义逻辑，返回需要导入的组件
public class MyImportSelector implements ImportSelector {
    /**
     * @param annotationMetadata 当前标注@Import注解的类的所有注解信息，在这里就是MainConfig2类中的三个注解:Conditional、Configuration、Import
     * @return 返回值就是要导入到容器中的组件全类名
     * eg：通过这个方法，将Blue、Yellow、Red添加到组件中
     */
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        //不能返回一个null，否则会报控制真异常
        return new String[]{"com.spring.entity.Red", "com.spring.entity.Blue", "com.spring.entity.Yellow"};
    }
}
