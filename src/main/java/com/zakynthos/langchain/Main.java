package com.zakynthos.langchain;

import com.zakynthos.langchain.model.GPT4LanguageModel;
import com.zakynthos.langchain.model.LanguageModel;
import com.zakynthos.langchain.model.chain.Chain;
import com.zakynthos.langchain.model.chain.LLMChain;
import com.zakynthos.langchain.model.prompt.PromptTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        LanguageModel languageModel = new GPT4LanguageModel();
        Map<String, String> inputVariables = new HashMap<>();
        inputVariables.put("product", "");
        PromptTemplate promptTemplate = new PromptTemplate("What is a good name for a company that makes {%s}?", inputVariables);
        Chain chain = new LLMChain(languageModel, promptTemplate);

        // Generate answers concurrently for 30 questions
        List<String> questions = List.of(
                "question1",
                "question2",
                "question3"
                // ...
                // Add 30 questions
        );

        List<CompletableFuture<String>> futures = questions.stream()
                .map(q -> {
                    Map<String, String> input = new HashMap<>();
                    input.put("product", q);
                    return chain.runAsync(input);
                })
                .collect(Collectors.toList());

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        List<String> answers = futures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

        // Print answers
        for (int i = 0; i < questions.size(); i++) {
            System.out.printf("Question: %s%nAnswer: %s%n%n", questions.get(i), answers.get(i));
        }
    }
}