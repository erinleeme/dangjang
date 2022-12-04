package com.dangjang.service;

import com.dangjang.dto.BasicProductMapperDTO;
import com.dangjang.dto.ProductMapperDTO;
import com.dangjang.dto.ReviewMapperDTO;
import com.dangjang.mapper.ImageMapper;
import com.dangjang.mapper.ProductMapper;
import com.dangjang.paging.ProductPaging;
import com.dangjang.paging.SearchListPaging;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Log
public class MainService {
    private final ProductMapper productMapper;
    private final ImageMapper imageMapper;
    private final ProductPaging productPaging;
    private final SearchListPaging searchListPaging;

    // main 신상품 10개
    public List<ProductMapperDTO> getProduct10List() {
        List<ProductMapperDTO> productList = productMapper.newProduct10List();
        return productList;
    }

    // main 시간 표시 part - 베스트 상품 2개
    public List<ProductMapperDTO> getBestProduct2() {
        List<ProductMapperDTO> bestProduct = productMapper.getBestProduct2();
        return bestProduct;
    }

    // main 카테고리 별 상품 리스트
    public List<ProductMapperDTO> getProduct10(String category) {
        List<ProductMapperDTO> productList = productMapper.getProduct10(category);
        log.info("------------------------"+category+"----"+productList);
        return productList;
    }

    // 상품 이미지 리스트
    public List<BasicProductMapperDTO> getProductImage(List<ProductMapperDTO> productList) { // image 번호 추출
        List<BasicProductMapperDTO> productImageList =imageMapper.getImageCode(productList);
        return productImageList;
    }

    // 검색 상품 리스트
    public List<ProductMapperDTO> getSearchProduct(String pg, String keyword, String listType) {
        long date = 15;
        int endPage = Integer.parseInt(pg) * 20;
        int startPage = endPage - 19;

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("startPage", startPage);
        map.put("endPage", endPage);
        map.put("date", date);
        map.put("keyword", keyword);
        map.put("listType", listType);

        log.info("------------------keyword: "+keyword);

        List<ProductMapperDTO> searchList = new ArrayList<>();

        if (listType.equals("reco")) { // 추천순이 default
            searchList = productMapper.suggestionSearchList(map);
        } else if (listType.equals("new")) { // 신상품 순
            searchList = productMapper.latelySearchList(map);
        } else if (listType.equals("top")) { // 베스트 순
            searchList = productMapper.bestSearchList(map);
        } else if (listType.equals("high") || listType.equals("low")) { // 가격순
            searchList = productMapper.orderByPriceSearchList(map);
        }
        return searchList;
    }

    // 페이징
    public SearchListPaging searchPaging(String pg, String keyword) {
        int totalRecords = productMapper.getTotalSearchRecords(keyword);
        searchListPaging.setCurrentPage(Integer.parseInt(pg));
        searchListPaging.setRecordsPerPage(20);
        searchListPaging.setPageSize(10);
        searchListPaging.setTotalRecords(totalRecords);
        searchListPaging.makePaging();
        return searchListPaging;
    }

    // 검색 상품 총 개수
    public int getSearchProductCount(String keyword){
        return productMapper.getTotalSearchRecords(keyword);
    }

    // 좋아요 수
    public List<Long> getFavoriteCount(List<ProductMapperDTO> Product) {
        return productMapper.getFavoriteCount(Product);
    }

    public int getOneFavoriteCount(ProductMapperDTO productMapperDTO){
        long seq_product = productMapperDTO.getSeq_product();
        return productMapper.getOneFavoriteCount(seq_product);
    }

    // 리뷰 수
    public List<Long> getProductReview(List<ProductMapperDTO> Product) {
        return productMapper.getProductReview(Product);
    }

    public List<ReviewMapperDTO> getOneProductReview(ProductMapperDTO productMapperDTO){
        long seq_product = productMapperDTO.getSeq_product();
        return productMapper.getOneProductReview(seq_product);
    }


}
