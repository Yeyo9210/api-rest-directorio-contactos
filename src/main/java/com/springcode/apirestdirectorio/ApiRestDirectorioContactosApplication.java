package com.springcode.apirestdirectorio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(scanBasePackages="com.springcode.apirestdirectorio")
@Configuration
public class ApiRestDirectorioContactosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiRestDirectorioContactosApplication.class, args);
    }

}
