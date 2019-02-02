package com.lmv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan
@EnableScheduling
@SpringBootApplication
public class BackendNApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendNApplication.class, args);
	}

}

