package com.getset.jpa.dao;

import com.getset.jpa.domain.Person;
import com.getset.jpa.support.CustomRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 自定义的Repository。
 * Created by kang on 17-2-28.
 */
public interface CustomPersonRepository extends CustomRepository<Person, Long> {

    List<Person> findByAddress(String address);

    Person findByNameAndAddress(String name, String address);

    @Query("select p from Person p where p.name= :name and p.address= :address")
    Person withNameAndAddressQuery(@Param("name")String name, @Param("address")String address);

    Person withNameAndAddressNamedQuery(String name, String address);
}
