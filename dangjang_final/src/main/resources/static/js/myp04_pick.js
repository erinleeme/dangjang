$(document).on("click",'#checkAll',function() {
    if($("#checkAll").is(":checked")) $("input[name=checkPdt]").prop("checked", true);
    else $("input[name=checkPdt]").prop("checked", false);
    $("input[name=checkPdt]").click(function() {
        var total = $("input[name=checkPdt]").length;
        var checked = $("input[name=checkPdt]:checked").length;

        if(total != checked) $("#checkAll").prop("checked", false);
        else $("#checkAll").prop("checked", true);
    });

});

//다수 상품 장바구니 보내기
//선택 상품 장바구니 보내기 전 체크하기
function checkAddCart() {
    var productSum = $("#checkAll").data("pdcount");
    console.log("test 총 갯수",productSum);
    var productKeies = [];
    $("input[name=checkPdt]:checked").each(function() {
        var pdt_no = $(this).data("productno");
        productKeies.push(pdt_no);
    });
    console.log(productKeies);


    if( productSum == 0 ){
        alert("찜한 상품이 없습니다.");
    } else if (productKeies.length == 0) {
        alert("상품을 선택해 주세요.");
    } else {
        $.ajax({
            url : "/dangjang/shop/cart/insertList",
            type: "POST",
            data: { "productSeq": productKeies },
            dataType: "json",
            success: function(data) {
                if (data == "success") {
                    alert("장바구니에 담겼습니다.");
                } else {
                    alert("실패");
                }
            },
            error: function(err){
                console.log(err);
            }
        });

    }
}



// 찜한상품 삭제
$(document).on('click','.deletePickProd',function(){
    var pickid =  $(this).data('pickid');
    console.log(pickid,"삭제시작");
    $.ajax({
        url : "/dangjang/mypage/favorite/deleteFavorite",
        type: "POST",
        data: {'id' : pickid},
        dataType: "json",
        success: function(data) {
            if (data == "deletePickPd") {
                alert("상품 삭제완료.");

            }
            else {
                alert("실패");
            }
        },
        error: function(err){
            console.log(err);
        }
    });
});


// 화면 띄우기
$(function(){
    $.ajax({
        type: 'GET',
        url: '/dangjang/mypage/favorite/myFavoriteList',
        dataType: 'text',
        success: function(data){
            //console.log(data);
            $('#pickHtml').html(data);
        },
        error:  function(err){
            alert(JSON.stringify(err));
        }
    });
});

