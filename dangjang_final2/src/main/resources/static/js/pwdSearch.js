// id 유효성 검사 - 고칠 예정
// idRegExp = /^[a-zA-Z0-9]{5,15}$/g;
// $('#pwdSearch_id').keyup(function(){
//     if(idRegExp.test($('#pwdSearch_id').val()) == true){
//         console.log('맞아!');
//     } else if(idRegExp.test($('#pwdSearch_id').val()) == false){
//         console.log('틀려!');
//         document.getElementById('pwdSearch_id').value = '';
//     }
// });

// 핸드폰번호 유효성검사
phoneRegExp = /^[0-9]+$/g;
$('#pwdSearch_phone').keyup(function(){
    console.log(phoneRegExp.test($('#pwdSearch_phone').val()));
    if(phoneRegExp.test($('#pwdSearch_phone').val()) == true){
        console.log('맞아!');
    } else if(phoneRegExp.test($('#pwdSearch_phone').val()) == false) {
        console.log('틀린 값!');
        document.getElementById('pwdSearch_phone').value = '';
    }

    if($('#pwdSearch_phone').val().length >= 10){
        $('#pwdSearch_btn').attr('disabled', false);
    } else {
        $('#pwdSearch_btn').attr('disabled', true);
    }
});

// 인증번호 받기 클릭 function
// click -> 인증번호 발송
// 3분 카운트 시작
$('#pwdSearch_btn').click(function(){
    if($('#pwdSearch_id').val() == ''){
        $('#pwdSearch_id').focus();
    } else {
        // 아이디 readonly 처리
        $('#pwdSearch_id').attr('readonly', true);
        // 휴대폰 번호 readonly 처리
        $('#pwdSearch_phone').attr('readonly', true);
        // countDown 함수 시작
        countDown_p();
        // 카운트 컬러 변경
        $('#pwdSearch_count').css('color', '#F50057');
        // 인증번호 받기 display none
        $('.pwdSearch_btn').attr('style', 'display: none;');
        // 확인 버튼 display block
        $('#pwdSearch_chk_btn').attr('style', 'display: block;');
        // 비동기 처리
        $.ajax({
            type: 'post',
            url: '/dangjang/shop/member/mobile',
            data: {'phoneNumber': $('#pwdSearch_phone').val()},
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
$('.pwdSearchNum_request_btn').click(function(){
    // countDown 함수 시작
    countDown_p();
    // 카운트 컬러 변경
    $('#pwdSearch_count').css('color', '#F50057');
    // 재발송 btn 비활성화
    $('.pwdSearchNum_request_btn').attr("disabled", true);
    // 비동기 처리
    $.ajax({
        type: 'post',
        url: '/dangjang/shop/member/mobile',
        data: {'phoneNumber': $('#pwdSearch_phone').val()},
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
$('#pwdSearch_number').keyup(function(){
    console.log(chkNumRegExp.test($('#pwdSearch_number').val()));
    if(chkNumRegExp.test($('#pwdSearch_number').val()) == true){
        console.log('맞아!');
    } else if(chkNumRegExp.test($('#pwdSearch_number').val()) == false) {
        console.log('틀린 값!');
        document.getElementById('pwdSearch_number').value = '';
    }

    if($('#pwdSearch_number').val().length == 4){
        $('#pwdSearch_chk_btn').attr('disabled', false);
    } else {
        $('#pwdSearch_chk_btn').attr('disabled', true);
    }
})

// count 함수
function timeFormat(num){
    return num < 10 ? "0" + num : num;
};
function countDown_p(){
    // 3분 count down
    let duration = 60 * 3;
    function countStart(){
        let disDue = --duration;
        if(disDue <= 0){
            clearInterval(pwdSearchTimer);
            // 유효시간 만료 알림 모달 띄워야 함
            document.getElementById('pwdSearch_count').innerText = '00:00';
            // 재발송 btn 활성화
            $('.pwdSearchNum_request_btn').attr('disabled', false);
        }

        let min = Math.floor(disDue / 60);
        let sec = Math.floor(disDue % 60);
        document.querySelector('#pwdSearch_count').innerText = `${timeFormat(min)}:${timeFormat(sec)}`;
    }
    var pwdSearchTimer = setInterval(countStart, 1000);
};

// 확인 click
$('#pwdSearch_chk_btn').click(function(){
    if($('#pwdSearch_id').val() == ''){
        $('#pwdSearch_id').focus();
    } else {
        // 인증번호 일치 ajax
        $.ajax({
            type: 'post',
            url: '/dangjang/shop/member/certify',
            data: {'certifyNum': $('#pwdSearch_number').val()},
            dataType: 'text',
            success: function(data){
                if(data == 'Ok'){
                    console.log('인증번호 일치');

                    // db 확인 ajax
                    $.ajax({
                        type: 'post',
                        url: '/dangjang/shop/member/find/pwdCheck',
                        data: $('.pwdSearchForm').serialize(),
                        async: false,
                        success: function(data){
                            // ok면 비밀번호 수정으로 이동
                            if(data == false){
                                location.href='/dangjang/shop/member/find/pwd/reset'
                            } else {
                            // fail이면 모달 or alert으로 알림 후 joinList로 이동
                                alert('비밀번호 재설정에 실패하였습니다.');
                            }
                        },
                        error: function(err){
                            console.log(err);
                        }
                    });

                } else {
                    // 틀렸다고 modal 알림 해조야해
                    console.log('인증번호 불일치');
                }
            },
            error: function(err){
                console.log(err);
            }
        });
    }
});