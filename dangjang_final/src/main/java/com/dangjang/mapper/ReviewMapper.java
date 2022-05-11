package com.dangjang.mapper;

import com.dangjang.dto.ReviewMapperDTO;
import com.dangjang.dto.ReviewPlusMapperDTO;
import com.dangjang.dto.ReviewPossibleMapperDTO;
import com.dangjang.dto.WrittenReviewMapperDTO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ReviewMapper {

    List<ReviewPlusMapperDTO> getProductReview(Map<String, Object> map);

    int getTotalReviewRecords(String seq_product);

    List<ReviewPlusMapperDTO> getProductReview(String seq_product);

    //작성 가능 리뷰
    @Select("select * from ")
    List<ReviewMapperDTO> getWriteReviewList();

    void writeReview(Map<String, String> map);

    List<WrittenReviewMapperDTO> getWrittenReviewList(Map<String, Object> map);

    //작성한 리뷰 수
    @Select("select count(*) from review where seq_member = #{memberId}")
    int getWrittenReviewCount(String memberId);

    @Delete("delete from review where seq_review = #{reviewNum}")
    void deleteReview(String reviewNum);

    void updateReview(Map<String, String> map);

    List<ReviewPossibleMapperDTO> getReviewPossibleList(Map<String, Object> map);

    int getReviewPossibleCount(String memberId);
}
