package com.example.springedu.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component()
@Aspect
@Slf4j
public class AOPLab2 {
  @Before("execution(public * com.example.springedu.controller.MultiController.select_proc(..))")
  public void b() {
    log.info("[AOP]Select_proc 수행 전 ######");
  }

  @After("execution(public * com.example.springedu.controller.MultiController.search_proc(..))")
  public void a() {
    log.info("[AOP]Select_proc 수행 후 ######");
  }
}
