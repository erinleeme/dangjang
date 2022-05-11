package com.dangjang.domain;

import com.dangjang.domain.type.RegisterStatus;
import com.dangjang.domain.type.StorageMethod;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)

public class BasicProduct extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "seq_basicProduct")
    private Long id;

    private String name;
    private String amount;

    @ManyToOne
    @JoinColumn(name = "seq_middle_category")
    private MiddleCategory smallCategory;

    private int originalPrice;

    private int sellingPrice;

    private int count;

    private String producer;

    private String serialNumber;

    @Enumerated(EnumType.STRING)
    private StorageMethod storageMethod;

    private String countryOrigin;

    private LocalDateTime receiveDate;

    @Enumerated(EnumType.STRING)
    private RegisterStatus registerStatus;

    private LocalDateTime productEndDate;


}
