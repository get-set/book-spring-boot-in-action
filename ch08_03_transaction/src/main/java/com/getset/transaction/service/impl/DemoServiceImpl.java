package com.getset.transaction.service.impl;

import com.getset.transaction.dao.PersonRepository;
import com.getset.transaction.domain.Person;
import com.getset.transaction.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * 服务实现类，使用@Transactional注解演示支持和不支持回滚两种情况。
 * Created by kang on 17-3-4.
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    PersonRepository personRepository;


    @Override
    @Transactional(rollbackOn = {IllegalArgumentException.class})
    public Person savePersonWithRollBack(Person person) {
        Person p = personRepository.save(person);
        if(person.getName().equals("张三")) {
            throw new IllegalArgumentException("张三已存在，数据将回滚。");
        }
        return p;
    }

    @Override
    @Transactional(dontRollbackOn = {IllegalArgumentException.class})
    public Person savePersonWithoutRollBack(Person person) {
        Person p = personRepository.save(person);
        if(person.getName().equals("张三")) {
            throw new IllegalArgumentException("张三已存在，数据将回滚。");
        }
        return p;
    }
}
