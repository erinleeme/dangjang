package com.dangjang.domain;

import com.dangjang.domain.type.DeliveryStatus;
import com.dangjang.domain.type.ParcelType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
/**
 * seq_delivery
 * seq_address
 * parcel_company(배송업체)
 * zipcode(받는이 우편)
 * address1(받는이 주소)
 * address2(받는이 상세주소)
 * tracking number(운송장 번호)
 * orderer_name(주문자 이름)
 * orderer_phone(주문자 번호)
 * recipient_name받는이 이름
 * recipient_phone(받는이 전화번호)
 * pracelType(배송 요청 유형)
 * parcelDetails(배송 세부 요청사항)
 */
public class Delivery extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "seq_delivery")
    private Long id;

    @Column(name = "seq_address")
    private Long addressId;

    private String parcelCompany;

    private String zipcode;

    private String address1;

    private String address2;

    private String trackingNumber;

    private String ordererName;

    private String ordererPhone;

    private String recipientName;

    private String recipientPhone;

    @Enumerated(EnumType.STRING)
    private ParcelType parcelType; // option 형식 현관앞에 놔주세요

    @Column(length = 1000)
    private String parcelDetails; // 입력 받아서

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @OneToOne(mappedBy = "delivery")
    private  Orders order;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;
}
