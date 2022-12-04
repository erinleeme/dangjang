package com.dangjang.mapper;

import com.dangjang.dto.NoticeDTO;
import com.dangjang.dto.NoticeMapperDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface NoticeMapper {

    List<NoticeMapperDTO> find4ForMainList();

    List<NoticeMapperDTO> getNoticeList(Map<String, Integer> map);

    @Select("select count(*) from notice")
    int getTotalRecords();

    @Select("select * from notice where seq_notice = #{no}")
    NoticeMapperDTO getNotice(String no);

    List<NoticeMapperDTO> getSearchNoticeList(Map<String, Object> map);

    int getSearchTotalRecords(String keyword);
}
