package com.example.Spring_App_Development.Controller;

import org.springframework.web.bind.annotation.*;

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
}
