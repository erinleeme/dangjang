package com.dangjang.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class AddressDTO {
    private Long id;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private String title;
    private String zipcode;
    private String address1;
    private String address2;
    private Boolean baseStatus;
    private String recipient;
    private String recipient_phone;
}
