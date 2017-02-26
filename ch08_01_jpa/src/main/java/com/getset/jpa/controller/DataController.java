package com.getset.jpa.controller;

import com.getset.jpa.dao.PersonRepository;
import com.getset.jpa.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 控制器。
 * Created by kang on 17-2-26.
 */
@RestController
public class DataController {

    @Autowired
    PersonRepository personRepository;

    // 测试保存
    @RequestMapping("/save")
    public Person save(String name, String address, Integer age) {
        Person p = personRepository.save(new Person(name, age, address));
        return p;
    }

    // 测试findByAddress
    @RequestMapping("/q1")
    public List<Person> q1(String address) {
        List<Person> list = personRepository.findByAddress(address);
        return list;
    }

    // 测试findByAddressAndName
    @RequestMapping("/q2")
    public Person q2(String name, String address) {
        Person person = personRepository.findByNameAndAddress(name, address);
        return person;
    }

    // 测试withNameAndAddressQuery
    @RequestMapping("/q3")
    public Person q3(String name, String address) {
        Person person = personRepository.withNameAndAddressQuery(name, address);
        return person;
    }

    // 测试withNameAndAddressNamedQuery
    @RequestMapping("/q4")
    public Person q4(String name, String address) {
        Person person = personRepository.withNameAndAddressNamedQuery(name, address);
        return person;
    }

    // 测试排序
    @RequestMapping("/sort")
    public List<Person> sort() {
        List<Person> people = personRepository.findAll(new Sort(Sort.Direction.ASC, "age"));
        return people;
    }

    // 测试分页
    @RequestMapping("/page")
    public Page<Person> page() {
        Page<Person> pagePeople = personRepository.findAll(new PageRequest(1,2));
        return pagePeople;
    }

}
