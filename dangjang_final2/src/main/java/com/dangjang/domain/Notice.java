package com.dangjang.domain;

import com.dangjang.domain.type.TopDisplayOn;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter

public class Notice extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "seq_notice")
    private Long id;

    private String title;

    private String writer;

    @Column(length = 1000)
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(name="top_display_on")
    private TopDisplayOn topDisplayOn;

    @Column(name = "create_date")
    private LocalDateTime createDate;

}
