<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- <button id="kakaopay">카카오페이</button> -->
	<button id="paytest">paytest</button>
	<button id="cancelPay">환불하기</button>
	
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script><!-- jQuery CDN --->
	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script type="text/javascript">
  
/* $(function() {
	$('#kakaopay').click(function() {
		$.ajax({
			url:'/SpringProject/kakaopay/pay',
			datatype:'json',
			success:function(data) {
				console.log(data);
				console.log(JSON.parse(data).tid);
				var box = JSON.parse(data).next_redirect_pc_url;
				window.open(box);
			},
			
			error:function(error) {
				alert("error.....");
			    alert(error);
			}
		});
	});
});
 */
$('#paytest').click(function() {
	var IMP = window.IMP;
	IMP.init('imp74293802'); // 가맹점 식별코드
	IMP.request_pay({
		pg: 'html5_inicis',
		pay_method: 'card',
		merchant_uid: 'merchant_' + 000002, //new Date().getTime(), // merchant_uid 의 경우 http://docs.iamport.kr/implementation/payment 에 가면 방법이 있음
		name: '꼬북이',
		amount: '592',
		buyer_email: 'illgyu9189@gamil.com',
		buyer_name: '전일규',
		buyer_tel: '010-9276-3494',
		buyer_addr: '인천광역시 계양구 계산동',
		buyer_postcode: '456-789',
	}, function(rsp) {
		console.log(rsp);
		if(rsp.success) {
			var msg = '결제가 완료되었습니다.';
			msg += '결제금액 : ' + rsp.paid_amount;
			var result = {
                    "imp_uid" : rsp.imp_uid,
                    "merchant_uid" : rsp.merchant_uid,
                    "biz_email" : rsp.buyer_email,
                    "pay_date" : new Date().getTime(),
                    "amount" : rsp.paid_amount,
                    "card_no" : rsp.apply_num,
                    "refund" : 'payed'
                    }; // 이게 import 결제 api 짠거입니당
			// 결제 성고시 ajax     // SpringProject/kakaopay/paysuccess
			$.ajax({
                        url : '/SpringProject/kakaopay/paysuccess', 
                        type :'POST',
                        data : JSON.stringify(result,
                                ['imp_uid', 'merchant_uid', 'biz_email', 
                                    'pay_date', 'amount', 'card_no', 'refund']),
                        
                        dataType: 'text', //서버에서 보내줄 데이터 타입 
			 success: function(data) { // 다음 문제로 가시쥬
				
					alert('서버 와따리 가따리 성공');
			},
			error: function(error) {
				alert('ajax 실패...........');
				console.log(error);
			} 
		});
		} else {
			var msg = '결제에 실패하였습니다.';
			msg += '실패 사유 : ' + rsp.eroor_msg;
		}
		alert(msg);
	}); // 여기에 이제 결제 환불을 넣어보려고 하는데 결제 환불시 필요한게 뭐엿더라 .. 토큰 이 필요한데 그 토큰을 불러올때부터 cors 오류가 남...쒸볼@@.. // 8시간의 사투끝에 토큰은 받아왔는디 ... 
	
});

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
</body>
</html>