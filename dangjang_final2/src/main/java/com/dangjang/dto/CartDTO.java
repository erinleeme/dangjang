package com.dangjang.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
public class CartDTO {
    private Long id;
    private Long memberId;
    private Long productId;
    private int count;
    private LocalDateTime createDate;
}
