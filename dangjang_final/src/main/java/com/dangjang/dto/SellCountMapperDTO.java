package com.dangjang.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellCountMapperDTO {
    private long seq_sellcount;
    private long seq_product;
    private int inventory;
    private int selling_count;
}
