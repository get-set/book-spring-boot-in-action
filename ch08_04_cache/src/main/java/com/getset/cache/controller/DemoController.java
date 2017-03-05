package com.getset.cache.controller;

import com.getset.cache.domain.Person;
import com.getset.cache.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试回滚和不回滚的情况。
 * Created by kang on 17-3-4.
 */
@RestController
public class DemoController {

    @Autowired
    DemoService demoService;

    @RequestMapping("/put")
    public Person cacheput(Person person) {
        return demoService.save(person);
    }

    @RequestMapping("/able")
    public Person cacheable(Person person) {
        return demoService.findOne(person);
    }

    @RequestMapping("/evict")
    public String cacheevict(Long id) {
        demoService.remove(id);
        return "OK";
    }
}
