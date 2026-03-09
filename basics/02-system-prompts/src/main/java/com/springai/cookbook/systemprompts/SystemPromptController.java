package com.springai.cookbook.systemprompts;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemPromptController {

    private final ChatClient chatClient;

    // The system prompt is set once during construction using .defaultSystem().
    // It defines the AI's persona and behavior for every request.
    public SystemPromptController(ChatClient.Builder builder) {
        this.chatClient = builder
                .defaultSystem("""
                        You are a senior Java developer with 10 years of experience.
                        You explain concepts clearly and always include a short code example.
                        Keep your answers concise and practical.
                        """)
                .build();
    }

    // GET /ask?question=What is dependency injection?
    // The system prompt above will apply to every question automatically.
    @GetMapping("/ask")
    public String ask(@RequestParam(defaultValue = "What is Spring Boot?") String question) {

        // Only the user message is passed here.
        // The system prompt is already baked into the ChatClient.
        return chatClient
                .prompt()
                .user(question)
                .call()
                .content();
    }

    // GET /ask-pirate?question=What is an API?
    // This endpoint overrides the default system prompt with a different persona.
    @GetMapping("/ask-pirate")
    public String askPirate(@RequestParam(defaultValue = "What is an API?") String question) {

        // .system() here overrides the default system prompt for this call only.
        return chatClient
                .prompt()
                .system("You are a pirate who explains tech concepts using pirate language. Always say 'Arrr!' at the start.")
                .user(question)
                .call()
                .content();
    }
}
