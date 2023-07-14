package com.wm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.wm.dao")
@SpringBootApplication
public class WyylApplication {
    public static void main(String[] args) {
        SpringApplication.run(WyylApplication.class, args);
    }

}
