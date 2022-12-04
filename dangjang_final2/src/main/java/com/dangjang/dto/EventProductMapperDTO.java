package com.dangjang.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventProductMapperDTO {
    private long seq_event_product;
    private long seq_event;
    private long seq_product;
    private int event_id;
    private int product_id;
    private LocalDateTime create_date;
    private LocalDateTime update_date;
}
