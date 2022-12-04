<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="productDetail">
    <input type="hidden" name="productDetail_categoryCode" id="productDetail_categoryCode"
           value="${productDetail_categoryCode}">
    <input type="hidden" name="productDetail_subCategoryCode" id="productDetail_subCategoryCode"
           value="${productDetail_subCategoryCode}">
    <input type="hidden" name="productDetail_seqProduct" id="productDetail_seqProduct" value="${seq_product}">
    <div class="currentPath">

    </div>
    <div class="detailTopInfo">
        <div class="detailInfo_inner">
            <div class="imgsArea">
                <div class="detail_imgWrap">

                </div>
                <div class="starShare">
                    <div class="detailStar">
                    </div>
                    <div class="itemShare">
                        <a href="#none">공유하기</a> <!--링크 복붙 api-->
                    </div>
                </div>
                <div class="togetherBuy">
                    <!--3개 고정으로 보여주기 / 이전, 다음 선택 없당-->
                    <h4>카테고리 구매 베스트</h4>
                    <div class="contBox">
                        <div class="cont_item">

                        </div>
                    </div>
                </div>
            </div>
            <div class="textArea">
                <div class="textSubject">
                    <!--<p>1년 중 오직 지금만 맛 볼 수 있는 달콤한 산딸기</p>-->
                </div>
                <div class="textContents">
                    <dl>
                        <div class="detail_price">

                        </div>
                        <div class="detail_normal">
                            <dt>원산지</dt>
                            <dd>국내산</dd>
                            <dt>보관방법</dt>
                            <dd class="detail_state"></dd>
                            <dt>배송구분</dt>
                            <dd>새벽배송</dd>
                            <dt>배송비 정책</dt>
                            <dd>5,000원 (30,000원 이상 무료)</dd>
                        </div>
                        <div class="detail_number">
                            <dt>구매수량</dt>
                            <dd>
                                <div class="item_detail_count">
                                    <button type="button" class="item_minus" onclick="countMinus(this)">감소</button>
                                    <input type="type" class="item_num stepperCounter" readonly value="1">
                                    <button type="button" class="item_plus" onclick="countPlus(this)">증가</button>
                                </div>
                            </dd>
                        </div>
                    </dl>
                    <div class="detail_order_total_price">
                        <strong>총 상품금액 : </strong>
                        <span class="detail_sum">
                                <span class="detail_num"></span>
                                <span class="detail_won">원</span>
                            </span>
                    </div>
                    <div class="cart_footer">
                        <c:if test="${memId == null}">
                            <div class="cart_functions">
                                <button type="button" class="pick_icon_btn"
                                        onclick="location.href='/dangjang/shop/member/login'">찜하기 버튼
                                </button>
                                <button type="button" disabled class="alarm_icon_btn">재입고 알림</button>
                            </div>
                            <div>
                                <button type="button" class="inCart_btn"
                                        onclick="location.href='/dangjang/shop/member/login'">장바구니 담기
                                </button>
                            </div>
                        </c:if>
                        <c:if test="${memId != null}">
                            <div class="cart_functions">
                                <button type="button" class="pick_icon_btn" onclick="productDetailPick()">찜하기 버튼
                                </button>
                                <button type="button" disabled class="alarm_icon_btn">재입고 알림</button>
                            </div>
                            <div>
                                <button type="button" class="inCart_btn">장바구니 담기</button>
                            </div>
                        </c:if>

                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="detail_TabCon">
        <div class="pViewTab">
            <ul class="tabList">
                <li data-idx="1" class="tab_on">
                    <a href="#product_info" data-tab="1">상품정보</a>
                </li>
                <li data-idx="2">
                    <a href="#product_detailInfo" data-tab="2">상품상세정보</a>
                </li>
                <li data-idx="3">
                    <a href="#product_reviewSection" data-tab="3">후기
                        <span class="productReviewTotal"></span>
                    </a>
                </li>
                <li data-idx="4">
                    <a href="#product_qnaSection" data-tab="4">문의
                        <span class="productQnaTotal"></span>
                    </a>

                </li>
            </ul>
        </div>
        <div class="detail_productInfo">
            <a name="product_info"></a>
            <div>
                <img class="pdImg" src="/pdImg/D12J131N22306_롯데 꼬깔콘고소한맛_01.jpg">
                <img class="pdImg" src="/pdImg/D12J131N22306_롯데 꼬깔콘고소한맛_02.jpg">
                <img class="pdImg" src="/pdImg/D12J131N22306_롯데 꼬깔콘고소한맛_03.jpg">
                <img class="pdImg" src="/pdImg/D12J131N22306_롯데 꼬깔콘고소한맛_04.jpg">
                <img class="pdImg" src="/pdImg/D12J131N22306_롯데 꼬깔콘고소한맛_05.jpg">
            </div>
        </div>
        <div class="detail_productDetailInfo">
            <a name="product_detailInfo"></a>
            <div id="goods_detail_img">
                <!--상세 이미지 있을 경우 추가-->
                <img id="pdImg" src="/pdImg/D12J131N22306_롯데 꼬깔콘고소한맛_06.jpg">
            </div>
            <!--
            <table width="100%" border="0" cellpadding="1" class="extra_info">
                <tbody>
                <tr>
                    <th>상품명</th>
                    <td>국내산 산딸기</td>
                </tr>
                <tr>
                    <th>용량/수량</th>
                    <td>100g</td>
                </tr>
                <tr>
                    <th>제조년월일/품질유지기한</th>
                    <td>수령 후 7일</td>
                </tr>
                <tr>
                    <th>원재료 및 함량</th>
                    <td></td>
                </tr>
                <tr>
                    <th>보관/취급방법</th>
                    <td>상온보관</td>
                </tr>
                <tr>
                    <th>소비자상담문의</th>
                    <td>고객센터 1588-1012</td>
                </tr>
                </tbody>
            </table>
            -->
        </div>
        <div class="product_reviewSection">
            <a name="product_reviewSection"></a>
            <div class="reviewBoard">
                <form name="reviewBoardForm">
                    <input type="hidden" name="reviewPg" value="${reviewPg}">
                    <input type="hidden" name="reviewListType" value="${reviewListType}">
                    <div class="reviewBoardTitle">
                        <h4>상품 후기</h4>
                        <p>상품에 대한 후기를 남기는 공간입니다. 해당 게시판의 성격과 다른 글은 사전동의 없이 담당 게시판으로 이동될 수 있습니다.</p>
                        <p>배송관련, 주문(취소/교환/환불)관련 문의 및 요청사항은 당장가게 내 <a>1:1문의</a>에 남겨주세요.</p>
                    </div>
                    <div class="reviewBoardCount">
                        <span class="totalReview">전체(<span class="totalReviewCount"></span>)</span>
                    </div>
                    <table class="reviewBoardTable" border="0" cellpadding="0" cellspacing="0">
                        <colgroup>
                            <col width="100">
                            <col width="100">
                            <col width="*">
                            <col width="100">
                            <col width="125">
                        </colgroup>
                        <thead>
                        <tr>
                            <th>번호</th>
                            <th>만족도</th>
                            <th>구매후기</th>
                            <th>작성자</th>
                            <th>작성일</th>
                        </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
                    <div id="productDetail_write_review_btn">
                    <c:if test="${memId == null}">
                            <span onclick="location.href='/dangjang/shop/login'">후기작성</span>
                    </c:if>
                    <c:if test="${memId =! null}">
                            <span onclick="location.href='/dangjang/mypage/review'">후기작성</span>
                    </c:if>
                    </div>
                    <!-- 페이징 -->
                    <div class="layout_paging">
                        <div class="pagingDiv">
                        </div>
                    </div> <!--end c:layout_paging div-->
                </form>
            </div>
        </div>
        <div class="product_qnaSection">
            <a name="product_qnaSection"></a>
            <div class="qnaBoard">
                <form name="qnaBoardForm">
                    <input type="hidden" name="qnaPg" value="${qnaPg}">
                    <div class="qnaBoardTitle">
                        <h4>상품 문의</h4>
                        <p>상품에 대한 문의를 남기는 공간입니다. 해당 게시판의 성격과 다른 글은 사전동의 없이 담당 게시판으로 이동될 수 있습니다.</p>
                        <p>가격, 판매자, 교환/환불 관련 문의 및 요청사항은 당장가게 내 <a>1:1문의</a>에 남겨주세요.</p>
                        <p>고객센터 답변가능시간: 평일 07:00 ~ 22:00 토,일요일 09:00 ~ 18~00</p>
                    </div>
                    <table class="qnaBoardTable" border="0" cellpadding="0" cellspacing="0">
                        <colgroup>
                            <col width="100">
                            <col width="100">
                            <col width="*">
                            <col width="100">
                            <col width="125">
                        </colgroup>
                        <thead>
                        <tr>
                            <th>문의유형</th>
                            <th>답변상태</th>
                            <th>제목</th>
                            <th>문의자</th>
                            <th>등록일</th>
                        </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
                    <div id="productDetail_write_qna_btn">
                    <c:if test="${memId == null}">
                            <span onclick="location.href='/dangjang/shop/login'">문의작성</span>
                    </c:if>
                    <c:if test="${memId =! null}">
                        <span onclick="location.href='/dangjang/mypage/qna'">문의작성</span>
                    </c:if>
                    </div>
                    <!-- 페이징 -->
                    <div class="layout_paging">
                        <div class="pagingDiv">
                        </div>
                    </div> <!--end c:layout_paging div-->
                </form>
            </div>
        </div>
    </div>
</div>

<div id="cart_modal_background"></div>
<div id="cart_modal">
    <div id="cart_save_modal">
        <div id="cart_save_modal_title">
            <h4>장바구니에 상품이 담겼습니다.</h4>
        </div>
        <span id="cart_save_modal_close">X</span>
        <div id="cart_save_modal_btn">
            장바구니 바로가기
        </div>
    </div>
</div>

<script type="text/javascript" src="/js/productDetail.js"></script>
<script type="text/javascript" src="/js/productDetailReview.js"></script>
<script type="text/javascript" src="/js/productDetailQnA.js"></script>