package com.getset.ch02.el;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试类。
 * Created by Kang on 2016/11/8 0008.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ELConfig.class);
        ELConfig el = context.getBean(ELConfig.class);
        el.outputResources();
        context.close();
    }
}
