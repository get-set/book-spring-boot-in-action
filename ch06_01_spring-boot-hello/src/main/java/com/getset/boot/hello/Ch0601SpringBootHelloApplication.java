package com.getset.boot.hello;

import com.getset.starter.hello.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Ch0601SpringBootHelloApplication {

    @Autowired
    HelloService helloService;

    @RequestMapping("/")
    public String hello() {
        return helloService.getMsg();
    }

	public static void main(String[] args) {
		SpringApplication.run(Ch0601SpringBootHelloApplication.class, args);
	}
}
