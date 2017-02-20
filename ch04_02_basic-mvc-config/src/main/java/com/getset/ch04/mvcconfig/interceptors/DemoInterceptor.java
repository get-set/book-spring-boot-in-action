package com.getset.ch04.mvcconfig.interceptors;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 本拦截器的业务含义为计算每一次请求的处理时长。
 * Created by Kang on 2017/2/20.
 */
public class DemoInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long endTime = System.currentTimeMillis();
        long startTime = (long)request.getAttribute("startTime");
        request.removeAttribute("startTime");
        System.out.println("本次请求处理时长为：" + new Long(endTime - startTime) + "ms");
        request.setAttribute("Handling time", endTime - startTime);
    }
}
