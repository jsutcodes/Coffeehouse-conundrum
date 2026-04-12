package com.github.jsutcodes.coffeehouse_scheduler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
    @GetMapping("/")
    public String home() {
        //model.addAttribute("message", "Welcome to Spring Boot!");
        return "index"; // Looks for index.html in src/main/resources/templates
    }
}

