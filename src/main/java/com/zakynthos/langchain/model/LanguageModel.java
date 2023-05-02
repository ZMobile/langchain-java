package com.zakynthos.langchain.model;

import java.util.concurrent.CompletableFuture;

public interface LanguageModel {
    String generate(String prompt);
    CompletableFuture<String> generateAsync(String prompt);
}
