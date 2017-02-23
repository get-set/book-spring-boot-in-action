package com.getset.starter.hello;

/**
 * 判断依据类。
 * Created by Kang on 2017/2/23.
 */
public class HelloService {
    private String msg;

    public String sayHello() {
        return "Hello, " + msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
