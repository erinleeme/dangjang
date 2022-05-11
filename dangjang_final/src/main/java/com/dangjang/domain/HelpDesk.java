package com.dangjang.domain;

import com.dangjang.domain.type.HelpType;
import com.dangjang.domain.type.RequestType;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter

public class HelpDesk extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "seq_helpdesk")
    private Long id;


    private String writer;

    private String title;

    @Column(length = 1000)
    private String content;

    @Enumerated(EnumType.STRING)
    private HelpType helpType;
    @Column(length = 1000)
    private String reply;
}
