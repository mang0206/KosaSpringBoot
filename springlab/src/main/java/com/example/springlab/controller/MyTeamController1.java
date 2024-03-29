package com.example.springlab.controller;

import com.example.springlab.domain.TeamDTO;
import com.example.springlab.domain.TeamMemberVO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("my")
public class MyTeamController1 {

  @ModelAttribute("my")
  public TeamDTO teamDTO() {
    return new TeamDTO();
  }

  @RequestMapping("/myTeam1")
  public String myteam(@RequestParam(defaultValue = "null")String request,
      @ModelAttribute("my")TeamDTO teamDTO, Model model) {
    System.out.println(request);
    if (request.equals("null")) {
      return "myTeamView";
    } else if (request.equals("Name")) {
      model.addAttribute("response", "Name");
      teamDTO.setTeamName("UniMeeting");
      return "myTeamView";
    } else {
      List<TeamMemberVO> list = new ArrayList<>();
      list.add(new TeamMemberVO("도회", "도회", "피자"));
      list.add(new TeamMemberVO("민재", "맹", "치킨"));
      list.add(new TeamMemberVO("애림", "림두콩", "김치찌개"));
      list.add(new TeamMemberVO("동우", "우동", "우동"));
      teamDTO.setTeamMember(list);

      model.addAttribute("response", "Member");
      return "myTeamView";
    }
  }

}
