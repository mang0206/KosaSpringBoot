package springrest.exam.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springrest.exam.domain.User;
import springrest.exam.exception.UserNotFoundException;
import springrest.exam.service.UserService;
import java.util.List;

@RestController
public class UserController1 {
    private  UserService service;
    public UserController1(UserService service){
        this.service=service;
    }
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable  int id){
        User user = service.findOne(id);
        if(user==null){
            throw new UserNotFoundException(String.format("ID 가 [%s] 번인 유저는 없슈!!", id));
        }
        return user;
    }
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){ // @Valid
        User savedUser = service.save(user);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(user);
    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        User user = service.deleteById(id);
        if(user==null){
            throw new UserNotFoundException(String.format("ID 가 [%s] 번인 유저는 없슈!!", id));
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity putUser(@Valid @RequestBody User user, @PathVariable int id){
        User updateUser = service.updateById(user, id);
        if(updateUser == null){
            throw new UserNotFoundException(String.format("ID 가 [%s] 번인 유저는 없슈!!", user.getId()));
        } else {
            return new ResponseEntity(HttpStatus.RESET_CONTENT);
        }
    }
}
