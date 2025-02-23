package com.example.Spring_App_Development.ServiceLayer;

import com.example.Spring_App_Development.Repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {
    public static String getGreeting(){
        return "Hello World";
    }
  //  this code is for repository uc4
  @Autowired
  private GreetingRepository greetingRepository;

    public void saveGreeting(String message) {
        greetingRepository.save(message);
    }

    public String getGreeting2() {
        return greetingRepository.find();
    }

    //  this code is for uc5
    public void saveGreetingbyid(Long id, String message) {
        greetingRepository.savebyid(id, message);
    }

    public String getGreetingById(Long id) {
        return greetingRepository.findById(id);
    }
}
