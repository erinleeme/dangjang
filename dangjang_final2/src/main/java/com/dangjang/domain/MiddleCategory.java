package com.dangjang.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class MiddleCategory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "seq_big_category")
    private BigCategory bigCategory;

    @Column(name = "category_name")
    private String name;

    private int view_seq;

    private String codeName;
}
