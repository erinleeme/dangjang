package com.dangjang.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EatenTrashMapperDTO {
    private long seq_et_food;
    private long seq_ref_product;
    private int count;
    private String product_status;
    private LocalDateTime create_date;
}
