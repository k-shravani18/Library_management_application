package com.library.library_management.service;

import com.library.library_management.model.ReturnBook;

import java.util.List;

public interface IReturnBookService {
    ReturnBook addReturnBook(ReturnBook returnBook);
    String updateReturnBook(ReturnBook returnBook);
    String deleteReturnBook(ReturnBook  returnBook);
    ReturnBook getById(Long returnBook_id);
    List<ReturnBook>getAll();

}