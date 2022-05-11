// 가격 천 단위 콤마 정규표현식
function priceToString(price) {
    return price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
}

$(
    $.ajax({
        type: 'post',
        url: '/dangjang/shop/payment/list',
        data: 'baseStatus='+$('#orderAddress').val(),
        success: function(data){ // productList, couponList, couponName, address
            var couponList = data.couponName;
            console.log(data);
            // 주문 요약
            if(data.productList.length > 1){
                let summary_num = '<span class="summary_num">' + String(parseInt(data.productList.length) - 1) + '</span>';
                $('.paySummary .summary_info').append(data.productList[0].name + ' 외 ' + summary_num + '개 상품을 주문합니다.');

            } else {
                $('.paySummary .summary_info').text(data.productList[0].name + '을 주문합니다.');
            }
            $('#orderProduct').val(data.productList[0].name);

            // 상품 가격
            let productPrice = 0;
            let discountPrice = 0;
            let shipPrice = 0;
            let totalPrice = 0;
            $.each(data.productList, function(index, items){
                productPrice += (parseInt(items.price) * parseInt(data.productCount[index].count)) ;
                if(items.discount_price != 0){
                    discountPrice += (parseInt(items.price) - parseInt(items.discount_price)) * parseInt(data.productCount[index].count);
                }
                totalPrice = productPrice - discountPrice;
            });
            if(totalPrice < 30000){
                shipPrice = 5000;
            }
            $('#pay_price_product').text(priceToString(productPrice));
            $('#pay_price_discount').text(priceToString(discountPrice));
            $('#pay_price_ship').text(priceToString(shipPrice));
            $('#pay_price_total').text(priceToString(totalPrice));

            // 결제 버튼에 가격 추가
            $('.pay_next_btn a').text(priceToString(totalPrice)+'원 결제하기');




            // 쿠폰
            let couponCount = parseInt(data.couponList.length);
            if(couponCount == 0){
                let couponList = '<option value="info">사용 가능 쿠폰 0개 / 전체 0개</option>';
                $('.mem_coupon_list select').append(couponList);
            } else {
                let usedCount = 0;

                $.each(data.couponList, function(index, items){
                    if(items.used_date != null){
                        usedCount += 1;
                    }
                })

                let couponList = '<option value="info">사용 가능 쿠폰 ' + couponCount + '개 / 전체 ' + couponCount + '개</option>';
                $('.mem_coupon_list select').append(couponList);

                $.each(data.couponList, function(index, items){
                    if(data.couponName[index].coupon_price > totalPrice){
                        couponList = '<option value="' + items.seq_coupon + '" data-price="' + data.couponName[index].coupon_price + '" disabled>'
                            + data.couponName[index].coupon_name + ' / ' + priceToString(data.couponName[index].coupon_price) + '</option>';
                    } else {
                        couponList = '<option value="' + items.seq_coupon + '" data-price="' + data.couponName[index].coupon_price + '">'
                            + data.couponName[index].coupon_name + ' / ' + priceToString(data.couponName[index].coupon_price) + '</option>';
                    }


                    $('.mem_coupon_list select').append(couponList);
                })
            }
            // 배송지
            let address = '<strong>' + data.address.receptionName + '</strong>';
            address += '<span>[' + data.address.zipcode + '] ' + data.address.address1 + ', ' + data.address.address2 + '</span>'
            $('.pay_delivery dl dd').append(address);



        },
        error: function(err){
            console.log(err);
        }
    })
)
onlyPrice = /[^0-9]/g;
function chooseCoupon(){

    // 원복
    let couponPriceAll = $('#pay_price_coupon').text();
    let couponPrice = parseInt(couponPriceAll.replace(onlyPrice, ""));
    let totalPriceAll = $('#pay_price_total').text();
    let totalPrice = parseInt(totalPriceAll.replace(onlyPrice, ""));
    totalPrice += couponPrice;

    var seq_coupon = $("#pay_coupon option:selected").val();
    var dataPrice = $("#pay_coupon option:selected").attr('data-price');
    console.log(seq_coupon);
    console.log(dataPrice);

    if(seq_coupon != 'info'){
        $('#pay_price_coupon').text(priceToString(dataPrice));
        totalPrice -= parseInt(dataPrice);
        $('#pay_price_total').text(priceToString(totalPrice));
        $('.pay_next_btn a').text(priceToString(totalPrice)+'원 결제하기');
    } else {
        // 쿠폰 선택 해지일 경우
        $('#pay_price_coupon').text('0');
        $('#pay_price_total').text(priceToString(totalPrice));
        $('.pay_next_btn a').text(priceToString(totalPrice)+'원 결제하기');
    }
}

$('.pay_next_btn').click(function(){
   if($('#payAgree').is(':checked') == false){
       alert('필수 동의를 확인해주세요.')
   } else{
       var IMP = window.IMP;
       let price = $('#pay_price_total').text();
       let payPrice = parseInt(price.replace(onlyPrice, ""));
       IMP.init('imp74293802'); // 가맹점 식별코드
       IMP.request_pay({
           pg: 'html5_inicis',
           merchant_uid: 'merchant_' + $('#orderCount').val() + 5015, //new Date().getTime(), // merchant_uid 의 경우 http://docs.iamport.kr/implementation/payment 에 가면 방법이 있음
           name: $('#orderProduct').val(),
           amount: '100', // payPrice,
           buyer_email: $('#customerEmail').val(),
           buyer_name: $('#customerName').val(),
           buyer_tel: $('#customerPhone').val(),
       }, function(rsp) {
           console.log(rsp);
           if(rsp.success) {
               let seq_coupon = $("#pay_coupon option:selected").val();
               let o_price = $('#pay_price_product').text();
               let originalPrice = parseInt(o_price.replace(onlyPrice, ""));
               let d_price = $('#pay_price_discount').text();
               let discountPrice = parseInt(d_price.replace(onlyPrice, ""));
               var msg = '결제가 완료되었습니다.';
               msg += '결제금액 : ' + rsp.paid_amount;
               var result = {
                   "imp_uid" : rsp.imp_uid,
                   "merchant_uid" : rsp.merchant_uid,
                   "biz_email" : rsp.buyer_email,
                   "pay_date" : new Date().getTime(),
                   "amount" : rsp.paid_amount,
                   "card_no" : rsp.apply_num,
                   "refund" : 'payed' ,
                   "seq_coupon" : seq_coupon,
                   "originalPrice" : originalPrice,
                   "discountPrice" : discountPrice
               }; // 이게 import 결제 api 짠거입니당

               // 결제 성공시 ajax     // SpringProject/kakaopay/paysuccess
               $.ajax({
                   url : '/dangjang/shop/payment/ok',
                   type :'POST',
                   data : result,
                   /*JSON.stringify(result,
                   ['imp_uid', 'merchant_uid', 'biz_email',
                    'pay_date', 'amount', 'card_no', 'refund',
                    'seq_coupon', 'originalPrice', 'discountPrice']) */
                   dataType: 'text', //서버에서 보내줄 데이터 타입
                   success: function(data) { // 다음 문제로 가시쥬
                       location.href="/dangjang/shop/order"
                       // alert('서버 와따리 가따리 성공');
                   },
                   error: function(error) {
                       alert('결제에 실패하였습니다.');
                       console.log(error);
                   }
               });
           } else {
               var msg = '결제에 실패하였습니다.';
               msg += '실패 사유 : ' + rsp.eroor_msg;
           }
           alert(msg);
       }); // 여기에 이제 결제 환불을 넣어보려고 하는데 결제 환불시 필요한게 뭐엿더라 .. 토큰 이 필요한데 그 토큰을 불러올때부터 cors 오류가 남...쒸볼@@.. // 8시간의 사투끝에 토큰은 받아왔는디 ...
   }
});