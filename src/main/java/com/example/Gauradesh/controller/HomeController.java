package com.example.Gauradesh.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String welcomeMessage(){
        return "Welcome to the Gauradesh Database";
    }


}
