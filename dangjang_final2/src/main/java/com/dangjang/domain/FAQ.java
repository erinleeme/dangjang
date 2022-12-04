package com.dangjang.domain;

import com.dangjang.domain.type.RequestType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * "FAQ
 * 자주묻는질문"
 * seq_faq
 * title
 * content
 * reply
 * requestType
 */
@Entity(name="faq")
@Getter
@Setter
public class FAQ extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "seq_faq")
    private Long id;

    @Column(length = 1000)
    private String content;

    @Column(length = 1000)
    private String reply;

    @Column(name="request_type")
    @Enumerated(EnumType.STRING)
    private RequestType requestType; //    상품문의, 일대일문의, 결제문의, 기타문의

    @Column(name = "create_date")
    private LocalDateTime createDate;


}
