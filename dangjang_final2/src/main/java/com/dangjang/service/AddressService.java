package com.dangjang.service;

import com.dangjang.domain.Address;
import com.dangjang.domain.AddressDto;
import com.dangjang.domain.Member;
import com.dangjang.dto.AddressMapperDTO;
import com.dangjang.mapper.AddressMapper;
import com.dangjang.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional(readOnly = false)
@RequiredArgsConstructor
@Log
public class AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;
    private final HttpSession session;


//    @Transactional
//    public void insert(Address address){
//        addressRepository.save(address);
//    }

    //회원별 배송지 리스트 갖고오기
//    public List<Address> addressListByMember(Member member){
//        return addressRepository.findAllByMember(member);
//    }

    //기본 배송지 먼저, 아닌 것은 나중에
    public List<AddressMapperDTO> addressListByMember(String memberId) {
        return addressMapper.addressListByMember(memberId);
    }

//    @Transactional
//    public void update(AddressDto addressDto){
//        Optional<Address> updateAddress = addressRepository.findById(addressDto.getId());
//        updateAddress.ifPresent(Address->{
//            Address.setAddress1(addressDto.getAddress1());
//            Address.setAddress2(addressDto.getAddress2());
//            Address.setZipcode(addressDto.getZipcode());
//            Address.setTitle(addressDto.getTitle());
//        });
//    }


    public void newAddressRegister(Map<String, String> map, Member member) {
        Address address = new Address();
        address.setTitle(map.get("addrName"));       // 배송지명
        address.setZipcode(map.get("zipcode"));        // 우편번호
        address.setAddress1(map.get("addr1"));         // 주소
        address.setAddress2(map.get("a_addr_detail")); // 상세주소
        address.setMember(member);
        addressRepository.save(address);         // insert into address
    }

    //배송지 등록
    public void addAddress(Map<String, String> map) {
        System.out.println("addressService----------------------------------");
        System.out.println("memberID-------------- : " + session.getAttribute("memId"));

        String memberId = session.getAttribute("memId") + "";
        //System.out.println("memberId : " + memberId);
        //String memberId = "1";
        map.put("memberId", memberId);

        System.out.println(map.get("defaultStatus"));
        if(map.get("defaultStatus").equals("1")) {
            map.put("base_status", "1");
            //기존 기본 배송지를 먼저 non basic으로 수정
            AddressMapperDTO addressMapperDTO = addressMapper.getBaseAdr();
            addressMapper.updateBaseToNon(addressMapperDTO.getSeq_address());
        } else {
            map.put("base_status", "0");
        }
        addressMapper.addAddress(map);
    }

    public void deleteAddress(String addressId) {
        addressMapper.deleteAddress(addressId);
    }

    //수정
    public void updateAddress(Map<String, String> map) {
        System.out.println("addressService-----------");
        System.out.println("memberID----- : " + session.getAttribute("memId"));

        String memberId = session.getAttribute("memId") + "";

        map.put("memberId", memberId);

        System.out.println(map.get("defaultStatus"));
        if(map.get("defaultStatus").equals("1")) {
            map.put("base_status", "1");
            //기존 기본 배송지를 먼저 non basic으로 수정
            AddressMapperDTO addressMapperDTO = addressMapper.getBaseAdr();
            addressMapper.updateBaseToNon(addressMapperDTO.getSeq_address());
        } else {
            map.put("base_status", "0");
        }
        addressMapper.updateAddress(map);
    }

    // 상품
    public List<AddressMapperDTO> getMemberAddress() {
        String memberId = session.getAttribute("memId")+"";
        List<AddressMapperDTO> addressList = addressMapper.addressListByMember(memberId);
        log.info("----------------------------------addressList " + addressList);
        return addressList;
    }

    // 상품
    public String addressAdd(Map<String, String> map) {
        String seq_member = session.getAttribute("memId")+"";
        map.put("seq_member", seq_member);
        String base_status = Integer.toString(Integer.parseInt(addressMapper.getLatelyBaseStatus(seq_member)) + 1);
        map.put("base_status", base_status);
        addressMapper.addressAdd(map);
        log.info("----------장바구니에서 배송지 추가 " + map);
        return base_status;
    }

    public AddressMapperDTO getOrderAddress(String baseStatus) {
        String seq_member = session.getAttribute("memId")+"";
        return addressMapper.getOrderAddress(seq_member, baseStatus);
    }
}
