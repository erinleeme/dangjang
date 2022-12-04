<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript" src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script type="text/javascript">

//kakao login
window.Kakao.init("2d82a7af3b69fbc0893a78b918f0cdc1");
function kakaoLogin() {
	
	window.Kakao.Auth.login({
		
		scope:'profile_nickname, account_email, gender',
		success: function(authObj) {
			
			console.log(authObj);
			
			window.Kakao.API.request({
				url:'/v2/user/me',
				success: res => {
					const kakao_account = res.kakao_account;
					console.log(kakao_account);
					
					$.ajax({
						type: 'post',
						url: '/SpringProject/member/kakaoLogin',
						data: {
							kakao_account
						},
						dataType: 'text',
						success: function(data){ // fail
							data = data.trim();
							if(data == 'ok')
								location.href="/SpringProject/index.jsp";
							
							else if(data == 'fail'){
								$.ajax({
									type: 'post',
									url: '/SpringProject/member/kakaoWriteForm',
									data: {
										kakao_account
									},
									dataType: 'text',
									success: function(data){
										data = data.trim();
										 alert(data);
									},
									error: function(err){
										alert(err);
									} // 여기까지 넘어와
								});
							}
						},
						error: function(err){
							alert(err);
						}
					});
				}
			});
		}
	});
}
</script>
</body>
</html>