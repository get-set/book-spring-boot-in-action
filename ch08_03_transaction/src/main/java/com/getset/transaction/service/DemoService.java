package com.getset.transaction.service;

import com.getset.transaction.domain.Person;

/**
 * 业务接口。
 * Created by kang on 17-3-4.
 */
public interface DemoService {
    Person savePersonWithRollBack(Person person);
    Person savePersonWithoutRollBack(Person person);
}
