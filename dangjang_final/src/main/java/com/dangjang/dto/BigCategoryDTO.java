package com.dangjang.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
public class BigCategoryDTO {
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private Long id;
    private String name;
    private int viewSeq;
    private String codeName;
}
