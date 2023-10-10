package com.example.springlab.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TeamMemberVO {
  private String name;
  private String nickName;
  private String food;

  public String toString(){
    return String.format("%s : 별병은 %s이고 좋아하는 음식은 %s입니다.", name, nickName, food);
  }
}
