package com.dangjang.domain;

import com.dangjang.domain.type.OtOStatus;
import com.dangjang.domain.type.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Setter
@Getter
public class OneToOneRequest extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "seq_oto_req")
    private Long id;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @Enumerated(EnumType.STRING)
    @Column(name="oto_status")
    private OtOStatus otoStatus;

    @Column(length = 1000)
    private String content; // 질문 내용

    @Column(name="reply_content", length = 1000)
    private String replyContent;

    @Column(name="complete_date")
    private LocalDateTime completeDate;

    @Enumerated(EnumType.STRING)
    @Column(name="request_type")
    private RequestType requestType;

    private int order_num;

    //private Long seq_image_content;


}
