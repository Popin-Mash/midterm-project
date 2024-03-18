package com.example.midtermproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.midtermproject.Repository.CategoryRepository;
import com.example.midtermproject.Repository.ProductRepository;
import com.example.midtermproject.contant.Constant;
import com.example.midtermproject.models.Product;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class ProductController {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @GetMapping("/product")
    public String product(Model model) {
        model.addAttribute("product", productRepository.findAllByStatus("ACT"));
        return "product/productlist";
    }

    @GetMapping("/product/create")
    public String create(Model model) {
        Product product = new Product();
        product.setCategories(categoryRepository.findAllByStatus("ACT"));

        product.setStatuslist(Constant.getAllStatus());
        product.setStocktypelist(Constant.getAllstockType());
        model.addAttribute("product", product);
        return "product/create";
    }

    @PostMapping("/product/create")
    public String create(Model model, @ModelAttribute("product") Product product) {
        productRepository.save(product);
        return "redirect:/product";
    }

    @GetMapping("/product/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            product.setCategories(categoryRepository.findAllByStatus("ACT"));
            product.setStocktypelist(Constant.getAllstockType());
            product.setStatuslist(Constant.getAllStatus());
            model.addAttribute("product", product);
            return "product/create";
        }
        return "redirect:/product";
    }

    @GetMapping("/product/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            product.setStatus("DEL");
            productRepository.save(product);
        }
        return "redirect:/product";
    }

    @GetMapping("/product/dis/{id}")
    public String disable(@PathVariable("id") Integer id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            product.setStatus("DSL");
            productRepository.save(product);
        }
        return "redirect:/product";
    }

}
