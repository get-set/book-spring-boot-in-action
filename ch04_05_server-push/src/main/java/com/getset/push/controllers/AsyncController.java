package com.getset.push.controllers;

import com.getset.push.services.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * 控制器从另外一个线程返回一个DeferredResult
 * 通过定时任务定时更新DeferredResult。
 * Created by Kang on 2017/2/21.
 */
@Controller
public class AsyncController {
    @Autowired
    PushService pushService;

    @RequestMapping("/defer")
    @ResponseBody
    public DeferredResult<String> deferredCall() {
        return pushService.getAsyncUpdate();
    }
}
