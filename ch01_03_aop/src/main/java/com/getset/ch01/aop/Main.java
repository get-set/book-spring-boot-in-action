package com.getset.ch01.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试类.
 * Created by Kang on 2016/11/8 0008.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        AnnotationService annotationService = context.getBean(AnnotationService.class);
        MethodService methodService = context.getBean(MethodService.class);
        annotationService.add();
        methodService.add();
        context.close();
    }
}
