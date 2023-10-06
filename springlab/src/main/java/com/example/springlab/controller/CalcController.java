package com.example.springlab.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalcController {
  @RequestMapping(value = "/calc.do")
  public ModelAndView clacDo(int firstNum,
      @RequestParam("operator") String op, int secondNum, HttpServletRequest req){
    ModelAndView mav = new ModelAndView();
    mav.addObject("refinfo", req.getHeader("referer"));
    int result = 0;
    switch(op){
      case "plus":
        result = firstNum + secondNum;
        break;
      case "minus":
        result = firstNum - secondNum;
        break;
      case "multiply":
        result = firstNum * secondNum;
        break;
      default:
        if(secondNum == 0) {
          mav.setViewName("errorResult");
          return mav;
        }
        result = firstNum / secondNum;
    }

    mav.addObject("result", result);
    mav.setViewName("calcResult");
    return mav;
  }
}
