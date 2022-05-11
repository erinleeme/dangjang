package com.dangjang.domain;

import com.dangjang.domain.type.AlarmType;
import com.dangjang.domain.type.ReadStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Alarm extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "seq_my_alarm")
    private Long id;

    @ManyToOne
    private Member member;

    @Enumerated(EnumType.STRING)
    private AlarmType alarmType; // 냉장고, 일대일문의, 기획전, 리뷰, 쿠폰, 재입고

    @Enumerated(EnumType.STRING)
    private ReadStatus readStatus; // read, unread

    private String url;

    @Column(length = 1000)
    private String content;

    private LocalDateTime readDate;


}
