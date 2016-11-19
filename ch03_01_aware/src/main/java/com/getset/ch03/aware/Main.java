package com.getset.ch03.aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试类
 * Created by Kang on 2016/11/19 0019.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AwareConfig.class);
        AwareService bean = context.getBean(AwareService.class);
        bean.outputResult();
        context.close();
    }
}
