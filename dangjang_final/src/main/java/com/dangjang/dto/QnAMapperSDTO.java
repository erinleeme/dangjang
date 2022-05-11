package com.dangjang.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QnAMapperSDTO {
    private long seq_qna;
    private long seq_member;
    private long seq_product;
    //private String qna_type;
    private String qna_content;
    private String reply_content;
    private String create_date;
    private String update_date;
    private String reply_date;
}
