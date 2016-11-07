package com.getset.ch01.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 配置类.
 * Created by Kang on 2016/11/8 0008.
 */
@Configuration
@ComponentScan("com.getset.ch01.aop")
@EnableAspectJAutoProxy
public class AopConfig {
}
