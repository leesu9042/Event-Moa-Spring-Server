package com.example.eventmoa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class EventMoaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventMoaApplication.class, args);
	}

}
