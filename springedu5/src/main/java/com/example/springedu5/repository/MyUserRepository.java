package com.example.springedu5.repository;

import com.example.springedu5.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;



public interface MyUserRepository extends JpaRepository<MyUser, Long>{
	MyUser findByUsername(String username);
}
