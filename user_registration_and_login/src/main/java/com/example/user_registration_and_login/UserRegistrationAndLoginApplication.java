package com.example.user_registration_and_login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class UserRegistrationAndLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserRegistrationAndLoginApplication.class, args);
    }

}
