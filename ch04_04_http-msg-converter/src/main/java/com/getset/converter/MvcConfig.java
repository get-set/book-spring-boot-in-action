package com.getset.converter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

/**
 * 配置类，通过extendMessageConverters方法配置MessageConverter。
 * Created by Kang on 2017/2/20.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.getset.converter")
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public MyMsgConverter converter() {
        return new MyMsgConverter();
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(converter());
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/index").setViewName("/index");
//        registry.addViewController("/toUpload").setViewName("/upload");
    }

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
