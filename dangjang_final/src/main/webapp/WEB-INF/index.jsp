<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <meta name="title" content="당장가게 :: 맛있게 드시는 순간까지 함께하는 당장가게">
    <meta name="theme-color" content="#00Acc1">
    <meta name="description" content="당신의 장바구니 속 먹거리를 냉장고까지! 유통기한 관리로 건강한 식생활을 제공하는 당장가게">

    <meta property="og:type" content="website">
    <meta property="og:title" content="당장가게 :: 맛있게 드시는 순간까지 함께하는 당장가게">
    <meta property="og:description" content="당신의 장바구니 속 먹거리를 냉장고까지! 유통기한 관리로 건강한 식생활을 제공하는 당장가게">
    <meta peoperty="og:image" content=""> <!--추가 필요-->
    <meta property="og:url" content=""> <!--추가 필요-->

    <!--favicon 추가 필요-->

    <title>당장가게 :: 맛있게 드시는 순간까지 함께하는 당장가게</title>

    <!--font-style link-->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap"
          rel="stylesheet">

    <!-- 공통 고정 css -->
    <link rel="stylesheet" type="text/css" href="/css/common.css">
    <link rel="stylesheet" type="text/css" href="/css/topPmBanner.css">
    <link rel="stylesheet" type="text/css" href="/css/header.css">
    <link rel="stylesheet" type="text/css" href="/css/main_banner.css">
    <link rel="stylesheet" type="text/css" href="/css/main_cs_list.css">
    <link rel="stylesheet" type="text/css" href="/css/footer.css">

    <!-- 회원 관련 css -->
    <link rel="stylesheet" type="text/css" href="/css/login.css">
    <link rel="stylesheet" type="text/css" href="/css/join.css">
    <link rel="stylesheet" type="text/css" href="/css/joinkakao.css">
    <link rel="stylesheet" type="text/css" href="/css/idSearch.css">
    <link rel="stylesheet" type="text/css" href="/css/pwdSearch.css">
    <link rel="stylesheet" type="text/css" href="/css/joinResult.css">

    <!-- 상품 관련 css -->
    <link rel="stylesheet" type="text/css" href="/css/product_set.css">
    <link rel="stylesheet" type="text/css" href="/css/productDetail.css">
    <link rel="stylesheet" type="text/css" href="/css/categoryMain.css">
    <link rel="stylesheet" type="text/css" href="/css/newArrivalMain.css">
    <link rel="stylesheet" type="text/css" href="/css/eventList.css">
    <link rel="stylesheet" type="text/css" href="/css/eventMain.css">
    <link rel="stylesheet" type="text/css" href="/css/bestMain.css">
    <link rel="stylesheet" type="text/css" href="/css/searchList.css">
    <link rel="stylesheet" type="text/css" href="/css/eventProductMain.css">

    <!-- 장바구니/주문/결제 css -->
    <link rel="stylesheet" type="text/css" href="/css/cartList.css">
    <link rel="stylesheet" type="text/css" href="/css/deliveryList.css">
    <link rel="stylesheet" type="text/css" href="/css/payment.css">
    <link rel="stylesheet" type="text/css" href="/css/orderComplete.css">

    <!-- 고객 센터 관련 css -->
    <link rel="stylesheet" type="text/css" href="/css/csMain.css">

    <!-- 슬릭 슬라이더 -->
    <!-- Add the slick-theme.css if you want default styling -->
    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
    <!-- Add the slick-theme.css if you want default styling -->
    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick-theme.css"/>
    <!-- hj -->
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script type="text/javascript" src="https://developers.kakao.com/sdk/js/kakao.js"></script>
    <script type="text/javascript" src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script type="text/javascript"
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous"></script><!-- jQuery CDN --->
    <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>


    <!-- ye -->
    <link rel="stylesheet" type="text/css" href="/css/mypageModal.css">
    <link rel="stylesheet" type="text/css" href="/css/mypage1-5.css">
    <link rel="stylesheet" type="text/css" href="/css/mypage6-10.css">
    <link rel="stylesheet" type="text/css" href="/css/mypageCommon.css">
    <link rel="stylesheet" type="text/css" href="/css/checkbox_component.css"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css"/>

</head>
<body class="dMain">
<!--주석
    c: 클래스
    i: 아이디 -->
<header>
    <div class="allWrap ">
        <!--이벤트 배너-->
        <div class="topPmBanner">
            <!--default-->
            <div class="tpbInner" id="tpbInner">
                <h2>HELLO DANGJANG WORLD!</h2>
                <p>
                    <span>당신의 신선한 냉장고를 위한 '당장가게'</span>
                </p>
                <p>
                    <!--로그인 유무 따져야 함-->
                    <c:if test="${memId == null}">
                        <a href="/dangjang/shop/member/login">
                            <span>지금, 당신의 냉장고를 '<strong>공유</strong>' 해보세요 ></span>
                        </a>
                    </c:if>
                    <c:if test="${memId != null}">
                        <a href="#none">
                            <span>지금, 당신의 냉장고를 '<strong>공유</strong>' 해보세요 ></span>
                        </a>
                    </c:if>
                </p>
            </div><!--end c:tpbInner div-->
            <a href="#" class="tpbOpen" id="tpbOpen">
                <svg height="30px" width="30px">
                    <line x1="0" y1="15px" x2="30px" y2="15px" style="stroke:#000000; stroke-width: 2px;"/>
                    <line x1="15px" y1="0" x2="15px" y2="30px" style="stroke:#000000; stroke-width: 2px;"/>
                </svg>
            </a>

            <!--open-->
            <div class="tpbInner_Open" id="tpbInner_Open" style="display: none;">
                <div class="tpbOpenInner_content" id="tpbOpenInner_content">
                    <div class="tpbOpenInner_content_txt">
                        <h2>HELLO,</h2>
                        <p>당신의 장바구니에 담기는 순간부터,</p>
                        <p>맛있게 드시는 순간까지</p>
                        <p>당장가게가 함께합니다.</p>
                        <h3>당장가게</h3>
                    </div> <!--end c:tpbOpenInner_content_txt div-->
                    <div class="tpbOpenInner_content_join">
                        <c:if test="${memId == null}">
                            <a href="/dangjang/shop/member/join/list">
                                <h2>JOIN</h2>
                                <svg width="140px" height="140px">
                                    <circle cx="70px" cy="70px" r="70px" fill="#F50057"></circle>
                                </svg>
                            </a>
                        </c:if>
                        <c:if test="${memId != null}">
                            <a href="/dangjang/mypage/order">
                                <h2>JOIN</h2>
                                <svg width="140px" height="140px">
                                    <circle cx="70px" cy="70px" r="70px" fill="#F50057"></circle>
                                </svg>
                            </a>
                        </c:if>
                    </div> <!--end c:tpbOpenInner_content_join div-->
                </div> <!--end c:tpbOpenInner_content i:tpbOpenInner_content div-->
                <div class="tpbClose" id="tpbClose">
                    <a href="#">
                        <svg height="50px" width="50px">
                            <line x1="0" y1="0" x2="50px" y2="50px" style="stroke:#FFFFFF; stroke-width: 2px;"/>
                            <line x1="0" y1="50px" x2="50px" y2="0" style="stroke:#FFFFFF; stroke-width: 2px;"/>
                        </svg>
                    </a>
                </div> <!--end c:tpbClose i:tpbClose div-->
            </div> <!--end c:tpbInner_Open i:tpbInner_Open div-->
        </div> <!--end c:topPmBanner div-->
        <script src="/js/top-banner.js"></script>

        <div id="header" class="dHeader">
            <!--logo & 개인메뉴-->
            <div class="header_area">
                <div class="header_contents">
                    <!--logo-->
                    <h1 class="logo">
                        <a href="/dangjang/shop/main">
                            <!--img로 대체 예정-->
                            <div>
                                <img src="/logo/dangjangLogo.png" alt="로고이미지">
                            </div>
                        </a>
                    </h1>
                    <div class="topMenu">
                        <div class="tMenu_unb">
                            <ul>
                                <c:if test="${memId == null}">
                                    <li class="t_m_unb t_m_join">
                                        <!--회원가입 링크 연결 필요-->
                                        <a href="/dangjang/shop/member/join/list" class="link_unb_menu">회원가입</a>
                                    </li>
                                    <li class="t_m_unb t_m_login">
                                        <!--로그인 링크 연결 필요-->
                                        <a href="/dangjang/shop/member/login" class="link_unb_menu">로그인</a>
                                    </li>
                                </c:if>
                                <c:if test="${memId != null}">
                                    <li class="t_m_unb t_m_mine" id="t_m_mine">
                                        <a href="/dangjang/mypage/order" id="unb_memberName">${memName} 님</a>
                                        <ul class="t_m_mine_sub" id="t_m_mine_sub">
                                            <li><a href="/dangjang/mypage/order">주문 내역</a></li>
                                            <li><a href="/dangjang/mypage/pick">찜한 상품</a></li>
                                            <li><a href="/dangjang/mypage/addr">배송지 관리</a></li>
                                            <li><a href="/dangjang/mypage/review">상품 후기</a></li>
                                            <li><a href="/dangjang/mypage/qna">문의</a></li>
                                            <li><a href="/dangjang/mypage/coupon">쿠폰</a></li>
                                            <li><a href="/dangjang/mypage/myInfo">개인 정보 수정</a></li>
                                            <li><a href="/dangjang/shop/member/logout">로그아웃</a></li>
                                        </ul>
                                    </li>
                                    <li class="t_m_unb t_m_alr">
                                        <a href="#none" class="t_m_alr_menu">알림</a>
                                    </li>
                                    <li class="t_m_unb t_m_ref">
                                        <a href="#none">나의 냉장고</a>
                                    </li>
                                </c:if>
                                <li class="t_m_cs" id="t_m_cs">
                                    <a href="/dangjang/shop/cs/notice" class="link_unb_menu">고객센터</a>
                                    <ul class="t_m_cs_sub" id="t_m_cs_sub">
                                        <li>
                                            <a href="/dangjang/shop/cs/notice">공지사항</a>
                                        </li>
                                        <li>
                                            <a href="/dangjang/shop/cs/faq">자주하는질문</a>
                                        </li>
                                        <c:if test="${memId == null}">
                                            <li>
                                                <a href="/dangjang/shop/member/login">1:1문의</a>
                                            </li>
                                        </c:if>
                                        <c:if test="${memId != null}">
                                            <li>
                                                <a href="/dangjang/mypage/qna">1:1문의</a>
                                            </li>
                                        </c:if>
                                    </ul>
                                </li>
                                <script src="/js/unb-menu.js"></script>
                            </ul>
                        </div> <!--end c:tMenu_unb div-->
                    </div> <!--end c:topMenu div-->
                </div> <!--end c:header_contents div-->
            </div> <!--end c:header_area div-->

            <div class="headerGnbWrap" id="headerGnbWrap">
                <div class="gnb" id="gnbArea">
                    <!--GNB 메뉴-->
                    <div class="gnb-main">
                        <ul class="gnb">
                            <li class="menu0">
                                <a href="javascript:void(0)" class="carList" id="carList">
                                    <span class="menu-ico"></span>
                                    <span class="menu-txt">전체상품보기</span>
                                </a>
                            </li>
                            <li class="menu1">
                                <a href="/dangjang/shop/goods/newArr">
                                    <span class="menu-txt">신상품</span>
                                </a>
                            </li>
                            <li class="menu2">
                                <a href="/dangjang/shop/goods/best">
                                    <span class="menu-txt">베스트</span>
                                </a>
                            </li>
                            <li class="menu3">
                                <a href="/dangjang/shop/goods/event">
                                    <span class="menu-txt">기획전</span>
                                </a>
                            </li>
                            <li class="menu4">
                                <a href="#">
                                    <span class="menu-txt">당신의 냉장고</span>
                                </a>
                            </li>
                            <c:if test="${memId == null}">
                                <li class="ico">
                                    <a href="/dangjang/shop/member/login">
                                        <span class="ico_pick"></span>
                                        <span class="ico-txt">찜하기</span>
                                    </a>
                                </li>
                                <li class="ico">
                                    <a href="/dangjang/shop/member/login">
                                        <span class="ico_cart"></span>
                                        <span class="ico-txt">장바구니</span>
                                    </a>
                                </li>
                                <li class="ico">
                                    <a href="/dangjang/shop/member/login">
                                        <span class="ico_ref"></span>
                                        <span class="ico-txt">나의냉장고</span>
                                    </a>
                                </li>
                            </c:if>
                            <c:if test="${memId != null}">
                                <li class="ico">
                                    <a href="/dangjang/mypage/pick">
                                        <span class="ico_pick"></span>
                                        <span class="ico-txt">찜하기</span>
                                        <!--0일때는 display none이고, 1 이상이면 보여주기-->
                                        <span id="pick_item_count" class="num"
                                              style="display: inline">${favoriteCount}</span>
                                    </a>
                                </li>
                                <li class="ico">
                                    <a href="/dangjang/shop/cart">
                                        <span class="ico_cart"></span>
                                        <span class="ico-txt">장바구니</span>
                                        <!--로그인 한 user의 local storage에서 가져오기-->
                                        <span id="cart_item_count" class="num"
                                              style="display: inline">${cartCount}</span>
                                    </a>
                                </li>
                                <li class="ico">
                                    <a href="#none">
                                        <span class="ico_ref"></span>
                                        <span class="ico-txt">나의냉장고</span>
                                    </a>
                                </li>
                            </c:if>
                            <li class="ico">
                                <a href="#none">
                                    <span id="ico_search"></span>
                                    <span class="ico-txt">검색</span>
                                    <div id="ico_close" style="display: none">
                                        <svg height="20px" width="20px">
                                            <line x1="0" y1="0" x2="20px" y2="20px"
                                                  style="stroke:#1A237E; stroke-width: 1.5px;"/>
                                            <line x1="0" y1="20px" x2="20px" y2="0"
                                                  style="stroke:#1A237E; stroke-width: 1.5px;"/>
                                        </svg>
                                    </div> <!--end i:ico_close div-->
                                </a>
                            </li>
                        </ul>
                    </div> <!--end c:gnb-main div-->
                    <!--전체 카테고리 리스트-->
                    <div class="gnb_allCat" id="gnb_allCat">
                        <div class="gnb_sub"> <!--  -->
                            <ul>
                                <!--hover 시 li에 class current_sub_menu 추가-->
                                <li class="current_sub_menu">
                                    <a class="gnb_sub_menu mcm" data-cat="D1" onclick="showCategory(this)"
                                       onmouseover="noteCategory(this)" onmouseout="removeNoteCategory(this)">
                                    <span class="gnb_sub_icon">
                                        <img src="/icon/icon_veggies.png" alt="카테고리 아이콘">
                                    </span>
                                        <span class="gnb_sub_tit">
                                        <span class="gnb_sub_txt">채소</span>
                                    </span>
                                    </a>
                                    <ul class="sub_menu">
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J1" data-subcat-end="J3"
                                               data-parent="D1">
                                                <span class="sub_sub_tit">고구마·감자·당근</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J4" data-subcat-end="J6"
                                               data-parent="D1">
                                                <span class="sub_sub_tit">시금치·쌈채소·나물</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J7" data-subcat-end="J9"
                                               data-parent="D1">
                                                <span class="sub_sub_tit">브로콜리·파프리카·양배추</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J10" data-subcat-end="J13"
                                               data-parent="D1">
                                                <span class="sub_sub_tit">양파·대파·마늘·배추</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J14" data-subcat-end="J16"
                                               data-parent="D1">
                                                <span class="sub_sub_tit">오이·호박·고추</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J17" data-subcat-end="J18"
                                               data-parent="D1">
                                                <span class="sub_sub_tit">냉동·간편채소</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J19" data-subcat-end="J20"
                                               data-parent="D1">
                                                <span class="sub_sub_tit">콩나물·버섯</span>
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                                <li>
                                    <a class="gnb_sub_menu mcm" data-cat="D2" onclick="showCategory(this)"
                                       onmouseover="noteCategory(this)" onmouseout="removeNoteCategory(this)">
                                                    <span class="gnb_sub_icon">
                                                        <img src="/icon/icon_fruit.png" alt="카테고리 아이콘">
                                                    </span>
                                        <span class="gnb_sub_tit">
                                                        <span class="gnb_sub_txt">과일</span>
                                                    </span>
                                    </a>
                                    <ul class="sub_menu">
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J22" data-subcat-end="J22"
                                               data-parent="D2">
                                                <span class="sub_sub_tit">과일</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J23" data-subcat-end="J23"
                                               data-parent="D2">
                                                <span class="sub_sub_tit">간편과일</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J24" data-subcat-end="J25"
                                               data-parent="D2">
                                                <span class="sub_sub_tit">냉동·건과일</span>
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                                <li>
                                    <a class="gnb_sub_menu mcm" data-cat="D3" onclick="showCategory(this)"
                                       onmouseover="noteCategory(this)" onmouseout="removeNoteCategory(this)">
                                                    <span class="gnb_sub_icon">
                                                        <img src="/icon/icon_fish2.png" alt="카테고리 아이콘">
                                                    </span>
                                        <span class="gnb_sub_tit">
                                                        <span class="gnb_sub_txt">수산·해산·건어물</span>
                                                    </span>
                                    </a>
                                    <ul class="sub_menu">
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J26" data-subcat-end="J26"
                                               data-parent="D3">
                                                <span class="sub_sub_tit">생선류</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J27" data-subcat-end="J28"
                                               data-parent="D3">
                                                <span class="sub_sub_tit">굴비·반건류</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J29" data-subcat-end="J31"
                                               data-parent="D3">
                                                <span class="sub_sub_tit">오징어·낙지·문어</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J32" data-subcat-end="J34"
                                               data-parent="D3">
                                                <span class="sub_sub_tit">새우·게·랍스터</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J35" data-subcat-end="J36"
                                               data-parent="D3">
                                                <span class="sub_sub_tit">해산물·조개류</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J37" data-subcat-end="J37"
                                               data-parent="D3">
                                                <span class="sub_sub_tit">수산가공품</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J38" data-subcat-end="J40"
                                               data-parent="D3">
                                                <span class="sub_sub_tit">김·미역·해조류</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J41" data-subcat-end="J42"
                                               data-parent="D3">
                                                <span class="sub_sub_tit">건어물·다시팩</span>
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                                <li>
                                    <a class="gnb_sub_menu mcm" data-cat="D4" onclick="showCategory(this)"
                                       onmouseover="noteCategory(this)" onmouseout="removeNoteCategory(this)">
                                                    <span class="gnb_sub_icon">
                                                        <img src="/icon/icon_meat.png" alt="카테고리 아이콘">
                                                    </span>
                                        <span class="gnb_sub_tit">
                                                        <span class="gnb_sub_txt">정육·계란</span>
                                                    </span>
                                    </a>
                                    <ul class="sub_menu">
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J43" data-subcat-end="J43"
                                               data-parent="D4">
                                                <span class="sub_sub_tit">소고기</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J44" data-subcat-end="J44"
                                               data-parent="D4">
                                                <span class="sub_sub_tit">돼지고기</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J45" data-subcat-end="J45"
                                               data-parent="D4">
                                                <span class="sub_sub_tit">계란류</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J46" data-subcat-end="J47"
                                               data-parent="D4">
                                                <span class="sub_sub_tit">닭·오리고기</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J48" data-subcat-end="J49"
                                               data-parent="D4">
                                                <span class="sub_sub_tit">양념육·돈까스</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J50" data-subcat-end="J50"
                                               data-parent="D4">
                                                <span class="sub_sub_tit">양고기</span>
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                                <li>
                                    <a class="gnb_sub_menu mcm" data-cat="D5" onclick="showCategory(this)"
                                       onmouseover="noteCategory(this)" onmouseout="removeNoteCategory(this)">
                                                    <span class="gnb_sub_icon">
                                                        <img src="/icon/icon_wheat2.png" alt="카테고리 아이콘">
                                                    </span>
                                        <span class="gnb_sub_tit">
                                                        <span class="gnb_sub_txt">쌀·잡곡·견과</span>
                                                    </span>
                                    </a>
                                    <ul class="sub_menu">
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J53" data-subcat-end="J54"
                                               data-parent="D5">
                                                <span class="sub_sub_tit">쌀·잡곡</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J52" data-subcat-end="J52"
                                               data-parent="D5">
                                                <span class="sub_sub_tit">견과류</span>
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                                <li>
                                    <a class="gnb_sub_menu mcm" data-cat="D6" onclick="showCategory(this)"
                                       onmouseover="noteCategory(this)" onmouseout="removeNoteCategory(this)">
                                                    <span class="gnb_sub_icon">
                                                        <img src="/icon/icon_noodle.png" alt="카테고리 아이콘">
                                                    </span>
                                        <span class="gnb_sub_tit">
                                                        <span class="gnb_sub_txt">국·반찬·요리</span>
                                                    </span>
                                    </a>
                                    <ul class="sub_menu">
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J55" data-subcat-end="J57"
                                               data-parent="D6">
                                                <span class="sub_sub_tit">국·탕·찌개</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J58" data-subcat-end="J59"
                                               data-parent="D6">
                                                <span class="sub_sub_tit">메인요리·밑반찬</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J60" data-subcat-end="J61"
                                               data-parent="D6">
                                                <span class="sub_sub_tit">김치·젓갈</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J62" data-subcat-end="J64"
                                               data-parent="D6">
                                                <span class="sub_sub_tit">두부·어묵·부침개</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J65" data-subcat-end="J67"
                                               data-parent="D6">
                                                <span class="sub_sub_tit">베이컨·햄·통조림</span>
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                                <li>
                                    <a class="gnb_sub_menu mcm" data-cat="D7" onclick="showCategory(this)"
                                       onmouseover="noteCategory(this)" onmouseout="removeNoteCategory(this)">
                                                    <span class="gnb_sub_icon">
                                                        <img src="/icon/icon_mealkit.png" alt="카테고리 아이콘">
                                                    </span>
                                        <span class="gnb_sub_tit">
                                                        <span class="gnb_sub_txt">밀키트</span>
                                                    </span>
                                    </a>
                                    <ul class="sub_menu">
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J68" data-subcat-end="J68"
                                               data-parent="D7">
                                                <span class="sub_sub_tit">밀키트</span>
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                                <li>
                                    <a class="gnb_sub_menu mcm" data-cat="D8" onclick="showCategory(this)"
                                       onmouseover="noteCategory(this)" onmouseout="removeNoteCategory(this)">
                                                    <span class="gnb_sub_icon">
                                                        <img src="/icon/icon_salad.png" alt="카테고리 아이콘">
                                                    </span>
                                        <span class="gnb_sub_tit">
                                                        <span class="gnb_sub_txt">간편식·샐러드</span>
                                                    </span>
                                    </a>
                                    <ul class="sub_menu">
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J69" data-subcat-end="J70"
                                               data-parent="D8">
                                                <span class="sub_sub_tit">샐러드·닭가슴살</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J71" data-subcat-end="J72"
                                               data-parent="D8">
                                                <span class="sub_sub_tit">도시락·밥류</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J73" data-subcat-end="J74"
                                               data-parent="D8">
                                                <span class="sub_sub_tit">파스타·면류</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J75" data-subcat-end="J77"
                                               data-parent="D8">
                                                <span class="sub_sub_tit">떡볶이·튀김·순대</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J78" data-subcat-end="J80"
                                               data-parent="D8">
                                                <span class="sub_sub_tit">피자·핫도그·만두</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J81" data-subcat-end="J83"
                                               data-parent="D8">
                                                <span class="sub_sub_tit">폭립·떡갈비·안주</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J84" data-subcat-end="J86"
                                               data-parent="D8">
                                                <span class="sub_sub_tit">죽·스프·카레</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J87" data-subcat-end="J88"
                                               data-parent="D8">
                                                <span class="sub_sub_tit">선식·시리얼</span>
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                                <li>
                                    <a class="gnb_sub_menu mcm" data-cat="D9" onclick="showCategory(this)"
                                       onmouseover="noteCategory(this)" onmouseout="removeNoteCategory(this)">
                                                    <span class="gnb_sub_icon">
                                                        <img src="/icon/icon_salt.png" alt="카테고리 아이콘">
                                                    </span>
                                        <span class="gnb_sub_tit">
                                                        <span class="gnb_sub_txt">양념·오일·면</span>
                                                    </span>
                                    </a>
                                    <ul class="sub_menu">
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J89" data-subcat-end="J90"
                                               data-parent="D9">
                                                <span class="sub_sub_tit">파스타·면류</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J91" data-subcat-end="J93"
                                               data-parent="D9">
                                                <span class="sub_sub_tit">식초·소스·드레싱</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J94" data-subcat-end="J96"
                                               data-parent="D9">
                                                <span class="sub_sub_tit">양념·액젓·장류</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J97" data-subcat-end="J99"
                                               data-parent="D9">
                                                <span class="sub_sub_tit">식용유·참기름·오일</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J100" data-subcat-end="J102"
                                               data-parent="D9">
                                                <span class="sub_sub_tit">소금·설탕·향신료</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J103" data-subcat-end="J105"
                                               data-parent="D9">
                                                <span class="sub_sub_tit">밀가루·가루·믹스</span>
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                                <li>
                                    <a class="gnb_sub_menu mcm" data-cat="D10" onclick="showCategory(this)"
                                       onmouseover="noteCategory(this)" onmouseout="removeNoteCategory(this)">
                                                    <span class="gnb_sub_icon">
                                                        <img src="/icon/icon_cheese.png" alt="카테고리 아이콘">
                                                    </span>
                                        <span class="gnb_sub_tit">
                                                        <span class="gnb_sub_txt">베이커리·유제품</span>
                                                    </span>
                                    </a>
                                    <ul class="sub_menu">
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J106" data-subcat-end="J107"
                                               data-parent="D10">
                                                <span class="sub_sub_tit">식빵·빵류</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J108" data-subcat-end="J110"
                                               data-parent="D10">
                                                <span class="sub_sub_tit">잼·버터·스프레드</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J111" data-subcat-end="J113"
                                               data-parent="D10">
                                                <span class="sub_sub_tit">케이크·파이·디저트</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J114" data-subcat-end="J114"
                                               data-parent="D10">
                                                <span class="sub_sub_tit">치즈</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J115" data-subcat-end="J115"
                                               data-parent="D10">
                                                <span class="sub_sub_tit">델리</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J116" data-subcat-end="J117"
                                               data-parent="D10">
                                                <span class="sub_sub_tit">올리브·피클</span>
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                                <li>
                                    <a class="gnb_sub_menu mcm" data-cat="D11" onclick="showCategory(this)"
                                       onmouseover="noteCategory(this)" onmouseout="removeNoteCategory(this)">
                                                    <span class="gnb_sub_icon">
                                                        <img src="/icon/icon_glasses.png" alt="카테고리 아이콘">
                                                    </span>
                                        <span class="gnb_sub_tit">
                                                        <span class="gnb_sub_txt">커피·음료</span>
                                                    </span>
                                    </a>
                                    <ul class="sub_menu">
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J118" data-subcat-end="J119"
                                               data-parent="D11">
                                                <span class="sub_sub_tit">생수·탄산수</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J120" data-subcat-end="J121"
                                               data-parent="D11">
                                                <span class="sub_sub_tit">음료·주스</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J122" data-subcat-end="J124"
                                               data-parent="D11">
                                                <span class="sub_sub_tit">우유·두유·요거트</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J125" data-subcat-end="J126"
                                               data-parent="D11">
                                                <span class="sub_sub_tit">커피·차</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J127" data-subcat-end="J128"
                                               data-parent="D11">
                                                <span class="sub_sub_tit">막걸리·약주</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J129" data-subcat-end="J130"
                                               data-parent="D11">
                                                <span class="sub_sub_tit">증류주·과실주</span>
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                                <li>
                                    <a class="gnb_sub_menu mcm" data-cat="D12" onclick="showCategory(this)"
                                       onmouseover="noteCategory(this)" onmouseout="removeNoteCategory(this)">
                                                    <span class="gnb_sub_icon">
                                                        <img src="/icon/icon_donut.png" alt="카테고리 아이콘">
                                                    </span>
                                        <span class="gnb_sub_tit">
                                                        <span class="gnb_sub_txt">간식·과자·떡</span>
                                                    </span>
                                    </a>
                                    <ul class="sub_menu">
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J131" data-subcat-end="J133"
                                               data-parent="D12">
                                                <span class="sub_sub_tit">과자·스낵·쿠키</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J134" data-subcat-end="J136"
                                               data-parent="D12">
                                                <span class="sub_sub_tit">초콜릿·젤리·캔디</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J137" data-subcat-end="J138"
                                               data-parent="D12">
                                                <span class="sub_sub_tit">떡·한과</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J139" data-subcat-end="J139"
                                               data-parent="D12">
                                                <span class="sub_sub_tit">아이스크림</span>
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                                <li>
                                    <a class="gnb_sub_menu mcm" data-cat="D13" onclick="showCategory(this)"
                                       onmouseover="noteCategory(this)" onmouseout="removeNoteCategory(this)">
                                                    <span class="gnb_sub_icon">
                                                        <img src="/icon/icon_gingerbreadman2.png" alt="카테고리 아이콘">
                                                    </span>
                                        <span class="gnb_sub_tit">
                                                        <span class="gnb_sub_txt">베이비·키즈</span>
                                                    </span>
                                    </a>
                                    <ul class="sub_menu">
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J140" data-subcat-end="J141"
                                               data-parent="D13">
                                                <span class="sub_sub_tit">분유·간편이유식</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J142" data-subcat-end="J142"
                                               data-parent="D13">
                                                <span class="sub_sub_tit">이유식재료</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J143" data-subcat-end="J145"
                                               data-parent="D13">
                                                <span class="sub_sub_tit">간식·음식·음료</span>
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                                <li>
                                    <a class="gnb_sub_menu mcm" data-cat="D14" onclick="showCategory(this)"
                                                                onmouseover="noteCategory(this)" onmouseout="removeNoteCategory(this)">
                                                    <span class="gnb_sub_icon">
                                                        <img src="/icon/icon_puppy.png" alt="카테고리 아이콘">
                                                    </span>
                                        <span class="gnb_sub_tit">
                                                        <span class="gnb_sub_txt">반려동물</span>
                                                    </span>
                                    </a>
                                    <ul class="sub_menu">
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J146" data-subcat-end="J146"
                                               data-parent="D14">
                                                <span class="sub_sub_tit">강아지간식</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J147" data-subcat-end="J147"
                                               data-parent="D14">
                                                <span class="sub_sub_tit">강아지주식</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J148" data-subcat-end="J148"
                                               data-parent="D14">
                                                <span class="sub_sub_tit">고양이간식</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J149" data-subcat-end="J149"
                                               data-parent="D14">
                                                <span class="sub_sub_tit">고양이주식</span>
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                                <li>
                                    <a class="gnb_sub_menu mcm" data-cat="D15" onclick="showCategory(this)"
                                       onmouseover="noteCategory(this)" onmouseout="removeNoteCategory(this)">
                                                    <span class="gnb_sub_icon">
                                                        <img src="/icon/icon_jug.png" alt="카테고리 아이콘">
                                                    </span>
                                        <span class="gnb_sub_tit">
                                                        <span class="gnb_sub_txt">건강식품</span>
                                                    </span>
                                    </a>
                                    <ul class="sub_menu">
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J150" data-subcat-end="J151"
                                               data-parent="D15">
                                                <span class="sub_sub_tit">영양제·유산균</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J152" data-subcat-end="J154"
                                               data-parent="D15">
                                                <span class="sub_sub_tit">홍삼·인삼·꿀</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J155" data-subcat-end="J156"
                                               data-parent="D15">
                                                <span class="sub_sub_tit">건강즙·건강음료</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J157" data-subcat-end="J158"
                                               data-parent="D15">
                                                <span class="sub_sub_tit">건강분말·건강환</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J159" data-subcat-end="J160"
                                               data-parent="D15">
                                                <span class="sub_sub_tit">다이어트·이너뷰티</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="sub_sub_menu msc" data-subcat-start="J161" data-subcat-end="J161"
                                               data-parent="D15">
                                                <span class="sub_sub_tit">유아동</span>
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                    </div><!--end c:gnb_allCat-->


                </div> <!--end c:gnb i:gnbArea div-->
            </div> <!--end c:headerGnbWrap div-->
        </div> <!--end i:header c:dHeader div-->
        <div class="gnb_search_section" style="display: none;">
            <div class="search_input">
                <form id="searchForm" class="searchForm" name="searchForm">
                    <input type="text" name="search_word" id="search_word" value required="required"
                           placeholder="검색어를 입력해주세요">
                    <div class="btn_search" id="btn_search"></div>
                </form>
            </div>
        </div>

        <div class="pageTop" style="display: none;">
            <a class="pageTop" href="#">맨 위로 가기</a>
        </div> <!--end c:btnTop div-->

    </div> <!--end c:allWrap div-->
</header>
<div id="main_container">
    <c:if test="${empty display}">
        <jsp:include page="main/main.jsp"/>
    </c:if>
    <c:if test="${not empty display}">
        <jsp:include page="${snbDisplay}"/>
        <jsp:include page="${display}"/>
    </c:if>
</div> <!--end i:main_container div -->


<div style="clear:both"></div>
<footer>
    <div class="dFooter footerArea">
        <div class="footerContent">
            <div class="customerCenter">
                <h3><a href="/dangjang/shop/cs/notice">당장가게 고객센터</a></h3>
                <p>
                    <strong>1588-1012</strong>
                    <span>평일</span>
                    <b>07:00 ~ 22:00</b>
                    <span>토, 일요일</span>
                    <b>09:00 ~ 18:00</b>
                </p>
            </div> <!--end c:customerCenter div-->
            <div class="githubLink">
                <a href="https://github.com/jujuchoi/DangJangShop.git" target="_blank" rel="opener">
                    <img src="/img/GitHub-Mark-64px.png"> <!--github 이미지 추가 필요-->
                </a>
            </div> <!--end c:githubLink div-->
        </div> <!--end c:footerContent div-->
        <div class="footerInfo">
            <a href="#none;" class="address_open">
                사업자 정보 확인
            </a>
            <address class="company_info" style="display: none;">
                <ul>
                    <li>조합장 : 최현주</li>
                    <li>법인명(단체명) : (주)당장조합</li>
                    <li>사업자 등록번호 : 105-62-31245</li>
                    <li>통신판매 신고번호 : 제2022 서울강남 02777호</li>
                    <li>개인정보 보호책임자 : 최영은</li>
                    <li>입점문의 : sales@dangjangsh.co.kr</li>
                    <li>제휴문의 : mkt@dangjangsh.co.kr</li>
                    <li>채용문의 : recruit@dangjangsh.co.kr</li>
                    <li>기타문의 : help@dangjangsh.co.kr</li>
                    <li>고객센터 : 1588-1012</li>
                    <li>주소 : 서울 강남구 강남대로94길 20, 삼오빌딩(5층 ~ 9층)</li>
                </ul>
            </address>
        </div> <!--end c:footerInfo div-->
        <div class="footer_bottom">
            <ul>
                <%--js로 window.open 하자--%>
                <li><a href="#none">식품안전기준</a></li>
                <li><a href="#none">이용약관</a></li>
                <li><a href="#none">개인정보취급방침</a></li>
            </ul>
            <p>Copyright © DANGJANGSHOP Corp. All Rights Reserved.</p>
        </div> <!--end c:footer_bottom div-->
    </div> <!--end c:dFooter footerArea div-->
</footer>

<!-- gnb 메뉴 관련 js -->
<script type="text/javascript" src="/js/gnb-menu.js"></script>
<script type="text/javascript" src="/js/unb-menu.js"></script>
<!-- 회원 관련 js -->
<script type="text/javascript" src="/js/login.js"></script>
<script type="text/javascript" src="/js/join.js"></script>
<script type="text/javascript" src="/js/joinForm.js"></script>
<script type="text/javascript" src="/js/joinkakao.js"></script>
<script type="text/javascript" src="/js/idSearch.js"></script>
<script type="text/javascript" src="/js/idResult.js"></script>
<script type="text/javascript" src="/js/pwdSearch.js"></script>
<script type="text/javascript" src="/js/pwdModify.js"></script>
<!-- 상품 관련 js
<script type="text/javascript" src="/js/main_product.js"></script>
<script type="text/javascript" src="/js/product_time.js"></script>
<script type="text/javascript" src="/js/newArr.js"></script>
<script type="text/javascript" src="/js/best.js"></script>
<script type="text/javascript" src="/js/categoryMain.js"></script>
<script type="text/javascript" src="/js/searchList.js"></script> -->
<script type="text/javascript" src="/js/productCommon.js"></script>

<!-- 장바구니 & 주문 관련 js
<script type="text/javascript" src="/js/cartList.js"></script> -->

<script type="text/javascript" src="/js/main_cs_list.js"></script>
<!-- 고객센터 관련 js
<script type="text/javascript" src="/js/csMain.js"></script> -->
<%--ye--%>
<script type="text/javascript" src="/js/mypageCommonjs.js"></script>
<!--footerInfo c:Info_on Event-->
<script type="text/javascript">
    // footerInfo c:Info_on Event
    let clickEventCheck = 1;

    function clickInfo(event) {
        if (clickEventCheck == 1) {
            document.querySelector(".address_open").classList.add("info_on");
            document.querySelector(".company_info").setAttribute("style", "display: block");
            clickEventCheck = 0;
        } else {
            document.querySelector(".address_open").classList.remove("info_on");
            document.querySelector(".company_info").setAttribute("style", "display: none");
            clickEventCheck = 1;
        }
    }

    document.querySelector(".address_open").addEventListener("click", clickInfo);
</script>
<!--pageTop-->
<script type="text/javascript">
    $(function () {
        $(window).scroll(function () {
            if ($(this).scrollTop() > 800) {
                // pageTop 버튼 보이기
                // $('.pageTop').fadeIn();
                $('.pageTop').slideDown(800, 'swing');
            } else {
                // pageTop 버튼 숨기기
                // $('.pageTop').fadeOut();
                $('.pageTop').slideUp(600, 'swing');
            }
        });
        $('.pageTop').click(function () {
            $('html, body').animate({
                scrollTop: 0
            }, 400);
            return false;
        });
    });

    // 가격 천 단위 콤마 정규표현식
    function priceToString(price) {
        return price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
    }
</script>
</body>