package com.dangjang.repository;

import com.dangjang.domain.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CouponRepository extends JpaRepository<Coupon, Long> {

}