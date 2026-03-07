# springai-cookbook

A collection of 15 practical Spring AI examples built with Java and Spring Boot. Each example is self-contained and focused on a single Spring AI feature, organized from beginner to advanced.

---

## Prerequisites

- Java 17 or higher
- Maven 3.8+
- An OpenAI API key (set as `OPENAI_API_KEY` environment variable)
- Each recipe has its own `pom.xml` and `application.properties`

---

## Structure

```
springai-cookbook/
├── basics/
│   ├── 01-chat-message/
│   ├── 02-system-prompts/
│   ├── 03-streaming-responses/
│   ├── 04-prompt-templates/
│   └── 05-conversation-history/
├── documents-and-rag/
│   ├── 06-pdf-reader/
│   ├── 07-rag-with-text/
│   ├── 08-text-embeddings/
│   ├── 09-vector-store/
│   └── 10-semantic-search/
└── advanced/
    ├── 11-function-calling/
    ├── 12-image-generation/
    ├── 13-image-input/
    ├── 14-chatbot/
    └── 15-mysql-ai-queries/
```

---

## Section 1: Basics (01-05)

**01 - Chat Message**
Send a simple chat message to an AI model and handle the response. The starting point for any Spring AI project.

**02 - System Prompts**
Customize AI behavior by providing a system prompt. Useful for setting tone, persona, or task constraints.

**03 - Streaming Responses**
Receive AI responses token by token in real time using reactive streams. Reduces perceived latency for long outputs.

**04 - Prompt Templates**
Use parameterized prompt templates to inject dynamic variables into your prompts cleanly and consistently.

**05 - Conversation History**
Maintain context across multiple turns by managing message history manually or with a memory advisor.

---

## Section 2: Documents and RAG (06-10)

**06 - PDF Reader**
Load and query a PDF document using Spring AI's document readers. Extract and chunk text for downstream processing.

**07 - RAG with Text**
Build a basic Retrieval-Augmented Generation pipeline using a plain text file as the knowledge source.

**08 - Text Embeddings**
Generate vector embeddings from text and compare similarity scores between different strings.

**09 - Vector Store**
Set up an in-memory or persistent vector store and index documents for later retrieval.

**10 - Semantic Search**
Run a semantic search over a vector store to find the most relevant chunks for a given query.

---

## Section 3: Advanced (11-15)

**11 - Function Calling**
Define Java methods that the AI can call during a conversation. Lets the model trigger real logic and return results.

**12 - Image Generation**
Use the DALL-E integration to generate images from text prompts and handle the response URL or base64 output.

**13 - Image Input**
Send images as part of the user message and ask the AI to analyze or describe them (multimodal input).

**14 - Chatbot**
Build a complete chatbot with conversation memory, a system prompt, and a simple REST or CLI interface.

**15 - MySQL + AI Queries**
Combine Spring AI with a MySQL database to let the model generate and explain SQL queries against real data.

---

## Running a Recipe

Each recipe is a standalone Spring Boot application. To run any of them:

```bash
cd basics/01-chat-message
mvn spring-boot:run
```

Make sure your API key is set before running:

```bash
export OPENAI_API_KEY=your-key-here
```

Each recipe folder contains its own README with expected output and configuration notes.

---

## Configuration

All recipes use `application.properties` for configuration. The minimum required property is:

```properties
spring.ai.openai.api-key=${OPENAI_API_KEY}
```

Some advanced recipes (vector store, MySQL) require additional configuration detailed in their respective READMEs.

---

## Dependencies

All recipes use Spring Boot 3.x and the Spring AI BOM. Core dependency in each `pom.xml`:

```xml
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>org.springframework.ai</groupId>
      <artifactId>spring-ai-bom</artifactId>
      <version>1.0.0</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>
```

---

## Contributing

Each recipe should follow the existing format:

- One main Java file with inline comments
- A `README.md` explaining what it does, how to run it, and sample output
- A self-contained `pom.xml` and `application.properties`

---

## License

MIT
