package com.dangjang.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Review {
    @Id
    @GeneratedValue
    @Column(name = "seq_review")
    private Long id;

    @Column(name = "seq_order_item")
    private Long orderItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @Column(length = 1000)
    private String content;

    @Column(length = 1000)
    private String replyContent;

    @CreatedDate
    private LocalDateTime memberDate;

    private LocalDateTime adminDate;

    private int score;
}
