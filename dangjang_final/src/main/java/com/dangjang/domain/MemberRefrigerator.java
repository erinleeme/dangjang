package com.dangjang.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * seq_mem_fridge
 * seq_member
 * seq_refrigerator
 * createDate
 * updateDate
 * status(보임/안보임)
 * 공유 시작 날짜
 * 공유 끝난 날짜
 */
@Entity
@Setter
@Getter

public class MemberRefrigerator extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "seq_mem_fridge")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seq_refrigerator")
    private Refrigerator refrigerator;


    private Boolean connectType;

    private LocalDateTime endDate;





}
