package com.dangjang.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
public class CouponDTO {
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private Long id;
    private String name;
    private String content;
    private int couponPrice;
    private int totalCount;
    private int usedCount;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
