package com.dangjang.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WithDrawalMapperDTO {
    private long seq_delete_member;
    private long seq_member;
    private int agreement;
    private String birth;
    private String email1;
    private String email2;
    private String gender;
    private String login_id;
    private String nickname;
    private String pwd;
    private String phone;
    private String social;
    private String social_token;
    private String login_token;
    private String member_grade;
    private String name;
    private LocalDateTime create_date;
}
