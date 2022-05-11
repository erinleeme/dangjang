
// view
$(function(){
    $.ajax({
        type: 'GET',
        url: '/dangjang/mypage/order/getOrderList',
        dataType: 'text',
        success: function(data){
            $('#orderListHtml').html(data);
        },
        error:  function(err){
            alert(JSON.stringify(err));
        }
    });
});




// ?? 주문번호로 주문상세페이지
$(document).on('click','.',function(){
    var seq_order = $(this).data('ordernum');
    $.ajax({
        type: 'get',
        url: '/dangjang/mypage/order/orderDetail?seq_order=' + seq_order,
        error: function (err) {
            console.log(err);
        }
    })
});
