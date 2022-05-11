package com.dangjang.repository;

import com.dangjang.domain.ShareRefrigerator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ShareRefrigeratorRepository extends JpaRepository<ShareRefrigerator, Long> {
    @Query("select s from ShareRefrigerator s where s.memberId = ?1 and s.refrigeratorId = ?2")
    List<ShareRefrigerator> findByMemberIdAndRefrigeratorId(Long memberId, Long refrigeratorId);

    @Query("select s from ShareRefrigerator s where s.refrigeratorId = ?1")
    List<ShareRefrigerator> findByRefrigeratorId(Long refrigeratorId);

    @Query("select s from ShareRefrigerator s where s.memberId = ?1")
    List<ShareRefrigerator> findByMemberId(Long memberId);



}
