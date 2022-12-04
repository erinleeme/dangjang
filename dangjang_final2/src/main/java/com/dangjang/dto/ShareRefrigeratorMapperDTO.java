package com.dangjang.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShareRefrigeratorMapperDTO {
    private long seq_sh_fridge;
    private long seq_member;
    private long seq_refrigerator;
    private LocalDateTime create_date;
    private LocalDateTime update_date;
}
