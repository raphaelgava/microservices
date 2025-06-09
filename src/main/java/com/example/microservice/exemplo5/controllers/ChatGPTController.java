package com.example.microservice.exemplo5.controllers;

import com.example.microservice.exemplo5.services.ChatGPTService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bot")
public class ChatGPTController {
    @Autowired
    private ChatGPTService service;

    @GetMapping("/chat")
    public Object chat(@RequestParam("prompt") String prompt) throws JsonProcessingException {
        return service.chat(prompt);
    }
}
