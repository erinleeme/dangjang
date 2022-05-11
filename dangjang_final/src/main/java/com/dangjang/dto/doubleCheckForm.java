package com.dangjang.dto;

import lombok.Data;

@Data
public class doubleCheckForm {
    private String loginId;

    public doubleCheckForm(String loginId, String nickname, String phone) {
        this.loginId = loginId;
        this.nickname = nickname;
        this.phone = phone;
    }

    private String nickname;
    private String phone;
}
