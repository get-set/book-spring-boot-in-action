package com.getset.ch01.aop;

import java.lang.annotation.*;

/**
 * 这是拦截规则的注解.
 * Created by Kang on 2016/11/7 0007.
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String name();
}
