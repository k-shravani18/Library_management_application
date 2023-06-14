package com.library.library_management.service;

import com.library.library_management.model.Book;

import java.util.List;
public interface IBookService {
    Book addBook(Book book);
    public Book updateBook(Book book);
    public void deleteBook(Book book);
    Book getBookById(Long bookId);
    List<Book>getAllBook();

}