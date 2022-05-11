package com.dangjang.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BigCategoryMapperDTO {
    private long seq_big_category;
    private int view_seq;
    private String code_name;
    private String category_name;
    private LocalDateTime create_date;
    private LocalDateTime update_date;
}
