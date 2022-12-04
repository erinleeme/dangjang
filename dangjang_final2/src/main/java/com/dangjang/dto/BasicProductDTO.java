package com.dangjang.dto;

import com.dangjang.domain.type.RegisterStatus;
import com.dangjang.domain.type.StorageMethod;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
public class BasicProductDTO {
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private Long id;
    private String name;
    private String amount;
    private Long smallCategoryId;
    private int originalPrice;
    private int sellingPrice;
    private int count;
    private String producer;
    private String serialNumber;
    private StorageMethod storageMethod;
    private String countryOrigin;
    private LocalDateTime receiveDate;
    private RegisterStatus registerStatus;
    private LocalDateTime productEndDate;
}
