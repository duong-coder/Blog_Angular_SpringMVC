/**
 * (#) StackApplication.java
 * 
 * Dependency inject stack @ 2020
 * 
 * Ngo Huu Duan
 * Ngo Huu Duong
 * 
 * ADD 2020.10.02 DuanNH
 */
package com.dependency.inject.stack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@SpringBootApplication
public class StackApplication {

    public static void main(String[] args) {
        SpringApplication.run(StackApplication.class, args);
    }

}
