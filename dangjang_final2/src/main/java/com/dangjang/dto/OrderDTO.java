package com.dangjang.dto;

import com.dangjang.domain.type.DeliveryType;
import com.dangjang.domain.type.OrderStatus;
import com.dangjang.domain.type.PayStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class OrderDTO {
    private Long id;
    private int orderNum;
    private Long deliveryId;
    private Long memberMemberId;
    private LocalDateTime orderDate;
    private OrderStatus orderStatus;
    private PayStatus payStatus;
    private Long couponId;
    private int discountPrice;
    private int originalTotalPrice;
    private int deliveryPrice;
    private int finalPrice;
    private DeliveryType deliveryType;
}
