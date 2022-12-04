package com.dangjang.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RefrigeratorDTO {

    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    private Long id;
    private Long addressId;
    private String name;
    private int bossMemId;
    private String address1;
    private String address2;
    private String zipcode;
}
