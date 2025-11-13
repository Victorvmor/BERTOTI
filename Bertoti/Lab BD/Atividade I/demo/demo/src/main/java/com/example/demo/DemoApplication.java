package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// PASSO 1: Adicione este import
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

// PASSO 2: Adicione o "exclude" na anotação
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}