package com.pictu.iam.iamService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IamServiceApplication {
    /*
    This service is reponsible for authentication and authorization of the User
    We will have role based authentication along with JWT
     */
    public static void main(String[] args) {
        SpringApplication.run(IamServiceApplication.class, args);
    }
}
