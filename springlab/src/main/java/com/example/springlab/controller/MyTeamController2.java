package com.example.springlab.controller;

import com.example.springlab.domain.TeamDTO;
import com.example.springlab.domain.TeamMemberVO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

@RestController
public class MyTeamController2 {
  @RequestMapping(value = "/myTeam2", produces = "application/json; charset=utf-8")
  public TeamDTO jsonTeam() {
    TeamDTO my = new TeamDTO();
    my.setTeamName("UniMeeting");

    List<TeamMemberVO> list = new ArrayList<>();
    list.add(new TeamMemberVO("도회", "도회", "피자"));
    list.add(new TeamMemberVO("민재", "맹", "치킨"));
    list.add(new TeamMemberVO("애림", "림두콩", "김치찌개"));
    list.add(new TeamMemberVO("동우", "우동", "우동"));
    my.setTeamMember(list);
    return my;
  }

}
