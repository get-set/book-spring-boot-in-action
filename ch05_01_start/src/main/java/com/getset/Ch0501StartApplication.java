package com.getset;

import com.getset.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @SpringBootApplication是Spring Boot项目的核心注解，主要目的是开启自动配置。
@SpringBootApplication
public class Ch0501StartApplication {

    @Value("${custom.env}")
    private String env;

    @Value("${custom.author}")
    private String author;

    @Autowired
    private Student student;

	@RequestMapping("/")
    String index() {
	    return "Hello, " + this.author + " of " + this.env + "\n\n"
                + "[student] id:" + student.getId() + " name:" + student.getName();
    }

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Ch0501StartApplication.class);
//        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
	}
}
