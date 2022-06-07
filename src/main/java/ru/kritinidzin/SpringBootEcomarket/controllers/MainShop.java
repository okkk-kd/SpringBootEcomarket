package ru.kritinidzin.SpringBootEcomarket.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kritinidzin.SpringBootEcomarket.models.Product;
import ru.kritinidzin.SpringBootEcomarket.service.ProductService;

import java.io.IOException;

@Controller
public class MainShop {

    @Autowired
    private ProductService productService;

    @GetMapping("/shop")
    public String shopMain(Model model) {
        Iterable<Product> products = productService.selectMany();
        model.addAttribute("products", products);
        return "shop";
    }
    @GetMapping("/shopFruit")
    public String shopMainFruit(Model model) {
        Iterable<Product> products = productService.selectCategory("Fruit");
        model.addAttribute("products", products);
        return "shop";
    }
    @GetMapping("/shopMeat")
    public String shopMainMeat(Model model) {
        Iterable<Product> products = productService.selectCategory("Meat");
        model.addAttribute("products", products);
        return "shop";
    }
    @GetMapping("/shopVegetables")
    public String shopMainVegetables(Model model) {
        Iterable<Product> products = productService.selectCategory("Vegetables");
        model.addAttribute("products", products);
        return "shop";
    }
    @GetMapping("/shopBakal")
    public String shopMainBakal(Model model) {
        Iterable<Product> products = productService.selectCategory("Bakal");
        model.addAttribute("products", products);
        return "shop";
    }
    @GetMapping("/shopChemistry")
    public String shopMainChemistry(Model model) {
        Iterable<Product> products = productService.selectCategory("Chemistry");
        model.addAttribute("products", products);
        return "shop";
    }
    @RequestMapping(value = "/shop/{productId}")
    public String findProductDetail(@PathVariable(value = "productId")Long productId, Model model) throws Exception {
        model.addAttribute("product", productService.selectOne(productId));
        return "product-detail";
    }
}
