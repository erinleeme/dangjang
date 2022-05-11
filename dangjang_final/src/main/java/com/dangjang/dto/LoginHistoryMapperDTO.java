package com.dangjang.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginHistoryMapperDTO {
    private long seq_log_history;
    private long member_seq;
    private LocalDateTime login_date;
    private LocalDateTime logout_date;
}
