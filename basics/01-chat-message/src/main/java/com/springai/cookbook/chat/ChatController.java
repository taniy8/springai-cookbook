package com.springai.cookbook.chat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private final ChatClient chatClient;

    // Spring AI provides a ChatClient.Builder bean automatically.
    // We use it to build a ChatClient instance.
    public ChatController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    // GET /chat?message=Hello
    // Sends the user's message to the AI and returns the response as plain text.
    @GetMapping("/chat")
    public String chat(@RequestParam(defaultValue = "Tell me a fun fact about Java") String message) {

        // .prompt()       - starts building the prompt
        // .user(message)  - sets the user message
        // .call()         - sends the request to the AI model
        // .content()      - extracts the response text
        return chatClient
                .prompt()
                .user(message)
                .call()
                .content();
    }
}
