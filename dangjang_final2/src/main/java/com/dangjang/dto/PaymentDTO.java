package com.dangjang.dto;

import com.dangjang.domain.type.PayMethod;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
public class PaymentDTO {
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private Long id;
    private Long orderId;
    private PayMethod payMethod;
    private LocalDateTime payDate;
    private int payPrice;
    private String payToken;
    private String approvalNum;
    private String cardCompany;
    private String depositorName;
    private String Bank;

    private String payment_status;

}
