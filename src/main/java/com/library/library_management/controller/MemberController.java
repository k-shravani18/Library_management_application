package com.library.library_management.controller;

import com.library.library_management.model.Address;
import com.library.library_management.model.Member;
import com.library.library_management.service.IMemberService;
import com.library.library_management.service.impl.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberServiceImpl memberService;

    public void addMember(Member member) {
        memberService.addMember(member);
    }

    public String updateUser(Member user) {
        memberService.updateUser(user);
        return null;
    }

    public String deleteUser(Member user) {
        memberService.deleteUser(user);
        return null;
    }


    public List<Member> getAll() {
        return null;
    }

    public Member getById(Long id) {
        return memberService.getById(id);
    }
}
