package com.TestingTutorial.TestApp1;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String greet(){
        return "Hello, SuperHero";
    }

}
