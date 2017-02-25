package com.getset.websocket;

/**
 * 服务器反馈浏览器的消息类。
 * Created by Kang on 2017/2/25.
 */
public class MyResponse {
    private String responseMessage;
    public MyResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }
    public String getResponseMessage() {
        return responseMessage;
    }
}
