package com.dangjang.ha.controller;

import com.dangjang.dto.CouponMapperDTO;
import com.dangjang.dto.CouponMapperSDTO;
import com.dangjang.dto.MemberCouponMapperDTO;
import com.dangjang.service.CouponService;
import com.dangjang.service.MemberCouponService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping(value = "/dangjang/mypage/memberCoupon")
public class MemberCouponController {
    private final MemberCouponService memberCouponService;
    private final CouponService couponService;

    //사용전인 쿠폰들 목록 가져오기
    @GetMapping(value="/myCouponList")
    //@ResponseBody
    public String getMyCouponList(@RequestParam(required = false, defaultValue = "1") String pg, Model model) {
        int count = 0;
        //사용안한 쿠폰 목록 가져오기
        List<MemberCouponMapperDTO> memberCouponList = memberCouponService.getMyCouponList(pg);
        //쿠폰 목록
        List<CouponMapperSDTO> myCouponList = couponService.getCouponMemberList(memberCouponList);



        Map<String, Object> map = new HashMap<>();
        map.put("memberCouponPaging", memberCouponService.paging(pg));
        map.put("myCouponList", myCouponList);

        for(CouponMapperSDTO couponMapperSDTO : myCouponList) {
            if(couponMapperSDTO.getDday() >= 0) {
                count++;
            }
        }

        model.addAttribute("memberCouponPaging", memberCouponService.paging(pg));
        model.addAttribute("myCouponList", myCouponList);
        model.addAttribute("couponCount", count);

        return "/mypage/xCoupon";
    }

    //쿠폰 사용 시 사용완료로 변경
    @PostMapping(value="/useCoupon")
    public void changeUsed(@RequestParam Map<String, String> map) {
        String couponId = map.get("couponId");

        //해당 쿠폰 사용 완료로 변경
        memberCouponService.changeUsed(couponId);

        //쿠폰 사용량 1 증가시키기
        couponService.userPlus(couponId);
    }

    //쿠폰 개수
    @GetMapping(value="/couponCount")
    @ResponseBody
    public int couponCount() {
        return memberCouponService.couponCount();
    }
}
