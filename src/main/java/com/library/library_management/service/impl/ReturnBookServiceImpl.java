package com.library.library_management.service.impl;

import com.library.library_management.model.ReturnBook;
import com.library.library_management.repository.IReturnBookRepository;
import com.library.library_management.service.IReturnBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReturnBookServiceImpl implements IReturnBookService {
    @Autowired
    private IReturnBookRepository returnBookRepository;

    @Override
    public ReturnBook addReturnBook(ReturnBook returnBook) {
        return null;
    }

    @Override
    public String updateReturnBook(ReturnBook returnBook) {
        return null;
    }

    @Override
    public String deleteReturnBook(ReturnBook returnBook) {
        return null;
    }

    @Override
    public ReturnBook getById(Long returnBook_id) {
        return null;
    }

    @Override
    public List<ReturnBook> getAll() {
        return null;
    }
}
