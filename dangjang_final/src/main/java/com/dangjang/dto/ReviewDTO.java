package com.dangjang.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
public class ReviewDTO {
    private Long id;
    private Long orderItemId;
    private Long memberMemberId;
    private String content;
    private String replyContent;
    private LocalDateTime memberDate;
    private LocalDateTime adminDate;
    private int score;
}
