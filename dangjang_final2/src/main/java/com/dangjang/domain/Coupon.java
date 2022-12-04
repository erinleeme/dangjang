package com.dangjang.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;


@Entity
@Setter
@Getter
public class Coupon extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "seq_coupon")
    private Long id;

    @Column(name = "coupon_name")
    private String name; // 쿠폰명

    @Column(name = "coupon_content", length = 1000)
    private String content;

    private int couponPrice;

    private int totalCount;

    private int usedCount;

    private LocalDateTime startDate;

    private LocalDateTime endDate;


}
