package com.dangjang.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HelpDeskMapperDTO {
    private long seq_helpdesk;
    private String title;
    private String content;
    private String writer;
    private String reply;
    private String help_type;
    private LocalDateTime create_date;
    private LocalDateTime update_date;

}
