package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloApplication {
    public static void main(String[] args) {
        // この一行でSpring Bootを起動します
        SpringApplication.run(HelloApplication.class, args);
    }
}