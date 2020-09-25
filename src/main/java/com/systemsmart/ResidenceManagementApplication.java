package com.systemsmart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@RestController // Controller: exposes a web address with a url and maps it to your methods
//@EnableAutoConfiguration
@SpringBootApplication
public class
ResidenceManagementApplication {

    public static void main (String[] args) {
        SpringApplication.run(ResidenceManagementApplication.class, args);
    }
}
