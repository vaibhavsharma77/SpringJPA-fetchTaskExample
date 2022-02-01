package com.spring.transtionsexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TranstionsExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(TranstionsExampleApplication.class, args);
	}

}
