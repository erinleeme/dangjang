<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="cartSection">
    <div class="order_step">
        <p>
            <span class="order_step_select">01 장바구니</span>
            <span>02 배송정보</span>
            <span>03 주문결제</span>
            <span>04 주문완료</span>
        </p>
    </div>
    <div class="cart_list">
        <div class="cart_select">
            <label class="cart_sel_check_all">
            </label>
            <a class="cart_del" style="cursor: pointer">
                선택삭제 <!--클릭하면 장바구니에 있는 product 삭제됨-->
            </a>
            <a class="cart_soldout_del" style="cursor: pointer">
                품절상품 삭제 <!--클릭하면 장바구니에 있는 product 삭제됨-->
            </a>
        </div>
        <div id="cartProductList">
            <div class="cartBox cart_cold">
                <div class="cart_tit">
                    <h4>
                    <span class="cart_inner_tit">
                        <span class="state_ico"></span>
                        냉장 상품
                    </span>
                    </h4>
                    <button type="button" class="cart_btn_dropup on">
                        접기 / 펼치기
                    </button>
                </div>
                <ul>

                </ul>
            </div>
            <div class="cartBox cart_frozen">
                <div class="cart_tit">
                    <h4>
                    <span class="cart_inner_tit">
                        <span class="state_ico"></span>
                        냉동 상품
                    </span>
                    </h4>
                    <button type="button" class="cart_btn_dropup on">
                        접기 / 펼치기
                    </button>
                </div>
                <ul>

                </ul>
            </div>
            <div class="cartBox cart_room">
                <div class="cart_tit">
                    <h4>
                    <span class="cart_inner_tit">
                        <span class="state_ico"></span>
                        상온 상품
                    </span>
                    </h4>
                    <button type="button" class="cart_btn_dropup on">
                        접기 / 펼치기
                    </button>
                </div>
                <ul>

                </ul>
            </div>
        </div>

    </div>
    <div class="cart_price">
            <span class="tol_o_price c_p">
                <span>총 상품금액</span>
                <b id="totalPrice"></b>원
            </span>
        <span class="price_operator">-</span>
        <span class="tol_d_price c_p">
                <span>총 할인금액</span>
                <b id="discountPrice"></b>원
            </span>
        <span class="price_operator">+</span>
        <span class="tol_s_price c_p">
                <span>총 배송비</span>
                <b id="shipPrice"></b>원
            </span>
        <span class="price_operator">=</span>
        <span class="tol_pay_price c_p">
                <span>총 주문금액</span>
                <b id="payPrice"></b>원
            </span>
    </div>
    <div class="cart_btn">
        <a href="/dangjang/shop/main">계속 쇼핑하기</a>
        <a href="/dangjang/shop/delivery">주문하기</a>
    </div>
</div>

<script type="text/javascript" src="/js/cartList.js"></script>