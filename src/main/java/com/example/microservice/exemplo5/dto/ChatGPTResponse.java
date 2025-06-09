package com.example.microservice.exemplo5.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ChatGPTResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Choice> choices;

    public ChatGPTResponse(){

    }

    public ChatGPTResponse(List<Choice> choices) {
        this.choices = choices;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ChatGPTResponse that = (ChatGPTResponse) o;
        return Objects.equals(choices, that.choices);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(choices);
    }
}
