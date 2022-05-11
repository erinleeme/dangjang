// div 박스 있는 input 클릭 시 display 보이도록~
$('#joinWriteSection_kakao .div_check').focus(function(){
    $(this).parent().children('.j_div').css('display', 'block');
});

$('#joinWriteSection_kakao #j_birth_year, #joinWriteSection_kakao #j_birth_month, #joinWriteSection_kakao #j_birth_day').focus(function(){
    $('#joinWriteSection_kakao .j_birth').css('border', '1.5px solid #1A237E');
    $('#joinWriteSection_kakao #j_birth_div').css('display', 'block');
})

// 닉네임 유효성 검사
nickNameRegExp = /^[ㄱ-ㅎ|가-힣|a-z|A-Z|0-9]+$/;
$('#joinWriteSection_kakao #j_nickname').keyup(function(){
    console.log(nickNameRegExp.test($('#joinWriteSection_kakao #j_nickname').val()));
    if(nickNameRegExp.test($('#joinWriteSection_kakao #j_nickname').val()) == false){
        document.getElementById('j_nickname').value = '';
        $('#joinWriteSection_kakao #j_nickname_div .txt_case1').removeClass('great');
        $('#joinWriteSection_kakao #j_nickname_div .txt_case1').addClass('wrong');
        $('#joinWriteSection_kakao #j_nickname_div .txt_case1').css('color', '#F50057');
        $('#joinWriteSection_kakao #j_nickname_btn').attr('disabled', true);
    } else if(nickNameRegExp.test($('#joinWriteSection_kakao #j_nickname').val()) == true){
        $('#joinWriteSection_kakao #j_nickname_div .txt_case1').removeClass('wrong');
        $('#joinWriteSection_kakao #j_nickname_div .txt_case1').addClass('great');
        $('#joinWriteSection_kakao #j_nickname_div .txt_case1').css('color', '#00ACC1');
        $('#joinWriteSection_kakao #j_nickname_btn').attr('disabled', false);
    }
});
// 핸드폰번호 유효성검사
phoneRegExp = /^[0-9]+$/g;
$('#joinWriteSection_kakao #j_phone').keyup(function(){
    console.log(phoneRegExp.test($('#joinWriteSection_kakao #j_phone').val()));
    if(phoneRegExp.test($('#joinWriteSection_kakao #j_phone').val()) == true){
        console.log('맞아!');
    } else if(phoneRegExp.test($('#joinWriteSection_kakao #j_phone').val()) == false) {
        console.log('틀린 값!');
        document.getElementById('j_phone').value = '';
    }

    if($('#joinWriteSection_kakao #j_phone').val().length >= 10){
        $('#joinWriteSection_kakao #j_phone_num_btn').attr('disabled', false);
    } else {
        $('#joinWriteSection_kakao #j_phone_num_btn').attr('disabled', true);
    }
});
// 생년월일 유효성 검사
$('#joinWriteSection_kakao #j_birth_year, #joinWriteSection_kakao #j_birth_month, #joinWriteSection_kakao #j_birth_day').blur(function(){
    const toyear = new Date().getFullYear();
    console.log(toyear);
    const b_year = Number($('#joinWriteSection_kakao #j_birth_year').val());
    const b_month = Number($('#joinWriteSection_kakao #j_birth_month').val());
    const b_day = Number($('#joinWriteSection_kakao #j_birth_day').val());

    if(b_year < 1900 || b_year > toyear) {
        console.log('틀린 값!');
        document.getElementById('j_birth_year').value = '';
        $('#joinWriteSection_kakao #j_birth_div .txt_case1').removeClass('great');
        $('#joinWriteSection_kakao #j_birth_div .txt_case1').addClass('wrong');
        $('#joinWriteSection_kakao #j_birth_div .txt_case1').css('color', '#F50057');
    } else if(b_month < 1 || b_month > 12) {
        console.log('틀린 값!');
        document.getElementById('j_birth_month').value = '';
        $('#joinWriteSection_kakao #j_birth_div .txt_case1').removeClass('great');
        $('#joinWriteSection_kakao #j_birth_div .txt_case1').addClass('wrong');
        $('#joinWriteSection_kakao #j_birth_div .txt_case1').css('color', '#F50057');
    } else if(b_day < 1 || b_day > 31) {
        console.log('틀린 값!');
        document.getElementById('j_birth_day').value = '';
        $('#joinWriteSection_kakao #j_birth_div .txt_case1').removeClass('great');
        $('#joinWriteSection_kakao #j_birth_div .txt_case1').addClass('wrong');
        $('#joinWriteSection_kakao #j_birth_div .txt_case1').css('color', '#F50057');
    } else {
        $('#joinWriteSection_kakao #j_birth_div .txt_case1').removeClass('wrong');
        $('#joinWriteSection_kakao #j_birth_div .txt_case1').addClass('great');
        $('#joinWriteSection_kakao #j_birth_div .txt_case1').css('color', '#00ACC1');
    }
});

// 닉네임 중복확인
$('#joinWriteSection_kakao .j_nickname_btn').click(function(){
    // alert('click');
    if($('#joinWriteSection_kakao #j_nickname').val() == ''){
        // input 안 채우면 버튼 비활성화~
        $('#joinWriteSection_kakao #j_nickname_btn').attr('disabled', true);
        $('#joinWriteSection_kakao #j_nickname_div').css('display', 'block');
    } else {
        $.ajax({
            type: 'post',
            url: '/dangjang/shop/member/join/overlapCheck',
            data: 'nickname='+$('#joinWriteSection_kakao #j_nickname').val(),
            async: false,
            success: function(data){
                // alert(data);
                if(data == false){
                    $('#joinWriteSection_kakao #j_nickname_check').val($('#joinWriteSection_kakao #j_nickname').val());
                    console.log($('#joinWriteSection_kakao #j_nickname').val());
                    console.log($('#joinWriteSection_kakao #j_nickname_check').val());
                    $('#joinWriteSection_kakao #j_nickname_div .txt_case2').removeClass('wrong');
                    $('#joinWriteSection_kakao #j_nickname_div .txt_case2').addClass('great');
                    $('#joinWriteSection_kakao #j_nickname_div .txt_case2').css('color', '#00ACC1');
                } else {
                    alert('이미 존재하는 닉네임입니다.')
                    $('#joinWriteSection_kakao #j_nickname_div .txt_case2').removeClass('great');
                    $('#joinWriteSection_kakao #j_nickname_div .txt_case2').addClass('wrong');
                    $('#joinWriteSection_kakao #j_nickname_div .txt_case2').css('color', '#F50057');
                }
            },
            error: function(err){
                console.log(err);
            }
        })
    }
});
// 전화번호 중복확인(=인증번호 받기)
$('#joinWriteSection_kakao #j_phone_num_btn').click(function(){
    // alert('click'); // 이건 지울 예정
    if($('#joinWriteSection_kakao #j_phone').val() == ''){
        $('#joinWriteSection_kakao #j_phone_num_btn').attr('disabled', true);
    } else if($('#joinWriteSection_kakao #j_phone_num_btn').val() != '재발송') {
        $.ajax({
            type: 'post',
            url: '/dangjang/shop/member/join/overlapCheck',
            data: 'phoneNumber='+$('#joinWriteSection_kakao #j_phone').val(),
            async: false,
            success: function(data){
                // 중복일 경우 이미 가입한 전화번호라고 모달 표시,
                // 중복 아닐 경우 인증번호 발송
                // alert(data);
                if(data == false){ // <- 중복 아님!
                    // 인증번호 발송 -> 전화번호 readonly 처리
                    $('#joinWriteSection_kakao #j_phone').attr('readonly', true);
                    // countDown 함수 시작
                    countDown_k();
                    // 카운트 컬러 변경
                    $('#joinWriteSection_kakao #j_phone_num_count').css('color', '#F50057');
                    // 인증번호 받기 -> 재발송 버튼으로 변경 but 비활성화
                    $('#joinWriteSection_kakao #j_phone_num_btn').val('재발송');
                    $('#joinWriteSection_kakao #j_phone_num_btn').attr('disabled', true);
                    // 인증번호 비동기 처리
                    $.ajax({
                        type: 'post',
                        url: '/dangjang/shop/member/mobile',
                        data: {'phoneNumber': $('#joinWriteSection_kakao #j_phone').val()},
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
                } else {
                    // 모달 처리 예정
                    alert('이미 가입하신 전화번호 입니다.');
                }
            },
            error: function(err){
                console.log(err);
            }
        })
    } else {
        // value가 재발송일 때
        // countDown 함수 시작
        countDown_k();
        // 카운트 컬러 변경
        $('#joinWriteSection_kakao #j_phone_num_count').css('color', '#F50057');
        // 인증번호 비동기 처리
        $.ajax({
            type: 'post',
            url: '/dangjang/shop/member/mobile',
            data: {'phoneNumber': $('#joinWriteSection_kakao #j_phone').val()},
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
// 인증번호 유효성
chkNumRegExp = /^[0-9]+$/g;
$('#joinWriteSection_kakao #j_phone_num').keyup(function(){
    console.log(chkNumRegExp.test($('#joinWriteSection_kakao #j_phone_num').val()));
    if(chkNumRegExp.test($('#joinWriteSection_kakao #j_phone_num').val()) == true){
        console.log('맞아!');
    } else if(chkNumRegExp.test($('#joinWriteSection_kakao #j_phone_num').val()) == false) {
        console.log('틀린 값!');
        document.getElementById('j_phone_num').value = '';
    }

    if($('#joinWriteSection_kakao #j_phone_num').val().length == 4){
        $('#joinWriteSection_kakao #j_phone_num_check_btn').attr('disabled', false);
    } else {
        $('#joinWriteSection_kakao #j_phone_num_check_btn').attr('disabled', true);
    }
})
// countDown
function timeFormat(num){
    return num < 10 ? "0" + num : num;
}
var joinKakaoTimer = '';
function countDown_k(){
    // 3분 count down
    let duration = 60 * 3;
    function countStart(){
        let disDue = --duration;
        if(disDue < 0){
            clearInterval(joinKakaoTimer); // parameter로 elemeter 받으면 한 개 함수로 여러 부분에서 사용 가능 - 나중에 처리할 예정
            document.getElementById('j_phone_num_count').innerText = '00:00';
            // 재발송 버튼 활성화
            $('#joinWriteSection_kakao #j_phone_num_btn').attr('disabled', false);
            // 확인 버튼 비활성화
            $('#joinWriteSection_kakao #j_phone_num_check_btn').attr('disabled', true);
        }
        let min = Math.floor(disDue / 60);
        let sec = Math.floor(disDue % 60);
        document.querySelector('#joinWriteSection_kakao #j_phone_num_count').innerText = `${timeFormat(min)}:${timeFormat(sec)}`;
    }
    joinKakaoTimer = setInterval(countStart, 1000);
}
// 인증번호 확인
$('#joinWriteSection_kakao #j_phone_num_check_btn').click(function(){
    // 1. 발급 번호와 일치하는지 확인
    // 2. 일치하면 휴대폰 번호, 인증번호 input은 readonly로 변경
    $.ajax({
        type: 'post',
        url: '/dangjang/shop/member/certify',
        data: {'certifyNum': $('#joinWriteSection_kakao #j_phone_num').val()},
        dataType: 'text',
        success: function(data){
            if(data == 'Ok'){
                console.log('인증번호 일치');
                // 인증번호 readonly 처리
                $('#joinWriteSection_kakao #j_phone_num').attr('readonly', true);
                // 타이머 clear
                clearInterval(joinKakaoTimer);
                // 시간 없애기
                document.getElementById('j_phone_num_count').innerText = '00:00';
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
});

// 주소 검색 클릭
function checkPost_k() {
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
            document.getElementById('zipcode').value = data.zonecode;
            document.getElementById('j_addr').value = data.zonecode;
            document.getElementById("addr1").value = addr;
            document.getElementById("j_address").value = addr;
            // document.getElementById("addr2").focus();
            document.getElementById("j_addr_detail").focus();
            // 주소 input 보이기
            $('#joinWriteSection_kakao #btn_address').attr('style', 'display: none');
            $('#joinWriteSection_kakao #j_selectAddress').attr('style', 'display: block');
        }
    }).open();
}
// 약관
$(document).ready(function(){
    // 전체 동의
    $('#joinWriteSection_kakao #j_chk_all').change(function(){
        if($('#joinWriteSection_kakao #j_chk_all').is(":checked")){
            $('#joinWriteSection_kakao #j_chk_1').prop("checked", true);
            $('#joinWriteSection_kakao #j_chk_2').prop("checked", true);
        } else {
            $('#joinWriteSection_kakao #j_chk_1').prop("checked", false);
            $('#joinWriteSection_kakao #j_chk_2').prop("checked", false);
        }
    })
    // 개별 동의
    $('#joinWriteSection_kakao #j_chk_1, #joinWriteSection_kakao #j_chk_2').change(function(){
        if($('#joinWriteSection_kakao #j_chk_1').is(":checked") && $('#joinWriteSection_kakao #j_chk_2').is(":checked")){
            $('#joinWriteSection_kakao #j_chk_all').prop("checked", true);
        } else {
            $('#joinWriteSection_kakao #j_chk_all').prop("checked", false);
        }
    })
});


// 가입하기 클릭
$('#joinWriteSection_kakao #btn_join_submit_kakao').click(function(){
    // alert('click');
    // 닉네임 미 입력
    if($('#joinWriteSection_kakao #j_nickname').val() == ''){
        $('#joinWriteSection_kakao #j_nickname_btn').attr('disabled', true);
        $('#joinWriteSection_kakao #j_nickname_div').css('display', 'block');
        $('#joinWriteSection_kakao #j_nickname_div .txt_case1').removeClass('great');
        $('#joinWriteSection_kakao #j_nickname_div .txt_case1').addClass('wrong');
        $('#joinWriteSection_kakao #j_nickname_div .txt_case1').css('color', '#F50057');

        // 닉네임 미 중복체크
    } else if($('#joinWriteSection_kakao #j_nickname').val() != $('#joinWriteSection_kakao #j_nickname_check').val()){
        $('#joinWriteSection_kakao #j_nickname_div').css('display', 'block');
        $('#joinWriteSection_kakao #j_nickname_div .txt_case2').removeClass('great');
        $('#joinWriteSection_kakao #j_nickname_div .txt_case2').addClass('wrong');
        $('#joinWriteSection_kakao #j_nickname_div .txt_case2').css('color', '#F50057');

        // 휴대폰 번호 미 입력
    } else if($('#joinWriteSection_kakao #j_phone').val() == ''){
        $('#joinWriteSection_kakao #j_phone_num_btn').attr('disabled', true);
        $('#joinWriteSection_kakao #j_phone').focus();

        // 인증번호 미 입력
    } else if($('#joinWriteSection_kakao #j_phone_num').val() == ''){
        $('#joinWriteSection_kakao #j_phone_num').focus();

        // 주소 미 입력
    } else if($('#joinWriteSection_kakao #j_addr').val() == ''){
        $('#joinWriteSection_kakao #btn_address').focus();

    } else if($('#joinWriteSection_kakao #j_address').val() == ''){
        $('#joinWriteSection_kakao #btn_address').focus();

        // 상세주소 미 입력
    } else if($('#joinWriteSection_kakao #j_addr_detail').val() == ''){
        $('#joinWriteSection_kakao #j_addr_detail').focus();

        // 부정확한 생년월일
    } else if($('#joinWriteSection_kakao #j_birth_div .txt_case1').hasClass('wrong') == true) {
        $('#joinWriteSection_kakao #j_birth_year').focus();

        // 약관 미 체크
    } else if($('#joinWriteSection_kakao #j_chk_all').is(':checked') == false){
        $('#joinWriteSection_kakao #j_chk_all').focus();

    } else {
        $.ajax({
            type: 'post',
            url: '/dangjang/shop/member/join/joinOk',
            data:'kakaojoinForm='+ $('#joinWriteForm_k').serialize(),
            dataType: 'text',
            success: function(data){
                // alert(data);
                // 회원가입 성공일 경우 joinOk return
                if(data == 'joinOk'){
                    // 회원가입 완료
                    location.href='/dangjang/shop/member/join/success?l=k';

                } else {
                    alert('회원가입에 실패하였습니다. 다시 가입해주세요.');
                    // modal로 수정할 예정
                };
            },
            error: function(err){
                console.log(err);
            }
        });
    }
})

