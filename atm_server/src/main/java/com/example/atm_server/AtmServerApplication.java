package com.example.atm_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AtmServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AtmServerApplication.class, args);
    }

}
