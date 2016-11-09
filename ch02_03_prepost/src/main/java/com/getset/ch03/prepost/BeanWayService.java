package com.getset.ch03.prepost;

/**
 * 这是使用@Bean的形式的Bean.
 * Created by Kang on 2016/11/9 0009.
 */
public class BeanWayService {
    public void init() {
        System.out.println("@Bean-init-method");
    }
    public BeanWayService() {
        System.out.println("BeanWayService construction.");
    }
    public void destroy() {
        System.out.println("@Bean-destroy-method");
    }
}
