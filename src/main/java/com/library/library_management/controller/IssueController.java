package com.library.library_management.controller;

import com.library.library_management.model.IssueBook;
import com.library.library_management.service.IIssueBookService;
import com.library.library_management.service.impl.IssueBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/issue")
public class IssueController implements IIssueBookService {
    @Autowired
    private IssueBookServiceImpl issueBookService;

    @Override
    public IssueBook addIssueBook(IssueBook issueBook) {
        return issueBookService.addIssueBook(issueBook);
    }

    @Override
    public String updateIssueBook(IssueBook issueBook) {
        issueBookService.updateIssueBook(issueBook);
        return null;
    }

    @Override
    public String deleteIssueBook(IssueBook issueBook) {
        issueBookService.deleteIssueBook(issueBook);
        return null;
    }

    @Override
    public IssueBook getById(Long issue_book_id) {
        return issueBookService.getById(issue_book_id);
    }

    @Override
    public List<IssueBook> getAll() {
        return null;
    }
}
