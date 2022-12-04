package com.dangjang.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderProductMapperDTO {
    private long seq_order_pdt;
    private long seq_order;
    private long seq_product;
    private int count;
    private int review_check; // 0(미작성), 1(작성완료)
    private LocalDateTime create_date;
    private LocalDateTime update_date;
    private String order_status;
}
