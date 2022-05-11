package com.dangjang.mapper;

import com.dangjang.dto.MemberMapperDTO;
import com.dangjang.dto.ReviewPlusMapperDTO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface MemberMapper {
    MemberMapperDTO getInformation(long seq_member);
    MemberMapperDTO getMemberInformation(long memId);

    void updateMember(Map<String, String> map);

    void updateSocialMember(Map<String, String> map);

    @Select("select * from member where seq_member = #{memberId} and pwd = #{pwd} ")
    MemberMapperDTO checkMember(Map<String, String> map);

    @Select("select * from member where seq_member = #{memberId}")
    MemberMapperDTO getInformationL(String memberId);

//    불가능 ${memId} ${memname}
//====
//    일반만 공통사항
//    ${mempassword} 확인후 새로운 값 보내기
//====
//    공통 변경사항
//    ${memnickname}
//    ${mememail}
//    ${memphone}
//    ${memnickname}
//    ${memgender}
//    ${membirth}

    @Delete("delete from member where seq_member = #{memId}")
    void deleteMember(@Param("memId") long memId);

    @Select("select * from member where seq_member = #{memId}")
    MemberMapperDTO myPagePwdCheck(@Param("memId") long memId);

    // 상품 상세 리뷰 리스트 작성자 정보
    List<MemberMapperDTO> getMemberByProductReview(List<ReviewPlusMapperDTO> reviewList);


    @Select("select * from member_count")
    Long getMemberCount();

    @Update("update member_count set member_count = #{memberId}")
    void updateMemberCount(@Param("memberId") Long memberId);

}
