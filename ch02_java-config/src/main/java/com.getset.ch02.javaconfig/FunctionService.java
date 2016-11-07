package com.getset.ch02.javaconfig;

/**
 * 这是一个功能类，跟ch01不同的是没有用@Service注解.
 * Created by Kang on 2016/11/7 0007.
 */

public class FunctionService {
    public String sayHello(String word) {
        return "Hello, " + word + " !";
    }
}
