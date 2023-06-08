package com.library.library_management.controller;

import com.library.library_management.model.ReturnBook;
import com.library.library_management.service.impl.ReturnBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("return")
public class ReturnBookController  {
    @Autowired
    private ReturnBookServiceImpl returnBookService;

    ReturnBook addReturnBook(ReturnBook returnBook){
        return returnBookService.addReturnBook(returnBook);
    }
    String updateReturnBook(ReturnBook returnBook){
        returnBookService.updateReturnBook(returnBook);
        return "updated";
    }
    String deleteReturnBook(ReturnBook  returnBook){
       return returnBookService.deleteReturnBook(returnBook);

    }
    ReturnBook getById(Long returnBook_id){
        return returnBookService.getById(returnBook_id);

    }
    List<ReturnBook> getAll(){
        return null;
    }
}
