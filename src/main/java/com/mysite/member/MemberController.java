package com.mysite.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	@GetMapping("/new")
	public String newMember(NewMember newMember) {
		return "memberForm";
	}
		
	@PostMapping("/new")
	public String newMember(@Valid NewMember newMember, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "memberForm";
		}
		if(!newMember.getPassword1().equals(newMember.getPassword2())) { //bindingResult.rejectValue(필드명, 오류코드, 에러메시지)
			bindingResult.rejectValue("password2", "passwordInCorrect","2개의 패스워드가 일치하지 않습니다.");
			return "memberForm";
		}
		try {
			this.memberService.create(newMember.getName(),newMember.getEmail(),newMember.getPassword1(),newMember.getAddress());
			
		}catch(Exception e) {
			bindingResult.rejectValue("email", "sameEmail", "이메일이 중복됨");
			return "memberForm";
		}
		
		return "redirect:/main";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
}
