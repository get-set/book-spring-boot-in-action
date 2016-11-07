package com.getset.ch01.aop;

import org.springframework.stereotype.Service;

/**
 * 使用注解的被拦截类.
 * Created by Kang on 2016/11/7 0007.
 */
@Service
public class AnnotationService {
    @Action(name="注解式拦截的add操作")
    public void add() {}
}
