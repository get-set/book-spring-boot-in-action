package com.getset.ch02.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 运行类。
 * Created by Kang on 2016/11/9 0009.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.getEnvironment().setActiveProfiles("dev");
        context.getEnvironment().setActiveProfiles("prd");
        context.register(ProfileConfig.class);
        context.refresh();
        DemoBean bean = context.getBean(DemoBean.class);
        System.out.println(bean.getContent());
        context.close();
    }
}
