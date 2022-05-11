package com.dangjang.service;

import com.dangjang.dto.CouponMapperDTO;
import com.dangjang.dto.CouponMapperSDTO;
import com.dangjang.dto.MemberCouponMapperDTO;
import com.dangjang.mapper.CouponMapper;
import com.dangjang.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CouponService {
    private final CouponRepository couponRepository;
    private final CouponMapper couponMapper;

    public List<CouponMapperSDTO> getCouponMemberList(List<MemberCouponMapperDTO> memberCouponList) {
        return couponMapper.getCouponMemberList(memberCouponList);
    }

    public void userPlus(String couponId) {
        couponMapper.userPlus(couponId);
    }



}
