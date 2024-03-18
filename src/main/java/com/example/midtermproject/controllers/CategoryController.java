package com.example.midtermproject.controllers;

import org.hibernate.mapping.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.midtermproject.Repository.CategoryRepository;
import com.example.midtermproject.contant.Constant;
import com.example.midtermproject.models.Category;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @GetMapping("/listcategory")
    public String category(Model model) {
        model.addAttribute("category",
                categoryRepository.findAllByStatusInOrderByIdDesc(Constant.getAllStatusString()));
        return "category/list";
    }

    @GetMapping("/listcategory/create")
    public String create(Model model) {
        Category category = new Category();
        category.setStatuslist(Constant.getAllStatus());
        model.addAttribute("category", category);
        return "category/create";

    }

    @PostMapping("/listcategory/create")
    public String create(@ModelAttribute("category") Category category) {
        if (category.getName() == "" || category.getStatus() == "") {
            return "category/create";
        }
        categoryRepository.save(category);
        return "redirect:/listcategory";

    }

    @GetMapping("/listcategory/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id) {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category != null) {
            category.setStatuslist(Constant.getAllStatus());
            model.addAttribute("category", category);
            categoryRepository.save(category);
            return "category/create";
        }
        return "redirect:/listcategory";
    }

    @GetMapping("/listcategory/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category != null) {
            category.setStatus("DEL");
            categoryRepository.save(category);
        }
        return "redirect:/listcategory";
    }

    @GetMapping("/listcategory/dis/{id}")
    public String disable(@PathVariable("id") Integer id) {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category != null) {
            category.setStatus("DLS");
            categoryRepository.save(category);
        }
        return "redirect:/listcategory";
    }

}
