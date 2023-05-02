package com.zakynthos.langchain.model.prompt;

import java.util.Map;

public class PromptTemplate {
    private String template;
    private Map<String, String> inputVariables;

    public PromptTemplate(String template, Map<String, String> inputVariables) {
        this.template = template;
        this.inputVariables = inputVariables;
    }

    public String apply(Map<String, String> input) {
        String prompt = template;

        for (Map.Entry<String, String> entry : inputVariables.entrySet()) {
            String placeholder = String.format("{%s}", entry.getKey());
            String value = input.getOrDefault(entry.getKey(), "");
            prompt = prompt.replace(placeholder, value);
        }

        return prompt;
    }

    // Getters, setters, and other utility methods
}
