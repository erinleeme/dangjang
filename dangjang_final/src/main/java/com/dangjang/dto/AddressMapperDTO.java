package com.dangjang.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressMapperDTO {
    private long seq_address;
    private LocalDateTime create_date;
    private LocalDateTime update_date;
    private String address1;
    private String address2;
    private String address_title;
    private String zipcode;
    private long seq_member;
    private int base_status;
    private String recipient;
    private String recipient_phone;
    private String receptionName; //배송지 별명 추가
    private String addressContent; //추가 입력 사항
}
