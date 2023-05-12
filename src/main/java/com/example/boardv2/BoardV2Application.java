package com.example.boardv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class BoardV2Application {

    public static void main(String[] args) {
        SpringApplication.run(BoardV2Application.class, args);
    }

}
