package com.library.library_management.controller;

import com.library.library_management.model.Category;
import com.library.library_management.service.ICategoryService;
import com.library.library_management.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    public Category addCategory(@ModelAttribute Category category){
        return categoryService.addCategory(category);
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
