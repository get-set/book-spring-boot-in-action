package com.getset.ch02.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Test scope of spring beans.
 * Created by Kang on 2016/11/8 0008.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

        SingletonService singleton1= context.getBean(SingletonService.class);
        SingletonService singleton2= context.getBean(SingletonService.class);
        System.out.println(singleton1 == singleton2);

        PrototypeService prototype1 = context.getBean(PrototypeService.class);
        PrototypeService prototype2 = context.getBean(PrototypeService.class);
        System.out.println(prototype1 == prototype2);
    }
}
