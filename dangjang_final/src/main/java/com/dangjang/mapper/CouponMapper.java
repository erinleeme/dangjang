package com.dangjang.mapper;

import com.dangjang.dto.CouponMapperDTO;
import com.dangjang.dto.CouponMapperSDTO;
import com.dangjang.dto.MemberCouponMapperDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface CouponMapper {
    List<MemberCouponMapperDTO> getMemberCoupon(long memId);

    List<CouponMapperSDTO> getCouponMemberList(List<MemberCouponMapperDTO> memberCouponList);

    //사용량 증가 + 1
    @Update("update coupon set used_count = used_count + 1 where seq_coupon = #{couponId}")
    void userPlus(String couponId);

    void wellcomCoupon(Map<String, Object> map);
}
