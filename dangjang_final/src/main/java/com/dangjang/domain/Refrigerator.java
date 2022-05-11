package com.dangjang.domain;

import lombok.Cleanup;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * seq_refrigerator
 * refrigeratorName
 * seq_address
 * seq_mem_fridge
 * bossmemberid
 * address1
 * address2
 * zipcode
 */

@Entity
@Setter
@Getter

public class Refrigerator extends BaseEntity{
    @Id
    // @GeneratedValue  autoincrement 사용을 해도 1++ 이 아니라 .............. 값이 이상하게 들어감 1이 들어가야하는데 52가 들어감 ㄹㅇ ㅋㅋ
    @Column(name = "seq_refrigerator")
    private Long id;

    @Column(name = "seq_address")
    private Long addressId;

    @Column(name = "refrigeratorName")
    private String name;

    @Column(name = "boss_mem_id")
    private int bossMemId;

    @Column
    private String address1;

    @Column
    private String address2;

    @Column
    private String zipcode;



}
