package com.example.springedu2;

import jakarta.transaction.Transactional;
import java.util.List;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import springrest.exam.repository.FriendRepository;
import springrest.exam.entity.Friend;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
public class FriendTest {
  @Autowired
  private FriendRepository friendR;

  @Test
  void list(){
    List<Friend> list = friendR.findAll();
    list.stream().forEach(System.out::println);
  }

  @Test
//  @Rollback(false)
  @Transactional
  void save(){
    Friend friend = Friend.builder()
        .fname("갱플랭크")
        .fage(40)
        .build();
    friendR.save(friend);
    friend = Friend.builder()
        .fname("미스포츈")
        .fage(32)
        .build();
    friendR.save(friend);
    friend = Friend.builder()
        .fname("티모")
        .fage(205)
        .build();
    friendR.save(friend);
    friend = Friend.builder()
        .fname("아우솔")
        .fage(100000000)
        .build();
    friendR.save(friend);
    List<Friend> list = friendR.findAll();
    list.stream().forEach(System.out::println);
  }

  @Test
  void serachID(){
    Friend friend;
    try {
      friend = friendR.findById(5).get();
    } catch(Exception e){
      System.out.println("번호가 없어요");
      return;
    }
    System.out.println(friend);
  }

  @Test
  @Transactional
  void update(){
    try {
      Friend friend = friendR.findById(5).get();
      friend.setFname("도로시");
      friend.setFage(1000000);
    } catch(Exception e) {
      System.out.println("수정 실패");
      return;
    }
    System.out.println(friendR.findById(5).get());
  }

  @Test
  @Transactional
  void delete(){
    try {
      friendR.deleteById(5);
    } catch(Exception e) {
      System.out.println("삭제 실패");
    }
    System.out.println(friendR.findById(5));
  }
}
