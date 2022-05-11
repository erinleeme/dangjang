package com.dangjang.domain;

import com.dangjang.domain.type.ReviewStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * seq_orderPdt
 * seq_product
 * count
 * reviewwritable(리뷰작성여부)
 */
@Entity
@Setter
@Getter

public class OrderProduct extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "seq_orderPdt")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seq_procuct")
    private Product product;

    private int count;

    private ReviewStatus reviewCheck;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seq_order")
    private Orders order;
}
