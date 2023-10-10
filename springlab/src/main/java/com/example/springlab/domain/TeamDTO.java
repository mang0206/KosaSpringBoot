package com.example.springlab.domain;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TeamDTO {
  private String teamName;
  private List<TeamMemberVO> teamMember;

  public String toString(){
    return teamName;
  }
}
