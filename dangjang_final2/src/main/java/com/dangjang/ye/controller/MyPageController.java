package com.dangjang.ye.controller;

import com.dangjang.domain.Member;

import com.dangjang.dto.MemberMapperDTO;
import com.dangjang.service.MemberService;
import com.dangjang.service.MyPageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping(value="/dangjang/mypage")
@RequiredArgsConstructor
@Log
public class MyPageController {
    @Autowired
    private final HttpSession session;
    @Autowired
    private final MyPageService myPageService;
    @Autowired
    private final MemberService memberService;

    @GetMapping("/order") // mypage 진입시 미니바, 상품
    public String order(Model model) {
        String memberId = (String)session.getAttribute("seq_member");
        MemberMapperDTO member = myPageService.getInformation2(memberId);

        // 상단 고정박스 ( 주문 / 배송 中 수, 쿠폰 수, 찜한상품 수, 나의냉장고 수)
        // int couponCount = myPageService.getCouponCount(memberId); // 미사용 쿠폰 수량
        // int deliveryCount = myPageService.getDeliveryCount(memberId); // 배송전, 배송중인 수량
        // int favoriteCount = myPageService.getFavoriteCount(memberId); // 찜한 총 상품 수
        // int refrigeratorCount = myPageService.getRefrigeratorCount(memberId);
        // order 하단박스
        //List<Product> list = myPageService.getOrderProduct(memberId); // 주문한 상품 list
        //List<ImageContent> imageList = myPageService.getImage(list); //
        /*model.addAttribute("couponCount", couponCount);
        model.addAttribute("deliveryCount", deliveryCount);
        model.addAttribute("orderProductList", list);*/
        // model.addAttribute("favoriteCount", favoriteCount); // 찜한상품 수
        // model.addAttribute("refrigeratorCount", refrigeratorCount); // 냉장고 수
        model.addAttribute("member", member); // 회원 정보
        model.addAttribute("display", "mypage/snb02_orderList.jsp");
        return "index";
    }

    @GetMapping(value = "/orderClaim")
    public String ordClaimList(Model model){
        model.addAttribute("display", "mypage/snb03_orderClaim.jsp");
        return "index";
    }
    @GetMapping(value = "/pick")
    public String myPick(Model model){
        model.addAttribute("display", "mypage/snb04_pick.jsp");
        return "index";
    }
    @GetMapping(value = "/review")
    public String review(Model model){
        model.addAttribute("display", "mypage/snb05_review.jsp");
        return "index";
    }
    @GetMapping(value = "/coupon")
    public String coupon(Model model){
        model.addAttribute("display", "mypage/snb06_coupon.jsp");
        return "index";
    }
    @GetMapping(value = "/myInfo")
    public String myInfo(Model model){
        String memberId = session.getAttribute("memId") + "";
        MemberMapperDTO member = myPageService.getInformation2(memberId);

        model.addAttribute("member", member);


        String social = session.getAttribute("social") + "";
        System.out.println("MemberSocial >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + social);

        model.addAttribute("social", social);
        model.addAttribute("display", "mypage/snb07_myInfo.jsp");

        return "index";
    }
    @GetMapping(value= "/myInfo1")
    public String myInfoMember(Model model) {
        String memberId = session.getAttribute("memId") + "";
        MemberMapperDTO member = myPageService.getInformation2(memberId);

        System.out.println("myInfo1 member >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + member);

        model.addAttribute("member", member);
        model.addAttribute("display", "mypage/snb07_myInfo.jsp");

        return "index";
    }

    @GetMapping(value = "/qna")
    public String perQna(Model model){
        model.addAttribute("display", "mypage/snb09_qnaList.jsp");
        return "index";
    }

    @GetMapping(value = "/addr")
    public String myAddr(Model model){
        model.addAttribute("display", "mypage/snb10_addr.jsp");
        return "index";
    }

    @GetMapping(value = "/check")
    public String checkMember(Model model){
        model.addAttribute("display", "mypage/checkMember.jsp");
        return "index";
    }


    @PostMapping("/member/modify") // 회원정보 수정 (mapping 이전)
    @ResponseBody
    public String modify(@RequestParam Map<String, String> map, Model model) {
        log.info("---------------------------- map : " + map);
        myPageService.modify(map);

        model.addAttribute("display", "mypage/snb07_myInfo.jsp");
        return "index";
    }


}
