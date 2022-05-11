<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="cs_container_header">
    <h2>
        자주하는 질문
        <span>고객님들께서 가장 자주하시는 질문을 모두 모았습니다.</span>
    </h2>
</div>
<div class="cs_container_list">
    <form>
        <input type="hidden" id="FaqPg" name="FaqPg" value="${FaqPg}">
        <input type="hidden" id="faqType" name="faqType" value="${faqType}">
        <div class="cs_faq_search">
            <input type="text" name="search_faq_keyword" id="search_faq_keyword" value required>
            <a href="#none" id="faq_search_btn"><img src="/icon/search_white.png"></a>
        </div>
        <div style="clear: both;"></div>
        <div class="cs_faq_nav">
            <nav>
                <ul>
                    <!-- Best 10이 default! -->
                    <li><a href="#none" id="faq_0">BEST 10</a></li>
                    <li><a href="#none" id="faq_1">회원/정보</a></li>
                    <li><a href="#none" id="faq_2">주문/결제</a></li>
                    <li><a href="#none" id="faq_3">배송</a></li>
                    <li><a href="#none" id="faq_4">취소/교환/반품</a></li>
                    <li><a href="#none" id="faq_5">서비스/기타</a></li>
                </ul>
            </nav>
        </div>
        <div class="cs_faq_contents">
            <ul id="cs_faq_contents_list"></ul>
        </div>

        <div class="layout_paging" id="faq_paging">
            <div class="pagingDiv">
            </div>
        </div> <!--paging-->
    </form>
</div>
<script type="text/javascript" src="/js/csFAQ.js"></script>