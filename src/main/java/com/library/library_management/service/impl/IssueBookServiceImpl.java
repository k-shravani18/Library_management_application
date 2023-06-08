package com.library.library_management.service.impl;

import com.library.library_management.model.IssueBook;
import com.library.library_management.repository.IIssueBookRepository;
import com.library.library_management.service.IIssueBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueBookServiceImpl implements IIssueBookService {
    @Autowired
    private IIssueBookRepository issueBookRepository;

    @Override
    public IssueBook addIssueBook(IssueBook issueBook) {
        return null;
    }

    @Override
    public String updateIssueBook(IssueBook issueBook) {
        return null;
    }

    @Override
    public String deleteIssueBook(IssueBook issueBook) {
        return null;
    }

    @Override
    public IssueBook getById(Long issue_book_id) {
        return null;
    }

    @Override
    public List<IssueBook> getAll() {
        return null;
    }
}
