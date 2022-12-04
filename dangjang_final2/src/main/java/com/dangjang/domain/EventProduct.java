package com.dangjang.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter

public class EventProduct  extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "seq_event_product")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "seq_product")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "seq_event")
    private Event event;

}
