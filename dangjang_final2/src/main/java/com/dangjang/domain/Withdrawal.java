package com.dangjang.domain;

import com.dangjang.domain.type.Gender;
import com.dangjang.domain.type.Social;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity

public class Withdrawal extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "seq_withdrawal")
    private Long memberId; // pk

    @Column(name = "login_id")
    private String loginId;    // login

    @Column(name = "pwd")
    private String password;

    private String nickName;

    private String email1;

    private String email2;

    private String phone;

    private String birth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private boolean agreement;// true false 값만 들어갈 수 있음

    private String socialToken;

    @Enumerated(EnumType.STRING)
    private Social social;

}
