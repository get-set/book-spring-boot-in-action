package com.getset.security.controller;

import com.getset.security.domain.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 此控制器用于为首页显示准备数据。
 * Created by kang on 17-3-11.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Model model) {
        Msg msg = new Msg("测试标题", "测试内容", "额外信息，只对管理员显示。");
        model.addAttribute("msg", msg);
        return "home";
    }
}
