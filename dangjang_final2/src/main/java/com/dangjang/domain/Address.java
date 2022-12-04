package com.dangjang.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
/**
 * "address*
 * 주소지"
 * seq_address
 * addresstitle(배송지명)
 * zipcode(우편번호)
 * address1(주소1)
 * address2(주소2)
 * seq_member
 */

public class Address extends BaseEntity {

    @Id
    // @GeneratedValue
    @Column(name = "seq_address")
    private Long id;

    @Column(name = "address_title")
    private String title;  // 집 누나네 등등

    private String zipcode; //  우편번호

    private String address1; //  검색주소 받아온 값

    private String address2; //  상세 정보

/*    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;*/

    private Boolean baseStatus;
    private String recipient;
    private String recipient_phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seq_member")
    private Member member;

}
