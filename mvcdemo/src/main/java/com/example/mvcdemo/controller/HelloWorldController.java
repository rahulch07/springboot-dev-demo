package com.example.mvcdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;

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

    @GetMapping("/processform-v2")
    public String processformV2(HttpServletRequest request, Model model){

//        request.getParameterMap().forEach((key, value) ->{
//            System.out.println("*&request**");
//            System.out.println(key + "-" + Arrays.toString(value));
//        });

        String name = request.getParameter("studentName") + "-v2";

        model.addAttribute("message", name);

        return "helloworldV2";    //view name
    }
}
