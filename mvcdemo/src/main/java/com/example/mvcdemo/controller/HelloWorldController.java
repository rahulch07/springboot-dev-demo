package com.example.mvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloWorldController {
    //method to render form
    @GetMapping("/showform")
    public String showForm(){
        return "helloworld-form";   //view Name
    }

    //method to process form
    @GetMapping("/processform")
    public String processform(){
        return "helloworld";    //view name
    }
}
