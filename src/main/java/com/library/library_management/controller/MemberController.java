package com.library.library_management.controller;

import com.library.library_management.exceptions.MemberNotFoundException;
import com.library.library_management.model.Address;
import com.library.library_management.model.Member;
import com.library.library_management.service.IMemberService;
import com.library.library_management.service.impl.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/member")
public class MemberController {
    private final MemberServiceImpl memberService;

    public MemberController(MemberServiceImpl memberService) {
        this.memberService = memberService;
    }



    @GetMapping("/addMember")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new Member());
        model.addAttribute("address", new Address());
        return "createMemberForm";
    }
    @PostMapping("/memberAdd")
    public String registerMember(@ModelAttribute("member") Member member,
                                 @ModelAttribute("address") Address address,
                                 Model model) {
        member.setName(member.getName().toUpperCase());

        if (address.getPhoneNumber().length() != 10) {
            model.addAttribute("error", "Please enter a 10-digit mobile number");
            return "createMemberForm";
        } else {
            memberService.addMember(member, address);
            System.out.println("The given details entered into the database....");
            return "redirect:/member/createSuccess";
        }
    }


    @GetMapping("/createSuccess")
    public String registrationSuccess(Model model) {
        String successMessage = "Member Registered Successfully";
        model.addAttribute("successMessage", successMessage);
        return "globalSuccessForm";
    }



    @GetMapping("/editMember")
    public String showEditForm(@RequestParam("memberId") Long memberId, Model model) {
        try {
            Member member = memberService.getById(memberId);
            if (member == null) {
                throw new MemberNotFoundException("Member not found with ID: " + memberId);
            }

            model.addAttribute("member", member);
            model.addAttribute("address", member.getAddresses().get(0));

            return "editMemberForm";
        } catch (MemberNotFoundException e) {
            return handlingMemberNotFoundException(model);
        }
    }


    @PutMapping("/updateMember")
    public String updateMember(@ModelAttribute("member") Member member,
                               @ModelAttribute("address") Address address,
                               Model model) {
        member.setName(member.getName().toUpperCase());
        memberService.updateMember(member, address);

        return "redirect:/member/editSuccess";
    }

    @GetMapping("/editSuccess")
    public String updationSuccess(Model model) {
        String successMessage = "Member Updated Successfully";
        model.addAttribute("successMessage", successMessage);
        return "globalSuccessForm";
    }



    @GetMapping("/delete")
    public String showDeleteForm(@RequestParam("memberId") Long memberId, Model model) {
        try {
            Member member = memberService.getById(memberId);
            if (member == null) {
                throw new MemberNotFoundException("Member not found with ID: " + memberId);
            }

            model.addAttribute("member", member);
            model.addAttribute("address", member.getAddresses().get(0));

            return "deleteMemberForm";
        } catch (MemberNotFoundException e) {
            return handlingMemberNotFoundException(model);
        }
    }


    @DeleteMapping("/deleteMember")
    public String deleteMember(@ModelAttribute("member") Member member,
                               @ModelAttribute("address") Address address,
                               Model model) {

        memberService.deleteMember(member);

        return "redirect:/member/deleteSuccess";
    }

    @GetMapping("/deleteSuccess")
    public String deleteSuccess(Model model) {
        String successMessage = "Member Deleted Successfully";
        model.addAttribute("successMessage", successMessage);
        return "globalSuccessForm";
    }

    @GetMapping("/allMembers")
    public String getAllMembers(Model model) {
        List<Member> members = memberService.getAllMembers();
        model.addAttribute("members", members);
        return "getMembers";
    }

    @ExceptionHandler
    private String handlingMemberNotFoundException(Model model) {
        String message = "Member Not Found For The Given Member ID";
        model.addAttribute("message", message);
        return "globalSuccessForm";
    }
}
