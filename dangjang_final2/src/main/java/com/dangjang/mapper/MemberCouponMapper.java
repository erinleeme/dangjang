package com.dangjang.mapper;

import com.dangjang.dto.CouponMapperDTO;
import com.dangjang.dto.MemberCouponMapperDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface MemberCouponMapper {
    //사용안한 마이 쿠폰 리스트
    List<MemberCouponMapperDTO> getMyCouponList(Map<String, Object> map);

    //사용 완료로 변경
    @Update("update member_coupon set coupon_status='사용완료' and used_date=now() where seq_coupon = #{couponId}")
    void changeUsed(String couponId);

    @Select("select count(*) from member_coupon where seq_member = #{memberId} and coupon_status = '미사용'")
    int getMemberCouponCount(String memberId);

    List<CouponMapperDTO> getCouponList(Map<String, Object> map);

    // 사용한 쿠폰 삭제
    void deleteUseCoupon(Map<String, Object> cMap);
}