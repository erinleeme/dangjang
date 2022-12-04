


function mypageAddCart(puductId){
    $.ajax({
        type: 'post',
        url: '/dangjang/shop/cart/insert',
        data: {
            'seq_product': puductId,
            'count': '1'
        },
        success: function(data){
            if(data == 'insertOk'){
                console.log("success cart", puductId);
            }
        }
    });
    alert("장바구니에 담겼습니다");
}



function myQnaDirect(){
    location.href="/dangjang/mypage/qna#my";
    $("#btnPerQuestion").trigger('click');
    $(document).ready(function(){
        $("#btnPerQuestion").trigger('click');
    });
}