package com.exadel.axonexample.axonhouseapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AxonHouseApp {

	public static ConfigurableApplicationContext context;

	public static void main(String[] args) {
		context = SpringApplication.run(AxonHouseApp.class, args);
	}

}

