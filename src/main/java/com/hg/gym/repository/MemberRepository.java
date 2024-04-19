package com.hg.gym.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hg.gym.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

}
