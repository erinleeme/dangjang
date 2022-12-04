package com.dangjang.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class MiddleCategoryDTO {
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private Long id;
    private Long bigCategoryId;
    private String name;
    private int view_seq;
    private String codeName;
}
