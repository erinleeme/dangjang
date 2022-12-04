package com.dangjang.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CouponMapperSDTO {
    private long seq_coupon;
    private String coupon_name;
    private String coupon_content;
    private int coupon_price;
    private int total_count;
    private int used_count;
    private String create_date;
    private String update_date;
    private String end_date;
    private String start_date;

    private int dday;

}
