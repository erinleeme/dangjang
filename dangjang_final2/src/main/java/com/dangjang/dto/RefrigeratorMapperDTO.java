package com.dangjang.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefrigeratorMapperDTO {
    private long seq_refrigerator;
    private long seq_address;
    private String address1;
    private String address2;
    private int boss_mem_id;
    private String refrigerator_name;
    private String zipcode;
    private LocalDateTime create_date;
    private LocalDateTime update_date;

}
