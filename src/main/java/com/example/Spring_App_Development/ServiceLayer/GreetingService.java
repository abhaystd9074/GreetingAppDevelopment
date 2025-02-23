package com.example.Spring_App_Development.ServiceLayer;

import com.example.Spring_App_Development.Repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    //  uc6
    public Map<Long, String> getAllGreetings() {
        return greetingRepository.getAllGreetings();
    }

    //uc7
    public String updateGreeting(Long id, String newMessage) {
        Map<Long,String>greetings=greetingRepository.getAllGreetings();
        if (greetings.containsKey(id)) {
            String oldMessage = greetings.get(id);
            greetings.put(id, newMessage);
            return "Original Message: " + oldMessage + " | Updated Message: " + newMessage;
        } else {
            return "Greeting with ID " + id + " not found!";
        }
    }
    //uc8
    public String deleteGreetingById(Long id) {

        Map<Long,String>greetings=greetingRepository.getAllGreetings();
        if (greetings.containsKey(id)) {
           greetings.remove(id);
            return "Greeting with ID " + id + " has been deleted successfully!";
        } else {
            return "Greeting with ID " + id + " not found!";
        }
    }
}
