package com.dangjang.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReviewPossibleMapperDTO {
    private String name; //상품 이름
    private String serial_number;
    private String seq_member;
    private String review_check;
    private String count;
    private String order_status;
    private String create_date;
    private String seq_order_pdt;
}
