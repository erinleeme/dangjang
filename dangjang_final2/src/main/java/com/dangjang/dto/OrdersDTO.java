package com.dangjang.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersDTO {
    private long seq_order;
    private long seq_my_coupon; //
    private long seq_delivery;
    private long seq_member;
    private long seq_coupon;
    private int delivery_price;
    private int discount_price;
    private int final_price;
    private long order_num;
    private int original_total_price;
    private String delivery_type;
    private String order_status;
    private String pay_status;
    private LocalDateTime order_date;
}
