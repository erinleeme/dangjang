package com.dangjang.dto;

import com.dangjang.domain.type.DiscountOnoff;
import com.dangjang.domain.type.DisplayOnoff;
import com.dangjang.domain.type.StorageMethod;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class ProductDTO {
    private LocalDateTime createDate;    // 생성날짜
    private LocalDateTime updateDate;    // 수정날짜
    private Long seq_product;            // seq 값
    private Long seq_basic_product;      // basicProduct seq 값
    private String name;                 // 상품 명
    private String content;              // 상품 content
    private int registerCount;           // 등록 수량
    private DiscountOnoff discountOnoff; // 할인 여부
    private DisplayOnoff displayOnoff;   // 전시 여부
    private double discount_rate;        // 할인률
    private int discount_price;          // 할인가
    private int price;                   // 정가
    private StorageMethod storageMethod; // 보관상태
}
