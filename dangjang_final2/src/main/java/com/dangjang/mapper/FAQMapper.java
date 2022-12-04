package com.dangjang.mapper;

import com.dangjang.dto.FAQMapperDTO;
import com.dangjang.dto.NoticeMapperDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface FAQMapper {

    List<FAQMapperDTO> find4ForMainList();

    List<FAQMapperDTO> getFaqList(Map<String, Object> map);

    int getTotalRecords(String faqType);

    List<FAQMapperDTO> getSearchList(Map<String, Object> map);

    int getSearchTotalRecords(String keyword);
}
