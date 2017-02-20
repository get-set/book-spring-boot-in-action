package com.getset.ch04.mvcconfig.controllers;

import com.getset.ch04.mvcconfig.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 演示advice的控制器。
 * Created by Kang on 2017/2/20.
 */

@Controller
public class AdviceController {

    @RequestMapping("/advice")
    public String doSthWrong(@ModelAttribute("msg") String msg, DemoObj obj) {
        throw new IllegalArgumentException("非常抱歉，参数有误。 来自@ModelAttribute" + msg + "，id=" + obj.getId() + "&name=" + obj.getName());
    }
}
