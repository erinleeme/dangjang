package com.dangjang.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMapperDTO {
    private long seq_payment;
    private long seq_order;
    private int pay_price;
    private String bank;
    private String approval_num;
    private String card_company;
    private String depositor_name;
    private String pay_method;
    private String pay_token;
    private LocalDateTime pay_date;
    private LocalDateTime create_date;
    private LocalDateTime update_date;

    private String payment_status;
}
