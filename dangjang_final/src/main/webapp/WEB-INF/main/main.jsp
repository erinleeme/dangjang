<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<article id="contentsArea">
    <!-- 메인 슬릭 슬라이더 -->
    <div class="main_banner">
        <div id="slick-slider-main">
            <!--
            1. img 가져와서 5초마다 변경
            2. 총 배너 , 현재 순서 표시 div + 비동기 처리
            3. cursor 위치에 따라 다르게 표시되도록 js 처리
             -->
            <div>
                <img src="/img/main_slick12.jpg">
            </div>
            <div>
                <img src="/img/main_slick13.jpg">
            </div>
            <div>
                <img src="/img/main_slick15.jpg">
            </div>
            <div>
                <img src="/img/main_slick6.jpg">
            </div>
            <div>
                <img src="/img/main_slick7.jpg">
            </div>
            <div>
                <img src="/img/main_slick18.jpg">
            </div>
            <div>
                <img src="/img/main_slick19.jpg">
            </div>
            <div>
                <img src="/img/main_slick10.jpg">
            </div>
        </div>
        <div></div>
    </div><!--end c:main_banner div-->

    <!-- 첫 번째 상품군 - 신상품 -->
    <div class="main_product_set">
        <div class="product_set">
            <a href="/dangjang/shop/goods/newArr">
                <h4>이 상품 어때요?</h4>
            </a>
            <div class="product_view" id="product_set_1" data-cat="newArr">
            </div>
        </div>
    </div>

    <section class="sectionContainer"> <%--product_set.css에 있음--%>
        <div class="random_line_banner">
            <!-- 비동기 처리로 가져와서 5초마다 변경되게 할 것~ -->
            <div>
                <img src="/img/banner1.jpg">
            </div>
            <div>
                <img src="/img/banner2.jpg">
            </div>
            <div>
                <img src="/img/banner3.jpg">
            </div>
            <div>
                <img src="/img/banner4.jpg">
            </div>
        </div>
    </section>


    <!-- 두 번째 상품군(시간) - 베스트 상품 -->
    <jsp:include page="product_time.jsp" />

    <section class="sectionContainer">
        <div class="random_line_banner">
            <div>
                <img src="/img/banner1.jpg">
            </div>
            <div>
                <img src="/img/banner2.jpg">
            </div>
            <div>
                <img src="/img/banner3.jpg">
            </div>
            <div>
                <img src="/img/banner4.jpg">
            </div>
        </div>
    </section>

    <!-- 세 번째 상품군(나들이 간편요리) - 밀키트 -->
    <div class="main_product_set" >
        <div class="product_set">
            <a href="/dangjang/shop/goods/category?categoryCode=D7">
                <h4>나들이 간편요리</h4>
            </a>
            <div class="product_view" id="product_set_3" data-cat="D7" >
            </div>
        </div>
    </div>

    <!-- 네 번째 상품군(SNS 감성 가득한) - 베이커리 카테고리 - -->
    <div class="main_product_set" >
        <div class="product_set">
            <a href="/dangjang/shop/goods/category?categoryCode=D10">
                <h4>SNS 감성 가득한</h4>
            </a>
            <div class="product_view" id="product_set_4" data-cat="D10">
            </div>
        </div>
    </div>

    <!-- 다섯 번째 상품군(식단관리 필수템) - 간편식/샐러드 카테고리-->
    <div class="main_product_set" >
        <div class="product_set">
            <a href="/dangjang/shop/goods/category?categoryCode=D8">
                <h4>식단관리 필수템</h4>
            </a>
            <div class="product_view" id="product_set_5" data-cat="D8">
            </div>
        </div>
    </div>

    <section class="sectionContainer">
        <div class="random_line_banner">
            <div>
                <img src="/img/banner1.jpg">
            </div>
            <div>
                <img src="/img/banner2.jpg">
            </div>
            <div>
                <img src="/img/banner3.jpg">
            </div>
            <div>
                <img src="/img/banner4.jpg">
            </div>
        </div>
    </section>

    <!-- 여섯 번째 상품군(간단하게 챙기는 점심식사) - 국/반찬/요리 카테고리 -->
    <div class="main_product_set" >
        <div class="product_set">
            <a href="/dangjang/shop/goods/category?categoryCode=D6">
                <h4>간단하게 챙기는 점심 식사</h4>
            </a>
            <div class="product_view" id="product_set_6" data-cat="D6">
            </div>
        </div>
    </div>

    <!-- 일곱 번째 상품군(냉장고 속 단골손님) - 채소 카테고리 -->
    <div class="main_product_set" >
        <div class="product_set">
            <a href="/dangjang/shop/goods/category?categoryCode=D1">
                <h4>당신의 냉장고 속 단골 손님</h4>
            </a>
            <div class="product_view" id="product_set_7" data-cat="D1" >
            </div>
        </div>
    </div>

</article> <!--end i:contentsArea article-->
<article id="customerCenter_list">
    <div id="customerCenter_list_wrap">
        <div class="latestBoard boardNotice">
            <h3>공지사항</h3>
            <ul id="main_cs_noticeList"></ul>
            <a href="/dangjang/shop/cs/notice" class="more">더보기</a>
        </div> <!--end c:latestBoard,boardNotice div-->
        <div class="latestBoard boardFAQ">
            <h3>FAQ</h3>
            <ul id="main_cs_faqList"></ul>
            <a href="/dangjang/shop/cs/faq" class="more">더보기</a>
        </div> <!--end c:latestBoard,boardFAQ div-->
    </div><!--end i:customerCenter_list_wrap div-->
</article> <!--end i:customerCenter_list article-->


<script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<script type="text/javascript" src="/js/main_product.js"></script>
<script type="text/javascript" src="/js/product_time.js"></script>