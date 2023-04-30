package com.pictu.iam.iamService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class IamServiceApplication {
    /*
    This service is reponsible for authentication and authorization of the User
    We will have role based authentication along with JWT
     */
    public static void main(String[] args) {
        SpringApplication.run(IamServiceApplication.class, args);
    }

}
