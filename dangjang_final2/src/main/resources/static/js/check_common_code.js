/* 유효성 체크 */

$(document).ready(function(){
	// 대문자 -> 소문자
	$(".text_LowerCase").on('keyup',function(){
		$(this).val($(this).val().toLowerCase());
		/*var inputVal = $(this).val();
		if (!(event.keyCode >= 37 && event.keyCode <= 40)) {
			$(this).val(inputVal.replace(/[^a-z]/gi,''));
		}*/
	});
	
	// 핸드폰 숫자만
	$(".textOnlyNum").on('keyup',function(){
		$(this).val($(this).val().toUpperCase());
		var inputVal = $(this).val();
		if((event.keyCode>64)&&(event.keyCode<91)){
			$(this).val(inputVal.replace(/[^0-9]/gi,''));
		}
	});

	// 숫자만 받음
	$(".textOnlyNum").on('blur',function(){
		$(this).val($(this).val().replace(/[^0-9]/gi,''));
	});


	// 숫자/영문만 - 편명, 여권번호
	$(".textUpperCaseNum").on('keyup',function(){
		$(this).val($(this).val().toUpperCase());

		if (!(event.keyCode >=37 && event.keyCode<=40)) {
			 var inputVal = $(this).val();
			 $(this).val(inputVal.replace(/[^a-z0-9]/gi,''));
		}
	});	

	// 고객이름 대문자로 치환 및 valid check
	$(".textUpperCase").on('keyup',function(){
		$(this).val($(this).val().toUpperCase());
		var inputVal = $(this).val();
		if (!(event.keyCode >= 37 && event.keyCode <= 40)) {
			$(this).val(inputVal.replace(/[^a-z]/gi,''));
		}
	});

	// 대문자로 변경
	$(".textUpperCase").on('blur',function(){
		$(this).val($(this).val().replace(/[^a-z]/gi,''));
	});
	
	// 대문자로 변경 (숫자도 받음)
	$(".textUpperCaseNum").on('blur',function(){
		$(this).val($(this).val().replace(/[^a-z0-9]/gi,''));
	});

	// 대문자로 치환 및 valid check
	$(".textUpperCaseEngOnly").on('keyup',function(){
		$(this).val($(this).val().toUpperCase());
		 if (!(event.keyCode >=37 && event.keyCode<=40)) {
			 var inputVal = $(this).val();
			 $(this).val(inputVal.replace(/([^가-힣\x20^a-z^A-Z\-\.,_\/])/i,''));
		 }
	});

	// 알파벳만 
	$(".onlyAlphabet").keyup(function(event){
		if (!(event.keyCode >=37 && event.keyCode<=40)) {
			var inputVal = $(this).val();
			$(this).val(inputVal.replace(/[^a-z0-9]/gi,''));
		}
	});
});



// 한글포함여부
function checkKo(txt){
	var vCnt = 0;

	for(i = 0; i < txt.length; i++)
	{
		if(txt.charCodeAt(i) >= 0 && txt.charCodeAt(i) <= 127)
		{
			// 영문 이나 숫자 타입
		} else {
			// 한글일때..
			vCnt++;
		}
	}

	if(vCnt > 0)
		return true;
	else
		return false;
}


var obj; //상품
var gubun; 
var qty ; //갯수


/**
	 * 상품 수량 증감시 금액 계산.
	 */
 function itemCalcPrc( obj, gubun, qty ) {
		
	var objTarget;
	
	if ( gubun == "L" ) {  //상품 리스트
		
		objTarget = $(obj).parents('div.info').find( '.cost' );
		
	} else if ( gubun == "V" ) {  //상품 상세
		
		objTarget = $('.prd_cost');
	}
	
	var dcFlag = objTarget.attr( 'data-dcFlag' );
	var dcRate = objTarget.attr( 'data-dcRate' );
	var dcAmt = objTarget.attr( 'data-dcAmt' );
	var iconFirst = objTarget.attr( 'data-iconFirst' );
	var firstBuyFlag = objTarget.attr( 'data-firstBuyFlag' );
	var afterCost = $("#abovelayer_optnCompntItem").find('#afterCost').val();  //판매가( 정상가 or 할인가 ) - 할인프로모션이 없는경우 정상가
	var beforeCost = $("#abovelayer_optnCompntItem").find('#beforeCost').val();  //정상가
	var beforeDcCost = objTarget.find( 'span[id="beforeCost"]' ).attr( 'data-dccost' );  //할인가(첫구매사용)
	var won = '<em>원</em>';
	var totalItemCost = '';
	var totalItemBeforeCost = '';
	var cost = 0;
	
	if ( iconFirst == '1' && firstBuyFlag == '1' ) {
		
		if ( beforeDcCost == undefined || beforeDcCost == null ) {
			beforeDcCost = beforeCost;
		}
		
		cost = ((qty-1) * parseInt( beforeDcCost, 10 )) + parseInt( afterCost, 10 );
		totalItemBeforeCost = (qty) * parseInt( beforeCost, 10 );
		
		//before 금액
		$( '#potnBeforeCost' ).show();
		$( '#potnBeforeCost' ).html( cfn_comma( Math.floor( totalItemBeforeCost ) ) + won );
		
	} else {
		
		cost = qty * parseInt( afterCost, 10 );
	}
	
	//after 금액
	$( '#potnCost' ).html( cfn_comma( Math.floor( cost ) ) + won );
}