package com.dangjang.ig.controller;

import com.dangjang.domain.Product;
import com.dangjang.dto.*;
import com.dangjang.mapper.MemberMapper;
import com.dangjang.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/dangjang/shop")
@RequiredArgsConstructor
@Log
public class ProductController {
    private final ProductService productService;
    private final ImageContentService imageContentService;
    private final HttpSession Session;
    private final MainService mainService;
    private final ReviewService reviewService;
    private final QnaService qnaService;
    private final MemberService memberService;

    // 신상품 화면 보여주기
    @GetMapping(value="/goods/newArr")
    public String newArrivalMain(Model model){
        model.addAttribute("display", "shop/newArrivalMain.jsp");
        return "index";
    }

    // 신상품 list
    @PostMapping(value="/goods/newArr/list")
    @ResponseBody
    public Map<String, Object> newArrivalList(@RequestParam(required = false, defaultValue = "1") String pg,
                                              @RequestParam String listType,
                                              Model model){

        List<ProductMapperDTO> productList = productService.getNewProductList(pg, listType);
        log.info("----------------- 신상품 join List : " + productList);

        List<BasicProductMapperDTO> imageList = imageContentService.productImage(productList);
        log.info("-------------------image list : " + imageList);

        List<Long> productFavorite = mainService.getFavoriteCount(productList);
        List<Long> productReview = mainService.getProductReview(productList);

        // 신상품 총 개수 가져오기
        int productCount = productService.getNewProductCount();

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("productList", productList);
        map.put("imageList", imageList);
        map.put("reviewCount", productReview);
        map.put("pickCount", productFavorite);
        map.put("productCount", productCount);
        map.put("paging", productService.newArrPaging(pg));
        model.addAttribute("pg", pg);
        return map;
    }

    // 카테고리 메인 화면 보여주기
    @GetMapping(value="/goods/category")
    public String catMain(@RequestParam String categoryCode,
                          @RequestParam(required = false, defaultValue = "null") String subCategoryCode,
                          Model model){
        // 카테고리명 가져오기
        String categoryTitle = productService.getCategoryTitle(categoryCode);
        log.info("-----------------카테고리 title " + categoryTitle);
        model.addAttribute("categoryTitle", categoryTitle);

        model.addAttribute("categoryCode", categoryCode);
        model.addAttribute("subCategoryNum", subCategoryCode);
        model.addAttribute("pg", 1);
        model.addAttribute("display", "shop/categoryMain.jsp");
        log.info("-----------------카테고리 코드 " + categoryCode);
        return "index";
    }

    // 카테고리 리스트 뿌려주기
    @PostMapping(value = "/goods/category/list")
    @ResponseBody
    public Map<String, Object> categoryList(@RequestParam(required = false, defaultValue = "1") String pg,
                                            @RequestParam String categoryCode,
                                            @RequestParam String subCategoryNum,
                                            @RequestParam String listType,
                                            Model model){
        // 카테고리, 하위 카테고리 리스트 가져오기
        List<MiddleCategoryMapperDTO> subCategoryList = productService.getSubCatList(categoryCode);

        // 카테고리 상품 리스트 가져오기
        List<ProductMapperDTO> productList = productService.getProductList(pg, categoryCode, subCategoryNum, listType);
        log.info("-----------------카테고리 product List : " + productList);

        // 카테고리 이미지 가져오기
        List<BasicProductMapperDTO> imageList = imageContentService.productImage(productList);
        log.info("-------------------카테고리 image list : " + imageList);

        List<Long> productFavorite = mainService.getFavoriteCount(productList);
        log.info("-------------------카테고리 상품 찜하기 : " + productFavorite);

        List<Long> productReview = mainService.getProductReview(productList);
        log.info("-------------------카테고리 상품 리뷰 : " + productReview);

        // 카테고리 상품 총 개수 가져오기
        int productCount = productService.getProductCount(categoryCode, subCategoryNum);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("subCategoryList", subCategoryList);
        map.put("productList", productList);
        map.put("imageList", imageList);
        map.put("reviewCount", productReview);
        map.put("pickCount", productFavorite);
        map.put("productCount", productCount);
        map.put("paging", productService.catPaging(pg, categoryCode, subCategoryNum));

        model.addAttribute("pg", pg);
        model.addAttribute("categoryCode", categoryCode);
        model.addAttribute("subCategoryNum", subCategoryNum);

        return map;
    }

    // 이벤트 목록 화면 뿌리기
    @GetMapping(value="/goods/event")
    public String eventList(Model model){
        model.addAttribute("display", "shop/eventList.jsp");
        return "index";
    }

    // 이벤트 상세 페이지 화면 뿌리기
    @GetMapping(value="/goods/event/show")
    public String eventNum(@RequestParam String num,
                           Model model){
        model.addAttribute("display", "shop/eventProductMain.jsp");
        model.addAttribute("event_seq", num);
        model.addAttribute("pg", "1");
        return "index";
    }

    // 이벤트 상품 뿌리기
    @PostMapping("/goods/eventProduct/list")
    @ResponseBody
    public Map<String, Object> eventProductList(@RequestParam(required = false, defaultValue = "1") String pg,
                                                @RequestParam String listType,
                                                Model model) {

        List<ProductMapperDTO> productList = productService.eventProduct(pg, listType);
        List<BasicProductMapperDTO> productListImages = imageContentService.productImage(productList);
        List<Long> productFavorite = mainService.getFavoriteCount(productList);
        List<Long> productReview = mainService.getProductReview(productList);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("paging", productService.eventPaging(pg));
        map.put("productList", productList); // 상품 정보들
        map.put("productListImages", productListImages); // 상품 정보에 대한 이미지들
        map.put("pickCount", productFavorite); // 상품마다 찜 수
        map.put("reviewCount", productReview); // 상품마다 리뷰 수
        map.put("productCount", productList.size()); // 상품 총 수량
        model.addAttribute("pg", pg);
        return map;
    }

    // 베스트 화면 뿌리기
    @GetMapping(value="/goods/best")
    public String bestList(Model model){
        model.addAttribute("display", "shop/bestMain.jsp");
        return "index";
    }

    // 베스트 상품 리스트 뿌리기
    @PostMapping("/goods/best/list")
    @ResponseBody
    public Map<String, Object> bestList() {
        List<ProductMapperDTO> reviewTop10 = productService.reviewTopProduct();  // 리뷰가 가장많은 상품 Top 10
        List<BasicProductMapperDTO> reviewTop10Images = imageContentService.productImage(reviewTop10); // 리뷰가 가장많은 상품 Top 10 이미지
        List<Long> productFavorite_reviewTop10 = mainService.getFavoriteCount(reviewTop10);
        List<Long> productReview_reviewTop10 = mainService.getProductReview(reviewTop10);

        List<ProductMapperDTO> sellingTop10 = productService.sellingTopProduct(); // 많이팔린순 Top 10
        List<BasicProductMapperDTO> sellingTop10Images = imageContentService.productImage(sellingTop10); // 많이팔린순 Top 10 이미지
        List<Long> productFavorite_sellingTop10 = mainService.getFavoriteCount(sellingTop10);
        List<Long> productReview_sellingTop10 = mainService.getProductReview(sellingTop10);

        List<ProductMapperDTO> suggestionTop10 = productService.suggestionTopProduct(); // MD 추천 (사실 랜덤 10개임)
        List<BasicProductMapperDTO> suggestionTop10Images = imageContentService.productImage(suggestionTop10); // MD 추천 (사실 랜덤 10개임) 이미지
        List<Long> productFavorite_suggestionTop10 = mainService.getFavoriteCount(suggestionTop10);
        List<Long> productReview_suggestionTop10 = mainService.getProductReview(suggestionTop10);

        log.info("-------------- 나와라 MD 추천 리스트! " + suggestionTop10);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("reviewTop10", reviewTop10);
        map.put("reviewTop10Images", reviewTop10Images);
        map.put("reviewCountWithReviewTop10", productReview_reviewTop10);
        map.put("pickCountWithReviewTop10", productFavorite_reviewTop10);

        map.put("sellingTop10", sellingTop10);
        map.put("sellingTop10Images", sellingTop10Images);
        map.put("reviewCountWithSellingTop10", productReview_sellingTop10);
        map.put("pickCountWithSellingTop10", productFavorite_sellingTop10);

        map.put("suggestionTop10", suggestionTop10);
        map.put("suggestionTop10Images", suggestionTop10Images);
        map.put("reviewCountWithSuggestionTop10", productReview_suggestionTop10);
        map.put("pickCountWithSuggestionTop10", productFavorite_suggestionTop10);

        return map;
    }

    // 상품 상세 페이지
    @GetMapping(value = "/product")
    public String productDetail(@RequestParam String num,
                                Model model){
        model.addAttribute("seq_product", num);
        model.addAttribute("display", "shop/productDetail.jsp");
        return "index";
    }

    // 상세 데이터 뿌리기
    @PostMapping(value="/product/detail")
    @ResponseBody
    public Map<String, Object> getProductDetail(@RequestParam String seq_product,
                                                Model model){
        // 카테고리 정보
        MiddleCategoryMapperDTO middleCategoryMapperDTO = productService.getMiddleCategory(seq_product);
        BigCategoryMapperDTO bigCategoryMapperDTO = productService.getBigCategory(seq_product);

        // 동일 카테고리 상품 랜덤 3개
        List<ProductMapperDTO> randomProduct = productService.randomProduct(bigCategoryMapperDTO.getSeq_big_category());
        List<BasicProductMapperDTO> randomProductImages = imageContentService.productImage(randomProduct);
        
        // 상품 정보
        ProductMapperDTO productMapperDTO = productService.getProductInformation(seq_product);
        BasicProductMapperDTO basicProductMapperDTO = imageContentService.getProductImage(productMapperDTO);

        // 좋아요 수
        int productFavorite = mainService.getOneFavoriteCount(productMapperDTO);

        // 리뷰 수, 평점
        List<ReviewMapperDTO> productReview = mainService.getOneProductReview(productMapperDTO);

        // review 평점 계산
        int reviewScore = 0;
        for(ReviewMapperDTO review : productReview){
            reviewScore += review.getScore();
            System.out.println(reviewScore);
        }
        if(productReview.size() == 0){
            reviewScore = 0;
        } else {
            reviewScore /= productReview.size();
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("middleCategory", middleCategoryMapperDTO);
        map.put("bigCategory", bigCategoryMapperDTO);
        map.put("product", productMapperDTO); // 상품 정보
        map.put("productImage", basicProductMapperDTO); // 상품 이미지

        map.put("randomProduct", randomProduct); // 동일 카테고리 추천 상품
        map.put("randomProductImages", randomProductImages); // 동일 카테고리 추천 상품 이미지

        map.put("pickCount", productFavorite); // 상품마다 찜 수
        map.put("reviewScore", reviewScore); // 상품 평균 리뷰 평점
        map.put("reviewCount", productReview.size()); // 상품 리뷰 수

        model.addAttribute("productDetail_categoryCode", bigCategoryMapperDTO.getCode_name());
        model.addAttribute("productDetail_subCategoryCode", middleCategoryMapperDTO.getId());

        return map;
    }
    // 상품 상세 페이지 문의
    @PostMapping("product/detail/qna")
    @ResponseBody
    public Map<String, Object> productQnA(@RequestParam String seq_product,
                                          @RequestParam(required = false, defaultValue = "1") String pg,
                                          Model model) {
        List<QnAPlusMapperDTO> qnaList = qnaService.getProductQnaList(pg, seq_product);

        Map<String, Object> map = new HashMap<>();
        map.put("paging", qnaService.productQnaPaging(pg, seq_product));
        map.put("qnaList", qnaList);
        map.put("pg", pg);
        model.addAttribute("qnaPg", pg);
        return map;
    }
    // 상품 상세 페이지 후기
    @PostMapping("product/detail/review")
    @ResponseBody
    public Map<String, Object> productReview(@RequestParam String seq_product,
                                             @RequestParam(required = false, defaultValue = "1") String pg,
                                             Model model) {

        ProductMapperDTO productMapperDTO = productService.getProductInformation(seq_product);
        List<ReviewPlusMapperDTO> reviewList = reviewService.getProductReview(seq_product, pg);
        log.info("-----------상품 상세 페이지 후기 " + reviewList);
        // List<MemberMapperDTO> memberList = memberService.getMemberByProductReview(reviewList);
        List<ReviewMapperDTO> productReview = mainService.getOneProductReview(productMapperDTO);
        // review 평점 계산
        int reviewScore = 0;
        for(ReviewMapperDTO review : productReview){
            reviewScore += review.getScore();
            System.out.println(reviewScore);
        }
        if(productReview.size() == 0){
            reviewScore = 0;
        } else {
            reviewScore /= productReview.size();
        }

        Map<String, Object> map = new HashMap<>();
        map.put("reviewScore", reviewScore); // 상품 평균 리뷰 평점
        map.put("reviewCount", productReview.size()); // 상품 리뷰 수
        map.put("reviewList", reviewList); // 해당 상품에 달려있는 review List
        // map.put("reviewWriter", memberList); // review 작성자
        map.put("paging", reviewService.productReviewPaging(pg, seq_product));
        map.put("pg", pg);

        model.addAttribute("reviewPg", pg);
        return map;
    }

}
