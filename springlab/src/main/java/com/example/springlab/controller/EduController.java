package com.example.springlab.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class EduController {
  @RequestMapping(value="/educontroller")
  public ModelAndView mav(int avgScore, String name, HttpServletRequest req){
    ModelAndView mav = new ModelAndView();
    mav.addObject("name", name);
    switch (avgScore/10) {
      case 10:
      case 9:
        mav.setViewName("gradeA");
        break;
      case 8:
        mav.setViewName("gradeB");
        break;
      case 7:
        mav.setViewName("gradeC");
        break;
      default:
        mav.setViewName("gradeD");
    }
    mav.addObject("refinfo", req.getHeader("referer"));
    return mav;
  }
}