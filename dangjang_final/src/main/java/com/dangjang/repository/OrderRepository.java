package com.dangjang.repository;


import com.dangjang.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface OrderRepository extends JpaRepository<Orders,Long> {

    @Query("select o from Orders o where o.member = ?1") // seq_member 로 해당되는 order 정보값 list 에 저장
    List<Orders> getOrders(String memberId);
}
