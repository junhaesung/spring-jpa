package com.nhn.edu.jpa.repository;

import com.nhn.edu.jpa.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("select m from Member m join fetch m.details as md")
    List<Member> getMembersWithAssociation();

}
