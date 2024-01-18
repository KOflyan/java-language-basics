package com.lesson7.lesson7;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {
    public record HelloWorld(String name, String message) {}
    @GetMapping("/hello")
    public String getHelloWorld() {
        return "Hello World!";
    }

    @GetMapping("/hello-json")
    public HelloWorld getHelloWorldJson() {
        return new HelloWorld(
                "World",
                "Hello World!"
        );
    }

    @GetMapping("/hello-json/{name}")
    public HelloWorld getHelloName(@PathVariable("name") String name) {
        return new HelloWorld(
                name,
                String.format("Hello %s!", name)
        );
    }
}
