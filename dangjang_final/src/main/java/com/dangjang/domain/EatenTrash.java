package com.dangjang.domain;

import com.dangjang.domain.type.ProductStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)

public class EatenTrash  {
    @Id
    @GeneratedValue
    @Column(name = "seq_et_food")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seq_ref_product")
    private RefrigeratorProduct refrigeratorProduct;

    private int count;

    @Column(name = "product_status")
    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;

    @CreatedDate
    private LocalDateTime createDate;




}
