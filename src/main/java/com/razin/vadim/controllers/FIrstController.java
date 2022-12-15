package com.razin.vadim.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/first") // префикс для обращения ко всем нижестоящим адресам
public class FIrstController {
    @GetMapping("/hello")
    public String helloPage() {
        return "first/hello"; // правило хорошего тона создавать папку для views c названием контроллера
    }
    @GetMapping("/goodbye")
    public String goodbyePage() {
        return "first/goodbye";
    }
}
