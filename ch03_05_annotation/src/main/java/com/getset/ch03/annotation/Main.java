package com.getset.ch03.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 运行类。
 * Created by Kang on 2016/11/26 0026.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        DemoService bean = context.getBean(DemoService.class);
        bean.output();
    }
}
