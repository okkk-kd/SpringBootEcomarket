package ru.kritinidzin.SpringBootEcomarket.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainCart {
    @GetMapping("/cart")
    public String cartMain(Model model) {
        return "cart";
    }
}
