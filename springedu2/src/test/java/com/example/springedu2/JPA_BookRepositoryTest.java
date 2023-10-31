package com.example.springedu2;


import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;
import springjpa.exam.entity.Book;
import springjpa.exam.repository.BookRepository;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)
@DataJpaTest
public class JPA_BookRepositoryTest {
  @Autowired
  private BookRepository bookR;

  @BeforeEach()
  void pr(){
    System.out.println("=".repeat(80));
  }

  @Test
  @Order(1)
  void allBook(){
    List<Book> list = bookR.findAll();
    list.stream().forEach(System.out::println);
  }

  //2
  @Test
  @Order(4)
  void oneBook(){
    Book book = bookR.findById(10);

    if (book != null)
      System.out.println(book);
    else
      System.out.println("********* 존재하지 않음!!***********");
  }

  //3
  @Test
  @Order(2)
  void orderPriceBook(){
    List<Book> list = bookR.findAll(Sort.by("price").descending());
    list.stream().forEach(System.out::println);
  }

  //4
  @Test
  @Order(3)
  void graterBook(){
    List<Book> list = bookR.findByPriceGreaterThanEqual(20000);
    list.stream().forEach(System.out::println);
  }

  //5
//  @Test
//  void kindBook(){
//    List<Book> list = bookR.findByKind("b01");
//    list.stream().forEach(System.out::println);
//  }

  //6
  @Test
  @Order(10)
  void startwidhBook(){
    List<Book> list = bookR.findByTitleStartsWith("바닐라");
    list.stream().forEach(System.out::println);
  }

  //7
  @Test
  @Order(5)
  void searchBook(){
    List<Book> list = bookR.findByTitleContainsOrTitleContains("자바", "스프링");
    list.stream().forEach(System.out::println);
  }

  //8
  @Test
  @Order(7)
  void minPriceBook(){
    Book book = bookR.findTopByOrderByPrice();
    System.out.println(book);
  }

  //9
  @Test
  @Order(8)
  void countBook(){
    long cnt = bookR.countBy();
    System.out.printf("전체 도서의 수 : %d권", cnt);
  }

  @Test
  @Order(9)
  void countKindBook(){
    long cnt = bookR.countByKind("b05");
    System.out.printf("b05 분류의 도서는 %d권", cnt);
  }

  @Test
  @Order(6)
  void avgKindBook(){
    List<Object> list = bookR.avgBook();
    list.stream().forEach(b -> {
        for(Object o : (Object[])b) {
          System.out.printf(o + " ");
        }
      System.out.println();
    });
  }
}
