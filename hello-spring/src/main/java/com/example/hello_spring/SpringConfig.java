package com.example.hello_spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.hello_spring.repository.MemberRepository;
import com.example.hello_spring.repository.MemoryMemberRepository;

import service.MemberService;

@Configuration
public class SpringConfig {
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}
	
	@Bean
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
}
