package com.library.library_management.service.impl;

import com.library.library_management.exceptions.CategoryNotFoundException;
import com.library.library_management.model.Category;
import com.library.library_management.repository.ICategoryRepository;
import com.library.library_management.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public void addCategory(Category category) {
         categoryRepository.save(category);
    }

    @Override
    public String updateCategory(Category category) {
        Category existingCategory = categoryRepository.findById(category.getCategoryId()).orElse(null);
        if (existingCategory == null) {
            return null;
        }
        existingCategory.setCategoryName(category.getCategoryName());
         categoryRepository.save(existingCategory);
         return "added";
    }

    @Override
    public String deleteCategory(Category category) {
        Category existingCategory = categoryRepository.findById(category.getCategoryId()).orElse(null);
        if (existingCategory == null) {
            new CategoryNotFoundException("Category Not Found");
        }
        else{
            categoryRepository.delete(existingCategory);
        }
        return "deleted";
    }

    @Override
    public Category getById(Long category_id) {
        return categoryRepository.findById(category_id).orElseThrow(
                ()-> new CategoryNotFoundException("category Not Found "+category_id)
        );
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
