package ru.kritinidzin.SpringBootEcomarket.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    @GetMapping("/shopFruit")
    public String shopMainFruit(Model model) {
        Iterable<Product> products = productRepository.findByCategory("Fruit");
        model.addAttribute("products", products);
        return "shop";
    }
    @GetMapping("/shopMeat")
    public String shopMainMeat(Model model) {
        Iterable<Product> products = productRepository.findByCategory("Meat");
        model.addAttribute("products", products);
        return "shop";
    }
    @GetMapping("/shopVegetables")
    public String shopMainVegetables(Model model) {
        Iterable<Product> products = productRepository.findByCategory("Vegetables");
        model.addAttribute("products", products);
        return "shop";
    }
    @GetMapping("/shopBakal")
    public String shopMainBakal(Model model) {
        Iterable<Product> products = productRepository.findByCategory("Bakal");
        model.addAttribute("products", products);
        return "shop";
    }
    @GetMapping("/shopChemistry")
    public String shopMainChemistry(Model model) {
        Iterable<Product> products = productRepository.findByCategory("Chemistry");
        model.addAttribute("products", products);
        return "shop";
    }

    @GetMapping("/shopAdd")
    public String shopAdd(Model model) {
        return "adminIndex";
    }

    @RequestMapping(value = "/shop/{productId}")
    public String findProductDetail(@PathVariable(value = "productId")Long productId, Model model) {
        productRepository.findById(productId).ifPresent(o -> model.addAttribute("product", o));
        return "product-detail";
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
