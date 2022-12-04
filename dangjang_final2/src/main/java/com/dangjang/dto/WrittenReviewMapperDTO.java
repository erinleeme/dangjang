package com.dangjang.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WrittenReviewMapperDTO {
    private String serial_number;
    private String create_date;
    private String count;
    private String name;
    private String content;
    private String reply_content;
    private String score;
    private String image1;
    private String image2;
    private String seq_review;
    private String seq_order_pdt;
}