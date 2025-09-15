package com.example.hello_spring.service;


import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.example.hello_spring.domain.Member;
import com.example.hello_spring.repository.MemoryMemberRepository;

import service.MemberService;

public class MemberServiceTest {
	MemberService memberservice;
	MemoryMemberRepository memberRepository;
	
	@org.junit.jupiter.api.BeforeEach
	public void BeforeEach() {
		memberRepository = new MemoryMemberRepository();
		memberservice = new MemberService(memberRepository);
	}
	
	@AfterEach
	public void afterEach() {
		memberRepository.clearStore();
	}
	
	@Test
	void join() {
		//given
		Member member = new Member();
		member.setName("hi");
		//when
		Long savedId = memberservice.join(member);
		//then
		Member findMember = memberservice.findOne(savedId).get();
		assertThat(member.getName()).isEqualTo(findMember.getName());
	}
	@Test
	void checkDupledateMember() {
		//given
		Member member = new Member();
		member.setName("hi");
		Member member2 = new Member();
		member2.setName("hi");
		//when
		memberservice.join(member);
		IllegalStateException e = assertThrows(IllegalStateException.class, ()->{
			memberservice.join(member2);
		});
		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
	}
	@Test
	void findOne() {

	}
}
