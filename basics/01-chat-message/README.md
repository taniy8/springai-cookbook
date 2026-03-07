# 01 - Chat Message

Send a simple chat message to an AI model and return the response. This is the most basic Spring AI use case and the starting point for all other recipes.

---

## What it does

Exposes a single REST endpoint that accepts a message as a query parameter, sends it to OpenAI using Spring AI's `ChatClient`, and returns the AI's response as plain text.

---

## Endpoint

```
GET /chat?message=your message here
```

If no message is provided, it defaults to: `Tell me a fun fact about Java`

---

## How to run

1. Set your OpenAI API key as an environment variable:

```bash
# Mac/Linux
export OPENAI_API_KEY=your-key-here

# Windows
set OPENAI_API_KEY=your-key-here
```

2. Run the application:

```bash
mvn spring-boot:run
```

3. Open your browser or use curl:

```bash
curl "http://localhost:8080/chat?message=What is Spring AI?"
```

---

## Expected output

```
Spring AI is a framework that brings the power of artificial intelligence to 
Spring Boot applications. It provides a consistent abstraction layer over 
various AI providers like OpenAI, making it easy to integrate chat, embeddings, 
and other AI capabilities into your Java applications.
```

---

## Key concepts

- `ChatClient` — the main interface for interacting with AI models in Spring AI
- `ChatClient.Builder` — auto-configured by Spring Boot, injected via constructor
- `.prompt().user().call().content()` — the fluent API chain to send a message and get a response

---

## Project structure

```
01-chat-message/
├── pom.xml
├── README.md
└── src/
    └── main/
        ├── java/com/springai/cookbook/chat/
        │   ├── ChatMessageApplication.java
        │   └── ChatController.java
        └── resources/
            └── application.properties
```
