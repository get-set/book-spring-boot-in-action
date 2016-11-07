package com.getset.ch01.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class uses function service.
 * Created by Kang on 2016/11/7 0007.
 */

// 使用@Service注解声明这个类是Spring管理的一个bean
@Service
public class UseFunctionService {

    // 使用@Autowired将FunctionService的实体Bean注入到UseFunctionService中
    @Autowired
    FunctionService functionService;

    public String sayHello(String word) {
        return functionService.sayHello(word);
    }
}
