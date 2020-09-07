package com.jp.messaging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AzureServiceBusProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AzureServiceBusProducerApplication.class, args);
	}

}
