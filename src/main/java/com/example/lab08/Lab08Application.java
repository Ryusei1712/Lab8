package com.example.lab08;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.example.lab08.entity")
public class Lab08Application {

    public static void main(String[] args) {
        SpringApplication.run(Lab08Application.class, args);
    }

}
