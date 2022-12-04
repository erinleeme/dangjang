package com.dangjang.ha.controller;

import com.dangjang.domain.Address;
import com.dangjang.domain.Member;
import com.dangjang.dto.AddressDTO;
import com.dangjang.dto.AddressMapperDTO;
import com.dangjang.mapper.AddressMapper;
import com.dangjang.service.AddressService;
import com.dangjang.service.MyPageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/dangjang/mypage/addr")
@RequiredArgsConstructor
@Log
public class AddressController {
    private final AddressService addressService;
    private final MyPageService myPageService;
    @Autowired
    private final HttpSession session;

    //배송지 등록&수정
    @PostMapping(value = "/addrOk")
    @ResponseBody
    public String addAddress(@RequestParam Map<String, String> map){
        log.info("----------new Address  map : " + map);

        if(map.get("seq_address").equals("-1")) {
            addressService.addAddress(map);
        } else {
            addressService.updateAddress(map);
        }
        //addressService.newAddressRegister(map,member);
        return "addAddr";
    }

    //배송지 전체 리스트(기본 배송지 우선으로)
    @GetMapping(value="/myaddress")
    //@ResponseBody
    public String getMyAddressList(Model model) {
        String memberId = session.getAttribute("memId") + "";
        List<AddressMapperDTO> addressList = addressService.addressListByMember(memberId);
        //System.out.println(list);
        model.addAttribute("addressList", addressList);
        return "/mypage/xAddress";
    }

    //배송지 수정
    @PostMapping(value="/updateAddress")
    @ResponseBody
    public void updateAddress(@RequestParam Map<String, String> map) {
        String memberId = session.getAttribute("membId")+"";
        map.put("memberId", memberId);
    }

    //배송지 삭제
    @PostMapping(value="/deleteAddress")
    @ResponseBody
    public String deleteAddress(@RequestParam Map<String, String> map) {
        String addressId = map.get("seq_address");
        System.out.println("addressId delete -----------------------------------------" + addressId);
        addressService.deleteAddress(addressId);
        return "deleteAddressOk";
    }


}
