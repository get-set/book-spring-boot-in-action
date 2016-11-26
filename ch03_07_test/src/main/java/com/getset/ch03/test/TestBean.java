package com.getset.ch03.test;

/**
 * Bean.
 * Created by Kang on 2016/11/26 0026.
 */
public class TestBean {
    private String content;

    public TestBean(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
