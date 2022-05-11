package com.dangjang.service;

import com.dangjang.domain.ImageContent;
import com.dangjang.domain.OneToOneRequest;
import com.dangjang.dto.ImageContentDTO;
import com.dangjang.dto.OneToOneRequestDTO;
import com.dangjang.dto.OneToOneRequestMapperDTO;
import com.dangjang.dto.OneToOneRequestMapperSDTO;
import com.dangjang.mapper.MemberMapper;
import com.dangjang.mapper.OneToOneMapper;
import com.dangjang.paging.OneToOnePaging;
import com.dangjang.repository.ImageContentRepository;
import com.dangjang.repository.MemberRepository;
import com.dangjang.repository.OneToOneRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = false)
@RequiredArgsConstructor
@Log
public class OneToOneRequestService {
    private OneToOneRepository oneToOneRepository;
    private final OneToOneMapper oneToOneMapper;
    private final HttpSession session;
    private final OneToOnePaging oneToOnePaging;
    private final MemberRepository memberRepository;
    private final ImageContentRepository imageContentRepository;

    public List<OneToOneRequestMapperSDTO> getOneToOneList(String pg) {
        String memberId = session.getAttribute("memId") + "";
        // String memberId = "1";

        int endPage = Integer.parseInt(pg)*10;
        int startPage = endPage - 9;
        log.info("----------------1:1문의 전체 리스트 / where조건: startPage= " + startPage + " endPage= " + endPage);

        Map<String, Object> map = new HashMap<>();
        map.put("startPage", startPage);
        map.put("endPage", endPage);
        map.put("memberId", memberId);

        return oneToOneMapper.getOneToOneList(map);
    }

    public OneToOnePaging paging(String pg) {
        String memberId = session.getAttribute("memId") + "";

        //String memberId = "1";
        int totalRecords = oneToOneMapper.getOneToOneCount(memberId);
        log.info("----------------paging " + totalRecords);
        oneToOnePaging.setCurrentPage(Integer.parseInt(pg));
        oneToOnePaging.setRecordsPerPage(5);
        oneToOnePaging.setPageSize(10);
        oneToOnePaging.setTotalRecords(totalRecords);
        oneToOnePaging.makePaging();
        return oneToOnePaging;
    }

    public void updateOto(Map<String, String> map) {
        oneToOneMapper.updateOto(map);
    }



    public void registerOto(Map<String, String> map) {
        String memberId = session.getAttribute("memId") + "";
        //String memberId = "1";
        map.put("memberId", memberId);

        oneToOneMapper.registerOto(map);
    }

    public OneToOneRequestDTO getLimitOne() {
        String memberId = session.getAttribute("memId") + "";
        return oneToOneMapper.getLimitOne(memberId);
    }

    public void deleteOto(Map<String, String> map) {
        oneToOneMapper.deleteOto(map);
    }

    public OneToOneRequestMapperDTO checkReplyOto(Map<String, String> map) {
        return oneToOneMapper.checkReplyOto(map);
    }
}
