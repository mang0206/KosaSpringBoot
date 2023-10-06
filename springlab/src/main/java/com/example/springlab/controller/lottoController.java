package com.example.springlab.controller;

import com.example.springlab.domain.LottoDTO;
import java.util.Random;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class lottoController {
  @RequestMapping("/lotto")
  public String lotto(@ModelAttribute("lotto")LottoDTO dto, Model model, @RequestHeader String referer){
    int ran = new Random().nextInt(6)+1;
    System.out.println(ran);

    if(ran == dto.getLottoNum()){
      dto.setImgName("<img src='/images/sun.png'>");
      dto.setResult("추카추카!");
    } else {
      dto.setImgName("<img src='/images/cloud.png'>");
      dto.setResult("아쉽네요.. 다음 기회를!!");
      model.addAttribute("refinfo", referer);
    }
    return "lottoView";
  }
}
