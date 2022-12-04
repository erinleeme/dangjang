package com.dangjang.mapper;

import com.dangjang.dto.QnAMapperDTO;
import com.dangjang.dto.QnAMapperSDTO;
import com.dangjang.dto.QnAPlusMapperDTO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface QnaMapper {

    List<QnAMapperSDTO> getQnaList(Map<String, Object> map);

    @Select("select * from qna where seq_qna = #{qnaId}")
    QnAMapperDTO checkReplyQna(Map<String, String> map);

    @Delete("delete from qna where seq_qna = #{qnaId}")
    void deleteQna(Map<String, String> map);

    void updateQna(Map<String, String> map);

    @Select("select count(*) from qna where seq_member = #{memberId}")
    int getQnaCount(String memberId);

    void writeQna(Map<String, String> map);

    // 상품 상세 페이지 문의 리스트
    int getQnaTotalRecords(String seq_product);
    // 상품 상세 페이지 문의 리스트
    List<QnAPlusMapperDTO> getProductQnaList(Map<String, Object> map);
}
