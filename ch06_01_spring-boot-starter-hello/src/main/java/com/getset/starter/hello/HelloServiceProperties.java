package com.getset.starter.hello;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 属性配置类。
 * Created by Kang on 2017/2/23.
 */
@ConfigurationProperties(prefix = "hello")
public class HelloServiceProperties {
    private static final String MSG = "world";

    private String msg = MSG;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
