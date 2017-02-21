package com.getset.push.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * 针对SSE推送请求的controller，注意contentType。
 * Created by Kang on 2017/2/21.
 */
@Controller
public class SseController {

    @RequestMapping(value = "/push", produces = "text/event-stream; charset=UTF-8")
    public @ResponseBody String push() {
        Random r = new Random();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "data: Testing --- " + r.nextInt() + "\n\n";
    }
}
