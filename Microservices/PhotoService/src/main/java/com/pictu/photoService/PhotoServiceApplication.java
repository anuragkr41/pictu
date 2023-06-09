package com.pictu.photoService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PhotoServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(PhotoServiceApplication.class, args);
	}


}
