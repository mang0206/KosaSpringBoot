package com.example.springlab.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LottoDTO {
    private int cnt;
    private int lottoNum;
    private String result;
    private String imgName;

    public void setCnt() {
        this.cnt++;
    }
    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}

