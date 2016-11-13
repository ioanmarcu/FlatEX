package com.ionelmarcu.flatex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlatExApplication {
    private static final Logger log = LoggerFactory.getLogger(FlatExApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(FlatExApplication.class, args);
    }

}
