package com.dangjang.repository;

import com.dangjang.domain.Alarm;
import com.dangjang.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface AlarmRepository extends JpaRepository<Alarm, Long> {
        @Query("select a from Alarm a where a.member = ?1")
        List<Alarm> findAllByMember(Member member);

}
