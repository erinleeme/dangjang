package com.dangjang.dto;

import lombok.Data;

@Data
public class SellCountDTO {
    private long seq_sellCount; // seq 값
    private long seq_product;   // product seq 값
    private int inventory;      // 등록 재고 수
    private int selling_count;  // 판매 수

}
