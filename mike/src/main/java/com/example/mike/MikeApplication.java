package com.example.mike;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.example.mike.mapper")
@SpringBootApplication
public class MikeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MikeApplication.class, args);
    }
}
