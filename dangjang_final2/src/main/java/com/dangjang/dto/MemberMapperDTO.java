package com.dangjang.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberMapperDTO {
    private Long seq_member;
    private LocalDateTime create_date;
    private LocalDateTime update_date;
    private boolean agreement;
    private String birth;
    private String email1;
    private String email2;
    private String gender;
    private String login_id;
    private String login_token;
    private String member_grade;
    private String name;
    private String nickname;
    private String pwd;
    private String phone;
    private String platform;
    private String social;
}
