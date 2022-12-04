package com.dangjang.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefrigeratorProductMapperDTO {
    private long seq_ref_product;
    private long seq_product;
    private long seq_refrigerator;
    private String location_type;
    private String name;
    private String register_count;
    private String register_type;
    private int now_count;
    private int trash_count;
    private int eaten_count;
    private LocalDateTime item_end_date;
    private LocalDateTime item_start_date;
    private LocalDateTime create_date;
    private LocalDateTime update_date;

}
