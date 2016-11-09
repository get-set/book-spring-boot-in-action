package com.getset.ch03.prepost;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 运行类.
 * Created by Kang on 2016/11/9 0009.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PrePostConfig.class);
        BeanWayService wayService = context.getBean(BeanWayService.class);
        JSR250WayService jsr250WayService = context.getBean(JSR250WayService.class);
        context.close();
    }
}
