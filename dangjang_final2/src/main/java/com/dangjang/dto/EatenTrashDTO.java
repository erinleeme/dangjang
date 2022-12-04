package com.dangjang.dto;

import com.dangjang.domain.type.ProductStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
public class EatenTrashDTO {
    private Long id;
    private Long refrigeratorProductId;
    private int count;
    private ProductStatus productStatus;
    private LocalDateTime createDate;
}
