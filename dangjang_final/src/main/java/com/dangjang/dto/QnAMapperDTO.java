package com.dangjang.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QnAMapperDTO {
    private long seq_qna;
    private long seq_member;
    private long seq_product;
    //private String qna_type;
    private String qna_content;
    private String reply_content;
    private LocalDateTime create_date;
    private LocalDateTime update_date;
    private LocalDateTime reply_date;
}
