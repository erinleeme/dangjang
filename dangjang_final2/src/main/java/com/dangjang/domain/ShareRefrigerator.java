package com.dangjang.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * seq_sh_fridge
 * seq_refrigerator
 * seq_member
 */
@Entity
@Setter
@Getter
public class ShareRefrigerator extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "seq_sh_fridge")
    private Long id;

    @Column(name = "seq_refrigerator")
    private Long refrigeratorId;

    @Column(name = "seq_member")
    private Long memberId;
}
