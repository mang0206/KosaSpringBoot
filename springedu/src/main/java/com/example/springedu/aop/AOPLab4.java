package com.example.springedu.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
public class AOPLab4 {
  @AfterThrowing(pointcut="execution(public * com.example.springedu.controller.ExceptionLocalController.detail(..))", throwing="e" )
  public void at(Throwable e){
    log.info("[AOP]오류 발생 : " + e.getMessage());
  }
}
