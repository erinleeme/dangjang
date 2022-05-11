package com.dangjang.dto;

import com.dangjang.domain.type.TopDisplayOn;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class NoticeDTO {
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private Long id;
    private String title;
    private String writer;
    private String content;
    private TopDisplayOn topDisplayOn;
}
