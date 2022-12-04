<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%--ProductMapperDTO 사용--%>
<input type="hidden" value="${fn:length(reviewPossibleMapperDTOList)}" id="reviewPossibleLength">
<c:if test="${fn:length(reviewPossibleMapperDTOList) == 0}">
    <li class="list">
        <h5 style="color: #888888; display: inline">후기를 기다리는 상품이 없습니다.</h5>

    </li>
</c:if>
<c:if test="${fn:length(reviewPossibleMapperDTOList) != 0}">
    <li class="list">
        <p>작성가능한 리뷰는... ${fn:length(reviewPossibleMapperDTOList)}</p>

    </li>
</c:if>
<c:forEach   items="${reviewPossibleMapperDTOList}" var="item">
    <li class="list">
        <div class="prodUnit">
            <div class="thumb">
                <a href="javascript:void(0);" >
                    <div class="img">
                        <img src="/images/${item.serial_number}.jpg" alt="${item.name}">
                    </div>
                </a>
            </div>
            <div class="pdInfo">
                <div class="name">
                    <a href="javascript:void(0);">${item.name}</a>
                </div>
                <div class="option">수량<span >${item.count}</span>
                </div>
                <div class="delivery">
                    배송완료 <span>${item.create_date}</span>
                </div>
            </div>
        </div>
        <div class="reviewBtnArea">
            <a href="javascript:void(0);"
               class="btnReviewWrite btn_myp01"
               data-serial_num="${item.serial_number}"
               data-name="${item.name}"
               data-seq_order_pdt ="${item.seq_order_pdt}"
            >후기작성</a>
        </div>
    </li>
</c:forEach>

