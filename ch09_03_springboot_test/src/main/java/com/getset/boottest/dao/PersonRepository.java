package com.getset.boottest.dao;

import com.getset.boottest.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * 数据访问接口类。
 * Created by kang on 17-2-26.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

    // 使用方法名查询
    List<Person> findByAddress(String address);

    // 使用方法名查询，基于两个查询条件
    Person findByNameAndAddress(String name, String address);

    // 使用@Query查询，参数按照名称绑定
    @Query("select p from Person p where p.name= :name and p.address= :address")
    Person withNameAndAddressQuery(@Param("name") String name, @Param("address") String address);

    // 使用@NamedQuery查询，在实体类中已经做了配置
    Person withNameAndAddressNamedQuery(String name, String address);
}
