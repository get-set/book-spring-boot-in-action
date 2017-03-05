package com.getset.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Ch0804CacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ch0804CacheApplication.class, args);
	}
}
