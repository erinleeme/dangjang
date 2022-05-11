
$(function(){
    eventProList("reco", '1')
})


// 이벤트 상품 리스트 가져오기기
function eventProList(listType, num){
    $.ajax({
        type: 'post',
        url: '/dangjang/shop/goods/eventProduct/list',
        data: {
            'listType': listType,
            'pg': $('#eventProductPg').val(),
        },
        success: function(data){ // productList, productListImages, productFavorite, productReview, productCount
            console.log(data);

            // 비우기
            $('#event_cat_goods_list .goods_count').empty();
            $('#event_cat_goods_list .product_view').empty();
            $('#event_cat_goods_list .pagingDiv').empty();

            // 상품 개수
            let productCout = '<span>총 ' + data.productCount + ' 개</span>';
            $('#event_cat_goods_list .goods_count').append(productCout);

            // 상품 리스트
            $.each(data.productList, function(index, items){
                let productList = '<div class="product_one">';
                productList += '<div class="product_img"><img src="/images/' + data.productListImages[index].serial_number + '.jpg" onclick="productDetail(' + items.seq_product + ')"></div>';
                productList += '<div class="product_name" onclick="productDetail(' + items.seq_product + ')"><span>'+items.name +'</span></div>';
                productList += '<div class="product_price">';
                if(items.discount_price != 0){
                    productList += '<span class="d_price"><b class="d_ratio">' + items.discount_rate + '%</b>' + priceToString(items.discount_price) + '원</span>';
                    productList += '<span class="o_price haveDiscount">' + priceToString(items.price) + '원</span>';
                } else {
                    productList += '<span class="o_price">' + priceToString(items.price) + '원</span>';
                }
                productList += '</div>';
                productList += '<div class="product_state"><span>' + items.storage_method + '</span></div>';
                productList += '<div class="product_reviewAndPick"><img class="p_review_icon" src="/icon/review_icon.png" />';
                productList += '<span class="product_review">' + data.reviewCount[index] + '</span>';
                productList += '<img class="p_pick_icon" src="/icon/heart.png" />';
                productList += '<span class="product_pick">' + data.pickCount[index] + '</span></div>';
                productList += '</div>'; // product_one div

                $('#event_cat_goods_list .product_view').append(productList);
            });

            // 페이징
            $('#event_cat_goods_list .pagingDiv').append(data.paging.pagingHTML);
        },
        error: function(err){
            console.log(err);
        }
    });
};

// 카테고리 리스트 (페이징)
function eventProListPaging(listType, pg){
    $.ajax({
        type: 'post',
        url: '/dangjang/shop/goods/eventProduct/list',
        data: {
            'listType': listType,
            'pg': pg,
        },
        success: function(data){ // productList, productListImages, productFavorite, productReview, productCount
            console.log(data);

            // 비우기
            $('#event_cat_goods_list .goods_count').empty();
            $('#event_cat_goods_list .product_view').empty();
            $('#event_cat_goods_list .pagingDiv').empty();

            // 상품 개수
            let productCout = '<span>총 ' + data.productCount + ' 개</span>';
            $('.categoryMain #cat_goods_list .goods_count').append(productCout);

            // 상품 리스트
            $.each(data.productList, function(index, items){
                let productList = '<div class="product_one">';
                productList += '<div class="product_img"><img src="/images/' + data.productListImages[index].serial_number + '.jpg" onclick="productDetail(' + items.seq_product + ')"></div>';
                productList += '<div class="product_name" onclick="productDetail(' + items.seq_product + ')"><span>'+items.name +'</span></div>';
                productList += '<div class="product_price">';
                if(items.discount_price != 0){
                    productList += '<span class="d_price"><b class="d_ratio">' + items.discount_rate + '%</b>' + priceToString(items.discount_price) + '원</span>';
                    productList += '<span class="o_price haveDiscount">' + priceToString(items.price) + '원</span>';
                } else {
                    productList += '<span class="o_price">' + priceToString(items.price) + '원</span>';
                }
                productList += '</div>';
                productList += '<div class="product_state"><span>' + items.storage_method + '</span></div>';
                productList += '<div class="product_reviewAndPick"><img class="p_review_icon" src="/icon/review_icon.png" />';
                productList += '<span class="product_review">' + data.reviewCount[index] + '</span>';
                productList += '<img class="p_pick_icon" src="/icon/heart.png" />';
                productList += '<span class="product_pick">' + data.pickCount[index] + '</span></div>';
                productList += '</div>'; // product_one div

                $('#event_cat_goods_list .product_view').append(productList);
            });

            // 페이징
            $('#event_cat_goods_list .pagingDiv').append(data.paging.pagingHTML);
        },
        error: function(err){
            console.log(err);
        }
    });
};

// 정렬 유형 선택
$('#event_cat_goods_list .attr_type ul li a').click(function(){
    console.log($(this).attr('id'));
    // listType
    eventProList($(this).attr('id'), "1");
    // attr_choose 추가해주기
    // 기존 attr_choose 제거
    let preChoice = document.querySelector('#event_cat_goods_list .attr_choose').removeAttribute('class');
    $(this).attr('class', 'attr_choose');
})

// 페이징
function eventProductPaging(pg2){
    let listType = document.querySelector('#event_cat_goods_list .attr_choose').getAttribute('id');
    eventProListPaging(listType, pg2)
}