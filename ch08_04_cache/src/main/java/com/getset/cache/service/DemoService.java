package com.getset.cache.service;


import com.getset.cache.domain.Person;

/**
 * 业务接口。
 * Created by kang on 17-3-4.
 */
public interface DemoService {
    Person save(Person person);
    void remove(Long id);
    Person findOne(Person person);
}
