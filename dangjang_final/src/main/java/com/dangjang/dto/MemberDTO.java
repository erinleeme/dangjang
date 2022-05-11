package com.dangjang.dto;

import com.dangjang.domain.MemberGrade;
import com.dangjang.domain.type.Gender;
import com.dangjang.domain.type.Social;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
public class MemberDTO {
    private Long memberId;
    private String loginId;
    private String password;
    private String nickname;
    private String email1;
    private String email2;
    private String phone;
    private String birth;
    private Gender gender;
    private boolean agreement;
    private String loginToken;
    private Social platform;
    private MemberGrade memberGrade;
    private String name;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
