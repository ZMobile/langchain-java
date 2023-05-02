package com.zakynthos.langchain.model.chain;

import com.zakynthos.langchain.model.LanguageModel;
import com.zakynthos.langchain.model.prompt.PromptTemplate;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class LLMChain implements Chain {
    private LanguageModel languageModel;
    private PromptTemplate promptTemplate;

    public LLMChain(LanguageModel languageModel, PromptTemplate promptTemplate) {
        this.languageModel = languageModel;
        this.promptTemplate = promptTemplate;
    }

    @Override
    public String run(Map<String, String> input) {
        String prompt = promptTemplate.apply(input);
        String response = languageModel.generate(prompt);
        return response;
    }

    @Override
    public CompletableFuture<String> runAsync(Map<String, String> input) {
        String prompt = promptTemplate.apply(input);
        return languageModel.generateAsync(prompt);
    }
}
