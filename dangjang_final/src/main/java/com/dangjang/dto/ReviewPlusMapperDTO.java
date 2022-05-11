package com.dangjang.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReviewPlusMapperDTO {
    private long seq_review;
    private long seq_member;
    private String name;
    private long seq_order_item;
    private String content;
    private String reply_content;
    private int score;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime member_date;
    private LocalDateTime admin_date;
}
