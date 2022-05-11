package com.dangjang.service;

import com.dangjang.dto.AddressMapperDTO;
import com.dangjang.dto.DeliveryMapperDTO;
import com.dangjang.mapper.AddressMapper;
import com.dangjang.mapper.DeliveryMapper;
import com.dangjang.repository.DeliveryRepository;
import com.dangjang.util.naverSMS;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;
    private final DeliveryMapper deliveryMapper;
    private final AddressMapper addressMapper;

    @Transactional
    public String deliveryOk(Map<String, Object> map) {
        DeliveryMapperDTO deliveryMapperDTO = new DeliveryMapperDTO();
        String seq_delivery = deliveryMapper.getSeq_delivery();
        if(seq_delivery.isEmpty() || seq_delivery == null) {
            seq_delivery = "0";
        }
        AddressMapperDTO addressMapperDTO = addressMapper.getAddressOne(map.get("base-status"));
        System.out.println(addressMapperDTO);

        deliveryMapperDTO.setSeq_delivery(Integer.parseInt( seq_delivery)+1); // seq_delivery
        deliveryMapperDTO.setSeq_address(addressMapperDTO.getSeq_address());
        deliveryMapperDTO.setRecipient_name((String) addressMapperDTO.getReceptionName()); // 받는이 이름
        deliveryMapperDTO.setRecipient_phone((String) addressMapperDTO.getRecipient_phone()); // 받는이 휴대폰
        deliveryMapperDTO.setAddress1((String) addressMapperDTO.getAddress1()); // address1 받는이 주소
        deliveryMapperDTO.setAddress2((String) addressMapperDTO.getAddress2()); // address2 받는이 상세주소
        deliveryMapperDTO.setZipcode((String) addressMapperDTO.getZipcode()); // zipcode 받는이 우편번호
        deliveryMapperDTO.setOrderer_name((String) map.get("orderer_name")); // 주문자 이름
        deliveryMapperDTO.setOrderer_phone((String) map.get("orderer_phone")); // 주문자 휴대폰
        deliveryMapperDTO.setParcel_type((String) map.get("새벽배송")); // 배송 요청 유형
        deliveryMapperDTO.setParcel_details((String) map.get("writeDeliveryMessage")); // 배송 요청 세부사항
        deliveryMapperDTO.setDelivery_status("배송전"); // 배송상태
        deliveryMapperDTO.setParcel_company("당장택배");

        naverSMS naverSMS = new naverSMS();
        StringBuffer buf = naverSMS.randomCode(); // 랜덤코드 생성
        deliveryMapperDTO.setTracking_number(buf+""); // tracking_number 운송장번호

        deliveryMapper.deliveryInsert(deliveryMapperDTO);

        return "success";
    }

    // mypage
    public DeliveryMapperDTO getOrderDelivery(String deliveryNum) {
        return deliveryMapper.getOrderDelivery(deliveryNum);
    }
    public DeliveryMapperDTO getOrderDeliveryDetail(Map<String, String> map) {
        return deliveryMapper.getOrderDeliveryDetail(map);
    }

}
