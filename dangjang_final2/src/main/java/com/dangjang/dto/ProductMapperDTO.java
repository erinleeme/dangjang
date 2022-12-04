package com.dangjang.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductMapperDTO {
    private long seq_product;
    private long seq_basic_product;
    private String name;
    private String product_content;
    private int price;
    private double discount_rate;
    private int discount_price;
    private String display_onoff;
    private String discount_onoff;
    private int register_count;
    private String storage_method;
    private LocalDateTime create_date;
    private LocalDateTime update_date;
}
