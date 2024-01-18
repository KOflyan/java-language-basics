package com.lesson7;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private record HelloWorld(String name, String message) {}

    @GetMapping("/hello")
    public String getHelloWorld() {
        return "Hello world!";
    }

    @GetMapping("/hello-json/{personName}")
    public HelloWorld getHelloWorldWithJson(
        @PathVariable("personName") String name
    ) {
        return new HelloWorld(
            name,
            String.format("Hello %s!", name)
        );
    }
}
