package com.getset.ch04.mvcconfig.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * 本例演示使用@ExceptionHandler处理全局异常，更人性化的将异常输出给用户。
 * Created by Kang on 2017/2/20.
 */

// 声明一个控制器advice，由于其组合了@Component注解，因此自动注册为Spring的Bean。
@ControllerAdvice
public class ExceptionHandlerAdvice {

    // @ExceptionHandler用来定义全局处理操作，value值可用于过滤拦截的条件，比如此处拦截所有的Exception。
    @ExceptionHandler(value = Exception.class)
    public ModelAndView exception(Exception exception, WebRequest request) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", exception.getMessage());
        return modelAndView;
    }

    // @ModuleAttribute注解用于将键值对添加到全局，所有注解@RequestMapping的方法可以获取到。
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "额外信息");
    }

    // 此处忽略request参数的id。
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id");
    }
}
