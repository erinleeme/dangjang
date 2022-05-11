package com.dangjang.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberRefrigeratorMapperDTO {
    private long seq_mem_fridge;
    private long seq_member;
    private long seq_refrigerator;
    private String connect_type;
    private LocalDateTime create_date;
    private LocalDateTime update_date;
    private LocalDateTime start_date;
    private LocalDateTime end_date;

}
