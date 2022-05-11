package com.dangjang.service;

import com.dangjang.domain.FAQ;
import com.dangjang.dto.FAQMapperDTO;
import com.dangjang.mapper.FAQMapper;
import com.dangjang.paging.FAQPaging;
import com.dangjang.repository.FAQRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Log
public class FAQService {
    private final FAQRepository faqRepository;
    @Autowired
    private FAQMapper faqMapper;
    @Autowired
    private FAQPaging faqPaging;

    // 최신 4개
    public List<FAQMapperDTO> getFaqFour() {
        //return faqRepository.findTop4ByOrderByCreateDateDesc();
        return faqMapper.find4ForMainList();
    }

    // 전체목록
    public List<FAQMapperDTO> getFaqList(String pg, String faqType) {
        int endPage = Integer.parseInt(pg) * 10;
        int startPage = endPage - 9;
        log.info("----------------전체 리스트 / where조건: startPage= " + startPage + " endPage= " + endPage);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startPage", startPage);
        map.put("endPage", endPage);
        map.put("faqType", faqType);
        return faqMapper.getFaqList(map);
    }

    // 페이징
    public FAQPaging paging(String pg, String faqType){
        int totalRecords = faqMapper.getTotalRecords(faqType);
        log.info("----------------totalRecords " + totalRecords + " / faqType " + faqType);
        faqPaging.setCurrentPage(Integer.parseInt(pg));
        faqPaging.setRecordsPerPage(10);
        faqPaging.setPageSize(10);
        faqPaging.setTotalRecords(totalRecords);
        faqPaging.makePaging();
        return faqPaging;
    }

    // 검색 리스트
    public List<FAQMapperDTO> getSearchList(String pg, String keyword) {
        int recordsPerPage = 10;
        int startPage = (Integer.parseInt(pg) - 1) * recordsPerPage;
        log.info("----------------검색 리스트 / limit조건: startPage= " + startPage + " recordsPerPage= " + recordsPerPage);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startPage", startPage);
        map.put("recordsPerPage", recordsPerPage);
        map.put("keyword", keyword);
        return faqMapper.getSearchList(map);
    }

    // 검색 페이징
    public FAQPaging searchPaging(String pg, String keyword){
        int totalRecords = faqMapper.getSearchTotalRecords(keyword);
        log.info("----------------search paging " + totalRecords + " keyword " + keyword);
        faqPaging.setCurrentPage(Integer.parseInt(pg));
        faqPaging.setRecordsPerPage(10);
        faqPaging.setPageSize(10);
        faqPaging.setTotalRecords(totalRecords);
        faqPaging.makePaging();
        return faqPaging;
    }

}
