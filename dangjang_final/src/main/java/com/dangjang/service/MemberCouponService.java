package com.dangjang.service;

import com.dangjang.dto.CouponMapperDTO;
import com.dangjang.dto.MemberCouponMapperDTO;
import com.dangjang.mapper.CouponMapper;
import com.dangjang.mapper.MemberCouponMapper;
import com.dangjang.paging.MemberCouponPaging;
import com.dangjang.repository.MemberCouponRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = false)
@RequiredArgsConstructor
@Log
public class MemberCouponService {
    private final MemberCouponRepository memberCouponRepository;
    private final MemberCouponMapper memberCouponMapper;
    private final HttpSession session;
    private final MemberCouponPaging memberCouponPaging;
    private final CouponMapper couponMapper;

    public List<MemberCouponMapperDTO> getMemberCouponList() { // 회원이 보유중인 쿠폰 list
        long memId = (long) session.getAttribute("memId");

        List<MemberCouponMapperDTO> memberCouponList = couponMapper.getMemberCoupon(memId);
        return memberCouponList;
    }

    public List<MemberCouponMapperDTO> getMyCouponList(String pg) {
        String memberId = session.getAttribute("memId")+"";
        //String memberId = "1";

        int endPage = Integer.parseInt(pg) * 10;
        int startPage = endPage - 9;
        log.info("---------------- 멤버쿠폰 전체 리스트 / where조건: startPage= " + startPage + " endPage= " + endPage);

        Map<String, Object> map = new HashMap<>();
        map.put("startPage", startPage);
        map.put("endPage", endPage);
        map.put("memberId", memberId);

        return memberCouponMapper.getMyCouponList(map);
    }

    public void changeUsed(String couponId) {
        memberCouponMapper.changeUsed(couponId);
    }

    public MemberCouponPaging paging(String pg) {
        String memberId = session.getAttribute("memId") + "";

        int totalRecords = memberCouponMapper.getMemberCouponCount(memberId);
        log.info("----------------paging " + totalRecords);
        memberCouponPaging.setCurrentPage(Integer.parseInt(pg));
        memberCouponPaging.setRecordsPerPage(10);
        memberCouponPaging.setPageSize(10);
        memberCouponPaging.setTotalRecords(totalRecords);
        memberCouponPaging.makePaging();
        return memberCouponPaging;
    }

    public int couponCount() {
        String memberId = session.getAttribute("memId") + "";
        return memberCouponMapper.getMemberCouponCount(memberId);
    }

    public List<CouponMapperDTO> getCouponList(List<MemberCouponMapperDTO> memberCouponList) {
        Map<String, Object> map = new HashMap<>();
        String memId = session.getAttribute("memId") + "";
        map.put("memId", memId);
        map.put("list", memberCouponList);
        return memberCouponMapper.getCouponList(map);
    }
}
