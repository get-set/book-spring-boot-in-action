package com.getset.ch02.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Kang on 2016/11/9 0009.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);
        DemoPublisher publisher = context.getBean(DemoPublisher.class);
        publisher.publish("Time to go to bed ...");
        context.close();
    }
}
