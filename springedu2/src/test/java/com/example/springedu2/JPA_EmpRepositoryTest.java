package com.example.springedu2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import springjpa.exam.entity.Emp;
import springjpa.exam.repository.EmpRepository;

import java.util.List;
import java.util.stream.Stream;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
public class JPA_EmpRepositoryTest {
    @Autowired
    private EmpRepository empR;

    @BeforeEach()
    void pr() {
        System.out.println("=".repeat(80));
    }

    @Test
    void list1() {
    	List<Emp> list = empR.findAll();
    	list.stream().forEach(System.out::println);
    }
    @Test
    void list2() {
        List<Emp> list = empR.findAll(Sort.by("sal").descending());
        list.stream().forEach(System.out::println);
    }
    @Test
    void list3() {
        List<Emp> list = empR.findAll(Sort.by("sal").ascending());
        list.stream().forEach(System.out::println);
    }
    @Test
    void list4() {
        Page<Emp> list = empR.findAll(PageRequest.of(0, 2));
        list.stream().forEach(System.out::println);
    }
    @Test
    void list5() {
        Page<Emp> list = empR.findAll(PageRequest.of(3, 4));
        list.stream().forEach(System.out::println);
    }
    @Test
    void list6() {
        List<Emp> list = empR.findAll(Sort.by("ename"));
        list.stream().forEach(System.out::println);
    }
    @Test
    void list7() {
        Page<Emp> list = empR.findAll(PageRequest.of(0, 3, Sort.by("ename")));
        list.stream().forEach(System.out::println);
    }
}
