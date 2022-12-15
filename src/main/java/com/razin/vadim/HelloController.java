package com.razin.vadim;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RestController
public class HelloController {
    @GetMapping("/hello-world")
    public String sayHello() {
        return "hello_world";
    }
}
