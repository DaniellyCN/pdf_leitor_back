package com.leitorpdf.leitorpdf.service;

import com.leitorpdf.leitorpdf.domain.ChoicesResponse;
import com.leitorpdf.leitorpdf.domain.LmStudioRequest;
import com.leitorpdf.leitorpdf.domain.LmStudioResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@Service
public class LlamaService {

    private final RestTemplate restTemplate;
    private final String lmStudioUrl = "http://localhost:1234/v1/completions";

    public LlamaService() {
        this.restTemplate = new RestTemplate();
    }
    public String ask(String texto, String pergunta) {
        String input = texto + "\n" + pergunta;
        LmStudioRequest request = new LmStudioRequest(input);
        LmStudioResponse response = restTemplate.postForObject(lmStudioUrl, request, LmStudioResponse.class);
        System.out.println(response);
        ChoicesResponse choicesResponse = response.getChoices()[0];

        return response != null ? choicesResponse.getText() : "Erro ao conectar com o LMStudio";
    }
}
