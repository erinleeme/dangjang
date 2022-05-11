package com.dangjang.dto;

import com.dangjang.domain.type.AlarmType;
import com.dangjang.domain.type.ReadStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class AlarmDTO implements Serializable {
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private Long id;
    private AlarmType alarmType;
    private ReadStatus readStatus;
    private String url;
    private String content;
    private LocalDateTime readDate;
    private Long memberId;
}
