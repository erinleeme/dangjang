
// 값 뿌려주기
$(function(){
    $.ajax({
        type: 'GET',
        url: '/dangjang/mypage/order/getOrderClaimList',
        dataType: 'text',
        success: function(data){
            /*console.log(data);*/
            $('#claimHtml').html(data);
        },
        error:  function(err){
            alert(JSON.stringify(err));
        }
    });
});

//content js 토글 열기

$(document).on("click",'.div_open',function(){
    console.log($(this))
    console.log($(this).next().css('display'))
    if ($(this).next().css('display') == 'none') {
        $(this).parent().addClass("info_on");
        $(this).next().attr('style', 'display: block');
    } else {
        $(this).parent().removeClass("info_on");
        $(this).next().attr('style', 'display: none');
    }
});

