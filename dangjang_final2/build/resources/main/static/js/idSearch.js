// 이름 유효성 검사
nameRegExp = /^[ㄱ-ㅎ|가-힣]+$/;
$('#idSearch_name').keyup(function(){
    console.log(nameRegExp.test($('#idSearch_name').val()));

    if(!nameRegExp.test($('#idSearch_name').val())){
        document.getElementById('idSearch_name').value = '';
    } else if(nameRegExp.test($('#idSearch_name').val())){
    }
});

// 핸드폰번호 유효성검사
phoneRegExp = /^[0-9]+$/g;
$('#idSearch_phone').keyup(function(){
    console.log(phoneRegExp.test($('#idSearch_phone').val()));
    if(phoneRegExp.test($('#idSearch_phone').val()) == true){
        console.log('맞아!');
    } else if(phoneRegExp.test($('#idSearch_phone').val()) == false) {
        console.log('틀린 값!');
        document.getElementById('idSearch_phone').value = '';
    }

    if($('#idSearch_phone').val().length >= 10){
        $('#idSearch_btn').attr('disabled', false);
    } else {
        $('#idSearch_btn').attr('disabled', true);
    }
});

// 인증번호 받기 클릭 function
$('#idSearch_btn').click(function(){
    // alert('click');
    if($('#idSearch_name').val() == ''){
        $('#idSearch_name').focus();
    } else {
        // 이름 readonly 처리
        $('#idSearch_name').attr('readonly', true);
        // 휴대폰 번호 readonly 처리
        $('#idSearch_phone').attr('readonly', true);
        // countDown 함수 시작
        countDown_i();
        // 카운트 컬러 변경
        $('#idSearch_count').css('color', '#F50057');
        // 인증번호 받기 display none
        $('#idSearch_btn').attr('style', 'display: none;');
        // 확인 버튼 display block
        $('#idSearch_chk_btn').attr('style', 'display: block;');
        // 비동기 처리
        $.ajax({
            type: 'post',
            url: '/dangjang/shop/member/mobile',
            data: {'phoneNumber': $('#idSearch_phone').val()},
            dataType: 'text',
            success: function(data){
                if(data == 'sendingOk'){
                    console.log('전송 성공~');
                }
            },
            error: function(err){
                console.log(err);
            }
        });
    }
});
// 재발송 btn click
$('.idSearchNum_request_btn').click(function(){
    // countDown 함수 시작
    countDown_i();
    // 카운트 컬러 변경
    $('#idSearch_count').css('color', '#F50057');
    // 재발송 btn 비활성
    $('.idSearchNum_request_btn').attr("disabled", true);
    // 비동기 처리
    $.ajax({
        type: 'post',
        url: '/dangjang/shop/member/mobile',
        data: {'phoneNumber': $('#idSearch_phone').val()},
        dataType: 'text',
        success: function(data){
            if(data == 'sendingOk'){
                console.log('전송 성공~');
            }
        },
        error: function(err){
            console.log(err);
        }
    });
});
// 인증번호 유효성 (숫자만 4자리)
chkNumRegExp = /^[0-9]+$/g;
$('#idSearch_number').keyup(function(){
    console.log(chkNumRegExp.test($('#idSearch_number').val()));
    if(chkNumRegExp.test($('#idSearch_number').val()) == true){
        console.log('맞아!');
    } else if(chkNumRegExp.test($('#idSearch_number').val()) == false) {
        console.log('틀린 값!');
        document.getElementById('idSearch_number').value = '';
    }

    if($('#idSearch_number').val().length == 4){
        $('#idSearch_chk_btn').attr('disabled', false);
    } else {
        $('#idSearch_chk_btn').attr('disabled', true);
    }
})

function timeFormat(num){
    return num < 10 ? "0" + num : num;
}
function countDown_i(){
    // 3분 count down
    let duration = 60 * 3;
    function countStart(){
        let disDue = --duration;
        if(disDue <= 0){
            clearInterval(idSearchTimer);
            document.getElementById('idSearch_count').innerText = '00:00';
            // 재발송 활성화
            $('.idSearchNum_request_btn').attr('disabled', false);
        }

        let min = Math.floor(disDue / 60);
        let sec = Math.floor(disDue % 60);
        document.querySelector('#idSearch_count').innerText = `${timeFormat(min)}:${timeFormat(sec)}`;
    }
    var idSearchTimer = setInterval(countStart, 1000);
}

// 확인 click
$('#idSearch_chk_btn').click(function(){
    if($('#idSearch_name').val() == ''){
        $('#idSearch_name').focus();
    } else {
        // 인증번호 일치 ajax
        $.ajax({
            type: 'post',
            url: '/dangjang/shop/member/certify',
            data: {'certifyNum': $('#idSearch_number').val()},
            dataType: 'text',
            success: function(data){
                if(data == 'Ok'){
                    console.log('인증번호 일치');
                    // db 확인
                    $.ajax({
                        type: 'post',
                        url: '/dangjang/shop/member/join/precenseCheck',
                        data: $('.idSearchForm').serialize(),
                        async: false,
                        success: function(data){
                            // ok면 result로 이동
                            if(data == false){
                                location.href='/dangjang/shop/member/find/id/success'
                            } else {
                            // fail이면 모달 or alert으로 알림 후 joinList로 이동
                                alert('존재하지 않는 회원 정보입니다.');
                                location.href='/dangjang/shop/member/join/list'
                            }
                        },
                        error: function(err){
                            console.log(err);
                        }
                    });

                } else {
                    // 틀렸다고 modal 알림 해조야해
                    alert('인증번호를 다시 확인해주세요.');
                    console.log('인증번호 불일치');
                }
            },
            error: function(err){
                console.log(err);
            }
        });
    }
})