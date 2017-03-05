package com.getset.cache.service.impl;

import com.getset.cache.dao.PersonRepository;
import com.getset.cache.domain.Person;
import com.getset.cache.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


/**
 * 服务实现类，使用@Transactional注解演示支持和不支持回滚两种情况。
 * Created by kang on 17-3-4.
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    PersonRepository personRepository;

    @Override
    // @CachePut始终缓存新增的或更新的数据到缓存，缓存名称为people，数据的key时person的id。
    @CachePut(value = "people", key = "#person.id")
    public Person save(Person person) {
        Person p = personRepository.save(person);
        System.out.println("为id/key为：" + p.getId() + "数据做了缓存。");
        return p;
    }

    @Override
    // @CacheEvict从缓存people中删除key为id的数据，由于没有指定key，则key使用参数。
    @CacheEvict(value = "people")
    public void remove(Long id) {
        System.out.println("删除了id/key为" + id + "的数据缓存。");
        personRepository.delete(id);
    }

    @Override
    // @Cacheable会首先检查缓存中是否有该数据，若无，那么将方法返回值放入缓存。
    @Cacheable(value = "people", key = "#person.id")
    public Person findOne(Person person) {
        Person p = personRepository.findOne(person.getId());
        System.out.println("为id/key为：" + p.getId() + "数据做了缓存。");
        return p;
    }
}
