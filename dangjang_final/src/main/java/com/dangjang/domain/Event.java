package com.dangjang.domain;

import com.dangjang.domain.type.EventStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter

public class Event extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "seq_event")
    private Long id;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @Enumerated(EnumType.STRING)
    private EventStatus eventStatus;

    private String url;

    private String eventTitle;
    @Column(length = 1000)
    private String eventContent;
}
