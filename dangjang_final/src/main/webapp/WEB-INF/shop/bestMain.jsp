<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div class="bestArea">
    <div class="bestMain">
        <div class="event_one">
            <img src="/img/best.jpg" style="object-fit: cover">
        </div>

        <!-- 베스트 nav -->
        <div class="bestNav">
            <ul> <!--이건 여러 카테고리 포함된 기획전일 경우에만 보여주기-->
                <li>
                    <a href="#review" class="best_review">
                        리뷰수 TOP 10
                    </a>
                </li>
                <li>
                    <a href="#top" class="best_top">
                        판매량 TOP 10
                    </a>
                </li>
                <li>
                    <a href="#md" class="best_rec">
                        MD추천
                    </a>
                </li>
            </ul>
        </div>

        <!-- 상품 영역 -->
        <div id="best_pro_Container" class="best_pro_Container">
            <div class="best_review_set">
                <div class="product_set">
                    <a name="review"><h4>지금 당장 장바구니로</h4></a>
                    <h4 style="font-weight: 500">후기 수 TOP 10</h4>
                    <div class="product_view">

                    </div>
                </div><!--end c:product_set div-->
            </div><!--end c:main_product_set div-->

            <div class="best_top_set">
                <div class="product_set">
                    <a name="top"><h4>당장 손님의 선택</h4></a>
                    <h4 style="font-weight: 500">판매량 TOP 10</h4>
                    <div class="product_view">

                    </div>
                </div><!--end c:product_set div-->
            </div><!--end c:main_product_set div-->

            <div class="best_md_set">
                <div class="product_set">
                    <a name="md"><h4>당장가게 MD가 준비한 맛집</h4></a>
                    <h4 style="font-weight: 500">MD추천</h4>
                    <div class="product_view">

                    </div>
                </div><!--end c:product_set div-->
            </div><!--end c:main_product_set div-->
        </div>

    </div> <!--end c:categoryMain div-->
</div>

<script type="text/javascript" src="/js/best.js"></script>