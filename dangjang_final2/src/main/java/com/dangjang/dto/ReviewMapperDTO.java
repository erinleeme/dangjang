package com.dangjang.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewMapperDTO {
    private long seq_review;
    private long seq_member;
    private long seq_order_item;
    private String content;
    private String reply_content;
    private int score;
    private LocalDateTime member_date;
    private LocalDateTime admin_date;
}
