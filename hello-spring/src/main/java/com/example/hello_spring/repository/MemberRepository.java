package com.example.hello_spring.repository;

import com.example.hello_spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
	Member save(Member member);
	Optional<Member> getById(long id);
	Optional<Member> getByName(String name);
	List<Member> findAll();
}
