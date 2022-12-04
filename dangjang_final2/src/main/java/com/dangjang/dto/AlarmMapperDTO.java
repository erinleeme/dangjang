package com.dangjang.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlarmMapperDTO {
    private Long seq_my_alarm;
    private Long seq_member;
    private String alarm_type;
    private String content;
    private LocalDateTime read_date;
    private String read_status;
    private String url;
    private LocalDateTime create_date;
    private LocalDateTime update_date;

}
