package com.dangjang.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartMapperDTO {
    private long seq_cart;
    private int count;
    private long seq_product;
    private long seq_member;
    private LocalDateTime create_date;

}
