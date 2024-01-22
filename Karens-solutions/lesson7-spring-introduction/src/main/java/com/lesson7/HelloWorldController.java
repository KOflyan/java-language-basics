package com.lesson7;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/hello/student")
    public StudentResponse getStudentResponse(@Valid @RequestBody StudentDto student) {
        return new StudentResponse("Student object is valid!");
    }
}
