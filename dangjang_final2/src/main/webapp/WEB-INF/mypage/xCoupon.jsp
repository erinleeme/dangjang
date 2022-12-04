
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<h3 style="display: inline">나의 쿠폰 &nbsp;     </h3>
<h5 style="color: #888888; display: inline"> 사용 가능 쿠폰 : ${fn:length(myCouponList)}개</h5>
<br>
<br>
<c:forEach   items="${myCouponList}" var="item">

<%--    <c:if test="${item.dday > -1}">--%>
        <li class="list" data-seqno="${item.seq_coupon}">
            <div class="cp_unit">
                <div class="cp_box">
                    <span class="price">${item.coupon_price}</span>
                    <span class="won">원</span>
                </div>
                <div class="cp_info">
                    <div class="name">${item.coupon_name}</div>
                    <div class="couti">${item.coupon_content}</div>
                    <div class="date">${item.end_date}


                        <strong>${item.dday}일 남음</strong></div>
                </div>
            </div>
        </li>
<%--    </c:if>--%>
</c:forEach>

<c:if test="${fn:length(myCouponList) == 0}">
    <li class="list">
        <p>사용 가능한 쿠폰이 없습니다.</p>
    </li>
</c:if>

<script>


</script>