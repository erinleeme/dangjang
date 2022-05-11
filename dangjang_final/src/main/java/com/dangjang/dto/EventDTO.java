package com.dangjang.dto;

import com.dangjang.domain.type.EventStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
public class EventDTO {
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private Long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private EventStatus eventStatus;
    private String url;
    private String eventTitle;
    private String eventContent;
}
