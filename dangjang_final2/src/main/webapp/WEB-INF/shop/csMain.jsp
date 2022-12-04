<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div id="csMain">
    <section class="cs_snb">
        <h2 class="cs_tit_snb">고객센터</h2>
        <div class="cs_inner_snb">
            <ul>
                <a href="/dangjang/shop/cs/notice"><li id="cs_inner_snb_1">공지사항</li></a>
                <a href="/dangjang/shop/cs/faq"><li>자주하는 질문</li></a>
            </ul>
        </div> <!--end c:cs_inner_snb div-->
        <!-- 클릭하면 로그인 유무 > 1. 로그인 상태 - 마이페이지 1:1 문의 2. 비 로그인 상태 - 로그인 화면 -->
        <c:if test="${memId == null}">
            <div class="cs_oneToOne" style="cursor:pointer;" onclick="moveToLogin()">
                <p class="cs_oneToOne_f">도움이 필요하신가요?</p>
                <p>1:1 문의하기</p>
            </div> <!--end c:cs_oneToOne div-->
        </c:if>
        <c:if test="${memId != null}">
            <div class="cs_oneToOne" style="cursor:pointer;" onclick="moveToOneToOne()">
                <p class="cs_oneToOne_f">도움이 필요하신가요?</p>
                <p>1:1 문의하기</p>
            </div> <!--end c:cs_oneToOne div-->
        </c:if>
    </section> <!--end c:cs_snb section-->
    <!-- snb 선택에 따라 container jsp 변경 -->
    <!-- notice, faq -->
    <section class="cs_container">
        <jsp:include page="${cs_display}" />
    </section>
</div>

