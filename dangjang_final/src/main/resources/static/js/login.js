// 회원가입 btn 클릭
$('.btn_l_join').click(function(){
    location.href="/dangjang/shop/member/join/list";
})

// 로그인 btn 클릭
$('.btn_login').click(function(){
    $('#loginCheckMsg').empty();

    if($('#userId').val() == ''){
        $('#loginCheckMsg').text('아이디 또는 비밀번호 오류입니다.');
    } else if($('#userPwd').val() == ''){
        $('#loginCheckMsg').text('아이디 또는 비밀번호 오류입니다.');
    } else {
        $.ajax({
            type: 'post',
            url: '/dangjang/shop/member/loginOk',
            data: $('#loginForm').serialize(),
            dataType: 'text',
            success: function(data){
                if(data == 'loginOk'){
                    location.href='/dangjang/shop/main';
                } else {
                    $('#userId').css('border', '1px solid #F50057');
                    $('#userPwd').css('border', '1px solid #F50057');
                    $('#loginCheckMsg').text('아이디 또는 비밀번호 오류입니다.');
                };
            },
            error: function(er){
                console.log(er);
            }
        });
    }
});

// kakao login btn click
window.Kakao.init("2d82a7af3b69fbc0893a78b918f0cdc1");
$('.kakao_Login_btn').click(function(){
    window.Kakao.Auth.login({
        scope:'profile_nickname, account_email, gender, birthday',
        success: function(authObj) {
            console.log(authObj);
            window.Kakao.API.request({
                url:'/v2/user/me',
                success: res => {
                    const kakao_account = res.kakao_account;
                    //console.log(kakao_account);
                    $.ajax({
                        type: 'post',
                        url: '/dnagjang/shop/member/kakaoLogin',
                        data: {
                            'kakao_account': kakao_account,
                            'social': 'kakao'
                        },
                        dataType: 'text',
                        success: function(data){ // fail
                            data = data.trim();
                            if(data == 'ok')
                                location.href="/dangjang/shop/main";
                            else if(data == 'fail'){
                                $.ajax({
                                    type: 'POST',
                                    url: '/dangjang/shop/member/join/kakaoSession',
                                    data: {
                                        'kakao_account': kakao_account,
                                        'social': 'kakao'
                                    },
                                    success: function (data) {
                                        console.log(data);
                                        location.href="/dangjang/shop/member/join/kakao";
                                    },
                                    error: function(err){
                                        console.log(err);
                                    }
                                });
                            }
                        },
                        error: function(err){
                            console.log(err);
                        }
                    });
                }
            });
        }
    });
});
