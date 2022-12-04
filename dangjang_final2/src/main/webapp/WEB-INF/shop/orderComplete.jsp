<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="orderCompleteSection">
    <div class="orderCompleteContent">
        <div class="orderCompleteTitle">
            <img src="/icon/icon_check.png">
            <h1>${orderName}님의 주문이 완료되었습니다.</h1>
            <p>내일 아침에 만나요!</p>
        </div>
        <div class="orderCompleteSummary">
            <p>주문번호 ${orderNum}</p>
            <p>주문일시 ${date}</p>
        </div>
        <div class="orderSeperate"></div>
        <div class="orderInfo">
            <p>[배송준비중]이전일 때 주문내역 상세페이지에서 주문 취소가 가능합니다.</p>
            <p>엘리베이터 이용이 어려운 경우 6층 이상부터는 공동 현관 앞 또는 경비실로 대응 배송 될 수 있습니다.</p>
            <p>주문 / 배송 및 기타 문의가 있을 경우, 1:1 문의에 남겨주시면 신속히 해결해드리겠습니다.</p>
        </div>
        <div class="nextBtnSection">
            <button type="button" onclick="location.href='/dangjang/mypage/order'">주문 상세보기</button>
            <button type="button" onclick="location.href='/dangjang/shop/main'">쇼핑 계속하기</button>
        </div>
    </div>
</div>