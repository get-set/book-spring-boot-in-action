package com.getset.test.controller;

import com.getset.test.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 普通控制器。
 * Created by Kang on 2017/2/22.
 */
@Controller
public class NormalController {

    @Autowired
    DemoService demoService;

    @RequestMapping("/normal")
    public String testPage(Model model) {
        model.addAttribute("msg", demoService.sayHello());
        return "page";
    }
}
