package com.getset.ch03.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类。
 * Created by Kang on 2016/11/23 0023.
 */
@Configuration
public class ConditionalConfig {

    @Bean
    @Conditional(WindowCondition.class)
    public ListService windowsListService() {
        return new WindowsListService();
    }

    @Bean
    @Conditional(LinuxCondition.class)
    public ListService linuxListService() {
        return new LinuxListService();
    }
}
