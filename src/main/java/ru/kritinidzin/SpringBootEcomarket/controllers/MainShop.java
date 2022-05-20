package ru.kritinidzin.SpringBootEcomarket.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.kritinidzin.SpringBootEcomarket.models.Product;
import ru.kritinidzin.SpringBootEcomarket.repositories.ProductRepository;

import java.io.IOException;

@Controller
public class MainShop {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/shop")
    public String shopMain(Model model) {
        Iterable<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "shop";
    }

    @GetMapping("/shopAdd")
    public String shopAdd(Model model) {
        return "adminIndex";
    }

    @PostMapping("/shopAdd")
    public String shopPostAdd(@RequestParam String name,
                              @RequestParam String information,
                              @RequestParam String category,
                              @RequestParam int amount,
                              @RequestParam double price,
                              @RequestParam int status,
                              @RequestParam MultipartFile productImg,
                              Model model) {
        try {
            byte [] img = productImg.getBytes();
            Product product = new Product(name, information, category, amount, price, status, img);
            productRepository.save(product);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/shopAdd";
    }
}
