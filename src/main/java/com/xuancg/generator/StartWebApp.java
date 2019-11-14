package com.xuancg.generator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class StartWebApp   {

	public static void main(String[] args) {
		SpringApplication.run(StartWebApp.class, args);
	}

	 

	 

}
