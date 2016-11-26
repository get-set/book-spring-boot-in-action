package com.getset.ch03.annotation;

import org.springframework.stereotype.Service;

/**
 * 测试用的Service。
 * Created by Kang on 2016/11/26 0026.
 */
@Service
public class DemoService {
    public void output() {
        System.out.println("使用组合注解获得的Bean");
    }
}
