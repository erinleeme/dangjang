package com.dangjang.domain;

import com.dangjang.domain.type.CouponStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)

public class MemberCoupon {
    @Id
    @GeneratedValue
    @Column(name = "seq_member_coupon")
    private Long id;

    @Enumerated(EnumType.STRING)
    private CouponStatus couponStatus; //사용전, 사용완료

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    private Coupon coupon;

    @CreatedDate // Entity가 생성되어 저장 시간 자동 저장
    private LocalDateTime receiveDate;

    private LocalDateTime usedDate;
}
