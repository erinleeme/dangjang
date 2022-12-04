$(function(){
    productView('#product_set_1', $('#product_set_1').attr('data-cat'));
    productView('#product_set_3', $('#product_set_3').attr('data-cat'));
    productView('#product_set_4', $('#product_set_4').attr('data-cat'));
    productView('#product_set_5', $('#product_set_5').attr('data-cat'));
    productView('#product_set_6', $('#product_set_6').attr('data-cat'));
    productView('#product_set_7', $('#product_set_7').attr('data-cat'));
})

function productView(element, category){ // element = main div 이름, order = main 순서
    $.ajax({
        type: 'post',
        url: '/dangjang/shop/main/productSet',
        data: 'category=' + category,
        dataType: 'json',
        success: function(data){ // productList, productImageList 전달
            console.log(data);
            $.each(data.productList, function(index, items){ // 10개 가져와서 slider로 넘겨 보여주기
                let product_view = '<div class="product_one main_list" data-index="'+ index +'">';
                product_view += '<div class="product_img"><img src="/images/' + data.productImageList[index].serial_number + '.jpg" onclick="productDetail(' + items.seq_product + ')"></div>';
                product_view += '<div class="product_name" onclick="productDetail(' + items.seq_product + ')"><span>' + items.name + '</span></div>';
                product_view += '<div class="product_price">';
                if(items.discount_price != 0){
                    product_view += '<span class="d_price"><b class="d_ratio">' + items.discount_rate + '%</b>' + priceToString(items.discount_price) + '원</span>';
                    product_view += '<span class="o_price haveDiscount">' + priceToString(items.price) + '원</span>';
                } else {
                    product_view += '<span class="o_price">' + priceToString(items.price) + '원</span>';
                }
                product_view += '</div>';
                product_view += '<div class="product_state"><span>' + items.storage_method + '</span></div>';
                product_view += '<div class="product_reviewAndPick"><img class="p_review_icon" src="/icon/review_icon.png" />';
                product_view += '<span class="product_review">' + data.reviewCount[index] + '</span>';
                product_view += '<img class="p_pick_icon" src="/icon/heart.png" />';
                product_view += '<span class="product_pick">' + data.pickCount[index] + '</span></div>';
                product_view += '</div>';

                $(element).append(product_view);
            });
        },
        error: function(err){
            console.log(err);
        }
    });
}

$(function(){
    $('.main_banner #slick-slider-main').slick({
        slide: 'div',
        infinite: true,
        slidesToShow: 1,
        slidesToScroll: 1,
        speed: 500,
        arrows: false,
        dots: false,
        autoplay: true,
        autoplaySpeed: 10000,
        pauseOnHover: false,
        draggable: true
    });
});

$(function(){
    $('.random_line_banner').slick({
        slide: 'div',
        infinite: true,
        slidesToShow: 1,
        slidesToScroll: 1,
        speed: 500,
        arrows: false,
        dots: false,
        autoplay: true,
        autoplaySpeed: 10000,
        pauseOnHover: false,
        draggable: true
    });
});

// slick Slider
// $(function(){
//    $('#product_set_1, #product_set_3, #product_set_4, #product_set_5, #product_set_6, #product_set_7').slick({
//        slide: 'div',
//        infinite: true,
//        arrows: true,
//        dots: false,
//        autoplay: false,
//        pauseOnHover: false,
//        draggable: false
//    });
// });