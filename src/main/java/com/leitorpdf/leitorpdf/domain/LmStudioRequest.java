package com.leitorpdf.leitorpdf.domain;

public class LmStudioRequest {
    private String prompt;

    public LmStudioRequest(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
}
