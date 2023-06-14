package com.library.library_management.service.impl;

import com.library.library_management.exceptions.IssueBookNotFoundException;
import com.library.library_management.exceptions.MemberNotFoundException;
import com.library.library_management.model.IssueBook;
import com.library.library_management.model.Member;
import com.library.library_management.repository.IBookRepository;
import com.library.library_management.repository.IIssueBookRepository;
import com.library.library_management.repository.IMemberRepository;
import com.library.library_management.service.IIssueBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IssueBookServiceImpl implements IIssueBookService {
    private final IIssueBookRepository issueBookRepository;
    private final IMemberRepository memberRepository;
    private final IBookRepository bookRepository;

    @Autowired
    public IssueBookServiceImpl(IIssueBookRepository issueBookRepository, IMemberRepository memberRepository, IBookRepository bookRepository) {
        this.issueBookRepository = issueBookRepository;
        this.memberRepository = memberRepository;
        this.bookRepository = bookRepository;
    }

    public void issueBook(IssueBook issueBook, Long memberId) throws MemberNotFoundException {
        if (memberId == null) {
            throw new IllegalArgumentException("Invalid memberId. memberId is null.");
        }

        Optional<Member> checkMember = memberRepository.findById(memberId);
        if (checkMember.isPresent()) {
            Member member = checkMember.get();
            issueBook.setMember(member);
            issueBookRepository.save(issueBook);
        } else {
            throw new MemberNotFoundException("Member not found with the given Id.");
        }
    }


    @Override
    public IssueBook updateIssueBook(IssueBook issueBook) {
        IssueBook issueCheck = issueBookRepository.findById(issueBook.getIssueBookId()).orElse(null);
        if(issueCheck == null){
            return null;
        }
        issueCheck.setReturnDate(issueBook.getReturnDate());
        return issueBookRepository.save(issueCheck);
    }

    @Override
    public String deleteIssueBook(IssueBook issueBook) {
        return null;
    }

    @Override
    public IssueBook getById(Long id) {
        return issueBookRepository.findById(id).orElseThrow(
                ()-> new IssueBookNotFoundException("Issue book is not found")
        );
    }

    @Override
    public List<IssueBook> getAll() {

        return issueBookRepository.findAll();
    }
}
