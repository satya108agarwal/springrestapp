package com.tpcf.springrestapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    public HelloController() {}

    @GetMapping("/hello")
    public String sayHello() {
        System.out.println("Hello World");
        return "Hello World";
    }
}
