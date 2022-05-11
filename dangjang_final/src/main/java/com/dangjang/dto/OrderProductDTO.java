package com.dangjang.dto;

import com.dangjang.domain.type.ReviewStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
public class OrderProductDTO {
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private Long id;
    private Long productId;
    private int count;
    private ReviewStatus reviewCheck;
    private Long orderId;
}
