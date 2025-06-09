package com.example.microservice.exemplo5.services;

import com.example.microservice.exemplo5.dto.ChatGPTRequest;
import com.example.microservice.exemplo5.dto.ChatGPTResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@Service
public class ChatGPTService {

    private Logger logger = Logger.getLogger(ChatGPTService.class.getName());

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String url;

    @Autowired
    private RestTemplate template;

    public Object chat(String prompt) throws JsonProcessingException {
        logger.info("Starting chat");
        ChatGPTRequest request = new ChatGPTRequest(model, prompt);

        String jsonString = new ObjectMapper().writeValueAsString(request);
        logger.info(jsonString);

        logger.info("Processing prompt");
        logger.info(url);
        ChatGPTResponse respose = template.postForObject(url, request, ChatGPTResponse.class);

        return respose.getChoices().get(0).getMessage().getContent();
    }
}
