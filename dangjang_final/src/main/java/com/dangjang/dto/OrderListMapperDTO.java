package com.dangjang.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderListMapperDTO {
    private String seq_order;
    private String order_date;
    private String recipient_name;
    private String final_price;
    private String name;
    private String serial_number;
    private String delivery_status;

    private String pay_status;
    private String order_num; //주문번호

    private String orderItem; //주문한 상품 개수
}
