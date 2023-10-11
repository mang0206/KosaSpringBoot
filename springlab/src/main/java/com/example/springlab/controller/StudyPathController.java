package com.example.springlab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudyPathController {
  @RequestMapping(value = "/study/{id}/thymeleaf")
  public String memberHandle(@PathVariable("id") int num) {
    switch (num) {
      case 1:
        return "redirect:https://abbo.tistory.com/56";
      case 2:
        return "redirect:https://abbo.tistory.com/57";
      case 3:
        return "redirect:https://www.thymeleaf.org/doc/tutorials/3.1/usingthymeleaf.html";
      default:
        return "redirect:https://www.baeldung.com/dates-in-thymeleaf";
    }
  }
}
