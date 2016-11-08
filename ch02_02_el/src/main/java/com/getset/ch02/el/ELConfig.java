package com.getset.ch02.el;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * 这是一个配置类，通过EL表达式注入各种不同的bean。
 * Created by Kang on 2016/11/8 0008.
 */
@Configuration
@ComponentScan("com.getset.ch02.el")
@PropertySource("classpath:/com/getset/ch02/el/test.properties")
public class ELConfig {

    // 注入普通字符串
    @Value("直接注入字符串")
    private String normal;

    // 注入操作系统属性
    @Value("#{systemProperties['os.name']}")
    private String osName;

    // 注入表达式结果
    @Value("#{T(java.lang.Math).random() * 100.0}")
    private double randomNumber;

    // 注入其他bean属性
    @Value("#{demoService.str}")
    private String str;

    // 注入文件资源
    @Value("classpath:/com/getset/ch02/el/test.txt")
    private Resource textFile;

    // 注入网址资源
    @Value("http://www.baidu.com")
    private Resource testUrl;

    // 注入配置文件信息
    @Value("${name}")
    private String name;

    @Autowired
    private Environment environment;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigure() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void outputResources() {
        try {
            System.out.println(normal);
            System.out.println(osName);
            System.out.println(randomNumber);
            System.out.println(str);
            System.out.println(IOUtils.toString(testUrl.getInputStream(), "gbk"));
            System.out.println(name);
            System.out.println(environment.getProperty("mail"));
            System.out.println(IOUtils.toString(textFile.getInputStream(), "utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
