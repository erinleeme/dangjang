<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<article id="paymentContentsArea">
    <div class="paymentSection">
        <input type="hidden" name="orderCount" id="orderCount" value="${orderCount}">
        <input type="hidden" id="customerName" value="${name}">
        <input type="hidden" id="customerEmail" value="${email}">
        <input type="hidden" id="customerPhone" value="${phone}">
        <div class="order_step">
            <p>
                <span class="">01 장바구니</span>
                <span class="">02 배송정보</span>
                <span class="order_step_select">03 주문결제</span>
                <span>04 주문완료</span>
            </p>
        </div>
        <div class="paySummary">
            <h4>주문상품</h4>
            <div class="summary_list">
                <input type="hidden" id="orderProduct" >
                <a href="javascript:void(0)" class="summary_open">
                    접기 / 펼치기
                </a>
                <div class="summary_info">
                </div>
            </div>
            <ul></ul>
        </div>
        <form class="paymentForm" id="paymentForm">
            <div class="pay_view">
                <div class="view_left">
                    <div class="pay_coupon">
                        <div class="pay_coupon_title">
                            <h3>쿠폰</h3>
                        </div>
                        <table class="mem_coupon">
                            <tbody>
                            <tr>
                                <th>쿠폰 적용</th>
                                <td>
                                    <div class="mem_coupon_list">
                                        <select name="coupon" id="pay_coupon" onchange="chooseCoupon()">
                                            <!--value에 쿠폰명 넣기-->
                                            <!--
                                                보유하고 있는 쿠폰이 없으면
                                                사용 가능 쿠폰 0개 / 전체 0 개 보여주고 disabled 처리
                                                보유 쿠폰 있으면 사용 가능 쿠폰 수량, 전체 수량 보여주고
                                                클릭하면 리스트 보이도록
                                            -->
                                        </select>
                                    </div>
                                </td>

                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="pay_type">
                        <div class="pay_type_title">
                            <h3>결제 수단</h3>
                        </div>
                        <table class="pay_type_choose">
                            <tbody>
                            <tr>
                                <th>결제수단 선택</th>
                                <td>
                                    <div class="payment_first kakaopay" id="kakaoPayment" data-payment="kakao">
                                        <img src="/icon/payment_icon_yellow_small.png" alt="카카오페이">
                                    </div>
                                    <div class="payment_second">
                                        <p id="creditCardPayment">신용카드</p>
                                        <p id="simplePay">간편결제</p>
                                        <p id="bankPay">계좌이체</p>
                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="pay_agree">
                        <div class="pay_agree_title">
                            <h3>개인정보 수집/제공</h3>
                        </div>
                        <div class="pay_agree_chk">
                            <label>
                                <input type="radio" id="payAgree" name="payAgree" value="1">
                                <span class="pay_agree_chk_box"></span>
                                결제 진행 필수 동의
                            </label>
                            <div id="pay_agree_detail">
                                <p>개인정보 수집·이용 및 처리 동의<span>(필수)</span><a>보기 ></a></p>
                                <p>전자지급 결제대행 서비스 이용약관 동의<span>(필수)</span><a>보기 ></a></p>
                            </div>
                        </div>
                    </div>
                </div> <!--view left-->
                <div class="view_right">
                    <div class="view_right_fixed">
                        <div class="pay_delivery">
                            <input type="hidden" value="${addr}" id="orderAddress">
                            <div class="pay_delivery_title">
                                <h4>배송지</h4>
                            </div>
                            <dl>
                                <dt>
                                    새벽배송
                                </dt>
                                <dd>

                                </dd>
                            </dl>
                        </div>
                        <div class="pay_price_detail">
                            <div class="pay_price_title">
                                <h4>최종 결제금액</h4>
                            </div>
                            <dl>
                                <dt class="pay_price_product">상품금액</dt>
                                <dd>
                                    <b id="pay_price_product"></b>
                                    원
                                </dd>
                                <dt class="pay_price_discount">총 할인금액</dt>
                                <dd>
                                    <b id="pay_price_discount"></b>
                                    원
                                </dd>
                                <dt class="pay_price_coupon">쿠폰 사용금액</dt>
                                <dd>
                                    <b id="pay_price_coupon">0</b>
                                    원
                                </dd>
                                <dt class="pay_price_ship">총 배송비</dt>
                                <dd>
                                    <b id="pay_price_ship"></b>
                                    원
                                </dd>
                                <dt class="pay_price_total">총 주문금액</dt>
                                <dd>
                                    <b id="pay_price_total"></b>
                                    원
                                </dd>
                            </dl>
                        </div>

                    </div>
                </div>

            </div>
        </form>
        <div class="pay_next_btn">
            <a></a>
        </div>
        <div class="pay_notice">
            <ul class="pay_notice_list">
                <li>[배송준비중] 이전까지 주문 취소 가능합니다.</li>
                <li>미성년자가 결제 시 법정대리인이 그 거래를 취소할 수 있습니다.</li>
                <li>상품 미배송 시, 결제수단으로 환불됩니다.</li>
            </ul>
        </div>
    </div>

</article> <!--end i:customerCenter_list article-->

<script type="text/javascript" src="/js/payment.js"></script>