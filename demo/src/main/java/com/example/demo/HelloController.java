package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
/*
 Hello world!
*/
@RestController
public class HelloController {

	@RequestMapping("/")
    public String index(){
        return "Hello,Spring Boot!";
    }
    @RequestMapping("/miyagi")
    public String miyagi(){
        return "Miyagi desu!";
    }

}
