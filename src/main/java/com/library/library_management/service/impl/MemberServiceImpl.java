package com.library.library_management.service.impl;

import com.library.library_management.exceptions.BookNotFoundException;
import com.library.library_management.exceptions.MemberNotFoundException;
import com.library.library_management.model.Address;
import com.library.library_management.model.Member;
import com.library.library_management.repository.IMemberRepository;
import com.library.library_management.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MemberServiceImpl implements IMemberService {
    @Autowired
    private IMemberRepository memberRepository;

    @Override
    public void addMember(Member member, Address address) {
        if (member.getAddresses() == null) {
            member.setAddresses(new ArrayList<>());
        }
        if (address.getMembers() == null) {
            address.setMembers(new ArrayList<>());
        }

        member.getAddresses().add(address);
        address.getMembers().add(member);
        memberRepository.save(member);
    }

    @Override
    public Member updateMember(Member member, Address address) {
        Member existingMember = memberRepository.findById(member.getMemberId()).orElse(null);
        if (existingMember == null) {
            return null;
        }
        existingMember.setName(member.getName());

        List<Address> addresses = existingMember.getAddresses();
        if (!addresses.isEmpty()) {
            Address existingAddress = addresses.get(0);
            existingAddress.setLocation(address.getLocation());
            existingAddress.setPhoneNumber(address.getPhoneNumber());
        }

        return memberRepository.save(existingMember);
    }


    @Override
    public void deleteMember(Member member) {
        Member existingMember = memberRepository.findById(member.getMemberId()).orElse(null);
        if (existingMember == null) {
            new MemberNotFoundException("Member Not Found");
        }
        else{
            memberRepository.delete(existingMember);
        }

    }
    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member getById(Long id) {
        return memberRepository.findById(id).orElseThrow(
                () -> new MemberNotFoundException("User Not Found " + id)
        );
    }


}
