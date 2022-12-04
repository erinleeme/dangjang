<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="mypageSbn">
    <h2 style="padding: 0">마이페이지</h2>
    <ul>
        <li>
            <a href="/dangjang/mypage/order#my">주문 배송내역</a>
        </li>

        <li>
            <a href="/dangjang/mypage/orderClaim#my">교환 반품내역</a>

        </li>
        <li>
            <a href="/dangjang/mypage/pick#my">찜한상품</a>

        </li>
        <li>
            <a href="/dangjang/mypage/review#my">상품후기</a>
        </li>

        <li>
            <a href="/dangjang/mypage/coupon#my">쿠폰</a>
        </li>
        <li>
            <a href="/dangjang/mypage/myInfo#my">회원정보</a>
        </li>
        <li>
            <a href="/dangjang/mypage/addr#my">배송지관리</a>
        </li>
        <li>
            <a href="/dangjang/mypage/qna#my">고객문의</a>
        </li>

        <div class="cs_oneToOne" style="cursor:pointer;" onclick=location.href="qna">
            <p class="cs_oneToOne_f">도움이 필요하신가요?</p>
            <p class="cs_oneToOne_S">1:1 문의하기</p>
        </div> <!--end c:cs_oneToOne div-->
    </ul>
</section>