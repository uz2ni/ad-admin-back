package com.spring.tester;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootTesterApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTesterApplication.class, args);
        System.out.println("main application running");
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
