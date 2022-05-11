// 공지사항 상세보기 - 전체보기 클릭
$('#backto_csNoticeList').click(function(){
    location.href='/dangjang/shop/cs/notice?pg='+$('#noticeOnePg').val();
});

function moveToOneToOne(){
    location.href='/dangjang/mypage/qna';
}

function moveToLogin(){
    location.href='/dangjang/shop/member/login';
}
