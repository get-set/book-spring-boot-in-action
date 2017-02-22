package com.getset.test;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * WebApplicationInitializer是Spring提供用来配置Servlet3.0+的接口，从而实现了替代web.xml的作用。实现此接口将会自动被SpringServletContainerInitializer获取到。
 * Created by Kang on 2016/11/27 0027.
 */
public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // 新建WebApplicationContext，注册配置类，并关联当前的servletContext。
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(MvcConfig.class);
        ctx.setServletContext(servletContext);
        // 注册SpringMVC的DispatcherServlet
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
        // 开启异步方法支持
        servlet.setAsyncSupported(true);
        registerCharachterEncodingFilter(servletContext);
    }

    private void registerCharachterEncodingFilter(ServletContext aContext) {
        CharacterEncodingFilter cef = new CharacterEncodingFilter();
        cef.setForceEncoding(true);
        cef.setEncoding("UTF-8");
        aContext.addFilter("charachterEncodingFilter", cef).addMappingForUrlPatterns(null ,true, "/*");
    }
}
