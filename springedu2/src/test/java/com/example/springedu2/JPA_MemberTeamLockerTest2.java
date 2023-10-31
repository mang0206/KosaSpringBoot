package com.example.springedu2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import springjpa.exam.entity.Member;
import springjpa.exam.repository.MemberTeamLockerRepository;
import springjpa.exam.repository.TeamName;

import java.util.List;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class JPA_MemberTeamLockerTest2 {
    @Autowired
    private MemberTeamLockerRepository repo;
    
    @BeforeEach()
    void pr() {
    	System.out.println("=".repeat(80));
    }
    @Test
    void test_bbb1() {
        String teamName = repo.bbb1("둘리");
        System.out.println(teamName);
    }
    @Test
    void test_bbb2() {
        String teamName = repo.bbb2("둘리");
        System.out.println(teamName);
    }
    @Test
    void test_findByTeamName() {
        TeamName result = repo.getByUsername("둘리");
        System.out.println(result.getTeamName());
    }
    @AfterAll
    static void end() {
        System.out.println("=".repeat(80));
        System.out.println("[[[[[[ 테스트 종료 ]]]]]]");
    }
}
