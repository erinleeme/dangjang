package com.dangjang.service;

import com.dangjang.domain.BasicProduct;
import com.dangjang.domain.Event;
import com.dangjang.domain.Product;
import com.dangjang.dto.*;
import com.dangjang.mapper.OrderProductMapper;
import com.dangjang.mapper.ProductMapper;
import com.dangjang.paging.EventProductPaging;
import com.dangjang.paging.NewProductPaging;
import com.dangjang.paging.ProductPaging;
import com.dangjang.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Log
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductPaging productPaging;
    private final NewProductPaging newProductPaging;
    private final EventProductPaging eventProductPaging;
    private final HttpSession session;
    private final OrderProductMapper orderProductMapper;

    // 신상품 리스트 가져오기
    public List<ProductMapperDTO> getNewProductList(String pg, String listType) {
        long date = 15;
        int endPage = Integer.parseInt(pg) * 20;
        int startPage = endPage - 19;
        log.info("----------------신상품 전체 리스트");

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("startPage", startPage);
        map.put("endPage", endPage);
        map.put("date", date);
        map.put("listType", listType);

        List<ProductMapperDTO> list = new ArrayList<>();

        if (listType.equals("reco")) { // 추천순이 default
            list = productMapper.suggestionNewProList(map);
        } else if (listType.equals("new")) { // 신상품 순
            list = productMapper.newProductList(map);
        } else if (listType.equals("top")) { // 베스트 순
            list = productMapper.bestNewProductList(map);
        } else if (listType.equals("high") || listType.equals("low")) { // 가격순
            list = productMapper.orderByPriceNewPro(map);
        }
        return list;
    }

    // 신상품 페이징
    public NewProductPaging newArrPaging(String pg){
        long date = 15;
        int totalRecords = productMapper.getTotalRecords(date);
        newProductPaging.setCurrentPage(Integer.parseInt(pg));
        newProductPaging.setRecordsPerPage(20);
        newProductPaging.setPageSize(10);
        newProductPaging.setTotalRecords(totalRecords);
        newProductPaging.makePaging();
        return newProductPaging;
    }

    // 신상품 총 개수
    public int getNewProductCount(){
        long date = 15;
        return productMapper.getTotalRecords(date);
    }

    //--------------------------------------------------------------------------------

    // 정렬 유형
    public List<ProductMapperDTO> getFilterProduct(Map<String, String> map) {
        List<ProductMapperDTO> filterList = new ArrayList<>();

        int endNum = Integer.parseInt(map.get("pg")) * 20;

        if(!map.get("big").isEmpty() || map.get("big") != null) {
            if (map.get("filter").equals("추천순")) {
                filterList = productMapper.suggestionList(map);
            } else if (map.get("filter").equals("베스트순")) {
                filterList = productMapper.bestProductList(map);
            } else if (map.get("filter").equals("가격순")) {
                filterList = productMapper.OrderByPrice(map);
            }
        }
        return filterList;
    }

    //--------------------------------------------------------------------------------

    // 카테고리명 가져오기
    public String getCategoryTitle(String categoryCode) {
        return productMapper.getCategoryTitle(categoryCode);
    }

    // 하위 카테고리 리스트 가져오기
    public List<MiddleCategoryMapperDTO> getSubCatList(String categoryCode) {
        return productMapper.getSubCatList(categoryCode);
    }

    // 카테고리 상품 리스트 가져오기
    public List<ProductMapperDTO> getProductList(String pg, String categoryCode, String subCategoryNum, String listType) {
        long date = 15;
        int endPage = Integer.parseInt(pg) * 20;
        int startPage = endPage - 19;


        Map<String, Object> map = new HashMap<String, Object>();

        map.put("startPage", startPage);
        map.put("endPage", endPage);
        map.put("date", date);
        map.put("categoryCode", categoryCode);
        map.put("subCategoryNum", subCategoryNum);
        map.put("listType", listType);

        List<ProductMapperDTO> list = new ArrayList<>();

        if (listType.equals("reco")) { // 추천순이 default
            list = productMapper.suggestionProList(map);
        } else if (listType.equals("new")) { // 신상품 순
            list = productMapper.latelyProList(map);
        } else if (listType.equals("top")) { // 베스트 순
            list = productMapper.bestProList(map);
        } else if (listType.equals("high") || listType.equals("low")) { // 가격순
            list = productMapper.orderByPriceProList(map);
        }
        log.info("----------------카테고리 상품 전체 리스트" + list);
        return list;
    }

    // 카테고리 페이징
    public ProductPaging catPaging(String pg, String categoryCode, String subCategoryNum){
        int totalRecords = productMapper.getTotalProductRecords(categoryCode, subCategoryNum);
        log.info("----------------카테고리 상품 수" + totalRecords);
        productPaging.setCurrentPage(Integer.parseInt(pg));
        productPaging.setRecordsPerPage(20);
        productPaging.setPageSize(10);
        productPaging.setTotalRecords(totalRecords);
        productPaging.makePaging();
        return productPaging;
    }

    // 카테고리 상품 총 개수
    public int getProductCount(String categoryCode, String subCategoryNum){
        log.info("----------------카테고리 상품 수" + productMapper.getTotalProductRecords(categoryCode, subCategoryNum));
        return productMapper.getTotalProductRecords(categoryCode, subCategoryNum);
    }

    //--------------------------------------------------------------------------------

    // 베스트
    public List<ProductMapperDTO> reviewTopProduct() {
        List<ProductMapperDTO> reviewTopProduct = productMapper.getReviewProductTop10();
        log.info("----------------베스트 리뷰 Top 10 " + reviewTopProduct);
        return reviewTopProduct;
    }

    public List<ProductMapperDTO> sellingTopProduct() {
        List<ProductMapperDTO> sellingTop10 = productMapper.getSellingTopProduct();
        log.info("----------------베스트 판매 Top 10 " + sellingTop10);
        return sellingTop10;
    }

    public List<ProductMapperDTO> suggestionTopProduct() {
        List<ProductMapperDTO> suggestionTop10 = productMapper.getSuggestionTopProduct();
        log.info("----------------베스트 추천 Top 10 " + suggestionTop10);
        return suggestionTop10;
    }

    //--------------------------------------------------------------------------------
    // 기획전
    public List<ProductMapperDTO> eventProduct(String pg, String listType) { // eventProduct 기획전 베이커리 / 음료 같은애들
        int endPage = Integer.parseInt(pg) * 20;
        int startPage = endPage - 19;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("endPage", endPage);
        map.put("startPage", startPage);
        map.put("listType", listType);

        List<ProductMapperDTO> productList = new ArrayList<>();

        if (listType.equals("reco")) { // default
            productList = productMapper.eventProduct(map);
        } else if (listType.equals("new")) { // 신상품 순
            productList = productMapper.latelyEventProList(map);
        } else if (listType.equals("top")) { // 베스트 순
            productList = productMapper.bestProEventList(map);
        } else if (listType.equals("high") || listType.equals("low")) { // 가격순
            productList = productMapper.orderByPriceProEventList(map);
        }

        return productList;
    }
    public EventProductPaging eventPaging(String pg){
        int totalRecords = productMapper.getTotalEventProductRecords();
        eventProductPaging.setCurrentPage(Integer.parseInt(pg));
        eventProductPaging.setRecordsPerPage(20);
        eventProductPaging.setPageSize(10);
        eventProductPaging.setTotalRecords(totalRecords);
        eventProductPaging.makePaging();
        return eventProductPaging;
    }

    public List<ProductMapperDTO> getCartChoiceProduct(List<String> productSeq) {
        List<ProductMapperDTO> productList = productMapper.getCartChoiceProduct(productSeq);

        return productList;
    }
    public ProductMapperDTO getProductInformation(String seq_product) {
        ProductMapperDTO productMapperDTO = productMapper.getProductInformation(seq_product);

        return productMapperDTO;
    }

    // mypage
    public List<ProductMapperDTO> getFavoriteProduct(List<FavoriteMapperDTO> favoriteList) {
        return productMapper.getFavoriteProduct(favoriteList);
    }

    public List<ProductMapperDTO> getQnaProductList(List<QnAMapperSDTO> qnaList) {
        return productMapper.getQnaProductList(qnaList);
    }

    public List<ProductMapperDTO> getOrderProductList(List<OrderProductMapperDTO> orderProductList) {
        return productMapper.getOrderProductList(orderProductList);
    }

    public List<ProductMapperDTO> getReviewPossibleProduct(List<OrderProductDTO> orderReviewList) {
        return productMapper.getReviewProssibleProduct(orderReviewList);
    }

    // 상품
    public List<ProductMapperDTO> getOrderProduct() { // 장바구니에 있는 상품 전부 끌
        long memId = (long) session.getAttribute("memId");
        List<ProductMapperDTO> productList = productMapper.getOrderProduct(memId);

        return productList;
    }

    // middlecategory
    public MiddleCategoryMapperDTO getMiddleCategory(String seq_product){
        return productMapper.getMiddleCategory(seq_product);
    }
    // bigcategory
    public BigCategoryMapperDTO getBigCategory(String seq_product){
        return productMapper.getBigCategory(seq_product);
    }

    public List<ProductMapperDTO> randomProduct(long seq_big_category){
        return productMapper.randomProduct(seq_big_category);
    }

    public List<ProductMapperDTO> getBuyProductList(OrdersMapperDTO ordersMapperDTO) {
        List<OrderProductMapperDTO> list = orderProductMapper.getBuyProduct(ordersMapperDTO.getSeq_order());

        List<ProductMapperDTO> productList = productMapper.getBuyProductList(list);

        return productList;
    }


}
