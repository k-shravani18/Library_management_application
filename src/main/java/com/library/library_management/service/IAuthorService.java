package com.library.library_management.service;

import com.library.library_management.model.Author;

import java.util.List;

public interface IAuthorService {
    Author addAuthor(Author author);
    String updateAuthor(Author author);
    String deleteAuthor(Author  author);
    Author getById(Long author_id);
    List<Author>getAll();


    //custom operations
//    List<Book> getByName(String name);
//    List<Book> getByNameAndEdition(String name,String edition);
//    List<Book> getByGenre(String genre);
//    List<Book> getByPrice(Double price);
//    List<Book> getByPages(Long pages);
//    List<Book> getByUserId(Long user_id);
}