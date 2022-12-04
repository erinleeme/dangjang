<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--        1. 보유 쿠폰 수, 쿠폰명/정보, 할인금액, 유효기간, 상태(사용 이전)를 확인할 수 있다.--%>

<jsp:include page="minibar.jsp" />
<article class="mypContainer" >
    <jsp:include page="snb.jsp" />
    <section class="mypContent flexCol">

        <section class="head_content">
            <h3>쿠폰</h3>
            <span class="tit_sub01">쿠폰 지급 후 주문취소나 환불 시 쿠폰은 회수될 수 있습니다.</span>
            <br>
            <hr color="#1A237E" width="100%" size="2px">
        </section>
        <section class="cpWrap">
            <ul id="couponBox">
            </ul>
        </section>

        <section class="paging">

            <%--<span>페이징 공간</span>--%>
        </section>
    </section>

</article>


<script>
    // 화면 구성
    $(function(){
        $.ajax({
            type: 'GET',
            url: '/dangjang/mypage/memberCoupon/myCouponList',
            dataType: 'text',
            success: function(data){
                $('#couponBox').html(data);
            },
            error:  function(err){
                alert(JSON.stringify(err));
            }
        });
    });
</script>