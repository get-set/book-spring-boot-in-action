package com.getset.ch04.mvcconfig.controllers;

import com.getset.ch04.mvcconfig.domain.DemoObj;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 本例演示RestController。
 * Created by Kang on 2017/2/12.
 */
@RestController
@RequestMapping("/rest")
public class DemoRestController {

    @RequestMapping(value = "restobj", produces = "application/json;charset=UTF-8")
    public DemoObj obj2(DemoObj obj) {
        return obj;
    }
}
