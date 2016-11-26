package com.getset.ch03.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * 配置类，使用profile切换不同的环境。
 * Created by Kang on 2016/11/26 0026.
 */
@Configuration
public class TestConfig {
    @Bean
    @Profile("dev")
    public TestBean devTestBean() {
        return new TestBean("dev env.");
    }
    @Bean
    @Profile("prd")
    public TestBean prdTestBean() {
        return new TestBean("prd env.");
    }
}
