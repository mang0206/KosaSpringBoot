package com.example.springedu.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component(value="advice")
@Aspect
@Slf4j
public class AOPLab1 {
  @Before("execution(public String com.example.springedu.controller.HelloController.hello(..))")
  public void b() {
    log.info("[AOP]hello 수행 전 ==============================");
  }

  @After("execution(public String com.example.springedu.controller.HelloController.*(..))")
  public void a() {
    System.out.println();
    log.info("[AOP]hello 수행 후 ==============================");
  }
}
