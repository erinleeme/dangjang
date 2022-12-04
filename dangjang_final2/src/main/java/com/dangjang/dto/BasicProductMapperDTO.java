package com.dangjang.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasicProductMapperDTO {
    private long seq_basic_product;
    private String amount;
    private int count;
    private String country_origin;
    private String name;
    private int original_price;
    private String producer;
    private LocalDateTime receive_date;
    private LocalDateTime product_end_date;
    private String register_status;
    private int selling_price;
    private String serial_number;
    private String storage_method;
    private long seq_middle_category;
    private LocalDateTime create_date;
    private LocalDateTime update_date;

}
