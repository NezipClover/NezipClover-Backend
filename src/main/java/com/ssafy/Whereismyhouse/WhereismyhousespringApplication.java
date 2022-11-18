package com.ssafy.Whereismyhouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ssafy"})
@EnableCaching 
public class WhereismyhousespringApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhereismyhousespringApplication.class, args);
	}

}
