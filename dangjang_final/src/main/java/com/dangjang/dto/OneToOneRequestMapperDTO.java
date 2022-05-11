package com.dangjang.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OneToOneRequestMapperDTO {
    private long seq_oto_req;
    private long seq_member;
    private String title;
    private String content;
    private String reply_content;
    private String request_type;
    private String oto_status;
    private LocalDateTime contact_date;
    private LocalDateTime complete_date;
    private LocalDateTime create_date;
    private LocalDateTime update_date;

    private int order_num; //주문번호 추가

    private Long seq_image_content;

    private String image1;
    private String image2;
}
