package com.dangjang.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberCouponMapperDTO {
    private long seq_member_coupon;
    private long seq_coupon;
    private long seq_member;
    private String coupon_status;
    private LocalDateTime receive_date;
    private LocalDateTime used_date;
}
