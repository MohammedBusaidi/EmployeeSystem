package com.EmployeeSystem.EmployeeSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)

public class EmployeeSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeSystemApplication.class, args);
    }

/*    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }*/
}
