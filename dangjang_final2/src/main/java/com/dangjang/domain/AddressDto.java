package com.dangjang.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
public class AddressDto  {
    private  Long id;
    private  String title;
    private  String zipcode;
    private  String address1;
    private  String address2;

    public AddressDto(Long id, String title, String zipcode, String address1, String address2) {
        this.id = id;
        this.title = title;
        this.zipcode = zipcode;
        this.address1 = address1;
        this.address2 = address2;
    }


}
