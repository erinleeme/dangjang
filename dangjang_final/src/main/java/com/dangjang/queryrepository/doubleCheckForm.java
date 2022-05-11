package com.dangjang.queryrepository;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


@Data
public class doubleCheckForm {
    private String loginId;

    private String nickname;
    private String phone;
    @JsonFormat
    private String Address1;
    private String Address2;
    private String zipcode;

    public doubleCheckForm(String loginId, String nickname, String phone, String address1, String address2, String zipcode) {
        this.loginId = loginId;
        this.nickname = nickname;
        this.phone = phone;
        Address1 = address1;
        Address2 = address2;
        this.zipcode = zipcode;
    }
}
