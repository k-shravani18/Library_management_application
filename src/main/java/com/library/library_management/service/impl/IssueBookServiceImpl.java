package com.library.library_management.service.impl;

import com.library.library_management.exceptions.MemberNotFoundException;
import com.library.library_management.model.IssueBook;
import com.library.library_management.model.Member;
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

    @Autowired
    public IssueBookServiceImpl(IIssueBookRepository issueBookRepository, IMemberRepository memberRepository) {
        this.issueBookRepository = issueBookRepository;
        this.memberRepository = memberRepository;
    }
    public void issueBook(IssueBook issueBook, Long memberId) throws MemberNotFoundException {

        // Validate the memberId parameter
        if (memberId == null) {
            throw new IllegalArgumentException("Invalid memberId. memberId is null.");
        }
        Optional<Member> checkMember = memberRepository.findById(memberId);
        if(checkMember.isPresent()) {
            issueBookRepository.save(issueBook);
        }
        else throw new MemberNotFoundException("member is not found with given Id ");
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
