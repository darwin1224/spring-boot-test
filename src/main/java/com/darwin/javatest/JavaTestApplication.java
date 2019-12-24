package com.darwin.javatest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JavaTestApplication {
	public static void main(String[] args) {
		SpringApplication.run(JavaTestApplication.class, args);
	}
}
