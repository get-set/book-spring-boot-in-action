package com.getset.ch04.mvcconfig.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller.
 * Created by Kang on 2016/11/27 0027.
 */
// @Controller注解声明一个控制器
@Controller
public class HelloController {
    // 配置URL和方法之间的映射
    @RequestMapping("/index")
    public String hello() {
        return "index";
    }
}
