package com.dangjang.dto;

import com.dangjang.domain.type.DeliveryStatus;
import com.dangjang.domain.type.ParcelType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
public class DeliveryDTO {
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private Long id;
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
    private ParcelType parcelType;
    private String parcelDetails;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long orderId;
    private DeliveryStatus deliveryStatus;
}
