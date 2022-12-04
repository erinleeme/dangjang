package com.dangjang.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CouponMapperDTO {
    private long seq_coupon;
    private String coupon_name;
    private String coupon_content;
    private int coupon_price;
    private int total_count;
    private int used_count;
    private LocalDateTime create_date;
    private LocalDateTime update_date;
    private LocalDateTime end_date;
    private LocalDateTime start_date;

}
