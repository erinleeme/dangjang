<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="minibar.jsp" />
<article class="mypContainer" >
    <jsp:include page="snb.jsp" />
    <section class="mypContent flexCol">

        <section class="head_content">
            <h3>찜한 상품 </h3>
            <span class="tit_sub01">최대 50개까지 등록가능 합니다. 50개 이상의 상품을 담으면 가장 오래 저장된 상품이 자동으로 삭제됩니다.</span>
            <br>
            <hr color="#1A237E" width="100%" size="2px">
        </section>

        <div class="pickPdArea" id="pickHtml">

        </div>

    </section>

</article>
<script src="js/svgcheckbx.js"></script>
<script type="text/javascript" src="/js/myp04_pick.js"></script>