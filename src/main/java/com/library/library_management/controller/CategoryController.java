package com.library.library_management.controller;

import com.library.library_management.model.Category;
import com.library.library_management.service.ICategoryService;
import com.library.library_management.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping("/category")
    public String showRegistration(@ModelAttribute("category") Category category) {
        return "categoryForm";
    }

    @PostMapping(value = "/add_category")
    public String addCategory(@ModelAttribute("category") Category category){
        categoryService.addCategory(category);
        return "redirect:/category/success";
    }
    @GetMapping("/success")
    public String showSuccessPage() {
        return "success";
    }


    public String updateCategory(Category category) {
        categoryService.updateCategory(category);
        return "updated";
    }

    public String deleteCategory(Category category) {
        categoryService.deleteCategory(category);
        return "deleted";
    }


    public Category getById(Long category_id) {
        return categoryService.getById(category_id);
    }


    public List<Category> getAll() {
        return null;
    }
}
