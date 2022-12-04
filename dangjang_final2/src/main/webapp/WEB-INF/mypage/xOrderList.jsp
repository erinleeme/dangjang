
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
    </ul>주문일자, 대표상품명, 주문상품수, 주문번호, 결제금액, 주문상태, 1:1문의
    <OrdersMapperDTO> <OrderListMapperDTO>
--%>
<c:forEach items="${orderListMapperList}" var="item">
    <li>
        <div class="date">${item.order_date}</div>
        <div class="orderGoods">
            <a class="btn_odDetail" href="javascript:void(0);"
               onclick="location.href='/dangjang/mypage/order/orderDetail?seq_order=${item.seq_order}';">

            <div class="odTit">
                    <span>${item.name}외</span>
                    <span>${item.orderItem}건</span>
                </div>
            </a>
            <div class="prodUnit">
                <div class="odInfoBox">
                    <div class="odPdImg" >
                        <img src="/images/${item.serial_number}.jpg">
                    </div>
                    <div class="odPdText">
                        <dl>
                            <dt>수령인</dt>
                            <dd>${item.recipient_name}</dd>
                        </dl>
                        <dl>
                            <dt>주문번호</dt>
                            <dd>${item.order_num}</dd>
                        </dl>
                        <dl>
                            <dt>결제금액</dt>
                            <dd>${item.final_price}원</dd>
                        </dl>
                    </div>
                </div>
                <div class="odBoxSize">
                    <span class="odStatus">${item.delivery_status}</span>
                </div>
                <div class="odBoxSize">

                    <a class="btn_ty01"
                       data-ordernum="${item.seq_order}"
                       onclick="javascript:myQnaDirect();">1:1문의</a>
                    <c:if test="${item.delivery_status == '주문접수'}">
                        <a class="btn_ty01" onclick="location.href='javascript:void(0);';"
                           data-order_num="${item.order_num}"
                           data-seq_order="${item.seq_order}">주문취소</a>
                    </c:if>
                    <c:if test="${item.delivery_status == '배송완료'}">
                        <a class="btn_ty01" onclick="location.href='/dangjang/mypage/review';">후기쓰기</a>
                    </c:if>
                </div>
            </div>
        </div>

    </li>
</c:forEach>
<c:if test="${fn:length(orderListMapperList) == 0}">
    <li class="list">
        <p>다음날 새벽 당장가게에서 신선한 상품을 받아보세요.</p>
    </li>
</c:if>
<script>
    $("#cancelPay").click(function(){
        $.ajax({
            url: "/SpringProject/kakaopay/paycancle",
            type:"post",
            //datatype:"json",
            contentType : 'application/x-www-form-urlencoded; charset = utf-8',

            data : {
                "biz_email" : 'imp_996801981532'  // 주문번호
                //"cancle_request_amount" : 2000, //환불금액
                // "reason": "테스트 결제 환불", //환불사유
                //"refund_holder": "홍길동", //[가상계좌 환불시 필수입력] 환불 가상계좌 예금주
                // "refund_bank":"88", //[가상계좌 환불시 필수입력] 환불 가상계좌 은행코드(ex Kg이니시스의 경우 신한은행 88)
                //"refund_account": "11111111" // [가상계좌 환불시 필수입력] 환불 가상계좌 번호
            },

            success:function(data){
                alert("data 불러오기 성공");
                console.log(data);

                $.ajax({ // 토큰 받아오기
                    type: "post", // POST method
                    url: "https://api.iamport.kr/users/getToken",  // import 로부터 토큰 받아오는 ajax 입니다 .
                    // headers: {"Content-Type": "application/json"},
                    // contentType: "application/json;charset=utf-8", // "Content-Type": "application/json"
                    data: {
                        'imp_key':"8026164892733224", // REST API키 똑같은데 ...
                        'imp_secret':"9ec827bfe309cbef3f52c4c260b5b33487e2ba0a1ebde162d61545763943f703da0a4005c8200ad7" // REST API Secret
                    },
                    dataType: 'json',
                    success: function(data) {
                        alert('토큰 받아오기 성공 console창 확인');
                        console.log(data);
                        console.log(data.response.access_token);
                        var token = data.response.access_token;
                        console.log(token);
                        // 결제환불 요청
                        var uid = "imp_745757715550"; // uid
                        try{
                            const getCancelData =
                                $.ajax({
                                    url: 'https://api.iamport.kr/payments/cancel',
                                    type: 'post',
                                    beforeSend: function (xhr) {
                                        xhr.setRequestHeader("Content-type","application/json");
                                        xhr.setRequestHeader("Authorization", token);

                                    },
                                    data:JSON.stringify({
                                        'reason':"testCancle", // 가맹점 클라이언트로부터 받은 환불사유
                                        'imp_uid': uid, // imp_uid를 환불 unique key로 입력
                                        //'merchant_uid':"merchant_1646470644711",
                                        'amount': "592", // 가맹점 클라이언트로부터 받은 환불금액
                                        'checksum': "592" // [권장] 환불 가능 금액 입력
                                    }),
                                    dataType: 'json',
                                    success: function(data) {
                                        console.log(uid);
                                        console.log(data);
                                    },
                                    error(error) {
                                        alert('error');
                                        console.log(error);
                                    }
                                });
                        }catch(error) {
                            alert(error);
                            console.log('catch---error');
                        }
                        // console.log(getCancleData);
                    }, // success
                    error: function(error) {
                        console.log(error);
                    } // error
                });
            },
            error: function(error) {
                alert("환불 실패");
                console.log(error);
            }
        }) // ajax
    });



</script>