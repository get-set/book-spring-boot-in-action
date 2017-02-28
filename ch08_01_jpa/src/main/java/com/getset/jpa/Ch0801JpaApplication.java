package com.getset.jpa;

import com.getset.jpa.dao.PersonRepository;
import com.getset.jpa.support.CustomRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// 在配置类上指定自定义的RepositoryFactoryBeanClass。
// 如果不需要自定义的RepositoryFactoryBeanClass，则无需@EnableJpaRepositories，因为@EnableJpaRepositories里包含的@EnableAutoConfiguration注解已经开启了对Spring Data JPA的支持。
@EnableJpaRepositories(repositoryFactoryBeanClass = CustomRepositoryFactoryBean.class)
public class Ch0801JpaApplication {

    @Autowired
    PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(Ch0801JpaApplication.class, args);
	}
}
