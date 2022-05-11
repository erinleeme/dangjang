package com.dangjang.domain;

import com.dangjang.domain.type.DeliveryType;
import com.dangjang.domain.type.OrderStatus;
import com.dangjang.domain.type.PayStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * seq_delivery
 * seq_member
 * orderdate(주문날짜)
 * orderstatus(주문 상태)
 * paystatus(결제 상태)
 * seq_mycoupon
 * discountprice(총할인금액)
 * originaltotalprice(할인전 총금액)
 * deliveryprice(배송비)
 * finalprice(최종금액)
 * deliveryType(배송선택)
 */
@Entity
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)

@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue
    @Column(name="seq_order")
    private Long id;

    private int orderNum;// 20223232321

    @OneToOne
    @JoinColumn(name = "seq_delivery")
    private Delivery delivery;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seq_member")
    private Member member;

    @CreatedDate
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus; // 출고 대기, 출고 완료

    @Enumerated(EnumType.STRING)
    private PayStatus payStatus; // 결제대기, 결제오류, 결제완료

    @Column(name = "seq_coupon")
    private Long couponId;

    private int discountPrice;

    private int originalTotalPrice;

    private int deliveryPrice;

    private int finalPrice;

    @Enumerated(EnumType.STRING)
    private DeliveryType deliveryType; // 새벽배송, 일반배송

}
