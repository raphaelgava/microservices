package com.example.microservice.exemplo4.controllers;

import com.example.microservice.exemplo4.configurations.GreetingConfiguration;
import com.example.microservice.exemplo4.models.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class Ex4GreetingController {

    private static final String template = "%s, %s!!";
    private final AtomicLong counter = new AtomicLong(); //Multithread

    @Autowired
    private GreetingConfiguration configuration;

    @RequestMapping("/ex4greeting") //Recuperar dados da url
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "") String name){
        if (name.isEmpty())
            name = configuration.getDefaultValue();

        return new Greeting(counter.incrementAndGet(), String.format(template, configuration.getGreeting(), name));
    }
}
