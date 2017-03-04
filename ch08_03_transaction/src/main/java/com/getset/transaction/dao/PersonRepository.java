package com.getset.transaction.dao;

import com.getset.transaction.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 实体类的Repository。
 * Created by kang on 17-3-1.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

}
