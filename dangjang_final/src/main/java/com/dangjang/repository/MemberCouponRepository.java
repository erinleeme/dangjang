package com.dangjang.repository;

import com.dangjang.domain.Member;
import com.dangjang.domain.MemberCoupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberCouponRepository extends JpaRepository<MemberCoupon, Long> {

    // 현재 사용하지 않은 특정 멤버 쿠폰 리스트(사용가능한 쿠폰 리스트) 유통기한이 끝나지 않은
    @Query("select m from MemberCoupon m join fetch Coupon c where m.member = ?1 and m.usedDate is null and c.endDate > current_timestamp ")
    List<MemberCoupon> findMemberCouponsByMemberAndUsedDateIsNull(Member member);

    @Query("select count(m) from MemberCoupon m inner join fetch Coupon c where m.member = ?1 and m.usedDate is null and c.endDate > current_timestamp")
    int getCouponCount(String memberId); // seq_member 일치, 사용기간이 끝나지않은, 사용기록이 없는 쿠폰 총 갯수

//    List<MemberCoupon>
}
