package com.getset.ch04.springmvc4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * 配置类，其中的Bean为JSP的ViewResolver，用来映射路径和实际页面的位置。
 * Created by Kang on 2016/11/27 0027.
 */
@Configuration
// @EnableWebMVC注解会开启一些默认的配置，如一些ViewResolver或者MessageConverter等。
@EnableWebMvc
@ComponentScan("com.getset.ch04.springmvc4")
public class MvcConfig {
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        // 这里的路径不是开发时的代码路径，而是运行时的代码路径
        resolver.setPrefix("/WEB-INF/classes/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }
}
