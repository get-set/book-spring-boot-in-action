package com.getset.ch03.prepost;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 这是使用JSR250形式的Bean.
 * Created by Kang on 2016/11/9 0009.
 */
public class JSR250WayService {
    @PostConstruct
    public void init() {
        System.out.println("JSR250-init-method");
    }
    public JSR250WayService() {
        System.out.println("JSR250WayService construction.");
    }
    @PreDestroy
    public void destroy() {
        System.out.println("JSR250-destroy-method");
    }
}
