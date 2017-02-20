package com.getset.ch04.mvcconfig.controllers;

import com.getset.ch04.mvcconfig.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 本例用于演示各种不同的注解应用方法
 * Created by Kang on 2017/2/12.
 */
@Controller
@RequestMapping("/anno")
public class DemoAnnoController {

    // 此方法没有给出路径，表示使用类级别路径。produces可以定制返回的response的类型和字符集
    @RequestMapping(produces="text/plain;charset=UTF-8")
    public @ResponseBody String index(HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access.";
    }

    @RequestMapping(value = "/pathvar/{str}", produces="text/plain;charset=UTF-8")
    public @ResponseBody String pathvar(@PathVariable String str, HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access. str:" + str;
    }

    @RequestMapping(value = "/param", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String passParam(Long id, HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access. id:" + id;
    }

    @RequestMapping(value = "obj1", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String obj1(DemoObj obj, HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access. id: " + obj.getId() + " name: " + obj.getName();
    }

    @RequestMapping(value = "obj2", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public DemoObj obj2(DemoObj obj) {
        return obj;
    }

    @RequestMapping(value = {"/name1", "/name2"}, produces = "text/plain;charset=UTF-8")
    public @ResponseBody String remove(HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access.";
    }

}
