package com.hg.gym.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hg.gym.model.Member;
import com.hg.gym.repository.MemberRepository;


@Controller
public class MemberController {
	@Autowired
	private MemberRepository memberRepository;
	
	@GetMapping("/members")
	public String getMembers(Model model) {
		List<Member> members = memberRepository.findAll();
		model.addAttribute("members", members);
		return "members";
	}
	
	@GetMapping("/members/new")
	public String getNewMemberForm(Model model) {
		model.addAttribute("member", new Member());
		return "add-member-form";
	}
	
	@PostMapping("/members")
	public String saveMember(@ModelAttribute Member member) {
	    memberRepository.save(member);
	    return "redirect:/members";
	  }
	
	@GetMapping("/members/{id}")
	public String getMemberById(@PathVariable Long id, Model model) {
		Optional<Member> memberOptional = memberRepository.findById(id);
		if(memberOptional.isPresent()) {
			Member member = memberOptional.get();
			model.addAttribute("member", member);
			return "member-details";
		}else {
			return "error: member not found";
		}
	}
	
	  @GetMapping("/members/{id}/edit")
	  public String getEditMemberForm(@PathVariable Long id, Model model) {
	    Optional<Member> memberOptional = memberRepository.findById(id);
	    if (memberOptional.isPresent()) {
	      Member member = memberOptional.get();
	      model.addAttribute("member", member);
	      return "update-member-form"; // Reuse member-form view for editing
	    } else {
	      // Handle case where member with id is not found (e.g., display error message)
	      return "error"; // Update view name for error page (optional)
	    }
	  }
	
	@PostMapping("/members/{id}/update")
	public String updateMember(@PathVariable Long id, @ModelAttribute Member member) {
		Optional<Member> memberOptional = memberRepository.findById(id);
		if(memberOptional.isPresent()) {
			Member existingMember = memberOptional.get();
		      existingMember.setName(member.getName()); // Update fields as needed
		      existingMember.setEmail(member.getEmail());
		      existingMember.setPlan(member.getPlan());
		      existingMember.setStartDate(member.getStartDate());
		      memberRepository.save(existingMember);			
			return "redirect:/members";
		}else {
			return "error: member not found";
		}
	}
	
	@PostMapping("/members/{id}/delete")
	public String deleteMember(@PathVariable Long id) {
	  Optional<Member> memberOptional = memberRepository.findById(id);
	  if (memberOptional.isPresent()) {
	    memberRepository.deleteById(id);
	    return "redirect:/members"; 
	  } else {
	    return "error"; 
	  }
	}
}
