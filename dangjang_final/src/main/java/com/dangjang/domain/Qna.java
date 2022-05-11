package com.dangjang.domain;

import com.dangjang.domain.type.QnaType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Qna extends BaseEntity{

    @Id@GeneratedValue
    @Column(name = "seq_qna")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "seq_product")
    private Product product;
    @ManyToOne
    private Member member;

    private String qna_content;
    @Enumerated(EnumType.STRING)
    private QnaType qnaType;

    private String replyContent;
}
