package com.example.microservice.exemplo4.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope //Para fazer atualização dinâmica das configurações pelo http://localhost:8080/actuator/refresh sem reset ta aplicação
@ConfigurationProperties ("greeting-service")
public class GreetingConfiguration {
    private String greeting;
    private String defaultValue;

    public GreetingConfiguration(){

    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
}
