package com.example.Spring_App_Development.ServiceLayer;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public static String getGreeting(){
        return "Hello World";
    }
}
