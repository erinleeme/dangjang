<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="minibar.jsp" />
<article class="mypContainer" >
    <jsp:include page="snb.jsp" />
    <section class="mypContent flexCol">

        <section class="head_content">
            <h3>교환 반품내역</h3>
            <span class="tit_sub01">지난 3년간 교환 반품 조회가 가능합니다.</span>
            <br>
            <hr color="#1A237E" width="100%" size="2px">
        </section>
        <ul class="orderWrap" id="claimHtml">
        </ul>
        <section class="paging">
            <%--<span>페이징 공간</span>--%>
        </section>
    </section>

</article>


<script type="text/javascript" src="/js/myp03_orderClaim.js"></script>