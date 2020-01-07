package com.der.webfluxstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class WebfluxStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebfluxStartApplication.class, args);
    }

}
