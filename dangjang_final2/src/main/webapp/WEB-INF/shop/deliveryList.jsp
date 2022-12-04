<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="shipSection">
    <div class="order_step">
        <p>
            <span class="">01 장바구니</span>
            <span class="order_step_select">02 배송정보</span>
            <span>03 주문결제</span>
            <span>04 주문완료</span>
        </p>
    </div>
    <div class="orderSummary">
        <h4>주문상품</h4>
        <div class="summary_list">
            <a href="javascript:void(0)" class="summary_open">
                접기 / 펼치기
            </a>
            <div class="summary_info">
            </div>
        </div>
        <ul></ul>
    </div>
    <form class="shipForm" id="shipForm">
        <div class="ship_view">
            <div>
                <h4>주문자 정보</h4>
                <div class="orderer_section">
                    <table class="orderinfo_table">
                        <tr class="table_1st">
                            <th>보내는 분</th>
                            <td id="delivery_mem_name">
                                <span>${orderer_name}</span>
                                <input type="hidden" name="orderer_name" value="${orderer_name}">
                            </td>
                        </tr>
                        <tr>
                            <th>휴대폰</th>
                            <td id="delivery_mem_phone">
                                <span>${orderer_phone}</span>
                                <input type="hidden" name="orderer_phone" value="${orderer_phone}">
                            </td>
                        </tr>
                        <tr>
                            <th>이메일</th>
                            <td id="delivery_mem_email">
                                <span>${orderer_email}</span>
                                <input type="hidden" name="orderer_email" value="${orderer_email}">
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
            <div>
                <h4>배송 정보</h4>
                <a class="s_address_list" id="s_address_list">배송지 목록</a>
                <div style="clear:both"></div>
                <div class="address_section">
                    <table class="orderinfo_table">
                        <input type="hidden" name="base-status" id="baseStatusNum">
                        <tr class="table_1st">
                            <th>배송지</th>
                            <td>
                                <p class="default_addr">기본배송지</p>
                                <p class="default_addr_1"></p>
                                <p class="default_addr_2"></p>
                            </td>
                        </tr>
                        <tr class="table_2nd">
                            <th>상세정보</th>
                            <td>

                            </td>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="deliveryTypePart">
                <h4>배송방법 선택</h4>
                <div style="clear:both"></div>
                <div class="deliveryType_section">
                    <div class="deliveryType_choose">
                        <label>
                            <input type="radio" id="delivery_early" name="새벽배송" value="새벽배송">
                            <span class="deliveryType_chk_box"></span>
                            새벽배송
                        </label>

                    </div>
                    <div class="delivery_door_pwd">
                        <label>
                            <input type="radio" name="doorPwd" value="비밀번호" id="deliveryType1" checked>
                            <span class="deliveryType_chk_box2"></span>
                            비밀번호
                        </label>
                        <label>
                            <input type="radio" name="doorPwd" value="자유출입" id="deliveryType2">
                            <span class="deliveryType_chk_box2"></span>
                            자유출입
                        </label>
                        <label>
                            <input type="radio" name="doorPwd" value="기타" id="deliveryType3">
                            <span class="deliveryType_chk_box2"></span>
                            기타
                        </label>
                        <div>
                            <input type="text" name="deliveryPwd" id="deliveryPwd" placeholder="예시) #누르고 1234*">
                        </div>
                        <p>특수문자를 포함한 상세패턴 및 정확한 비밀번호를 입력해주세요</p>
                    </div>
                </div>
            </div>
            <div class="deliveryOption">
                <h4>배송 요청사항</h4>
                <div class="address_section">
                    <table class="orderinfo_table">
                        <tr class="table_1st">
                            <th>배송 메시지</th>
                            <td>
                                <div>
                                    <select id="selectDeliveryMessage">
                                        <option value="direct">직접입력</option>
                                        <option>부재시, 새벽이라도 괜찮으니 전화 연락 바랍니다.</option>
                                        <option>부재시, 새벽이라도 괜찮으니 세대 호출 바랍니다.</option>
                                        <option>부재시, 무인 택배함 보관 후 연락바랍니다.</option>
                                        <option>부재시, 경비실에 맡겨주세요.</option>
                                    </select>
                                </div>
                                <div>
                                    <input type="text" name="writeDeliveryMessage" id="writeDeliveryMessage">
                                </div>
                                <p>새벽배송의 경우 비밀번호 불일치, 경비원 부재와 같은 특이건 발생 시 꼭 배송 요청사항을 선택 부탁드립니다.</p>
                            </td>
                        </tr>
                    </table>
                </div>
            </div> <!--end deliveryOption -->
        </div>
    </form>
    <div class="order_next_btn">
        <a>주문서 작성 완료</a>
    </div>
</div>
<div class="j_modal_background"></div>
<div class="j_modal deliveryAddrListModal" id="j_deliveryList_modal">
    <div class="j_modal_body deliveryAddrListBodyModal">
        <div id="deliveryList_title">
            <h4>배송지 목록</h4>
        </div>
        <span id="deliveryList_close_btn">X</span>
        <div class="de_list">
        </div>
        <div id="de_list_plus_btn">
            <button type="button" id="de_list_plus">추가</button>
        </div>
    </div>
</div>
<script type="text/javascript" src="/js/deliveryList.js"></script>