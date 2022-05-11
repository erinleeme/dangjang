$(document).ready(function () {
    $('.m_chk_tel_Area').css('display', 'none');
    $('.m_chk_pwd_Area').css('display', 'none');

    console.log("$('input[name=\"pwdChange\"]:checked').val()  ",$('input[name="pwdChange"]:checked').val());
});

/* 중복확인이 필요한 nickname , email, phone*/
const past_seq_member = $('#modifySubmit').data("seq_member");
const past_platform = $('#platformType').val();
const past_nickname = $('#m_nickname').val();
const past_email = $('#m_email').val().split("@")[0] + '@' + $('#m_email').val().split("@")[1];
const past_phone = $('#m_phone').val();

/* */
console.log("  ",);
/* */

$('#summitCheck').click(function () {
    var newPwd;

    /* 공통 사항 확인 --------------------*/


    console.log("기존닉네임  ",past_nickname);
    console.log(" 비교닉넴 ",$('#m_nickname').val());
    console.log(" 기존이랑동일한지않음 T예상 ",past_nickname != $('#m_nickname').val());
    console.log(" 검증이되었는지,, 검증ㄴㄴ False ",$('#m_nickname_btn').data("possible"));
    console.log(" 검증이 안되었나요? ", $('#m_nickname_btn').data("possible") == false);
    console.log(" 전체 확인 ", past_nickname != $('#m_nickname').val() && $('#m_nickname_btn').data("possible") == false);

    if (  past_nickname != $('#m_nickname').val() && $('#m_nickname_btn').data("possible") == false  ) {
        $('#m_nickname_div').css('display', 'block');
        $('#m_nickname_div .txt_case2').addClass('wrong');
        $('#m_nickname_div .txt_case2').css('color', '#F50057');

        console.log("닉네임 검증 x");
    } else if ($('#m_email').val() == '') {
        $('#m_email').focus();

        // 이메일 미 중복체크
        console.log("이메일 없음 ");
    } else if (past_email != $('#m_email').val() && $('#m_email_btn').data("possible") == false) {
        $('#m_email_div').css('display', 'block');
        $('#m_email_div .txt_case1').removeClass('great');
        $('#m_email_div .txt_case1').addClass('wrong');
        $('#m_email_div .txt_case1').css('color', '#F50057');
        // 휴대폰 번호 미 입력
        console.log("이메일 중복체크");

    } else if ($('#m_phone').val() == '') {
        $('#m_phone_num_btn').attr('disabled', true);
        $('#m_phone').focus();
        console.log("핸드폰 없음");

        // 번호가 다른 번혼데 인증번호 미 입력
    } else if (  past_phone != $('#m_phone').val() && $('#m_phone_num').val() == '' ) {
        $('#m_phone_num').focus();

        console.log( "인증번호 미입력");
    } else if ($('#j_birth_div .txt_case1').hasClass('wrong') == true) {
        $('#m_birth_year').focus();

        console.log("생년월일 ㅜ");
    }
    /* 일반회원 사항 확인 --------------------*/
    else if (past_platform == '일반') {
        console.log("일반회원일때 비밀번호 검증");

        //신규 비밀번호 활성화 되어있는지 확인
        newPwd = $('input[name="pwdChange"]:checked').val();
        // 신규 비밀번호 활성화 시킨 후 미입력
        if ($($('input[name="pwdSwitch"]')).prop("checked") && $('#m_pwd').val() == '') {

            $('#m_pwd_div').css('display', 'block');
            $('#m_pwd_div .txt_case1').addClass('wrong');
            $('#m_pwd_div .txt_case1').css('color', '#F50057');
            // 재비밀번호 미입력
            console.log("비밀번호 1번 ");
        } else if ($($('input[name="pwdSwitch"]')).prop("checked") && $('#m_chk_pwd').val() == '') {
            $('#m_pwd_check_div').css('display', 'block');
            $('#m_pwd_check_div .txt_case1').addClass('wrong');
            $('#m_pwd_check_div .txt_case1').css('color', '#F50057');
            console.log("비밀번호 2번 ");
            // 비밀번호 불일치
        } else if ($($('input[name="pwdSwitch"]')).prop("checked") &&
            $(' #m_pwd').val() != $('#m_chk_pwd').val()) {

            $('#m_pwd_check_div').css('display', 'block');
            $('#m_pwd_check_div .txt_case1').addClass('wrong');
            $('#m_pwd_check_div .txt_case1').css('color', '#F50057');

            console.log("비밀번호 3번 ");
            //필수 ** 현재 비밀번호 확인!
        } else if ($('#pastPwdIs').val() == '') {
            $('#pastPwdIs').focus();
            console.log("비밀번호 488 ");
        } else {
            console.log("비밀번호 488 ",$('#pastPwdIs').val());
            //    일반회원 비밀번호 확인 !!!! 필수
            modifySubmit();
/*
            $.ajax({
                type: 'post',
                url: '/dangjang/shop/member/loginOk',
                data: {'pwd' : $('#pastPwdIs').val()},
                dataType: 'text',
                success: function(data){
                    if(data == 'loginOk'){
                        console.log("드디어 등록하러 간다 일반회원@@");
                        modifySubmit();
                    } else {
                        alert('비밀번호가 일치하지 않습니다.');
                    };
                },
                error: function(er){
                    console.log(er);
                }
            });
*/
        }
    } else{
        modifySubmit();
        console.log("드디어 등록하러 간다 일반회원@@");


    }


});


function modifySubmit() {
    console.log("modifysumit ");
    var realPwd = $('#pastPwdIs').val();
    var realGender = '남자';

    if ($('#m_pwd').val() != '') {
        realPwd = $('#m_pwd').val();
    }

    if ($('input[name="sex"]:checked').val() == 'w') {
        realGender = '여자';
    }
    var tel = $('#m_birth_year').val();
    if ($('#m_birth_month').val().length == 1) {
        tel += '0';
    }
    tel += $('#m_birth_month').val();
    if ($('#m_birth_day').val().length == 1) {
        tel += '0';
    }
    tel += $('#m_birth_day').val();


    $.ajax({
        type: 'get',
        url: '/dangjang/mypage/member/updateMember',
        data: {
            'seq_member': past_seq_member,
            'platform': past_platform,
            'pwd': realPwd,
            'nickname': $('#m_nickname').val(),
            'email1': $('#m_email').val().split("@")[0],
            'email2': $('#m_email').val().split("@")[1],
            'phone': $('#m_phone').val(),
            'gender': realGender,
            'birth': tel
        },
        // dataType: 'text',
        success: function(data) {
            data=data.trim();
            if(data == "success") {
                alert("회원정보가 정상적으로 수정되었습니다.");
                console.log("");
                location.reload();
            }

        },
        error: function (err) {
            console.log(err);
        }
    });

}
//*================================================================*/
//비밀번호 change event */

$(document).on('click', 'input[name="pwdSwitch"]', function () {
    var isOn = $('input[name="pwdSwitch"]');
    console.log($(isOn).prop("checked"));
    if ($(isOn).prop("checked")) {
        //true = 새로운 비밀번호 설정
        $('#m_pwd').attr("placeholder", "신규 비밀번호를 입력해주세요");
        $('#m_pwd').attr("readonly", false);

        /*        $('.m_chk_pwd_Area').css('display', '');
                $('.insertPwd .hint_txt').css('display', 'flex');*/
    } else {
        // 기존 비밀번호 사용
        $('#m_pwd').val("");
        $('#m_pwd').removeAttr("placeholder");
        $('#m_pwd').attr("readonly", true);
        $('.m_chk_pwd_Area, #m_pwd_div, #pwdCancel,#m_chk_pwd_div').css('display', 'none');

    }

});

/* 회원탈퇴 */



//*================================================================*/
// 01-1 pwd 유효성 검사
var pwdRegExp = /^(?=.*[a-zA-Z])(?=.*[~!@#$%^&*])(?=.*\d)[a-zA-Z\d!@#$%^*]{8,16}$/g;
var sameNumRegExp = /(\d)\1\1$/;

$('#m_pwd').keyup(function () {

    if ($($('input[name="pwdSwitch"]')).prop("checked")) {
        $('.m_chk_pwd_Area').css('display', '');
        $('.insertPwd .hint_txt').css('display', 'flex');
    }

    // 개수
    if ($('#m_pwd').val().length >= 8 && $('#m_pwd').val().length <= 16) {
        $('#m_pwd_div .txt_case1').css('display', 'none');
    } else {
        $('.txt_case1').css('display', '');
        $('#m_pwd_div .txt_case1').removeClass('great');
        $('#m_pwd_div .txt_case1').addClass('wrong');
        $('#m_pwd_div .txt_case1').css('color', '#F50057');
    }
    // 문자 조합
    if (pwdRegExp.test($('#m_pwd').val()) == true && sameNumRegExp.test($('#m_pwd').val()) == false) {
        console.log('true');
        $('#m_pwd_div .txt_case2').css('display', 'none');
    } else {
        $('.txt_case2').css('display', '');
        $('#m_pwd_div .txt_case2').addClass('wrong');
        $('#m_pwd_div .txt_case2').css('color', '#F50057');
    }
});

// 01-2 repwd 유효성 검사
$('#m_chk_pwd').keyup(function () {
    console.log($('#m_pwd').val().length != 0);
    if ($('#m_pwd').val().length != 0 && $('#m_chk_pwd').val() == $('#m_pwd').val()) {
        console.log("성공");
        $('#m_chk_pwd_div .txt_case1').css('display', 'none');
    } else {
        $('#m_chk_pwd_div .txt_case1').css('display', '');
        $('#m_chk_pwd_div .txt_case1').addClass('wrong');
        $('#m_chk_pwd_div .txt_case1').css('color', '#F50057');
    }
});

// 02-1 닉넴 유효성 검사
var nickNameRegExp = /^[ㄱ-ㅎ|가-힣|a-z|A-Z|0-9]+$/;

$('#m_nickname').keyup(function () {
    $("#m_nickname_btn").attr("data-possible", false);
    $('.nick_txt_case').css('display', 'none');

    if ($('#m_nickname').val().length == 0) {
        console.log("닉네임 생각 없음");
        $('#m_nickname_div').css('display', 'none');
        $('#nickname').value('');
    } else {
        /*$('#m_nickname_div').css('display', '');*/
        $('#m_nickname_div').css('display', 'flex');
    }
    console.log(nickNameRegExp.test($('#m_nickname').val()));

    if (nickNameRegExp.test($('#m_nickname').val()) == false) {
        document.getElementById('m_nickname').value = '';
        $('#m_nickname_div .txt_case1').addClass('wrong');
        $('#m_nickname_div .txt_case1').css('color', '#F50057');
    } else if (nickNameRegExp.test($('#m_nickname').val()) == true) {
        $('#m_nickname_div .txt_case1').css('display', 'none');

    }
});

// 02-2 닉네임 중복확인
$('#m_nickname_btn').click(function () {
    console.log("확인");
    console.log(document.getElementById('m_nickname').value);
    var newNickname = document.getElementById('m_nickname').value;

    if (newNickname == past_nickname) {
        console.log("현재닉네임");
        alert("기존 닉네임입니다.");
    } else if (newNickname == '') {
    } else {
        $.ajax({
            type: 'post',
            url: '/dangjang/shop/member/join/overlapCheck',
            data: 'nickname=' + $('#m_nickname').val(),
            async: false,
            success: function (data) {
                alert(data);
                if (data == false) {
                    $('#m_nickname_div .txt_case2').removeClass('wrong');
                    $('#m_nickname_div .txt_case2').addClass('great');
                    $('#m_nickname_div .txt_case2').css('color', '#00ACC1');
                    //중복확인 했을때만 true
                    $('#m_nickname_btn').attr('data-possible', true);

                } else {
                    $('#m_nickname_div .txt_case2').removeClass('great');
                    $('#m_nickname_div .txt_case2').addClass('wrong');
                    $('#m_nickname_div .txt_case2').css('color', '#F50057');
                }
            },
            error: function (err) {
                console.log(err);
            }
        })
    }
});


// 03-1 email 입력 여부
$('#m_email').keyup(function () {
    //중복확인 했을때만 true
    $('#m_email_btn').attr('data-possible', false);
    if ($('#m_email').val() != '') {
        $('#m_email_div').css('display', 'flex');
        $('#m_email_div .txt_case1').removeClass('great');
        $('#m_email_div .txt_case1').addClass('wrong');
        $('#m_email_div .txt_case1').css('color', '#F50057');
    }
});

// 03-2  이메일 중복 체크
$('#m_email_btn').click(function () {
    console.log("  중복체크", $('#m_email').val());
    if ($('#m_email').val() == past_email) {
        console.log("기존 이메일");
        alert("기존 이메일 입니다.");
    } else if ($('#m_email').val() == '') {
        alert("이메일을 입력해주세요.");
    } else {
        $.ajax({
            type: 'post',
            url: '/dangjang/shop/member/join/overlapCheck',
            data: 'email=' + $('#m_email').val(),
            async: false,
            success: function (data) {
                if (data == false) { // 사용 가능
                    //$('#email').val($('#m_email').val());
                    // 문구 okay~
                    $('#m_email_div .txt_case1').removeClass('wrong');
                    $('#m_email_div .txt_case1').addClass('great');
                    $('#m_email_div .txt_case1').css('color', '#00ACC1');
                    //중복확인 했을때만 true
                    $('#m_email_btn').attr('data-possible', true);

                } else { // 이미 존재하는 이메일
                    alert('이미 가입하신 이메일입니다.');
                    $('#m_email_div .txt_case1').removeClass('great');
                    $('#m_email_div .txt_case1').addClass('wrong');
                    $('#m_email_div .txt_case1').css('color', '#F50057');
                }
            },
            error: function (err) {
                console.log(err);
            }
        })
    }
});

// 04-1  핸드폰번호 유효성검사
var phoneRegExp = /^[0-9]+$/g;
$('#m_phone').keyup(function () {
    //중복확인 했을때만 true
    $('#m_phone_num_check_btn').attr('data-possible', false);
    console.log(phoneRegExp.test($('#m_phone').val()));

    if (phoneRegExp.test($('#m_phone').val()) == true) {
        console.log('맞아!');
    } else if (phoneRegExp.test($('#m_phone').val()) == false) {
        console.log('틀린 값!');
        document.getElementById('m_phone').value = '';
    }

    if ($('#m_phone').val().length < 10 && $('#m_phone').val().length > 6) {
        $('.m_chk_tel_Area').css('display', '');
    }
});

// 전화번호 중복확인(=인증번호 받기) --------------------------------------------------
$('#m_phone_btn').click(function () {
    if ($('#m_phone').val() == '') {

        alert("전화번호를 입력해주세요.");
    } else if ($('#m_phone').val() == past_phone) {
        alert("기존 휴대전화입니다.");
        $('.m_chk_tel_Area').css('display', 'none');
    } else if ($('#m_phone_num_btn').val() != '재발송') {
        // 중복 체크 먼저
        $.ajax({
            type: 'post',
            url: '/dangjang/shop/member/join/overlapCheck',
            data: 'phoneNumber=' + $('#m_phone').val(),
            async: false,
            success: function (data) {
                // 중복일 경우 이미 가입한 전화번호라고 모달 표시,
                // 중복 아닐 경우 인증번호 발송
                //alert(data);
                if (data == false) { // <- 중복 아님!
                    // 인증번호 발송 -> 전화번호 readonly 처리
                    $('#m_phone').attr('readonly', true);
                    // countDown 함수 시작
                    countDown_m();
                    // 카운트 컬러 변경
                    $('#m_phone_num_count').css('color', '#F50057');
                    // 인증번호 받기 -> 재발송 버튼으로 변경 but 비활성화
                    $('#m_phone_btn').val('재발송');
                    $('#m_phone_btn').attr('data-check', false);
                    // 인증번호 비동기 처리
                    $.ajax({
                        type: 'post',
                        url: '/dangjang/shop/member/mobile',
                        data: {'phoneNumber': $('#m_phone').val()},
                        dataType: 'text',
                        success: function (data) {
                            if (data == 'sendingOk') {
                                console.log('전송 성공~');
                            }
                        },
                        error: function (err) {
                            console.log(err);
                        }
                    });
                } else {
                    // 모달 처리 예정
                    alert('이미 가입하신 전화번호 입니다.');
                }
            },
            error: function (err) {
                console.log(err);
            }
        });
    } else {
        // value가 재발송일 때
        // countDown 함수 시작
        countDown_m();
        // 카운트 컬러 변경
        $('#m_phone_num_count').css('color', '#F50057');
        // 인증번호 비동기 처리
        $.ajax({
            type: 'post',
            url: '/dangjang/shop/member/mobile',
            data: {'phoneNumber': $('#m_phone').val()},
            dataType: 'text',
            success: function (data) {
                if (data == 'sendingOk') {
                    console.log('전송 성공~');
                }
            },
            error: function (err) {
                console.log(err);
            }
        });
    }
});


// countDown
function timeFormat(num) {
    return num < 10 ? "0" + num : num;
}

function countDown_m() {
    // 3분 count down
    let duration = 60 * 3;

    function countStart() {
        let disDue = --duration;
        if (disDue < 0) {
            clearInterval(modifyFormTimer); // parameter로 elemeter 받으면 한 개 함수로 여러 부분에서 사용 가능 - 나중에 처리할 예정
            document.getElementById('m_phone_num_count').innerText = '00:00';
            // 재발송 버튼 활성화
            $('#m_phone_btn').attr('data-check', '1');
            // 확인 버튼 비활성화
            $('#m_phone_num_check_btn').attr('data-check', '0');
        }

        let min = Math.floor(disDue / 60);
        let sec = Math.floor(disDue % 60);
        document.querySelector('#m_phone_num_count').innerText = `${timeFormat(min)}:${timeFormat(sec)}`;
    }

    var modifyFormTimer = setInterval(countStart, 1000);
    //console.log(timer);
}


// 04-3  인증번호
// 인증번호 유효성 (숫자만 4자리)
var chkNumRegExp = /^[0-9]+$/g;
$('#m_phone_num').keyup(function () {

    console.log(chkNumRegExp.test($('#m_phone_num').val()));
    if (chkNumRegExp.test($('#m_phone_num').val()) == true) {
        console.log('맞아!');
    } else if (chkNumRegExp.test($('#m_phone_num').val()) == false) {
        console.log('틀린 값!');
        document.getElementById('j_phone_num').value = '';
    }

    if ($('#m_phone_num').val().length == 4) {
        $('#m_phone_num_check_btn').attr('data-check', true);
    } else {
        $('#m_phone_num_check_btn').attr('data-check', false);
    }
})


// 04-4 인증번호 확인
$('#m_phone_num_check_btn').click(function () {
    // 1. 발급 번호와 일치하는지 확인
    // 2. 일치하면 휴대폰 번호, 인증번호 input은 readonly로 변경
    if ($(this).data('check') == true) {
        $.ajax({
            type: 'post',
            url: '/dangjang/shop/member/certify',
            data: {'certifyNum': $('#m_phone_num').val()},
            dataType: 'text',
            success: function (data) {
                if (data == 'Ok') {
                    console.log('인증번호 일치');
                    // 인증번호 readonly 처리
                    $('#m_phone_num').attr('readonly', true);
                    // 시간 stop
                    clearInterval(modifyFormTimer); // timer stop
                    document.getElementById('m_phone_num_count').innerText = ''; // 시간 없애기
                    $('.m_chk_tel_Area').css('display', 'none');
                    console.log('인증번호 area없애기');
                    //인증번호 완료 - 중복확인 했을때만 true
                    $('#m_phone_num_check_btn').attr('data-possible', true);
                } else {
                    // 틀렸다고 modal 알림 해조야해
                    alert('fail');
                    console.log('인증번호 불일치');
                }
            },
            error: function (err) {
                console.log(err);
            }
        });
    }

});


//05-1 생년월일 유효성 검사
$('#m_birth_year,#m_birth_month,#m_birth_day').blur(function () {

        const toyear = new Date().getFullYear();
        console.log(toyear);
        const b_year = Number($('#m_birth_year').val());
        const b_month = Number($('#m_birth_month').val());
        const b_day = Number($('#m_birth_day').val());
        console.log(b_year);
        var phoneRegExp = /^[0-9]+$/g;

        if (b_year < 1900 || b_year > toyear) {
            console.log('틀린 값!');
            document.getElementById('m_birth_year').value = '';
            $('#m_birth_div .txt_case1').removeClass('great');
            $('#m_birth_div .txt_case1').addClass('wrong');
            $('#m_birth_div .txt_case1').css('color', '#F50057');
        } else if (isNaN(b_year)) {
            document.getElementById('m_birth_year').value = '';
            $('#m_birth_div .txt_case1').removeClass('great');
            $('#m_birth_div .txt_case1').addClass('wrong');
            $('#m_birth_div .txt_case1').css('color', '#F50057');
        } else if (b_month < 1 || b_month > 12) {
            console.log('틀린 값!');
            document.getElementById('m_birth_month').value = '';
            $('#m_birth_div .txt_case1').removeClass('great');
            $('#m_birth_div .txt_case1').addClass('wrong');
            $('#m_birth_div .txt_case1').css('color', '#F50057');
        } else if (isNaN(b_month)) {
            console.log('틀린 값!');
            document.getElementById('m_birth_month').value = '';
            $('#m_birth_div .txt_case1').removeClass('great');
            $('#m_birth_div .txt_case1').addClass('wrong');
            $('#m_birth_div .txt_case1').css('color', '#F50057');
        } else if (b_day < 1 || b_day > 31) {
            console.log('틀린 값!');
            document.getElementById('m_birth_day').value = '';
            $('#m_birth_div .txt_case1').removeClass('great');
            $('#m_birth_div .txt_case1').addClass('wrong');
            $('#m_birth_div .txt_case1').css('color', '#F50057');
        } else if (isNaN(b_day)) {
            console.log('틀린 값!');
            document.getElementById('m_birth_day').value = '';
            $('#m_birth_div .txt_case1').removeClass('great');
            $('#m_birth_div .txt_case1').addClass('wrong');
            $('#m_birth_div .txt_case1').css('color', '#F50057');
        } else {
            $('#m_birth_div .txt_case1').removeClass('wrong');
            $('#m_birth_div .txt_case1').addClass('great');
            $('#m_birth_div .txt_case1').css('color', '#00ACC1');
        }
    }
)
;
$('#m_birth_year, #m_birth_month, #m_birth_day').focus(function () {
    $('.j_birth').css('border', '1.5px solid #1A237E');
    $('#m_birth_div').css('display', 'block');
})


/*비밀번호 관련  */
/*비밀번호 관련  */
// 회원 탈퇴
$('#deleteMember').click(function() {
    $.ajax({
        type: 'post',
        url: '/dangjang/mypage/member/withdrawal',
        dataType: 'text',
        success: function (data) {
            data = data.trim();
            if(data == "success") {
                alert("성공적으로 탈퇴되었습니다");
                console.log("ㅜㅜ탈퇴 성공");
            }
        },
        error: function (err) {
            console.log(err);
        }
    });
});

function deleteMember() {

    $.ajax({
        type: 'post',
        url: '/dangjang/mypage/member/withdrawal',
        dataType: 'json',
        success: function (data) {
            alert("성공적으로 탈퇴되었습니다");
            console.log("ㅜㅜ탈퇴 성공");

        },
        error: function (err) {
            console.log(err);
        }
    });

}