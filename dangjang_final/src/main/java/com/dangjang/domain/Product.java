package com.dangjang.domain;

import com.dangjang.domain.type.DiscountOnoff;
import com.dangjang.domain.type.DisplayOnoff;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * "product
 * 상품"
 * seq_product
 * seq_basic_product
 * name(전시 상품 이름)
 * registercount(등록수량)
 * normal_selling(일반판매량)
 * discount_selling(할인판매량)
 * discount_onoff(할인 여부)
 * displayonoff(전시 여부)
 * displayonoff(전시 여부)
 */
@Entity
@Setter
@Getter

public class Product extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "seq_product")
    private Long id;

    @OneToOne
    @JoinColumn(name = "seq_basic_product")
    private BasicProduct basicProduct;

    private String name;


    @Column(name = "product_content", length = 2000)
    private String content;

    private int registerCount;//(등록수량)

    private int normal_selling;//(일반판매량)

    private int  discount_selling;//(할인판매량)

    @Enumerated(EnumType.STRING)
    private DiscountOnoff discountOnoff;

    @Enumerated(EnumType.STRING)
    private DisplayOnoff displayOnoff;



}
