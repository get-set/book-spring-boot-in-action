package com.getset.ch03.taskscheduler;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 执行类。
 * Created by Kang on 2016/11/22 0022.
 */
public class Main {
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(TaskSchedulerConfig.class);
    }
}
