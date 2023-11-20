package com.example.springedu6.repository;

import com.example.springedu6.entity.JwtMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JwtMemberRepository extends JpaRepository<JwtMember, Integer> {
    JwtMember findByEmailAndPassword(String email, String password);
}