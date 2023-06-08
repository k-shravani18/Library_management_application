package com.library.library_management.service;

import com.library.library_management.model.ReturnBook;

import java.util.List;

public interface IReturnBookService {
    ReturnBook addReturnBook(ReturnBook returnBook);
    String updateReturnBook(ReturnBook returnBook);
    String deleteReturnBook(ReturnBook  returnBook);
    ReturnBook getById(Long returnBook_id);
    List<ReturnBook>getAll();


    //custom operations
//    List<Book> getByName(String name);
//    List<Book> getByNameAndEdition(String name,String edition);
//    List<Book> getByGenre(String genre);
//    List<Book> getByPrice(Double price);
//    List<Book> getByPages(Long pages);
//    List<Book> getByUserId(Long user_id);
}