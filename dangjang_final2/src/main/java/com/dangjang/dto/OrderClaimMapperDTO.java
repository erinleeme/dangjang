package com.dangjang.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderClaimMapperDTO {
    private String serial_number;
    private String order_num;
    private String seq_order;
    private String seq_member;
    private String name; //상품 이름
    private String count;
    private String order_status;
    private String claim_date;
    private String claim_content; //클레임 사유
    private String end_date; //배송완료 날짜
    private String seq_product; //제품 번호
}
