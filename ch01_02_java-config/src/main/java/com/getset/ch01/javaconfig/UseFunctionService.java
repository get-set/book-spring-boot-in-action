package com.getset.ch01.javaconfig;

/**
 * This class uses function service.与ch01不同的是，这里没有添加@Service和@Autowire的注解。
 * Created by Kang on 2016/11/7 0007.
 */

// 使用@Service注解声明这个类是Spring管理的一个bean

public class UseFunctionService {

    // 使用@Autowired将FunctionService的实体Bean注入到UseFunctionService中
    FunctionService functionService;

    public void setFunctionService(FunctionService functionService) {
        this.functionService = functionService;
    }

    public String sayHello(String word) {
        return functionService.sayHello(word);
    }
}
