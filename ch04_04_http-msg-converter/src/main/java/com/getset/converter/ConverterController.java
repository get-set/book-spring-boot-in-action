package com.getset.converter;

import com.getset.converter.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ConverterController.
 * 测试时使用RestClient发送请求，contentType为“application/x-wisely”，data为“123-zhangsan”。
 * Created by Kang on 2017/2/21.
 */
@Controller
public class ConverterController {

    @RequestMapping(value = "/converter", produces = {"application/x-wisely"})
    public @ResponseBody DemoObj convert(@RequestBody DemoObj obj) {
        return obj;
    }
    @RequestMapping(value = "/hello")
    public @ResponseBody String hello() {
        return "Hello";
    }
}
