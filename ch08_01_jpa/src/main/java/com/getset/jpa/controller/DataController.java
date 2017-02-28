package com.getset.jpa.controller;

import com.getset.jpa.dao.CustomPersonRepository;
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

    @Autowired
    CustomPersonRepository customPersonRepository;

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

    /**
     * 基于自定义Repository，接受一个Person对象person。
     * 当person的name有值时，会自动对name进行like查询；
     * 当person的age有值时，会进行等于查询；
     * 当person中有多个值不为空时，会自动构造多个查询条件；
     * 当person所有值为空时，默认查询出所有的记录。
     * @param person
     * @return
     */
    @RequestMapping("/auto")
    public Page<Person> auto(Person person) {
        Page<Person> pagePeople = customPersonRepository.findByAuto(person, new PageRequest(0, 10));
        return pagePeople;
    }

}
