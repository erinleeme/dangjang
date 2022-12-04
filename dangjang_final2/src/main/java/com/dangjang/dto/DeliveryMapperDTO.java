package com.dangjang.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryMapperDTO {
    private long seq_delivery;
    private long seq_address;
    private String address1;
    private String address2;
    private String zipcode;
    private String orderer_name;
    private String orderer_phone;
    private String parcel_company;
    private String parcel_details;
    private String parcel_type;
    private String recipient_name;
    private String recipient_phone;
    private String tracking_number;
    private String delivery_status;
    private LocalDateTime start_date;
    private LocalDateTime end_date;
    private LocalDateTime create_date;
    private LocalDateTime update_date;
}
