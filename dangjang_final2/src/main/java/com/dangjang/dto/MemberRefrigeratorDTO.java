package com.dangjang.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class MemberRefrigeratorDTO {
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private Long id;
    private Long memberMemberId;
    private Long refrigeratorId;
    private Boolean connectType;
    private LocalDateTime endDate;
}
