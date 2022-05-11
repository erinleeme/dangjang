package com.dangjang.domain;

import com.dangjang.domain.type.PayMethod;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * seq_payment
 * seq_orders(주문내역)
 * pay_method(결제수단)
 * paydate(결제일자)
 * payprice(실제 결제 금액)
 * paytoken(결제 api 토큰 정보)
 * approval_num(승인번호(카드))
 * card_company(카드회사(카드))
 * depositor_name(입금자명(무통장))
 * bank(입금은행(무통장))
 * 기획전 이미지 냉장고
 */

@Entity
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)

public class Payment extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "seq_payment")
    private Long id;

    @OneToOne
    @JoinColumn(name = "seq_order")
    private Orders order;

    @Enumerated(EnumType.STRING)
    private PayMethod payMethod; //    카카오페이, 네이버페이, 가상계좌

    @CreatedDate
    private LocalDateTime payDate; //(결제일자)

    private int payPrice;//(실제 결제 금액)

    private String payToken;//(결제 api 토큰 정보)

    private String approvalNum;//(승인번호(카드))

    private String cardCompany;//(카드회사(카드))

    private String depositorName;//(입금자명(무통장))

    private String Bank;


}
