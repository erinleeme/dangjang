$(
    $.ajax({
        type: 'post',
        url: '/dangjang/shop/delivery/list',
        success: function(data){ // addressList, member, orderProductList, orderProductImageList, orderProductCount
            // 비우기
            $('.de_list').empty();
            // 주문 요약
            if(data.orderProductList.length > 1){
                let summary_num = '<span class="summary_num">' + String(parseInt(data.orderProductList.length) - 1) + '</span>';
                $('.orderSummary .summary_info').append(data.orderProductList[0].name + ' 외 ' + summary_num + '개 상품을 주문합니다.');

            } else {
                $('.orderSummary .summary_info').text(data.orderProductList[0].name + '을 주문합니다.');
            }

            // 배송지
            for(let i = 0; i < data.addressList.length; i++){
                // 기본 배송지
                if (data.addressList[i].base_status == 1) {
                    $('.default_addr_1').text(data.addressList[i].address1);
                    $('.default_addr_2').text(data.addressList[i].address2);
                    let recipient = '<p>' + data.addressList[i].recipient + ', ' + data.addressList[i].recipient_phone + '</p>'
                    $('.table_2nd td').append(recipient);
                    $('#baseStatusNum').val(data.addressList[i].base_status);
                }

                // 배송지 목록
                if (data.addressList[i].base_status == 1) {
                    let de_list_detail = '<div class="de_list_detail" id="de_list_' + i + '" onclick="selectDeliveryList(this)" data-base="' + data.addressList[i].base_status + '">';
                    de_list_detail += '<p class="de_list_Recipient">기본배송지 | '+ data.addressList[i].receptionName + '</p>';
                    de_list_detail += '<p class="de_list_addr1">' + data.addressList[i].address1 + '</p>';
                    de_list_detail += '<p class="de_list_addr2">' + data.addressList[i].address2 + '</p>';
                    de_list_detail += '<span class="de_list_receptionName">' + data.addressList[i].recipient + ', </span>';
                    de_list_detail += '<span class="de_list_recipient_phone">' + data.addressList[i].recipient_phone + '</span>';
                    de_list_detail += '</div>';
                    $('.de_list').append(de_list_detail);
                } else {
                    let de_list_detail = '<div class="de_list_detail" id="de_list_' + i + '" onclick="selectDeliveryList(this)" data-base="' + data.addressList[i].base_status + '">';
                    de_list_detail += '<p class="de_list_Recipient">' + data.addressList[i].receptionName + '</p>';
                    de_list_detail += '<p class="de_list_addr1">' + data.addressList[i].address1 + '</p>';
                    de_list_detail += '<p class="de_list_addr2">' + data.addressList[i].address2 + '</p>';
                    de_list_detail += '<span class="de_list_receptionName">' + data.addressList[i].recipient + ', </span>';
                    de_list_detail += '<span class="de_list_recipient_phone">' + data.addressList[i].recipient_phone + '</span>';
                    de_list_detail += '</div>';
                    $('.de_list').append(de_list_detail);
                }
            }

        },
        error: function(err){
            console.log(err);
        }
    })
)
const modalDelivery = document.querySelector('.deliveryAddrListModal');
const modalBg = document.querySelector('.j_modal_background');
$('#s_address_list').click(function(){
    modalDelivery.style.display = 'block';
    modalBg.style.display = 'block';
})

// modal 닫기
$('#deliveryList_close_btn').click(function(){
    if($('#de_list_add').hasClass('beforeSave') && $('#de_list_add_zipcode').val() != ''){
        alert('배송지 목록 추가를 마무리해주세요.');
    } else {
        modalDelivery.style.display = 'none';
        modalBg.style.display = 'none';
    }
});

window.addEventListener("keyup", e => {
    if(modalDelivery.style.display == 'block' && e.key == "Escape"){
        if($('#de_list_add').hasClass('beforeSave') && $('#de_list_add_zipcode').val() != ''){
            alert('배송지 목록 추가를 마무리해주세요.');
        } else {
            modalDelivery.style.display = 'none';
            modalBg.style.display = 'none';
        }
    }
});
// 배송 목록 클릭
function selectDeliveryList (element){
    let Recipient = $(element).children().eq(0).text();
    let addr1 = $(element).children().eq(1).text();
    let addr2 = $(element).children().eq(2).text();
    let receptionName = $(element).children().eq(3).text();
    let recipient_phone = $(element).children().eq(4).text();
    if($(element).first().attr('data-base') == 1){
        $('.default_addr').text('기본배송지');
    } else {
        $('.default_addr').text(Recipient);
    }
    $('.default_addr_1').text(addr1);
    $('.default_addr_2').text(addr2);
    let reci = '<p>' + receptionName + recipient_phone + '</p>';
    $('.table_2nd td').empty();
    $('.table_2nd td').append(reci);
    $('#baseStatusNum').val($(element).first().attr('data-base'));
    modalDelivery.style.display = 'none';
    modalBg.style.display = 'none';
}
// 배송 목록 추가 클릭
$('#de_list_plus').click(function(){
    let de_list_detail = '<div class="de_list_detail beforeSave" id="de_list_add">';
        de_list_detail += '<input type="hidden" id="de_list_add_zipcode">';
        de_list_detail += '<input type="hidden" id="de_list_add_addr1">';
        de_list_detail += '<p class="de_list_Recipient" style="display: none"></p>';
        de_list_detail += '<p>배송지명';
        de_list_detail += '<input type="text" id="de_list_add_Recipient" minlength="1" maxlength="10">';
        de_list_detail += '</p>';
        de_list_detail += '<p class="de_list_addr1"></p>';
        de_list_detail += '<p>상세주소';
        de_list_detail += '<input type="text" id="de_list_add_addr2">';
        de_list_detail += '</p>';
        de_list_detail += '<p class="de_list_addr2"></p>';
        de_list_detail += '<span class="de_list_receptionName"></span>';
        de_list_detail += '<p>수령인';
        de_list_detail += '<input type="text" id="de_list_add_receptionName">';
        de_list_detail += '</p>';
        de_list_detail += '<span class="de_list_recipient_phone"></span>';
        de_list_detail += '<p>연락처';
        de_list_detail += '<input type="text" id="de_list_add_recipient_phone" pattern="[0-9]{11}">';
        de_list_detail += '</p>';
        de_list_detail += '</div>';
        de_list_detail += '<div id="de_list_add_btn">';
        de_list_detail += '<a id="de_list_add_cancel" onclick="deListAddCancel(this)">취소</a>';
        de_list_detail += '<a id="de_list_add_save" onclick="deListAddSave(this)">저장</a>';
        de_list_detail += '</div>';
    $('.de_list').append(de_list_detail);

    new daum.Postcode({
        oncomplete: function(data) {
            var addr = '';
            if (data.userSelectedType === 'R') {
                addr = data.roadAddress;
            } else {
                addr = data.jibunAddress;
            }
            if(data.userSelectedType === 'R'){
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                }
                if(data.buildingName !== '' && data.apartment === 'Y'){
                }
            } else {
            }
            document.querySelector('#de_list_add #de_list_add_zipcode').value = data.zonecode;
            document.querySelector("#de_list_add #de_list_add_addr1").value = addr;
            document.querySelector('#de_list_add .de_list_addr1').innerText = addr;
            if($('#de_list_add_addr1').val() != ''){
                document.querySelector('#de_list_add').style.display = 'block';
                document.querySelector('#de_list_add_btn').style.display = 'block';
            }

        }
    }).open();
});

// 저장 버튼
function deListAddSave(element){
    if($('#de_list_add_Recipient').val() == ''){
        alert('배송지명을 입력해주세요.');
    } else if($('#de_list_add_addr2').val() == ''){
        alert('상세 주소를 입력해주세요.');
    } else if($('#de_list_add_receptionName').val() == ''){
        alert('수령인 이름을 입력해주세요.');
    } else if($('#de_list_add_recipient_phone').val() == ''){
        alert('연락처를 입력해주세요.');
    } else {
        // db
        $.ajax({
            type: 'post',
            url: '/dangjang/shop/address/add',
            data: {
                'zipcode': $('#de_list_add_zipcode').val(),
                'address1': $('#de_list_add_addr1').val(),
                'address2': $('#de_list_add_addr2').val(),
                'recipient': $('#de_list_add_Recipient').val(),
                'receptionName': $('#de_list_add_receptionName').val(),
                'recipient_phone': $('#de_list_add_recipient_phone').val()
            },
            success: function(data){
                console.log(data)
                let plus_baseStatus = data;
                document.querySelector('#de_list_add').setAttribute('data-base', plus_baseStatus);
                document.querySelector('#de_list_add').setAttribute("onclick", 'selectDeliveryList(this)');
            },
            error: function (err){
                console.log(err);
            }
        });

        // beforeSave 클래스 제거
        $('#de_list_add').removeClass('beforeSave');

        // 태그 정리
        $('#de_list_add_zipcode').remove();
        $('#de_list_add_addr1').remove();
        document.querySelector('#de_list_add .de_list_Recipient').style.display = 'block';
        $('#de_list_add .de_list_Recipient').text($('#de_list_add_Recipient').val());
        $('#de_list_add_Recipient').parent().remove();
        $('#de_list_add .de_list_addr2').text($('#de_list_add_addr2').val());
        $('#de_list_add_addr2').parent().remove();
        $('#de_list_add .de_list_receptionName').text($('#de_list_add_receptionName').val() + ', ');
        $('#de_list_add_receptionName').parent().remove();
        $('#de_list_add .de_list_recipient_phone').text($('#de_list_add_recipient_phone').val());
        $('#de_list_add_recipient_phone').parent().remove();
        $('#de_list_add').css('border', '0');
        document.querySelector('#de_list_add_btn').remove();
    }


}

// 취소 버튼
function deListAddCancel(element){
    $('#de_list_add').remove();
    $('#de_list_add_btn').remove();
}

// 새벽배송 체크 시 비밀번호 입력 칸 보여줘~
$(
    $('#delivery_early').change(function(){

        if($('#delivery_early').is(':checked')){
            document.querySelector('.delivery_door_pwd').style.display = 'block';
        }
    })
)

// 주문서 작성 완료 클릭
$('.order_next_btn').click(function(){
   if($('#delivery_early').is(':checked') == false){
       alert('배송 방법을 선택해주세요.');
   } else if($('#deliveryType1').is(':checked') == true && $('#deliveryPwd').val() == ''){
        alert('공동현관 비밀번호를 입력해 주세요.');
   } else {
       $.ajax({
           type: 'post',
           url: '/dangjang/shop/delivery/ok',
           data: $('#shipForm').serialize(),
           success: function (){
               location.href='/dangjang/shop/payment?addr='+$('#baseStatusNum').val();
           },
           error: function(err){
               console.log(err);
           }
       });
   }
});