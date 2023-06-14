package com.library.library_management.service;

import com.library.library_management.model.Address;
import com.library.library_management.model.Member;

import java.util.List;
public interface IMemberService {
    void addMember(Member member, Address address);
    Member updateMember(Member member, Address address);

    void deleteMember(Member member);
    public List<Member> getAllMembers();

    Member getById(Long id);



}
