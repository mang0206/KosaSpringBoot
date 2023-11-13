package com.example.springedu.aop;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class AOPLab3 {
  @Around("execution(public * com.example.springedu.controller.EmpController.*(..))")
  public void a(ProceedingJoinPoint jp) throws Throwable {
    LocalDateTime start = LocalDateTime.now();
    try {
      jp.proceed();
    } catch(Exception e){
      log.error(e.getMessage());
    }
    Duration duration = Duration.between(start, LocalDateTime.now());
    log.info(String.format("[LOG]-수행시간 %d밀리초 +++++++++++",duration.toMillis()));
  }
}
