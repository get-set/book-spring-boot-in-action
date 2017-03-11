package com.getset.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ch0902RabbitmqApplication implements CommandLineRunner {

	@Autowired
	RabbitTemplate rabbitTemplate;

	public static void main(String[] args) {
		SpringApplication.run(Ch0902RabbitmqApplication.class, args);
	}

    @Override
    public void run(String... strings) throws Exception {
        rabbitTemplate.convertAndSend("my-queue", "来自rabbitMQ的消息。");
    }

    @Bean
    public Queue myQueue() {
	    return new Queue("my-queue");
    }
}
