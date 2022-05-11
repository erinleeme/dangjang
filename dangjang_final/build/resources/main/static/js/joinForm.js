// div 박스 있는 input 클릭 시 display 보이도록~
$('.joinWriteSection .div_check').focus(function(){
    $(this).parent().children('.joinWriteSection .j_div').css('display', 'block');
});

$('.joinWriteSection #j_birth_year, .joinWriteSection #j_birth_month, .joinWriteSection #j_birth_day').focus(function(){
    $('.joinWriteSection .j_birth').css('border', '1.5px solid #1A237E');
    $('.joinWriteSection #j_birth_div').css('display', 'block');
})

// id 유효성 검사
var idRegExp = /^[a-zA-Z0-9]{5,15}$/g;
$('.joinWriteSection #j_id').on('keyup', function(event){

    if(idRegExp.test($('.joinWriteSection #j_id').val()) == true){
        console.log('true');
        $('.joinWriteSection #j_id_div .txt_case1').removeClass('wrong');
        $('.joinWriteSection #j_id_div .txt_case1').addClass('great');
        $('.joinWriteSection #j_id_div .txt_case1').css('color', '#00ACC1');
        $('.joinWriteSection #j_id_btn').attr('disabled', false);
    } else if(idRegExp.test($('.joinWriteSection #j_id').val()) == false){
        console.log('false');
        $('.joinWriteSection #j_id_div .txt_case1').removeClass('great');
        $('.joinWriteSection #j_id_div .txt_case1').addClass('wrong');
        $('.joinWriteSection #j_id_div .txt_case1').css('color', '#F50057');
        $('.joinWriteSection #j_id_btn').attr('disabled', true);
    }
});

// pwd 유효성 검사
var pwdRegExp = /^(?=.*[a-zA-Z])(?=.*[~!@#$%^&*])(?=.*\d)[a-zA-Z\d!@#$%^*]{8,16}$/g;
var sameNumRegExp = /(\d)\1\1$/;
$('.joinWriteSection #j_pwd').keyup(function(){
    // 개수
    if($('.joinWriteSection #j_pwd').val().length >= 8 && $('#j_pwd').val().length <= 16) {
        $('.joinWriteSection #j_pwd_div .txt_case1').removeClass('wrong');
        $('.joinWriteSection #j_pwd_div .txt_case1').addClass('great');
        $('.joinWriteSection #j_pwd_div .txt_case1').css('color', '#00ACC1');
    } else {
        $('.joinWriteSection #j_pwd_div .txt_case1').removeClass('great');
        $('.joinWriteSection #j_pwd_div .txt_case1').addClass('wrong');
        $('.joinWriteSection #j_pwd_div .txt_case1').css('color', '#F50057');
    }
    // 문자 조합
    if(pwdRegExp.test($('.joinWriteSection #j_pwd').val()) == true){
        console.log('true');
        $('.joinWriteSection #j_pwd_div .txt_case2').removeClass('wrong');
        $('.joinWriteSection #j_pwd_div .txt_case2').addClass('great');
        $('.joinWriteSection #j_pwd_div .txt_case2').css('color', '#00ACC1');
    } else if(pwdRegExp.test($('.joinWriteSection #j_pwd').val()) == false){
        $('.joinWriteSection #j_pwd_div .txt_case2').removeClass('great');
        $('.joinWriteSection #j_pwd_div .txt_case2').addClass('wrong');
        $('.joinWriteSection #j_pwd_div .txt_case2').css('color', '#F50057');
    }
    // 숫자 3글자 연속
    if(sameNumRegExp.test($('.joinWriteSection #j_pwd').val()) == true){
        $('.joinWriteSection #j_pwd_div .txt_case3').removeClass('great');
        $('.joinWriteSection #j_pwd_div .txt_case3').addClass('wrong');
        $('.joinWriteSection #j_pwd_div .txt_case3').css('color', '#F50057');
    } else if(sameNumRegExp.test($('.joinWriteSection #j_pwd').val()) == false){
        $('.joinWriteSection #j_pwd_div .txt_case3').removeClass('wrong');
        $('.joinWriteSection #j_pwd_div .txt_case3').addClass('great');
        $('.joinWriteSection #j_pwd_div .txt_case3').css('color', '#00ACC1');
    }
});

// repwd 유효성 검사
$('.joinWriteSection #j_chk_pwd').keyup(function(){
    if($('.joinWriteSection #j_chk_pwd').val() == $('.joinWriteSection #j_pwd').val()){
        $('.joinWriteSection #j_pwd_check_div .txt_case1').removeClass('wrong');
        $('.joinWriteSection #j_pwd_check_div .txt_case1').addClass('great');
        $('.joinWriteSection #j_pwd_check_div .txt_case1').css('color', '#00ACC1');
    } else {
        $('.joinWriteSection #j_pwd_check_div .txt_case1').removeClass('great');
        $('.joinWriteSection #j_pwd_check_div .txt_case1').addClass('wrong');
        $('.joinWriteSection #j_pwd_check_div .txt_case1').css('color', '#F50057');
    }
});

// 이름, 닉네임 유효성 검사
var nameRegExp = /^[ㄱ-ㅎ|가-힣]+$/;
$('.joinWriteSection #j_name').keyup(function(){
    console.log(nameRegExp.test($('.joinWriteSection #j_name').val()));

    if(!nameRegExp.test($('.joinWriteSection #j_name').val())){
        document.getElementById('j_name').value = '';
    } else if(nameRegExp.test($('.joinWriteSection #j_name').val())){

    }
});
var nickNameRegExp = /^[ㄱ-ㅎ|가-힣|a-z|A-Z|0-9]+$/;
$('.joinWriteSection #j_nickname').keyup(function(){
    console.log(nickNameRegExp.test($('.joinWriteSection #j_nickname').val()));
    if(nickNameRegExp.test($('.joinWriteSection #j_nickname').val()) == false){
        document.getElementById('j_nickname').value = '';
        $('.joinWriteSection #j_nickname_div .txt_case1').removeClass('great');
        $('.joinWriteSection #j_nickname_div .txt_case1').addClass('wrong');
        $('.joinWriteSection #j_nickname_div .txt_case1').css('color', '#F50057');
        $('.joinWriteSection #j_nickname_btn').attr('disabled', true);
    } else if(nickNameRegExp.test($('.joinWriteSection #j_nickname').val()) == true){
        $('.joinWriteSection #j_nickname_div .txt_case1').removeClass('wrong');
        $('.joinWriteSection #j_nickname_div .txt_case1').addClass('great');
        $('.joinWriteSection #j_nickname_div .txt_case1').css('color', '#00ACC1');
        $('.joinWriteSection #j_nickname_btn').attr('disabled', false);
    }
});
// email 입력 여부
$('.joinWriteSection #j_email').keyup(function(){
    if($('.joinWriteSection #j_email').val() != ''){
        // 중복 확인 버튼 활성화
        $('.joinWriteSection #j_email_btn').attr('disabled', false);
        // 문구 표시
        $('.joinWriteSection #j_email_div .txt_case1').removeClass('great');
        $('.joinWriteSection #j_email_div .txt_case1').addClass('wrong');
        $('.joinWriteSection #j_email_div .txt_case1').css('color', '#F50057');
    } else {
        $('.joinWriteSection #j_email_btn').attr('disabled', true);
    }
});
// 핸드폰번호 유효성검사
var phoneRegExp = /^[0-9]+$/g;
$('.joinWriteSection #j_phone').keyup(function(){
    console.log(phoneRegExp.test($('.joinWriteSection #j_phone').val()));
    if(phoneRegExp.test($('.joinWriteSection #j_phone').val()) == true){
        console.log('맞아!');
    } else if(phoneRegExp.test($('.joinWriteSection #j_phone').val()) == false) {
        console.log('틀린 값!');
        document.getElementById('j_phone').value = '';
    }

    if($('.joinWriteSection #j_phone').val().length >= 10){
        $('.joinWriteSection #j_phone_num_btn').attr('disabled', false);
    } else {
        $('.joinWriteSection #j_phone_num_btn').attr('disabled', true);
    }
});
// 생년월일 유효성 검사
$('.joinWriteSection #j_birth_year, .joinWriteSection #j_birth_month, .joinWriteSection #j_birth_day').blur(function(){
    const toyear = new Date().getFullYear();
    console.log(toyear);
    const b_year = Number($('.joinWriteSection #j_birth_year').val());
    const b_month = Number($('.joinWriteSection #j_birth_month').val());
    const b_day = Number($('.joinWriteSection #j_birth_day').val());

    if(b_year < 1900 || b_year > toyear) {
        console.log('틀린 값!');
        document.getElementById('j_birth_year').value = '';
        $('.joinWriteSection #j_birth_div .txt_case1').removeClass('great');
        $('.joinWriteSection #j_birth_div .txt_case1').addClass('wrong');
        $('.joinWriteSection #j_birth_div .txt_case1').css('color', '#F50057');
    } else if(b_month < 1 || b_month > 12) {
        console.log('틀린 값!');
        document.getElementById('j_birth_month').value = '';
        $('.joinWriteSection #j_birth_div .txt_case1').removeClass('great');
        $('.joinWriteSection #j_birth_div .txt_case1').addClass('wrong');
        $('.joinWriteSection #j_birth_div .txt_case1').css('color', '#F50057');
    } else if(b_day < 1 || b_day > 31) {
        console.log('틀린 값!');
        document.getElementById('j_birth_day').value = '';
        $('.joinWriteSection #j_birth_div .txt_case1').removeClass('great');
        $('.joinWriteSection #j_birth_div .txt_case1').addClass('wrong');
        $('.joinWriteSection #j_birth_div .txt_case1').css('color', '#F50057');
    } else {
        $('.joinWriteSection #j_birth_div .txt_case1').removeClass('wrong');
        $('.joinWriteSection #j_birth_div .txt_case1').addClass('great');
        $('.joinWriteSection #j_birth_div .txt_case1').css('color', '#00ACC1');
    }
});
// 아이디 중복확인
$('.joinWriteSection .j_id_btn').click(function(){
    if($('.joinWriteSection #j_id').val() == ''){
        // input 안 채우면 버튼 비활성화~
        $('.joinWriteSection #j_id_btn').attr('disabled', true);
        $('.joinWriteSection #j_id_div').css('display', 'block');
    } else {
        $.ajax({
            type: 'post',
            url: '/dangjang/shop/member/join/overlapCheck',
            data: 'id='+$('#j_id').val(),
            async: false,
            success: function(data){
                if(data == false){
                    $('.joinWriteSection #j_id_check').val($('#j_id').val());
                    console.log($('.joinWriteSection #j_id').val());
                    console.log($('.joinWriteSection #j_id_check').val());
                    $('.joinWriteSection #j_id_div .txt_case2').removeClass('wrong');
                    $('.joinWriteSection #j_id_div .txt_case2').addClass('great');
                    $('.joinWriteSection #j_id_div .txt_case2').css('color', '#00ACC1');
                } else {
                    $('.joinWriteSection #j_id_div .txt_case2').removeClass('great');
                    $('.joinWriteSection #j_id_div .txt_case2').addClass('wrong');
                    $('.joinWriteSection #j_id_div .txt_case2').css('color', '#F50057');
                }
            },
            error: function(err){
                console.log(err);
            }
        })
    }
});

// 닉네임 중복확인
$('.joinWriteSection .j_nickname_btn').click(function(){
    if($('.joinWriteSection #j_nickname').val() == ''){
        // input 안 채우면 버튼 비활성화~
        $('.joinWriteSection #j_nickname_btn').attr('disabled', true);
        $('.joinWriteSection #j_nickname_div').css('display', 'block');
    } else {
        $.ajax({
            type: 'post',
            url: '/dangjang/shop/member/join/overlapCheck',
            data: 'nickname='+$('#j_nickname').val(),
            async: false,
            success: function(data){
                if(data == false){
                    $('.joinWriteSection #j_nickname_check').val($('.joinWriteSection #j_nickname').val());
                    $('.joinWriteSection #j_nickname_div .txt_case2').removeClass('wrong');
                    $('.joinWriteSection #j_nickname_div .txt_case2').addClass('great');
                    $('.joinWriteSection #j_nickname_div .txt_case2').css('color', '#00ACC1');
                } else {
                    $('.joinWriteSection #j_nickname_div .txt_case2').removeClass('great');
                    $('.joinWriteSection #j_nickname_div .txt_case2').addClass('wrong');
                    $('.joinWriteSection #j_nickname_div .txt_case2').css('color', '#F50057');
                }
            },
            error: function(err){
                console.log(err);
            }
        })
    }
});

// 이메일 중복 체크
$('.joinWriteSection #j_email_btn').click(function(){
    if($('.joinWriteSection #j_email').val() == ''){
        // input 안 채우면 버튼 비활성화~
        $('.joinWriteSection #j_email_btn').attr('disabled', true);
    } else {
        $.ajax({
            type: 'post',
            url: '/dangjang/shop/member/join/overlapCheck',
            data: 'email='+$('.joinWriteSection #j_email').val(),
            async: false,
            success: function(data){
                if(data == false){ // 사용 가능
                    // 중복 input에 넣어주고
                    $('.joinWriteSection #j_email_check').val($('.joinWriteSection #j_email').val());
                    // 문구 okay~
                    $('.joinWriteSection #j_email_div .txt_case1').removeClass('wrong');
                    $('.joinWriteSection #j_email_div .txt_case1').addClass('great');
                    $('.joinWriteSection #j_email_div .txt_case1').css('color', '#00ACC1');
                    // 버튼 비활성화
                    $('.joinWriteSection #j_email_btn').attr('disabled', true);
                } else { // 이미 존재하는 이메일
                    // modal로 변경 예정
                    alert('이미 가입하신 이메일입니다.');
                    $('.joinWriteSection #j_email_div .txt_case1').removeClass('great');
                    $('.joinWriteSection #j_email_div .txt_case1').addClass('wrong');
                    $('.joinWriteSection #j_email_div .txt_case1').css('color', '#F50057');
                }
            },
            error: function(err){
                console.log(err);
            }
        })
    }
});

// 전화번호 중복확인(=인증번호 받기) --------------------------------------------------
$('.joinWriteSection #j_phone_num_btn').click(function(){
    if($('.joinWriteSection #j_phone').val() == ''){
        $('.joinWriteSection #j_phone_num_btn').attr('disabled', true);
    } else if($('.joinWriteSection #j_phone_num_btn').val() != '재발송'){
        // 중복 체크 먼저
        $.ajax({
            type: 'post',
            url: '/dangjang/shop/member/join/overlapCheck',
            data: 'phoneNumber='+$('.joinWriteSection #j_phone').val(),
            async: false,
            success: function(data){
                // 중복일 경우 이미 가입한 전화번호라고 모달 표시,
                // 중복 아닐 경우 인증번호 발송
                if(data == false){ // <- 중복 아님!
                    // 인증번호 발송 -> 전화번호 readonly 처리
                    $('.joinWriteSection #j_phone').attr('readonly', true);
                    // countDown 함수 시작
                    countDown_d();
                    // 카운트 컬러 변경
                    $('.joinWriteSection #j_phone_num_count').css('color', '#F50057');
                    // 인증번호 받기 -> 재발송 버튼으로 변경 but 비활성화
                    $('.joinWriteSection #j_phone_num_btn').val('재발송');
                    $('.joinWriteSection #j_phone_num_btn').attr('disabled', true);
                    // 인증번호 비동기 처리
                    $.ajax({
                        type: 'post',
                        url: '/dangjang/shop/member/mobile',
                        data: {'phoneNumber': $('.joinWriteSection #j_phone').val()},
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
        countDown_d();
        // 카운트 컬러 변경
        $('.joinWriteSection #j_phone_num_count').css('color', '#F50057');
        // 인증번호 비동기 처리
        $.ajax({
            type: 'post',
            url: '/dangjang/shop/member/mobile',
            data: {'phoneNumber': $('.joinWriteSection #j_phone').val()},
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
// 인증번호
// 인증번호 유효성 (숫자만 4자리)
var chkNumRegExp = /^[0-9]+$/g;
$('.joinWriteSection #j_phone_num').keyup(function(){
    console.log(chkNumRegExp.test($('.joinWriteSection #j_phone_num').val()));
    if(chkNumRegExp.test($('.joinWriteSection #j_phone_num').val()) == true){
        console.log('맞아!');
    } else if(chkNumRegExp.test($('.joinWriteSection #j_phone_num').val()) == false) {
        console.log('틀린 값!');
        document.getElementById('j_phone_num').value = '';
    }

    if($('.joinWriteSection #j_phone_num').val().length == 4){
        $('.joinWriteSection #j_phone_num_check_btn').attr('disabled', false);
    } else {
        $('.joinWriteSection #j_phone_num_check_btn').attr('disabled', true);
    }
})
// countDown
function timeFormat(num){
    return num < 10 ? "0" + num : num;
}
var joinFormTimer = '';
function countDown_d(){
    // 3분 count down
    let duration = 60 * 3;
    function countStart(){
        let disDue = --duration;
        if(disDue < 0){
            clearInterval(joinFormTimer); // parameter로 elemeter 받으면 한 개 함수로 여러 부분에서 사용 가능 - 나중에 처리할 예정
            document.getElementById('j_phone_num_count').innerText = '00:00';
            // 재발송 버튼 활성화
            $('.joinWriteSection #j_phone_num_btn').attr('disabled', false);
            // 확인 버튼 비활성화
            $('.joinWriteSection #j_phone_num_check_btn').attr('disabled', true);
        }

        let min = Math.floor(disDue / 60);
        let sec = Math.floor(disDue % 60);
        document.querySelector('.joinWriteSection #j_phone_num_count').innerText = `${timeFormat(min)}:${timeFormat(sec)}`;
    }
     joinFormTimer = setInterval(countStart, 1000);
}
// 인증번호 확인
$('.joinWriteSection #j_phone_num_check_btn').click(function(){
    // 1. 발급 번호와 일치하는지 확인
    // 2. 일치하면 휴대폰 번호, 인증번호 input은 readonly로 변경
    $.ajax({
        type: 'post',
        url: '/dangjang/shop/member/certify',
        data: {'certifyNum': $('.joinWriteSection #j_phone_num').val()},
        dataType: 'text',
        success: function(data){
            if(data == 'Ok'){
                // 인증번호 readonly 처리
                $('.joinWriteSection #j_phone_num').attr('readonly', true);
                // 시간 stop
                clearInterval(joinFormTimer); // timer stop
                document.getElementById('j_phone_num_count').innerText = ''; // 시간 없애기
                // 확인 버튼 비활성화
                $('#joinWriteTable #j_phone_num_check_btn').attr('disabled', true);

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
function checkPost() {
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
            $('.joinWriteSection #btn_address').attr('style', 'display: none');
            $('.joinWriteSection #j_selectAddress').attr('style', 'display: block');
        }
    }).open();
}
// 약관
$(document).ready(function(){
    // 전체 동의
    $('.joinWriteSection #j_chk_all').change(function(){
        if($('.joinWriteSection #j_chk_all').is(":checked")){
            $('.joinWriteSection #j_chk_1').prop("checked", true);
            $('.joinWriteSection #j_chk_2').prop("checked", true);
        } else {
            $('.joinWriteSection #j_chk_1').prop("checked", false);
            $('.joinWriteSection #j_chk_2').prop("checked", false);
        }
    })
    // 개별 동의
    $('.joinWriteSection #j_chk_1, .joinWriteSection #j_chk_2').change(function(){
        if($('.joinWriteSection #j_chk_1').is(":checked") && $('.joinWriteSection #j_chk_2').is(":checked")){
            $('.joinWriteSection #j_chk_all').prop("checked", true);
        } else {
            $('.joinWriteSection #j_chk_all').prop("checked", false);
        }
    })
});


// 가입하기 클릭
$('.joinWriteSection #btn_join_submit').click(function(){
    // alert('click');

    // 아이디 미 입력
    if($('.joinWriteSection #j_id').val() == ''){
        $('.joinWriteSection #j_id_btn').attr('disabled', true);
        $('.joinWriteSection #j_id_div').css('display', 'block');
        $('.joinWriteSection #j_id_div .txt_case1').removeClass('great');
        $('.joinWriteSection #j_id_div .txt_case1').addClass('wrong');
        $('.joinWriteSection #j_id_div .txt_case1').css('color', '#F50057');

        // 아이디 미 중복체크
    } else if($('.joinWriteSection #j_id').val() != $('.joinWriteSection #j_id_check').val()){
        $('.joinWriteSection #j_id_div').css('display', 'block');
        $('.joinWriteSection #j_id_div .txt_case2').removeClass('great');
        $('.joinWriteSection #j_id_div .txt_case2').addClass('wrong');
        $('.joinWriteSection #j_id_div .txt_case2').css('color', '#F50057');

        // 비밀번호 미 입력
    } else if($('.joinWriteSection #j_pwd').val() == ''){
        $('.joinWriteSection #j_pwd_div').css('display', 'block');
        $('.joinWriteSection #j_pwd_div .txt_case1').removeClass('great');
        $('.joinWriteSection #j_pwd_div .txt_case1').addClass('wrong');
        $('.joinWriteSection #j_pwd_div .txt_case1').css('color', '#F50057');

        // 비밀번호 확인 미 입력
    } else if($('.joinWriteSection #j_chk_pwd').val() == ''){
        $('.joinWriteSection #j_pwd_check_div').css('display', 'block');
        $('.joinWriteSection #j_pwd_check_div .txt_case1').removeClass('great');
        $('.joinWriteSection #j_pwd_check_div .txt_case1').addClass('wrong');
        $('.joinWriteSection #j_pwd_check_div .txt_case1').css('color', '#F50057');

        // 비밀번호 불일치
    } else if($('.joinWriteSection #j_pwd').val() != $('.joinWriteSection #j_chk_pwd').val()){
        $('.joinWriteSection #j_pwd_check_div').css('display', 'block');
        $('.joinWriteSection #j_pwd_check_div .txt_case1').removeClass('great');
        $('.joinWriteSection #j_pwd_check_div .txt_case1').addClass('wrong');
        $('.joinWriteSection #j_pwd_check_div .txt_case1').css('color', '#F50057');

        // 이름 미입력
    } else if($('.joinWriteSection #j_name').val() == ''){
        $('.joinWriteSection #j_name').focus();

        // 닉네임 미입력
    } else if($('.joinWriteSection #j_nickname').val() == ''){
        $('.joinWriteSection #j_nickname_btn').attr('disabled', true);
        $('.joinWriteSection #j_nickname_div').css('display', 'block');
        $('.joinWriteSection #j_nickname_div .txt_case1').removeClass('great');
        $('.joinWriteSection #j_nickname_div .txt_case1').addClass('wrong');
        $('.joinWriteSection #j_nickname_div .txt_case1').css('color', '#F50057');

        // 닉네임 미 중복체크
    } else if($('.joinWriteSection #j_nickname').val() != $('.joinWriteSection #j_nickname_check').val()){
        $('.joinWriteSection #j_nickname_div').css('display', 'block');
        $('.joinWriteSection #j_nickname_div .txt_case2').removeClass('great');
        $('.joinWriteSection #j_nickname_div .txt_case2').addClass('wrong');
        $('.joinWriteSection #j_nickname_div .txt_case2').css('color', '#F50057');

        // 이메일 미 입력
    } else if($('.joinWriteSection #j_email').val() == ''){
        $('.joinWriteSection #j_email').focus();

        // 이메일 미 중복체크
    } else if($('.joinWriteSection #j_email').val() != $('.joinWriteSection #j_email_check').val()){
        $('.joinWriteSection #j_email_div').css('display', 'block');
        $('.joinWriteSection #j_email_div .txt_case1').removeClass('great');
        $('.joinWriteSection #j_email_div .txt_case1').addClass('wrong');
        $('.joinWriteSection #j_email_div .txt_case1').css('color', '#F50057');

        // 휴대폰 번호 미 입력
    } else if($('.joinWriteSection #j_phone').val() == ''){
        $('.joinWriteSection #j_phone_num_btn').attr('disabled', true);
        $('.joinWriteSection #j_phone').focus();

        // 인증번호 미 입력
    } else if($('.joinWriteSection #j_phone_num').val() == ''){
        $('.joinWriteSection #j_phone_num').focus();

        // 주소 미 입력
    } else if($('.joinWriteSection #j_addr').val() == ''){
        $('.joinWriteSection #btn_address').focus();

    } else if($('.joinWriteSection #j_address').val() == ''){
        $('.joinWriteSection #btn_address').focus();

        // 상세주소 미 입력
    } else if($('.joinWriteSection #j_addr_detail').val() == ''){
        $('.joinWriteSection #j_addr_detail').focus();

        // 부정확한 생년월일
    } else if($('.joinWriteSection #j_birth_div .txt_case1').hasClass('wrong') == true) {
        $('.joinWriteSection #j_birth_year').focus();

        // 약관 미 체크
    } else if($('.joinWriteSection #j_chk_all').is(':checked') == false){
        $('.joinWriteSection #j_chk_all').focus();

    } else {
        $.ajax({
            type: 'post',
            url: '/dangjang/shop/member/join/joinOk',
            data: $('#joinWriteForm').serialize(),
            dataType: 'text',
            success: function(data){
                // alert(data);
                // 회원가입 성공일 경우 joinOk return
                if(data == 'joinOk'){
                    // 회원가입 완료
                    location.href='/dangjang/shop/member/join/success?l=d';
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

