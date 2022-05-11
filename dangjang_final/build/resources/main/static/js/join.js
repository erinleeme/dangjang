// 일반 회원가입 btm 클릭
$('.btn_d_join').click(function(){
    location.href="/dangjang/shop/member/join";
});

// kakao 회원가입
$('#joinByKakao').click(function(){
    window.Kakao.Auth.login({
        scope:'profile_nickname, account_email, gender, birthday',
        success: function(authObj) {
            console.log(authObj);
            window.Kakao.API.request({
                url:'/v2/user/me',
                success: res => {
                    const kakao_account = res.kakao_account;
                    console.log(kakao_account);
                    $.ajax({
                        type: 'POST',
                        url: '/dangjang/shop/member/join/kakaoSession',
                        data: {
                            'kakao_account': kakao_account,
                            'social': 'kakao'
                        },
                        success: function(){
                            location.href="/dangjang/shop/member/join/kakao";
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