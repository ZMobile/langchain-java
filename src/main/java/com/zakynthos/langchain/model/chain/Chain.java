package com.zakynthos.langchain.model.chain;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public interface Chain {
    String run(Map<String, String> input);
    CompletableFuture<String> runAsync(Map<String, String> input);
}

