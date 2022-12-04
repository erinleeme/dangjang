package com.dangjang.service;

import com.dangjang.dto.QnAMapperDTO;
import com.dangjang.dto.QnAMapperSDTO;
import com.dangjang.dto.QnAPlusMapperDTO;
import com.dangjang.mapper.QnaMapper;
import com.dangjang.paging.ProductDetailQnAPaging;
import com.dangjang.paging.QnaPaging;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = false)
@RequiredArgsConstructor
@Log4j2
public class QnaService {
    private final QnaMapper qnaMapper;
    private final HttpSession session;
    private final QnaPaging qnaPaging;
    private final ProductDetailQnAPaging productDetailQnAPaging;

    public List<QnAMapperSDTO> getQnsList(String pg) {
        String memberId = session.getAttribute("memId")+"";
        //String memberId = "1";

        int endPage = Integer.parseInt(pg) * 10;
        int startPage = endPage - 9;
        log.info("---------------- QNA 전체 리스트 / where조건: startPage= " + startPage + " endPage= " + endPage);

        Map<String, Object> map = new HashMap<>();
        map.put("startPage", startPage);
        map.put("endPage", endPage);
        map.put("memberId", memberId);

        return qnaMapper.getQnaList(map);
    }

    public QnAMapperDTO checkReplyQna(Map<String, String> map) {
        return qnaMapper.checkReplyQna(map);
    }

    public void deleteQna(Map<String, String> map) {
        qnaMapper.deleteQna(map);
    }

    public void updateQna(Map<String, String> map) {
        qnaMapper.updateQna(map);
    }

    public QnaPaging paging(String pg) {
        String memberId = session.getAttribute("memId") + "";

        int totalRecords = qnaMapper.getQnaCount(memberId);
        log.info("----------------paging " + totalRecords);
        qnaPaging.setCurrentPage(Integer.parseInt(pg));
        qnaPaging.setRecordsPerPage(10);
        qnaPaging.setPageSize(10);
        qnaPaging.setTotalRecords(totalRecords);
        qnaPaging.makePaging();
        return qnaPaging;
    }

    public void writeQna(Map<String, String> map) {
        String memberId = session.getAttribute("memId") + "";
        map.put("memberId", memberId);

        qnaMapper.writeQna(map);
    }

    // 상품 상세 페이지 문의 리스트
    public List<QnAPlusMapperDTO> getProductQnaList(String pg, String seq_product) {
        int endPage = Integer.parseInt(pg) * 10;
        int startPage = endPage - 9;

        Map<String, Object> map = new HashMap<>();
        map.put("startPage", startPage);
        map.put("endPage", endPage);
        map.put("seq_product", seq_product);

        List<QnAPlusMapperDTO> qnaList = qnaMapper.getProductQnaList(map);

        return qnaList;
    }

    public ProductDetailQnAPaging productQnaPaging(String pg, String seq_product) { // 상품 상세페이지에 나오는 qna
        int totalRecords = qnaMapper.getQnaTotalRecords(seq_product);
        productDetailQnAPaging.setCurrentPage(Integer.parseInt(pg));
        productDetailQnAPaging.setRecordsPerPage(10);
        productDetailQnAPaging.setPageSize(10);
        productDetailQnAPaging.setTotalRecords(totalRecords);
        productDetailQnAPaging.makePaging();
        return productDetailQnAPaging;
    }
}
