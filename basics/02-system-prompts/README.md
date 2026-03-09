# 02 - System Prompts

Customize AI behavior by providing a system prompt. A system prompt sets the persona, tone, and constraints for the AI before any user message is sent.

---

## What it does

This recipe shows two things:
- How to set a default system prompt that applies to every request
- How to override the system prompt per request for a different persona

Two endpoints are exposed, each with a different AI personality.

---

## Endpoints

```
GET /ask?question=your question
```
Responds as a senior Java developer with code examples.

```
GET /ask-pirate?question=your question
```
Responds as a pirate who explains tech concepts.

---

## How to run

1. Set your OpenAI API key:

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

3. Test it:

```bash
curl "http://localhost:8080/ask?question=What is dependency injection?"
curl "http://localhost:8080/ask-pirate?question=What is an API?"
```

---

## Expected output

`/ask`:
```
Dependency injection is a design pattern where an object's dependencies
are provided externally rather than created internally.

Example:
@Service
public class OrderService {
    private final PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
```

`/ask-pirate`:
```
Arrr! An API be like a map to a treasure chest, it tells ye what ye can
ask for and how to ask for it, without needin' to know what's inside the chest!
```

---

## Key concepts

- `defaultSystem()` — sets a system prompt that applies to all requests made by this `ChatClient`
- `.system()` on a prompt — overrides the default system prompt for a single call
- System prompts are invisible to the end user but shape every response

---

## Project structure

```
02-system-prompts/
├── pom.xml
├── README.md
└── src/
    └── main/
        ├── java/com/springai/cookbook/systemprompts/
        │   ├── SystemPromptsApplication.java
        │   └── SystemPromptController.java
        └── resources/
            └── application.properties
```
