package com.getset.ch02.el;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 被注入的bean.
 * Created by Kang on 2016/11/8 0008.
 */
@Service
public class DemoService {

    @Value("这是一段普通的字符串。")
    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
