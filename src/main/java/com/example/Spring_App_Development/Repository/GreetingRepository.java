package com.example.Spring_App_Development.Repository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class GreetingRepository {
    private String greetingMessage;
    //  it is used to save the greeting
    public void save(String message) {
        this.greetingMessage = message;
    }
   //  it is used to return the greeting
    public String find() {
        return greetingMessage;
    }
///   this code is for uc5, save greetings with id
    private final Map<Long, String> greetings = new HashMap<>();

    public void savebyid(Long id, String message) {
        greetings.put(id, message);
    }

    public String findById(Long id) {
        return greetings.getOrDefault(id, "Greeting not found!");
    }
}
