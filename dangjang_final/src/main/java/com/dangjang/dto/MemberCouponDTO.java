package com.dangjang.dto;

import com.dangjang.domain.type.CouponStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
public class MemberCouponDTO {
    private Long id;
    private CouponStatus couponStatus;
    private Long memberMemberId;
    private Long couponId;
    private LocalDateTime receiveDate;
    private LocalDateTime usedDate;
}
