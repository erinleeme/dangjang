<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<%--//주문한 상품 리스트
        List<OrderProductMapperDTO> orderProductList
        상품 리스트
        List<ProductMapperDTO> productList
        시리얼넘버
        List<BasicProductMapperDTO> serialNumberList

        //결제 정보
        OrdersMapperDTO orderMapperDTO = orderService.getOrderDetail(map);
        //결제 일시
        PaymentMapperDTO paymentMapperDTO = paymentService.getPaymentDetail(map);
        //배송 정보
       DeliveryMapperDTO deliveryMapperDTO

--%>
<jsp:include page="minibar.jsp"/>
<article class="mypContainer " >
    <jsp:include page="snb.jsp"/>
    <section class="mypContent flexCol">

        <section class="head_content">
            <h3>주문 상세 내역</h3>
            <span class="tit_sub01">지난 3년간 주문 내역 조회가 가능합니다.</span>
        </section>
        <article class="detail_container" id="detail_container">
            <!--
            2. 상품 정보
            - 상품 이미지
            - 상품명
            - 구매가
            - 수량
            - 배송 상태
            - 후기쓰기
            - 장바구니 담기
            - 전체 상품 다시 담기

            4. 개별 장바구니 담기를 클릭하면 수량 선택 모달창이 표시된다.
            5. 전체 상품 다시 담기를 클릭하면 구매한 수량만큼 장바구니에 담긴다.
            6. 후기 작성을 클릭하면 모달창에 제목 입력, 내용 입력, 이미지 첨부 form으로 구성된 화면이 표시된다.
            (환불 방법) -->
            <section class="head_section">
                <h3 class="head_tit">주문번호 ${orderMapperDTO.order_num}</h3>
                <span class="link">
                    문의사항이 있으신가요?
                    <a href="javascript:void(0);" onclick="javascript:myQnaDirect();">1:1 문의하기
                    </a>

                </span>
            </section>
            <form class="orderForm" name="orderProdListView">
                <ul>
                    <c:forEach items="${orderProductList}" var="item" varStatus="status">
                        <li class="list">
                            <div class="prodUnit_02">
                                <div class="thumb">
                                    <a href="javascript:void(0);">
                                            <%--onclick="javascript:showProductDetail(${item.seq_product});"--%>
                                        <div class="img">
                                            <img src="/images/${serialNumberList[status.index].serial_number}.jpg"
                                                  alt="${productList[status.index].name}">
                                        </div>
                                    </a>
                                </div>
                                <div class="pdInfo">

                                    <div class="name">
                                        <a href="javascript:void(0);">${productList[status.index].name}
                                        </a>
                                    </div>

                                    <div class="option">수량<span>${item.count}개</span>
                                    </div>
                                    <div class="delivery">
                                            ${productList[status.index].price}원<span></span>
                                    </div>
                                </div>
                            </div>
                            <div class="status">
                                <span>${item.order_status}</span>
                            </div>
                            <div class="status">
                                <a data-seq_product="${item.seq_product}"
                                   onclick="mypageAddCart(${item.seq_product})">
                                    장바구니 담기
                                </a>
                            </div>
                        </li>
                    </c:forEach>

                </ul>
            </form>
            <section class="head_section">
                <h3 class="head_tit">결제정보</h3>
            </section>
            <section class="payment_section">
                <table class="tbl_type2 tbl_right">
                    <colgroup>
                        <col style="width: 160px;">
                        <col style="width: auto;">
                    </colgroup>
                    <tbody>
                    <tr>
                        <th>상품금액</th>
                        <td>
                            <span id="orderTotalPrice">${orderMapperDTO.original_total_price}원</span>
                        </td>
                    </tr>
                    <tr>
                        <th>배송비</th>
                        <td>
                            <span id="orderDeliveryP">${orderMapperDTO.delivery_price}원</span>
                        </td>

                    </tr>
                    <tr>
                        <th>쿠폰할인</th>
                        <td>
                            <span id="orderCouponDC">-${orderMapperDTO.discount_price}원</span>
                        </td>
                    </tr>
                    <tr>
                        <th>결제금액</th>
                        <td>
                            <span id="orderFinalPrice">${orderMapperDTO.final_price}원</span>
                        </td>
                    </tr>
                    <tr>
                        <th>결제방법</th>
                        <td>
                            <span>${paymentMapperDTO.pay_method}</span>
                        </td>
                    </tr>

                    </tbody>
                </table>
            </section>

            <section class="head_section">
                <h3 class="head_tit">주문정보</h3>
            </section>
            <section class="orderDelivery">
                <table class="tbl_type2">
                    <colgroup>
                        <col style="width: 160px;">
                        <col style="width: auto;">
                    </colgroup>
                    <tbody>
                    <tr>
                        <th>주문번호</th>
                        <td>
                            <span id="orderNumber">${orderMapperDTO .order_num}</span>
                        </td>
                    </tr>
                    <tr>
                        <th>주문자명</th>
                        <td>
                            <span id="orderName">${orderMapperDTO .order_date}</span>
                        </td>
                    </tr>
                    <tr>
                        <th>결제일시</th>
                        <td>
                            <span id="orderdate">${orderMapperDTO .order_date}</span>
                        </td>
                    </tr>

                    </tbody>
                </table>
            </section>


            <section class="head_section">
                <h3 class="head_tit">배송정보</h3>
            </section>
            <section class="head_section">
                <table class="tbl_type2">
                    <colgroup>
                        <col style="width: 160px;">
                        <col style="width: auto;">
                    </colgroup>
                    <tbody>
                    <tr>
                        <th>수령인</th>
                        <td>
                            <span id="odRecipientName">${deliveryMapperDTO.recipient_name}</span>
                        </td>
                    </tr>
                    <tr>
                        <th>연락처</th>
                        <td>
                            <span id="odReciptientPhone">${deliveryMapperDTO.recipient_phone}</span>
                        </td>
                    </tr>
                    <tr>
                        <th>배송방법</th>
                        <td>
                    <span id="odParcelCompany">
                        ${deliveryMapperDTO.parcel_company}
                    </span>
                        </td>
                    </tr>
                    <tr>
                        <th>주소</th>
                        <td>
                    <span id="odAddress">
                         [${deliveryMapperDTO.zipcode}]${deliveryMapperDTO.address1} ${deliveryMapperDTO.address2}
                    </span>
                        </td>
                    </tr>
                    <tr>
                        <th>추가 입력사항</th>
                        <td>
                    <span id="odParcelDetail">
                        ${deliveryMapperDTO.parcel_details}
                    </span>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </section>
        </article>
    </section>

</article>