package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloApiController {

    /**
     * GET /api/hello
     */
    @GetMapping("/hello")
    public String getHello() {
        return "Hello World";
    }

    /**
     * GET /api/message
     */
    @GetMapping("/message")
    public Message getMessage() {
        return new Message("Hello World", "This is a REST API response");
    }

    /**
     * POST /api/message
     */
    @PostMapping("/message")
    public Message createMessage(@RequestBody MessageRequest request) {
        return new Message(request.getTitle(), request.getContent());
    }

    /**
     * メッセージクラス（内部クラス）
     */
    public static class Message {
        private String title;
        private String content;

        public Message(String title, String content) {
            this.title = title;
            this.content = content;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    public static class MessageRequest {
        private String title;
        private String content;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}