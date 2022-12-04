package com.dangjang.dto;

import com.dangjang.domain.type.HelpType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class HelpDeskDTO {
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private Long id;
    private String writer;
    private String title;
    private String content;
    private HelpType helpType;
    private String reply;
}
