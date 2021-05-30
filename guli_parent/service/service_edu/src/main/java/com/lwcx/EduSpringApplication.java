package com.lwcx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author cx
 */
@SpringBootApplication
@Configuration
// @Configuration 和 @ComponentScan(basePackages = "com.lwcx")二选其一
//@ComponentScan(basePackages = "com.lwcx")
public class EduSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduSpringApplication.class, args);
    }
}
