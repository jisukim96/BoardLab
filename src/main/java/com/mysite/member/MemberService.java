package com.mysite.member;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;
	
	public Member create(String mname,String email, String mpassword,String address) {
		Member member = new Member();
		member.setMName(mname);
		member.setEmail(email);
		member.setAddress(address);
		member.setMPassword(this.passwordEncoder.encode(mpassword));
		this.memberRepository.save(member);
		return member;
		
	}
}
