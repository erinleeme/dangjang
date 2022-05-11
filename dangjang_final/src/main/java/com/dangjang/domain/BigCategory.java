package com.dangjang.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter

public class BigCategory extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "seq_big_category")
    private Long id;

    @Column(name = "category_name")
    private String name;

    private int viewSeq;

    private String codeName;

    @OneToMany(mappedBy = "bigCategory")
    private List<MiddleCategory> middleCategory;

}
