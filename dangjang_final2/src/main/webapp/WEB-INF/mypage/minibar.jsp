<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<section class="mypMinibarWrap">
    <div class="innerMinibar">
        <div class="mb_profile miniBox box">
            <%--        <div class="mb2">--%>
            <%--            <div class="member_profile"></div>--%>
            <div style="padding: 10px">
                <img width="40" height="40" src="/img/person.png">
            </div>
            <div style="font-size: 18px">
                <span class="name">${memName}님 환영합니다.<br></span>
            </div>
            <a class="card_01" href="/dangjang/mypage/myInfo#my">
                <img style="margin-top: 5px" id="my" src="/img/setting.png"> 내 정보 관리
            </a>
        </div>
        <div class="mb2" onclick="location.href='/dangjang/mypage/order#my';">
            <%--            <svg width="50" height="40"  xmlns="http://www.w3.org/2000/svg" viewBox="0 0 640 512"><!--! Font Awesome Pro 6.0.0 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2022 Fonticons, Inc. -->--%>
            <%--                <path d="M368 0C394.5 0 416 21.49 416 48V96H466.7C483.7 96 499.1 102.7 512 114.7L589.3 192C601.3 204 608 220.3 608 237.3V352C625.7 352 640 366.3 640 384C640 401.7 625.7 416 608 416H576C576 469 533 512 480 512C426.1 512 384 469 384 416H256C256 469 213 512 160 512C106.1 512 64 469 64 416H48C21.49 416 0 394.5 0 368V48C0 21.49 21.49 0 48 0H368zM416 160V256H544V237.3L466.7 160H416zM160 368C133.5 368 112 389.5 112 416C112 442.5 133.5 464 160 464C186.5 464 208 442.5 208 416C208 389.5 186.5 368 160 368zM480 464C506.5 464 528 442.5 528 416C528 389.5 506.5 368 480 368C453.5 368 432 389.5 432 416C432 442.5 453.5 464 480 464z"/></svg>--%>
            <div style="padding: 10px">
                <img width="40" height="40" src="/img/delivery.png">
            </div>
            <span style="font-size: 15px">주문/배송</span>
            <em style="font-size: 23px">${orderCount}</em>
        </div>
        <div class="mb2" onclick="location.href='/dangjang/mypage/coupon';">
            <%--            <svg width="50" height="40" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512" ><!--! Font Awesome Pro 6.0.0 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2022 Fonticons, Inc. --><path d="M0 128C0 92.65 28.65 64 64 64H512C547.3 64 576 92.65 576 128V208C549.5 208 528 229.5 528 256C528 282.5 549.5 304 576 304V384C576 419.3 547.3 448 512 448H64C28.65 448 0 419.3 0 384V304C26.51 304 48 282.5 48 256C48 229.5 26.51 208 0 208V128z"/></svg>--%>
            <div style="padding: 10px">
                <img width="40" height="40" src="/img/ticket.png">
            </div>
            <span style="font-size: 15px">쿠폰</span>
            <em style="font-size: 23px">${couponCount}</em>
        </div>
        <div class="mb2" onclick="location.href='/dangjang/mypage/pick#my';">
            <!--Begin  pick Icon-->
            <div style="padding: 10px">
                <img width="40" height="40" src="/img/favorite.jpg">
            </div>
            <!--End pick Icon-->
            <span  style="font-size: 15px">찜한 상품</span>
            <em style="font-size: 23px">${favoriteCount}</em>
        </div>
        <div class="mb2" onclick="location.href='/dangjang/mypage/order';">
            <div style="padding: 10px">
                <img width="40" height="40" src="/img/ref.png">
            </div>
            <span style="font-size: 15px">나의 냉장고</span>
            <em style="font-size: 23px">0</em>
        </div>


    </div><!-- innerMinibar end -->
</section>
<%--<script src="js/minibar.js"></script>--%>
<script>
    $(function(){
        $.ajax({
            type: 'get',
            url: '/dangjang/mypage/member/miniBarCount',
            dataType: 'text',
            success: function(data){
                $('.mypMinibarWrap').html(data);
            },
            error: function (err){
                console.log(err);
            }
        });
    });

</script>