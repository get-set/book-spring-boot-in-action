package com.getset.ch01.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * This is the main class.
 * Created by Kang on 2016/11/7 0007.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DiConfig.class);
        UseFunctionService useFunctionService = applicationContext.getBean(UseFunctionService.class);
        System.out.println(useFunctionService.sayHello("world"));
        applicationContext.close();
    }
}
