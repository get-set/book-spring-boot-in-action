package com.getset.ch03.conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 运行类。
 * Created by Kang on 2016/11/24 0024.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionalConfig.class);
        ListService listService = context.getBean(ListService.class);
        System.out.println(listService.showListCmd());
    }
}
