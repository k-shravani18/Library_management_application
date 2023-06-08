package com.library.library_management.service.impl;

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
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public String updateCategory(Category category) {
         categoryRepository.save(category);
         return "added";
    }

    @Override
    public String deleteCategory(Category category) {
        categoryRepository.delete(category);
        return "deleted";
    }

    @Override
    public Category getById(Long category_id) {
        return categoryRepository.getById(category_id);
    }

    @Override
    public List<Category> getAll() {
        return null;
    }
}
