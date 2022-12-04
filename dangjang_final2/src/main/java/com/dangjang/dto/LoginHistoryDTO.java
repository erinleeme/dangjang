package com.dangjang.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
public class LoginHistoryDTO {
    private Long id;
    private Long memberMemberId;
    private LocalDateTime loginDate;
    private LocalDateTime logoutDate;
}
