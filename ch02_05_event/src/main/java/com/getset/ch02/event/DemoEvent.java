package com.getset.ch02.event;

import org.springframework.context.ApplicationEvent;

/**
 * 这是一个事件类。
 * Created by Kang on 2016/11/9 0009.
 */
public class DemoEvent extends ApplicationEvent {
    private String msg;
    public DemoEvent(String msg) {
        super(msg);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
