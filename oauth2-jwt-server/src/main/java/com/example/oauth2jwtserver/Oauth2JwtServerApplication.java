package com.example.oauth2jwtserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author aaron
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class Oauth2JwtServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2JwtServerApplication.class, args);
    }

}
