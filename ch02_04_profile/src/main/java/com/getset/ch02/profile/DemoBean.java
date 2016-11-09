package com.getset.ch02.profile;

/**
 * 该Bean在使用不同的profile时生成不同的对象。
 * Created by Kang on 2016/11/9 0009.
 */
public class DemoBean {
    private String content;

    public DemoBean(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
