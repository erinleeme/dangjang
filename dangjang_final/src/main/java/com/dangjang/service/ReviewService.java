package com.dangjang.service;

import com.dangjang.dto.ReviewMapperDTO;
import com.dangjang.dto.ReviewPlusMapperDTO;
import com.dangjang.dto.ReviewPossibleMapperDTO;
import com.dangjang.dto.WrittenReviewMapperDTO;
import com.dangjang.mapper.ReviewMapper;
import com.dangjang.paging.ProductDetailReviewPaging;
import com.dangjang.paging.ReviewPaging;
import com.dangjang.paging.WrittenReviewPaging;
import com.dangjang.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = false)
@RequiredArgsConstructor
@Log
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;
    private final HttpSession session;
    private final WrittenReviewPaging writtenReviewPaging;
    private final ReviewPaging reviewPaging;
    private final ProductDetailReviewPaging productDetailReviewPaging;

    //    public List<ReviewMapperDTO> getWriteReviewList() {
    //        return reviewMapper.getWriteReviewList();
    //    }


    public List<ReviewPlusMapperDTO> getProductReview(String seq_product, String pg) {
        int endPage = Integer.parseInt(pg) * 10;
        int startPage = endPage - 9;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("endPage", endPage);
        map.put("startPage", startPage);
        map.put("seq_product", seq_product);

        List<ReviewPlusMapperDTO> reviewList = reviewMapper.getProductReview(map);

        return reviewList;
    }

    public ReviewPaging reviewPaging(String pg, String seq_product){
        int totalRecords = reviewMapper.getTotalReviewRecords(seq_product);
        reviewPaging.setCurrentPage(Integer.parseInt(pg));
        reviewPaging.setRecordsPerPage(20);
        reviewPaging.setPageSize(10);
        reviewPaging.setTotalRecords(totalRecords);
        reviewPaging.makePaging();
        return reviewPaging;
    }

    // 상품 상세 페이지 리뷰 페이징
    public ProductDetailReviewPaging productReviewPaging(String pg, String seq_product){
        int totalRecords = reviewMapper.getTotalReviewRecords(seq_product);
        productDetailReviewPaging.setCurrentPage(Integer.parseInt(pg));
        productDetailReviewPaging.setRecordsPerPage(10);
        productDetailReviewPaging.setPageSize(10);
        productDetailReviewPaging.setTotalRecords(totalRecords);
        productDetailReviewPaging.makePaging();
        return productDetailReviewPaging;
    }

    public List<ReviewPlusMapperDTO> getProductReview(String seq_product) {
        List<ReviewPlusMapperDTO> reviewList = reviewMapper.getProductReview(seq_product);

        return reviewList;
    }

    public List<ReviewMapperDTO> getWriteReviewList() {
        return reviewMapper.getWriteReviewList();
    }

    public void writeReview(Map<String, String> map) {
        String memberId = session.getAttribute("memId") + "";
        map.put("memberId", memberId);
        reviewMapper.writeReview(map);
    }

    public List<WrittenReviewMapperDTO> getWrittenReviewList(String pg) {
        String memberId = session.getAttribute("memId") + "";
        //String memberId = "1";

        int endPage = Integer.parseInt(pg) * 10;
        int startPage = endPage - 9;
        log.info("---------------- 찜 전체 리스트 / where조건: startPage= " + startPage + " endPage= " + endPage);

        Map<String, Object> map = new HashMap<>();
        map.put("startPage", startPage);
        map.put("endPage", endPage);
        map.put("memberId", memberId);

        return reviewMapper.getWrittenReviewList(map);
    }


    public WrittenReviewPaging paging(String pg) {
        String memberId = session.getAttribute("memId") + "";

        int totalRecords = reviewMapper.getWrittenReviewCount(memberId);
        log.info("----------------paging " + totalRecords);
        writtenReviewPaging.setCurrentPage(Integer.parseInt(pg));
        writtenReviewPaging.setRecordsPerPage(10);
        writtenReviewPaging.setPageSize(10);
        writtenReviewPaging.setTotalRecords(totalRecords);
        writtenReviewPaging.makePaging();
        return writtenReviewPaging;
    }

    //리뷰 삭제
    public void deleteReview(String reviewNum) {
        reviewMapper.deleteReview(reviewNum);
    }

    //리뷰 수정
    public void updateReview(Map<String, String> map) {
        reviewMapper.updateReview(map);
    }

    //작성 가능한 리뷰 갖고오기
    public List<ReviewPossibleMapperDTO> getReviewPossibleList(String pg) {
        String memberId = session.getAttribute("memId") + "";
        //String memberId = "1";

        int endPage = Integer.parseInt(pg) * 10;
        int startPage = endPage - 9;
        log.info("---------------- 작성 가능한 리뷰 전체 리스트 / where조건: startPage= " + startPage + " endPage= " + endPage);

        Map<String, Object> map = new HashMap<>();
        map.put("startPage", startPage);
        map.put("endPage", endPage);
        map.put("memberId", memberId);

        return reviewMapper.getReviewPossibleList(map);
    }

    public WrittenReviewPaging possiblePaging(String pg) {
        String memberId = session.getAttribute("memId") + "";

        int totalRecords = reviewMapper.getReviewPossibleCount(memberId);
        log.info("----------------paging " + totalRecords);
        writtenReviewPaging.setCurrentPage(Integer.parseInt(pg));
        writtenReviewPaging.setRecordsPerPage(10);
        writtenReviewPaging.setPageSize(10);
        writtenReviewPaging.setTotalRecords(totalRecords);
        writtenReviewPaging.makePaging();
        return writtenReviewPaging;
    }

    public int getReviewPossibleCount() {
        String memberId = session.getAttribute("memId") + "";
        return reviewMapper.getReviewPossibleCount(memberId);
    }

    public int getWrittenReviewCount() {
        String memberId = session.getAttribute("memId") + "";
        return reviewMapper.getWrittenReviewCount(memberId);
    }
}
