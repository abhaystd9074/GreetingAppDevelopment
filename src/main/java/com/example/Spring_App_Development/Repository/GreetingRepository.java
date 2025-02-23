package com.example.Spring_App_Development.Repository;
import org.springframework.stereotype.Repository;

@Repository
public class GreetingRepository {
    private String greetingMessage;
    //  it is used to save the greeting
    public void save(String message) {
        this.greetingMessage = message;
    }

    public String find() {
        return greetingMessage;
    }
}
