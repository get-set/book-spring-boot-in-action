package com.getset.test.controller;

import com.getset.test.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Rest测试Controller
 * Created by Kang on 2017/2/22.
 */
@Controller
public class RestController {

    @Autowired
    DemoService demoService;

    @RequestMapping(value = "/testRest", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String testRest() {
        return demoService.sayHello();
    }
}
