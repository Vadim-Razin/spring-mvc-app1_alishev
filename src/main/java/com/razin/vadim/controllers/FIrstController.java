package com.razin.vadim.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FIrstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {
        model.addAttribute("message", "Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/calculator")
    public String calcPage(
            @RequestParam(value = "a") int number1,
            @RequestParam("b") int number2,
            @RequestParam(value = "action") String action,
            Model model) {
        double result = switch (action) {
            case "multiplication":
                yield number1 * number2;
            case "addition":
                yield number1 + number2;
            case "subtraction":
                yield number1 - number2;
            case "division":
                yield number1 / (double) number2;
            default:
                yield 0;
        };

        model.addAttribute("result", "Number 1: " + number1 + ", Number 2: "
                + number2 + ", Action: " + action + ", Result = " + result);

        return "first/calculator";
    }

    @GetMapping("/goodbye")
    public String goodbyePage() {
        return "first/goodbye";
    }
}
