package com.dangjang.mapper;

import com.dangjang.domain.BasicProduct;
import com.dangjang.domain.Product;
import com.dangjang.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface ProductMapper {

    @Select("select count(*) from product where DATEDIFF(now(), create_date) < #{date}")
    int getTotalRecords(Long date); //

    // 카테고리 총 상품 수
    int getTotalProductRecords(@Param("categoryCode") String categoryCode, @Param("subCategoryNum") String subCategoryNum);

    // 검색 총 상품 수
    int getTotalSearchRecords(String keyword);

    // 신상품 리스트 --------------------------------------------------------------------------------------
    List<ProductMapperDTO> suggestionNewProList(Map<String, Object> map); // 추천순(default)

    List<ProductMapperDTO> newProductList(Map<String, Object> map); // 신상품순

    List<ProductMapperDTO> bestNewProductList(Map<String, Object> map); // best 상품

    List<ProductMapperDTO> orderByPriceNewPro(Map<String, Object> map); // 가격순

    // 메인 상품 리스트 --------------------------------------------------------------------------------------
    List<ProductMapperDTO> newProduct10List(); // 신상품 10개

    List<ProductMapperDTO> getBestProduct2(); // 많이팔린순 2개

    List<ProductMapperDTO> getProduct10(String category); // 진짜;;; 내가생각해도 개잘만들었다!!

    // 검색 상품 리스트 --------------------------------------------------------------------------------------
    List<ProductMapperDTO> search(String keyword); // 검색

    List<ProductMapperDTO> suggestionSearchList(Map<String, Object> map); // 추천순

    List<ProductMapperDTO> latelySearchList(Map<String, Object> map); // 신상품 순

    List<ProductMapperDTO> bestSearchList(Map<String, Object> map); // 베스트 순

    List<ProductMapperDTO> orderByPriceSearchList(Map<String, Object> map); // 가격 순

    // 카테고리 리스트 --------------------------------------------------------------------------------------
    @Select("select category_name from big_category where code_name = #{categoryCode}")
    String getCategoryTitle(String categoryCode);

    @Select("select code_name, category_name, id from middle_category where code_name = #{categoryCode}")
    List<MiddleCategoryMapperDTO> getSubCatList(String categoryCode);

    List<ProductMapperDTO> suggestionProList(Map<String, Object> map); // 추천순

    List<ProductMapperDTO> latelyProList(Map<String, Object> map); // 신상품 순

    List<ProductMapperDTO> bestProList(Map<String, Object> map); // 베스트 순

    List<ProductMapperDTO> orderByPriceProList(Map<String, Object> map); // 가격순

    // 정렬 유형 --------------------------------------------------------------------------------------
    List<ProductMapperDTO> suggestionList(Map<String, String> map); // 추천순

    List<ProductMapperDTO> bestProductList(Map<String, String> map); // 카테고리 best 상품

    List<ProductMapperDTO> OrderByPrice(Map<String, String> map); // 최고가순 최저가순

    // 베스트 리스트 --------------------------------------------------------------------------------------
    List<ProductMapperDTO> getReviewProductTop10(); // 리뷰 Top 10 상품

    List<ProductMapperDTO> getSellingTopProduct(); // 많이팔린순 Top 10

    List<ProductMapperDTO> getSuggestionTopProduct(); // MD 추천 (사실 랜덤 10개)

    // 공통: 좋아요, 리뷰 count --------------------------------------------------------------------------------------
    List<Long> getFavoriteCount(List<ProductMapperDTO> Product);

    List<Long> getProductReview(List<ProductMapperDTO> Product);

    // 기획전 count --------------------------------------------------------------------------------------
    List<ProductMapperDTO> eventProduct(Map<String, Object> map); // 기획전 default

    List<ProductMapperDTO> latelyEventProList(Map<String, Object> map); // 기획전 최신순

    List<ProductMapperDTO> bestProEventList(Map<String, Object> map); // 기획전 많이 팔린 순

    List<ProductMapperDTO> orderByPriceProEventList(Map<String, Object> map); // 기획전 가격순

    int getTotalEventProductRecords(); // 기획전 상품 총 수량 (D10, D11)

    List<ProductMapperDTO> getCartChoiceProduct(List<String> productSeq); // 카트에서 선택한 상품들의 정보

    @Select("select * from product where seq_product = #{seq_product}")
    ProductMapperDTO getProductInformation(String seq_product);

    // mypage
    //찜에 있는 상품 목록
    List<ProductMapperDTO> getFavoriteProduct(List<FavoriteMapperDTO> favoriteList);

    //Qna에 있는 상품 목록
    List<ProductMapperDTO> getQnaProductList(List<QnAMapperSDTO> qnaList);

    //주문내역에 있는 목록
    List<ProductMapperDTO> getOrderProductList(List<OrderProductMapperDTO> orderProductList);

    //리뷰 가능한 상품 목록 갖고오기
    List<ProductMapperDTO> getReviewProssibleProduct(List<OrderProductDTO> orderReviewList);

    // 결제용 장바구니 상품 정보
    List<ProductMapperDTO> getOrderProduct(@Param("memId") long memId);

    // 상품 상세 좋아요 수
    @Select("select count(*) from favorite where product_id = #{seq_product}")
    int getOneFavoriteCount(@Param("seq_product") long seq_product);

    // 상품 상세 리뷰 수
    List<ReviewMapperDTO> getOneProductReview(@Param("seq_product") long seq_product);

    // middlecategory
    MiddleCategoryMapperDTO getMiddleCategory(@Param("seq_product") String seq_product);

    // bigcategory
    BigCategoryMapperDTO getBigCategory(@Param("seq_product") String seq_product);

    // randomProduct
    List<ProductMapperDTO> randomProduct(@Param("seq_big_category") long seq_big_category);

    List<ProductMapperDTO> getBuyProductList(List<OrderProductMapperDTO> list);
}
