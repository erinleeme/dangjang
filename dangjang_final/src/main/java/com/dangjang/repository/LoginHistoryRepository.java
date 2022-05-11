package com.dangjang.repository;

import com.dangjang.domain.LoginHistory;
import com.dangjang.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Long> {
    @Query("select l from LoginHistory l where l.member = ?1 order by l.loginDate")
    List<LoginHistory> findAllByMemberOrderByLoginDate(Member member);

    @Modifying
    @Query("update LoginHistory l set l.logoutDate = current_timestamp where l.member = ?1 and l.logoutDate is null") // 로그아웃 기록 남기기
    void logoutLog(long memberId);

}
