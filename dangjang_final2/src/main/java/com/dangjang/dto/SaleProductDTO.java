package com.dangjang.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
public class SaleProductDTO {
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private Long id;
    private Long basicProductId;
    private int discountStockCount;
    private int discountPrice;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
