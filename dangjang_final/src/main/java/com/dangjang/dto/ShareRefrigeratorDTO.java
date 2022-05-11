package com.dangjang.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
public class ShareRefrigeratorDTO {
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private Long id;
    private Long refrigeratorId;
    private Long memberId;
}
