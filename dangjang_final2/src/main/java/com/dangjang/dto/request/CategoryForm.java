package com.dangjang.dto.request;

/**
 * 1. 카테고리 메인 페이지에서는
 *     - 하위 카테고리 목록
 *     - 접속 단계
 * ex) 채소 > 고구마/감자/당근
 *     - 해당 카테고리의 총 상품 수
 *     - 진행되는 기획전
 *     - 할인상품
 *     - 하위 카테고리 상품 목록
 * 을 확인할 수 있다.
 */
public class CategoryForm {
    private Long bigCategory;
    private Long middleCategory;

}
