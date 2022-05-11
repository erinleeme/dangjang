package com.dangjang.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleProductMapperDTO {
    private long seq_sale_product;
    private long seq_basic_product;
    private int basic_product_id;
    private int discount_total;
    private int discount_price;
    private int discount_stock_count;
    private LocalDateTime end_date;
    private LocalDateTime start_date;
    private LocalDateTime create_date;
    private LocalDateTime update_date;
}
