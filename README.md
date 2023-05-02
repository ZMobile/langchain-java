# langchain-java

`langchain-java` is a Java-based library designed to interact with large language models (LLMs) like OpenAI's GPT-4. This library allows you to build and execute chains of operations on LLMs, such as processing input data, applying templates, and generating responses. `langchain-java` is inspired by the Python LangChain library and aims to provide similar functionality with the added benefits of the Java ecosystem.

`com.zakynthos.langchain` is the main package of the `langchain-java` library.

## Features

- Interact with large language models like GPT
- Define and apply prompt templates
- Build chains of operations for processing input data and generating responses
- Async support for concurrent execution of tasks
- Designed to be language-translatable to Python LangChain

## Installation

To add `langchain-java` to your project, include the following dependency in your build file:

### For Gradle

```groovy
dependencies {
    implementation 'com.zakynthos:langchain-java:1.0.0'
}
```

### For Maven

```xml
<dependency>
    <groupId>com.zakynthos</groupId>
    <artifactId>langchain-java</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Usage

Here's a simple example of using langchain-java to interact with GPT-4:

```java
import com.zakynthos.langchain.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        LanguageModel languageModel = new GPT4LanguageModel();
        Map<String, String> inputVariables = new HashMap<>();
        inputVariables.put("product", "");
        PromptTemplate promptTemplate = new PromptTemplate("What is a good name for a company that makes {%s}?", inputVariables);
        Chain chain = new LLMChain(languageModel, promptTemplate);

        Map<String, String> input = new HashMap<>();
        input.put("product", "toothpaste");
        String response = chain.run(input);

        System.out.println(response);
    }
}
```

This example demonstrates how to create a GPT4LanguageModel, PromptTemplate, and LLMChain to process input data and generate a response from GPT-4. Replace the API_KEY constant in the GPT4LanguageModel class with your actual GPT-4 API key.

### License

langchain-java is licensed under the MIT License.

### Contributing

We welcome contributions to the langchain-java project! If you'd like to contribute, please fork the repository and submit a pull request with your changes.
