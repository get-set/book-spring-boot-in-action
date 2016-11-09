package com.getset.ch02.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * 配置类，定义两种profile.
 * Created by Kang on 2016/11/9 0009.
 */
@Configuration
@ComponentScan("com.getset.ch02.profile")
public class ProfileConfig {

    @Bean
    @Profile("dev")
    public DemoBean devDemoBean() {
        return new DemoBean("dev profile");
    }

    @Bean
    @Profile("prd")
    public DemoBean prdDemoBean() {
        return new DemoBean("prd profile");
    }
}
