package com.dangjang.dto;

import com.dangjang.domain.type.Gender;
import com.dangjang.domain.type.Social;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
public class WithDrawalDTO {
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private Long memberId;
    private String loginId;
    private String password;
    private String nickName;
    private String email1;
    private String email2;
    private String phone;
    private String birth;
    private Gender gender;
    private boolean agreement;
    private String socialToken;
    private Social social;
}
