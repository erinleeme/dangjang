package com.dangjang.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter

public class SaleProduct extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "seq_sale_product")
    private Long id;

    @OneToOne
    @JoinColumn(name = "seq_basic_product")
    private BasicProduct basicProduct;

    private int discountStockCount; // 할인재고 수량

    private int discountPrice;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

}
