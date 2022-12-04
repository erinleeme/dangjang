
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<c:forEach items="${orderClaimList}" var="item">
    <li class="list">
        <div class="prodUnit">
            <div class="thumb">
                <a href="javascript:void(0);" onclick="javascript:showProductDetail(${item.seq_product});" >
                    <div class="img">
                        <img src="/images/${item.serial_number}.jpg" alt="${item.name}">
                    </div>
                </a>
            </div>
            <div class="pdInfo">
                <div class="name">
                    <a href="javascript:void(0);">${item.name}</a>
                </div>
                <div class="option">수량<span>${item.count}개</span>
                </div>
                <div class="delivery">
                    배송완료 <span></span>${item.end_date}
                </div>
                <div class="status">
                    <span>${item.order_status}</span>
                </div>
            </div>
        </div>

        <div class="div_open toggleDiv">
        </div>

        <div class="info_view" style="display: none">
            <ul class="infoResult">
                <li>
                    <dl>
                        <dt>주문번호</dt>
                        <dd>${item.order_num}</dd>
                    </dl>
                    <dl>
                        <dt>사유</dt>
                        <dd>${item.claim_content}</dd>
                    </dl>
                    <dl>
                        <dt>완료일자</dt>
                        <dd>${item.claim_date}</dd>
                    </dl>
                </li>
            </ul>
        </div>
    </li>
</c:forEach>
