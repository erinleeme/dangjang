package com.dangjang.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventMapperDTO {
    private long seq_event;
    private String event_title;
    private String event_content;
    private String url;
    private String event_status;
    private LocalDateTime create_date;
    private LocalDateTime update_date;
    private LocalDateTime start_date;
    private LocalDateTime end_date;
}
