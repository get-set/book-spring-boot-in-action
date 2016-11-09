package com.getset.ch02.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 这是一个事件监听者。
 * Created by Kang on 2016/11/9 0009.
 */
@Component
public class DemoEventListener implements ApplicationListener<DemoEvent> {

    @Override
    public void onApplicationEvent(DemoEvent demoEvent) {
        System.out.println("Msg received: " + demoEvent.getMsg());
    }
}
