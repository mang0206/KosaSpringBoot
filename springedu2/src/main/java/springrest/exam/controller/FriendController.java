package springrest.exam.controller;

import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springrest.exam.repository.FriendRepository;
import springrest.exam.entity.Friend;
@RestController
@RequestMapping("/friends")
public class FriendController {
  @Autowired
  FriendRepository friendR;

  @GetMapping("")
  public ResponseEntity<List<Friend>> friendList(){

    return ResponseEntity.ok()
        .body(friendR.findAll());
  }

  @PostMapping("")
  @Transactional
  public ResponseEntity<String> insertFriend(@RequestBody Friend friend) {

    try {
      friendR.save(friend);
    } catch(Exception e){
      System.out.println(e.getMessage());
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("저장 중 오류가 발생했어요");
    }
    return ResponseEntity.status(HttpStatus.CREATED)
        .body("성공적으로 삽입했습니다");
  }

  @GetMapping("/{friendId}")
  public ResponseEntity<Friend> readFriend(@PathVariable("friendId") int friendId){
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json; charset=UTF-8");

    Friend friend;
    try{
      friend = friendR.findById(friendId).get();
    } catch(Exception e){
      headers.add("Bad_id", "" + friendId);
      return ResponseEntity.status(HttpStatus.NO_CONTENT)
          .headers(headers)
          .body(null);
    }
    return ResponseEntity.status(HttpStatus.OK).headers(headers).body(friend);
  }

  @PutMapping("/{friendId}")
  @Transactional
  public ResponseEntity<String> updateFriend(@PathVariable("friendId") int friendId,@RequestBody Friend friend){
    HttpStatus status;
    try {
      Friend oldfriend = friendR.findById(friendId).get();
      oldfriend.setFname(friend.getFname());
      oldfriend.setFage(friend.getFage());
      status = HttpStatus.RESET_CONTENT;
    } catch(Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("수정하는 도중 오류가 발생했습니다.");
    }

    return new ResponseEntity("정보가 변경되었습니다.", HttpStatus.RESET_CONTENT);
//    return ResponseEntity.status(status).body("정보가 변경되었습니다.");
  }

  @DeleteMapping("/{friendId}")
  @Transactional
  public ResponseEntity<String> deleteFriend(@PathVariable("friendId") int friendId) {
    HttpStatus status;

    try {
      friendR.deleteById(friendId);
      status = HttpStatus.RESET_CONTENT;
    } catch(Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("삭제하는 도중 오류가 발생했습니다.");
    }

    return ResponseEntity.status(status).body("삭제되었습니다.");
  }
}
