package com.dangjang.repository;

import com.dangjang.domain.Cart;
import com.dangjang.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    // 멤버별 카트 목록
    List<Cart> findAllByMemberOrderByCreateDate(Member member);
}
