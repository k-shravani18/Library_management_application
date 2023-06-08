package com.library.library_management.service;

import com.library.library_management.model.Book;

import java.util.List;
public interface IBookService {
    Book addBook(Book book);
    String updateBook(Book book);
    String deleteBook(Book book);
    Book getById(Long bookId);
    List<Book>getAll();


    //custom operations
//    List<Book> getByName(String name);
//    List<Book> getByNameAndEdition(String name,String edition);
//    List<Book> getByGenre(String genre);
//    List<Book> getByPrice(Double price);
//    List<Book> getByPages(Long pages);
//    List<Book> getByUserId(Long user_id);
}