package com.dangjang.ha.controller;

import com.dangjang.dto.MemberMapperDTO;
import com.dangjang.mapper.MemberMapper;
import com.dangjang.service.FavoriteService;
import com.dangjang.service.MemberCouponService;
import com.dangjang.service.MemberService;
import com.dangjang.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping(value="/dangjang/mypage/member")
@RequiredArgsConstructor
public class MyMemberController {
    private final MemberService memberService;
    private final OrderService orderService;
    private final MemberCouponService memberCouponService;
    private final FavoriteService favoriteService;
    private final HttpSession session;

    //회원정보 갖고오기
    @GetMapping(value="/getMemberInfo")
    public String getMemberInfo(Model model) {
        MemberMapperDTO memberMapperDTO = memberService.getMemberInfo();

        model.addAttribute("memberMapperDTO", memberMapperDTO);
        return "/mypage/snb07_myInfo";
    }

    //회원정보수정
    @GetMapping(value="/updateMember")
    @ResponseBody
    public String updateMember(@RequestParam Map<String, String> map, Model model) {
        memberService.updateMember(map);
        return "success";
    }

    //아이디비밀번호 체크
    @GetMapping(value = "/checkMember")
    @ResponseBody
    public String checkMember(@RequestParam Map<String, String> map) {
        System.out.println("pwd>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + map.get("pwd"));

        MemberMapperDTO memberMapperDTO = new MemberMapperDTO();
        memberMapperDTO = memberService.checkMember(map);
        
        System.out.println("memberMapperDTO >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + memberMapperDTO);

        if(memberMapperDTO == null) {
            return "non_exist";
        } else {
            return "exist";
        } // if
    }

    // 회원 탈퇴
    @PostMapping("/withdrawal")
    @ResponseBody
    public String withdrawal() {
        String memberId = session.getAttribute("memId")+"";
        System.out.println("withdrawal>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        return memberService.withdrawal();
    }

    //minibar 개수
    @GetMapping("/miniBarCount")
    public String getMiniBarCount(Model model) {
        int orderCount = orderService.orderCount(); // 주문 수
        int couponCount = memberCouponService.couponCount(); // 보유 쿠폰 수량
        int favoriteCount = favoriteService.getFavoriteCount(); // 찜 상품 수량

        model.addAttribute("orderCount", orderCount);
        model.addAttribute("couponCount", couponCount);
        model.addAttribute("favoriteCount", favoriteCount);

        return "/mypage/minibar";
    }



}