package com.dangjang.service;

import com.dangjang.dto.NoticeMapperDTO;
import com.dangjang.mapper.NoticeMapper;
import com.dangjang.paging.NoticePaging;
import com.dangjang.repository.NoticeRepository;
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
public class NoticeService {
    private final NoticeRepository noticeRepository;
    @Autowired
    private NoticeMapper noticeMapper;
    @Autowired
    private NoticePaging noticePaging;

    // main notice list - 4개
    public List<NoticeMapperDTO> find4ForMainList() {
        return noticeMapper.find4ForMainList();
    }

    // 전체 목록
    public List<NoticeMapperDTO> getNoticeList(String pg){
        int endPage = Integer.parseInt(pg) * 10;
        int startPage = endPage - 9;
        log.info("----------------전체 리스트 / where조건: startPage= " + startPage + " endPage= " + endPage);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("startPage", startPage);
        map.put("endPage", endPage);
        return noticeMapper.getNoticeList(map);
    }

    // 페이징
    public NoticePaging paging(String pg){
        int totalRecords = noticeMapper.getTotalRecords();
        log.info("----------------paging " + totalRecords);
        noticePaging.setCurrentPage(Integer.parseInt(pg));
        noticePaging.setRecordsPerPage(10);
        noticePaging.setPageSize(10);
        noticePaging.setTotalRecords(totalRecords);
        noticePaging.makePaging();
        return noticePaging;
    }

    // 공지사항 상세보기
    public NoticeMapperDTO getNotice(String no) {
        return noticeMapper.getNotice(no);
    }

    // 검색 리스트
    public List<NoticeMapperDTO> getSearchNoticeList(String pg, String keyword){
        int recordsPerPage = 10;
        int startPage = (Integer.parseInt(pg) - 1) * recordsPerPage;
        log.info("----------------검색 리스트 / limit조건: startPage= " + startPage + " recordsPerPage= " + recordsPerPage);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startPage", startPage);
        map.put("recordsPerPage", recordsPerPage);
        map.put("keyword", keyword);
        return noticeMapper.getSearchNoticeList(map);
    }

    // 검색 페이징
    public NoticePaging searchPaging(String pg, String keyword){
        int totalRecords = noticeMapper.getSearchTotalRecords(keyword);
        log.info("----------------search paging " + totalRecords + " keyword " + keyword);
        noticePaging.setCurrentPage(Integer.parseInt(pg));
        noticePaging.setRecordsPerPage(10);
        noticePaging.setPageSize(10);
        noticePaging.setTotalRecords(totalRecords);
        noticePaging.makePaging();
        return noticePaging;
    }

}
