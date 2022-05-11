// 시간 count down
const clock = document.getElementById('p_clock');

function countDown(){
    const dueHour = 24;
    const nowHour = new Date().getHours();
    const dueMin = 60;
    const nowMin = new Date().getMinutes();
    const dueSec = 60;
    const nowSec = new Date().getSeconds();

    const Hours = String(dueHour - nowHour - 1).padStart(2, "0");
    const Minutes = String(dueMin - nowMin).padStart(2, "0");
    const Seconds = String(dueSec - nowSec).padStart(2, "0");
    clock.innerText = `${Hours} : ${Minutes} : ${Seconds}`;
}

countDown();
setInterval(countDown, 1000);

// 상품 가져오기
$(function(){
    $.ajax({
        type: 'post',
        url: '/dangjang/shop/main/product_time',
        dataType: 'json',
        success: function(data){// bestProduct, bestProductImages 전달
            //console.log(data);
            $.each(data.bestProduct, function(index, items){ // 2개만 보내주세요. 기준은 베스트 TOP 2
                //console.log(index);
               let  product_one = '<div class="p_one" id='+ items.seq_product +'>';
                    product_one += '<div class="product_img"><img src="/images/'+ data.bestProductImages[index].serial_number +'.jpg" rel="상품 이미지" onclick="productDetail(' + items.seq_product + ')"/></div>';
                    product_one += '<div class="product_name" onclick="productDetail(' + items.seq_product + ')"><span>'+ items.name +'</span></div>';
                    product_one += '<div class="product_price">';
                if(items.discount_price != 0){
                    product_one += '<span class="d_price"><b class="d_ratio">' + items.discount_rate + '%</b>' + priceToString(items.discount_price) + '원</span>';
                    product_one += '<span class="o_price haveDiscount">' + priceToString(items.price) + '원</span>';
                } else {
                    product_one += '<span class="o_price">' + priceToString(items.price) + '원</span>';
                }
                    product_one += '</div>';
                    product_one += '<div class="product_state"><span>' + items.storage_method + '</span></div>';
                    product_one += '<div class="product_reviewAndPick"><img class="p_review_icon" src="/icon/review_icon.png" />';
                    product_one += '<span class="product_review">' + data.reviewCount[index] + '</span>';
                    product_one += '<img class="p_pick_icon" src="/icon/heart.png" />';
                    product_one += '<span class="product_pick">' + data.pickCount[index] + '</span></div></div>';

               $('.product_time_view .p_t_set').append(product_one);
            });
        },
        error: function(err){
            console.log(err);
        }
    });
});
// 더 보기 클릭
$('#more_p').click(function(){
    location.href='/dangjang/shop/goods/best';
});

