package com.dangjang.repository;

import com.dangjang.domain.Member;
import com.dangjang.dto.MemberDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 테이블
 * cart
 * favorite
 * with~
 * alarm
 * memberHistory
 * address
 * onetoone
 * <p>
 * faq - admin
 */

public interface MemberRepository extends JpaRepository<Member, Long> {

    // 일반 로그인
    @Query("select m from Member m where m.loginId = ?1 and m.password = ?2")
    Member findByLoginIdAndPassword(String loginId, String pwd);

    // 소셜로그인
    @Query("select m from Member m where m.email1 = ?1 and m.email2 = ?2")
    Member socialLogin(String email1, String email2);


    // 로그인 아이디가 있으면 true
    Member findByLoginId(String loginId);
    // 중복된 폰번호가 있으면 true
    Member findByPhone(String Phone);
    // 중복된 nickname이 있으면 true
    Member findByNickname(String nickname);

    @Query("select m from Member m where m.email1 = ?1 and m.email2 = ?2")
    Member findByEmail1AndEmail2(String email, String email2);
    
    @Query("select m from Member m where m.phone = ?1") // 폰번호로 아이디 찾기
    MemberDTO findIdByPhone(String phone);

    @Query("select m from Member m where m.loginId = ?1") // pwd 변경시 있는 회원인지 확인
    Member findPwd(String loginId);

    @Query("select m from Member m where m.memberId = ?1") // seq_member 로 회원 정보 가져오기
    Member getInformation(String memberId);

    @Query("select m from Member m where m.memberId = ?1") // seq_member 로 회원 정보 가져오기  파라미터 Long
    Member getInformationL(Long memberId);

    @Query("select m from Member m order by m.memberId desc")
    List<Member> lastMemberId();

    List<Member> findTop1ByOrderByMemberIdDesc();

    @Modifying
    @Query("update Member m set m.password = ?1 where m.memberId = ?2") // pwd 변경
    void modifyPwd(String d_repwd, Long memberId);

    @Query("update Member m set m.password = ?1, m.email1 = ?1, m.email2 = ?1, m.gender = ?1, m.birth = ?1, m.nickname = ?1 where m.memberId = ?2")
    void modifyAll(Member member, Long memberId);
}

