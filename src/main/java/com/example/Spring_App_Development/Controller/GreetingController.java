package com.example.Spring_App_Development.Controller;

import com.example.Spring_App_Development.ServiceLayer.FullNameService;
import com.example.Spring_App_Development.ServiceLayer.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GreetingController {

// uc1 problem getting all the methods output into json format
    @GetMapping
    public String b1(){
        return "this is get mapping http method";
    }

    @PutMapping
    public String b2(){
        return "this is put mapping http method";
    }
    @PostMapping
    public String b3(){
        return "this is post mapping http method";
    }
    @DeleteMapping
    public String b4(){
        return "this is delete mapping http method";
    }
    // json output
    @GetMapping("/combined")
    public Map<String, String> combined() {
        return Map.of(
                "firstMethod", b1(),
                "SecondMethod", b2(),
                "ThirdMethod", b3(),
                "FourthMapping", b4()
        );
    }


    //uc2 getting simple methods using service layer
      @GetMapping("/service")
    public String greetingMethod(){
        return GreetingService.getGreeting();
      }

      // uc3 greeting message with either firstname,lastname or full name
    @GetMapping("/greetingname")
    public Map<String ,String> greetingMethod(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        FullNameService obj = new FullNameService();
        Map<String, String> response = new HashMap<>();

        response.put("response is ", obj.greetingWithName(firstName, lastName));
        return response;

    }
        //  uc4 save greeting in repository
        @Autowired
        private GreetingService greetingService;

    @PostMapping("/savegreeting")
    public String saveGreeting(@RequestBody String message) {
        greetingService.saveGreeting(message);
        return "Greeting saved successfully!";
    }

    @GetMapping("/getgreeting")
    public String getGreeting() {
        return greetingService.getGreeting2();
    }

    // uc5 save greeting by id and fetch
    @PostMapping("/id/{id}")
    public String saveGreeting(@PathVariable Long id, @RequestBody String message) {
        greetingService.saveGreetingbyid(id, message);
        return "Greeting saved with ID: " + id;
    }

    @GetMapping("/id/{id}")
    public String getGreeting(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }

    // uc6 showing all the messages
    @GetMapping("/all")
    public Map<Long, String> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    // uc7 here i am updating  the greeting message stored by id
    @PutMapping("/id/{id}")
    public String updateGreeting(@PathVariable Long id, @RequestBody String newMessage) {
        String response = greetingService.updateGreeting(id, newMessage);
        return response;
    }
  //  uc8 delete stored greetings with id
    @DeleteMapping("/id/{id}")
    public String deleteGreeting(@PathVariable Long id) {
        String response = greetingService.deleteGreetingById(id);
        return response;
    }




}
