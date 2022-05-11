package com.dangjang.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QnAPlusMapperDTO {
    private long seq_qna;
    private long seq_member;
    private long seq_product;
    private String name;
    private String qna_type;
    private String qna_content;
    private String reply_content;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime create_date;
    private LocalDateTime update_date;
    private LocalDateTime reply_date;
}
