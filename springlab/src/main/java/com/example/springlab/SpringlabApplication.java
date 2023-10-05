package com.example.springlab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = {"com.example.springlab", "thymeleaf.exam"})
public class SpringlabApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringlabApplication.class, args);
  }

}
