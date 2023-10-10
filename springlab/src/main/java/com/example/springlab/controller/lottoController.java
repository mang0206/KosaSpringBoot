package com.example.springlab.controller;

import com.example.springlab.domain.LottoDTO;
import java.util.Random;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("lotto")
public class lottoController {
  @ModelAttribute("lotto")
  public LottoDTO createLotto(){
    return new LottoDTO();
  }
  @RequestMapping("/lotto")
  public String lotto(@ModelAttribute("lotto")LottoDTO dto, Model model, @RequestHeader String referer){
    dto.setCnt();
    System.out.println(dto.getCnt());
    if(dto.getCnt() >= 4){
      dto.setImgName("snow");
      dto.setResult("로또 응모는 낙첨된 경우에 한하여 3번 까지만 가능합니다. <br> 브라우저를 재기동한 후에 응모해 주세요.");
    }
    else {
      if (new Random().nextInt(6) + 1 == dto.getLottoNum()) {
        dto.setImgName("sun");
        dto.setResult("추카추카!");
        dto.setCnt(4);
      } else {
        dto.setImgName("cloud");
        dto.setResult("아쉽네요.. 다음 기회를!!");
        model.addAttribute("refinfo", referer);
      }
    }
    return "lottoView";
  }
}
