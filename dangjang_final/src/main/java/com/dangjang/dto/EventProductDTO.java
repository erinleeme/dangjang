package com.dangjang.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
public class EventProductDTO {
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private Long id;
    private Long productId;
    private Long eventId;
}
