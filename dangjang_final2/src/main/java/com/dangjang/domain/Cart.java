package com.dangjang.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Cart {
    @Id
    @GeneratedValue
    @Column(name = "seq_cart")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @Column(name = "seq_product")
    private Long productId;

    private int count;  // 상품의 갯수

    @CreatedDate
    private LocalDateTime createDate;

}
