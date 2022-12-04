package com.dangjang.domain;

import com.dangjang.domain.type.LocationType;
import com.dangjang.domain.type.RegisterType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * seq_ref_product
 * name
 * registercount(처음 등록 재고수)
 * shelflifestartdate유통기한 시작날짜
 * shelflifeenddate유통기한 마감날짜
 * updatedate냉장고 산입날짜
 * storage보관 위치
 * eaten_count
 * trash_count
 * nowcount(현재 재고수)
 * seq_mem_fridge
 */
@Entity
@Getter
@Setter

public class RefrigeratorProduct extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "seq_ref_product")
    private Long id;

    private String name;

    @Column(name = "item_start_date")
    private LocalDateTime itemStartDate;

    @Column(name = "item_end_date")
    private LocalDateTime itemEndDate;

    @Column(name = "location_type")
    @Enumerated(EnumType.STRING)
    private LocationType locationType;

    @Column(name = "eaten_count")
    private int eatenCount;

    @Column(name = "trash_count")
    private int trashCount;

    @Column(name = "now_count")
    private int nowCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="seq_refrigerator")
    private Refrigerator refrigerator;

    @Column(name = "seq_product")
    private Long productId;

    @Enumerated(EnumType.STRING)
    private RegisterType registerType;

}
