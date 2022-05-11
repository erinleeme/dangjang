package com.dangjang.dto;

import com.dangjang.domain.type.QnaType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
public class QnaDTO {
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private Long id;
    private Long productId;
    private Long memberMemberId;
    private String qna_content;
    //private QnaType qnaType;
    private String replyContent;
    private LocalDateTime reply_date;
}
