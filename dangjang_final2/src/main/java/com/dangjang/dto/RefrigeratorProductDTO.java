package com.dangjang.dto;

import com.dangjang.domain.type.LocationType;
import com.dangjang.domain.type.RegisterType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
public class RefrigeratorProductDTO {
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private Long id;
    private String name;
    private LocalDateTime itemStartDate;
    private LocalDateTime itemEndDate;
    private LocationType locationType;
    private int eatenCount;
    private int trashCount;
    private int nowCount;
    private Long refrigeratorId;
    private Long productId;
    private RegisterType registerType;
}
