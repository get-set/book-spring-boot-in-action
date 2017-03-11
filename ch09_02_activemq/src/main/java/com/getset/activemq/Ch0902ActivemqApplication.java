package com.getset.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;

/**
 * Spring Boot提供了CommandLineRunner接口，用于程序启动后执行的代码，通过重写run方法在执行。
 */
@SpringBootApplication
public class Ch0902ActivemqApplication implements CommandLineRunner {

    /**
     * 注入Spring Boot 配置好的JMSTemplate的bean。
     */
    @Autowired
    JmsTemplate jmsTemplate;

	public static void main(String[] args) {
		SpringApplication.run(Ch0902ActivemqApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
	    // 通过send方法向my-destination目的地发送Msg消息。这也会在消息代理上定义一个目的地。
		jmsTemplate.send("my-destination", new Msg());
	}
}
