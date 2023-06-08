package com.library.library_management.service;

import com.library.library_management.model.Category;

import java.util.List;

public interface ICategoryService {
    Category addCategory(Category category);
    String updateCategory(Category category);
    String deleteCategory(Category category);
    Category getById(Long category_id);
    List<Category>getAll();


    //custom operations
//    List<Book> getByName(String name);
//    List<Book> getByNameAndEdition(String name,String edition);
//    List<Book> getByGenre(String genre);
//    List<Book> getByPrice(Double price);
//    List<Book> getByPages(Long pages);
//    List<Book> getByUserId(Long user_id);
}