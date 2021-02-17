package com.training.crud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class customerController {

    @RequestMapping("/")
    @GetMapping()
    public String getCustomers() {
        return "Greetings from Spring Boot!";
    }

}
