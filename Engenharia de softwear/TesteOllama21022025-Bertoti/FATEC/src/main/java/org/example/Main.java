package org.example;

import io.github.ollama4j.OllamaAPI;
import io.github.ollama4j.exceptions.OllamaBaseException;
import io.github.ollama4j.models.response.OllamaResult;
import io.github.ollama4j.types.OllamaModelType;
import io.github.ollama4j.utils.OptionsBuilder;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws OllamaBaseException, IOException, InterruptedException {

        String host = "http://localhost:11434/";

        OllamaAPI ollamaAPI = new OllamaAPI(host);
        ollamaAPI.setRequestTimeoutSeconds(120);

        OllamaResult result =
                ollamaAPI.generate("deepseek-r1:1.5b", "Who are you?", true, new OptionsBuilder().build());

        System.out.println(result.getResponse());
    }
}
