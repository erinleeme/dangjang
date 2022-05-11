// pwd 유효성 검사
pwdRegExp = /^(?=.*[a-zA-Z])(?=.*[~!@#$%^&*])(?=.*\d)[a-zA-Z\d!@#$%^*]{8,16}$/g;
sameNumRegExp = /(\d)\1\1$/;
$('#d_repwd, #d_repwd_chk').keyup(function(){
    // 개수
    if($('#d_repwd').val().length >= 8 && $('#d_repwd').val().length <= 16) {
        $('#r_pwd_div .txt_case1').removeClass('wrong');
        $('#r_pwd_div .txt_case1').addClass('great');
        $('#r_pwd_div .txt_case1').css('color', '#00ACC1');
    } else {
        $('#r_pwd_div .txt_case1').removeClass('great');
        $('#r_pwd_div .txt_case1').addClass('wrong');
        $('#r_pwd_div .txt_case1').css('color', '#F50057');
    }
    // 문자 조합
    if(pwdRegExp.test($('#d_repwd').val()) == true){
        console.log('true');
        $('#r_pwd_div .txt_case2').removeClass('wrong');
        $('#r_pwd_div .txt_case2').addClass('great');
        $('#r_pwd_div .txt_case2').css('color', '#00ACC1');
    } else if(pwdRegExp.test($('#d_repwd').val()) == false){
        $('#r_pwd_div .txt_case2').removeClass('great');
        $('#r_pwd_div .txt_case2').addClass('wrong');
        $('#r_pwd_div .txt_case2').css('color', '#F50057');
    }

    // 숫자 3글자 연속
    if(sameNumRegExp.test($('#d_repwd').val()) == true){
        $('#r_pwd_div .txt_case3').removeClass('great');
        $('#r_pwd_div .txt_case3').addClass('wrong');
        $('#r_pwd_div .txt_case3').css('color', '#F50057');
    } else if(sameNumRegExp.test($('#d_repwd').val()) == false){
        $('#r_pwd_div .txt_case3').removeClass('wrong');
        $('#r_pwd_div .txt_case3').addClass('great');
        $('#r_pwd_div .txt_case3').css('color', '#00ACC1');
    }
    // 비밀번호 일치 확인
    if($('#d_repwd').val() != $('#d_repwd_chk').val()){
        $('#r_pwd_check_div .txt_case1').removeClass('great');
        $('#r_pwd_check_div .txt_case1').addClass('wrong');
        $('#r_pwd_check_div .txt_case1').css('color', '#F50057');
    } else if($('#d_repwd').val() == $('#d_repwd_chk').val()){
        $('#r_pwd_check_div .txt_case1').removeClass('wrong');
        $('#r_pwd_check_div .txt_case1').addClass('great');
        $('#r_pwd_check_div .txt_case1').css('color', '#00ACC1');
        $('.d_repwd_btn').attr('disabled', false);
    }
});

$('.d_repwd_btn').click(function(){
   $.ajax({
       type: 'post',
       url: '/dangjang/shop/member/pwd/resetOk',
       data: $('.repwdForm').serialize(), // memId, d_repwd 전달
       success: function(){
           location.href='/dangjang/shop/member/login';
       },
       error: function(err){
           console.log(err);
       }
   });
});

$('#d_repwd').focus(function(){
    $('#r_pwd_div').css('display', 'block');
});

$('#d_repwd_chk').focus(function(){
    $('#r_pwd_check_div').css('display', 'block');
});

