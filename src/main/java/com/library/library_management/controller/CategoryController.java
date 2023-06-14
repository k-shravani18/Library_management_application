package com.library.library_management.controller;

import com.library.library_management.exceptions.CategoryNotFoundException;
import com.library.library_management.model.Category;
import com.library.library_management.service.ICategoryService;
import com.library.library_management.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping("/category_form")
    public String showRegistration(@ModelAttribute("category") Category category) {
        return "createCategoryForm";
    }

    @PostMapping(value = "/add_category")
    public String addCategory(@ModelAttribute("category") Category category){
        categoryService.addCategory(category);
        return "redirect:/category/success";
    }
    @GetMapping("/success")
    public String showSuccessPage() {
        return "successForm";
    }

    @GetMapping("/editCategory")
    public String showEditForm(@RequestParam("categoryId") Long categoryId, Model model) {
        try {
            Category category =categoryService.getById(categoryId);
            if (category == null) {
                throw new CategoryNotFoundException("category not found with ID: " + categoryId);
            }

            model.addAttribute("category", category);

            return "editCategoryForm";
        } catch (CategoryNotFoundException e) {
            return handlingCategoryNotFoundException(model);
        }
    }
    @PutMapping("/updateCategory")
    public String updateCategory(@ModelAttribute("category") Category category,
                               Model model) {
        category.setCategoryName(category.getCategoryName().toUpperCase());
        categoryService.updateCategory(category);

        return "redirect:/category/editSuccess";
    }

    @GetMapping("/editSuccess")
    public String updationSuccess(Model model) {
        String successMessage = "Category Updated Successfully";
        model.addAttribute("successMessage", successMessage);
        return "globalSuccessForm";
    }



    @GetMapping("/delete")
    public String showDeleteForm(@RequestParam("categoryId") Long categoryId, Model model) {
        try {
            Category category = categoryService.getById(categoryId);
            if (category == null) {
                throw new CategoryNotFoundException("Category not found with ID: " + categoryId);
            }

            model.addAttribute("category", category);

            return "deleteCategoryForm";
        } catch (CategoryNotFoundException e) {
            return handlingCategoryNotFoundException(model);
        }
    }


    @DeleteMapping("/deleteCategory")
    public String deleteCategory(@ModelAttribute("category") Category category,
                               Model model) {

        categoryService.deleteCategory(category);

        return "redirect:/category/deleteSuccess";
    }

    @GetMapping("/deleteSuccess")
    public String deleteSuccess(Model model) {
        String successMessage = "Category Deleted Successfully";
        model.addAttribute("successMessage", successMessage);
        return "GlobalSuccessForm";
    }

    @GetMapping("/allCategories")
    public String getAllCategories(Model model) {
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        return "getCategories";
    }
    @ExceptionHandler
    private String handlingCategoryNotFoundException(Model model) {
        model.addAttribute("", "CategoryNotFoundException");
        return "categoryNotFoundException";
    }

}
