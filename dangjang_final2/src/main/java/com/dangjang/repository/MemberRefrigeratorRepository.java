package com.dangjang.repository;

import com.dangjang.domain.MemberRefrigerator;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRefrigeratorRepository extends JpaRepository<MemberRefrigerator, Long> {
//    List<MemberRefrigerator>
//    findAllByMemberAndRefrigeratorAndConnectTypeIsFalse
//            (Member member, Refrigerator refrigerator);

}
