package com.dangjang.ig.controller;

import com.dangjang.dto.BasicProductMapperDTO;
import com.dangjang.dto.ProductMapperDTO;
import com.dangjang.service.MainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/dangjang/shop")
@RequiredArgsConstructor
@Log
public class MainController {
    private final MainService mainService;

    // 메인 상품 가져와서 뿌려주기
    @PostMapping("/main/product_time")
    @ResponseBody
    public Map<String, Object> mainProductWithTime(Model model){
        log.info("-------------------------------------main/product with time join");

        List<ProductMapperDTO> bestProduct = mainService.getBestProduct2(); // best 상품 2개
        List<BasicProductMapperDTO> bestProductImages = mainService.getProductImage(bestProduct); // best 상품 2개에 대한 이미지
        List<Long> bestProductFavorite = mainService.getFavoriteCount(bestProduct);// 신상품에 대한 찜 수
        List<Long> bestProductReview = mainService.getProductReview(bestProduct); // 신상품에 대한 리뷰 수

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("bestProduct", bestProduct); // best 상품 2개
        map.put("bestProductImages", bestProductImages); // best 상품 2개에 대한 이미지
        map.put("reviewCount", bestProductReview);
        map.put("pickCount", bestProductFavorite);
        log.info("-------------------------------------main/product time push");
        return map;
    }

    @PostMapping("/main/productSet")
    @ResponseBody
    public Map<String, Object> mainProduct(@RequestParam String category,
                                           Model model){
        System.out.println(category);
        log.info("-------------------------------------main/product join");
        List<ProductMapperDTO> productList = new ArrayList<>();
        List<BasicProductMapperDTO> productImageList = new ArrayList<>();
        List<Long> productFavorite = new ArrayList<>();
        List<Long> productReview = new ArrayList<>();
        if(category.equals("newArr")){
            productList = mainService.getProduct10List();   // 신상품 10개
            productImageList = mainService.getProductImage(productList); // 신상품 10개에 대한 이미지
            productFavorite = mainService.getFavoriteCount(productList);
            productReview = mainService.getProductReview(productList);
        } else {
            productList = mainService.getProduct10(category); // 카테고리 10개
            productImageList = mainService.getProductImage(productList); // 카테고리 10개에 대한 이미지
            productFavorite = mainService.getFavoriteCount(productList);
            productReview = mainService.getProductReview(productList);
            log.info("-------------------------------------main/product category: " + category + " / " + productList);
        }

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("productList", productList);
        map.put("productImageList", productImageList);
        map.put("reviewCount", productReview);
        map.put("pickCount", productFavorite);
        log.info("-------------------------------------main/product set push");
        return map;
    }

    // 검색
    @GetMapping("/search")
    public String search(@RequestParam String keyword,
                         Model model) {
        log.info("-----------------search: " + keyword);
        model.addAttribute("searchKeyword", keyword);
        model.addAttribute("pg", 1);
        model.addAttribute("display", "shop/searchList.jsp");
        return "index";
    }

    // 검색 리스트
    @PostMapping(value = "/search/list")
    @ResponseBody
    public Map<String, Object> searchList(@RequestParam(required = false, defaultValue = "1") String pg,
                                          @RequestParam String keyword,
                                          @RequestParam String listType,
                                          Model model){
        List<ProductMapperDTO> searchList = mainService.getSearchProduct(pg, keyword, listType); // 검색결과 상품 정보

        if(!searchList.isEmpty() || searchList != null) {
            List<BasicProductMapperDTO> searchListImages = mainService.getProductImage(searchList);
            List<Long> productFavorite = mainService.getFavoriteCount(searchList);// 찜 수
            List<Long> productReview = mainService.getProductReview(searchList); // 리뷰 수

            Map<String, Object> map = new HashMap<String, Object>();

            map.put("searchList", searchList);
            map.put("searchImageList", searchListImages);
            map.put("searchCount", mainService.getSearchProductCount(keyword));
            map.put("reviewCount", productReview);
            map.put("pickCount", productFavorite);
            map.put("paging", mainService.searchPaging(pg, keyword));

            model.addAttribute("pg", pg);
            log.info("searchList : " + searchList);
            return map;
        } else {
            return null;
        }
    }

}
