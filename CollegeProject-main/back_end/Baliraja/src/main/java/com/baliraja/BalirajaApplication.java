package com.baliraja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BalirajaApplication {
	public static void main(String[] args) {
		SpringApplication.run(BalirajaApplication.class, args);
	}
}