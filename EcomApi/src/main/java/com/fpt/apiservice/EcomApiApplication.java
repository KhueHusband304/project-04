package com.fpt.apiservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories
@SpringBootApplication
public class EcomApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcomApiApplication.class, args);
    }

}
