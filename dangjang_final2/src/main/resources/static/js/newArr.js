$(
    // 신상품 페이지 첫 로딩 시 default로 추천순 정렬 리스트 뽑아오기
    newArrList('reco')
);
// 가격 천 단위 콤마 정규표현식
function priceToString(price) {
    return price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
}
// 리스트 뽑아오기
function newArrList(listType){
    $.ajax({
        type: 'post',
        url: '/dangjang/shop/goods/newArr/list',
        data: {
            'listType': listType,
            'pg': $('#newArrpg').val()
        },
        dataType: 'json',
        success: function(data){// productList, imageList, productCount 전달
            // console.log(data);
            // console.log(data.productList);
            // console.log(data.imageList);
            // console.log(data.productCount);
            // console.log(data.reviewCount);
            // console.log(data.pickCount);

            // 비우기
            $('#newArrival_list .goods_count').empty();
            $('#newArrival_list .product_view').empty();
            $('#newArrival_list .pagingDiv').empty();

            // 상품 개수
            let productCount = '<span>총 ' + data.productCount + ' 개</span>';
            $('#newArrival_list .goods_count').append(productCount);

            // 상품 리스트
            for(let i = 0; i < data.productList.length; i++){
                let productList = '<div class="product_one">';
                productList += '<div class="product_img"><img src="/images/' + data.imageList[i].serial_number + '.jpg" onclick="productDetail(' + data.productList[i].seq_product + ')"></div>';
                productList += '<div class="product_name" onclick="productDetail(' + data.productList[i].seq_product + ')"><span>'+data.productList[i].name +'</span></div>';
                productList += '<div class="product_price">';
                if(data.productList[i].discount_price != 0){
                    productList += '<span class="d_price"><b class="d_ratio">' + data.productList[i].discount_rate + '%</b>' + priceToString(data.productList[i].discount_price) + '원</span>';
                    productList += '<span class="o_price haveDiscount">' + priceToString(data.productList[i].price) + '원</span>';
                } else {
                    productList += '<span class="o_price">' + priceToString(data.productList[i].price) + '원</span>';
                }
                productList += '</div>';
                productList += '<div class="product_state"><span>' + data.productList[i].storage_method + '</span></div>';
                productList += '<div class="product_reviewAndPick"><img class="p_review_icon" src="/icon/review_icon.png" />';
                productList += '<span class="product_review">' + data.reviewCount[i] + '</span>';
                productList += '<img class="p_pick_icon" src="/icon/heart.png" />';
                productList += '<span class="product_pick">' + data.pickCount[i] + '</span></div>';
                productList += '</div>'; // product_one div

                $('#newArrival_list .product_view').append(productList);
            }
            // 페이징
            $('#newArrival_list .pagingDiv').append(data.paging.pagingHTML);
        },
        error: function(err){
            console.log(err);
        }
    });
};

// 페이징 리스트 뽑아오기
function newArrListPaging(pg, listType){
    $.ajax({
        type: 'post',
        url: '/dangjang/shop/goods/newArr/list',
        data: {
            'listType': listType,
            'pg': pg
        },
        dataType: 'json',
        success: function(data){// productList, imageList, productCount 전달
            // console.log(data);
            // console.log(data.productList);
            // console.log(data.imageList);
            // console.log(data.productCount);
            // console.log(data.reviewCount);
            // console.log(data.pickCount);

            // 비우기
            $('#newArrival_list .goods_count').empty();
            $('#newArrival_list .product_view').empty();
            $('#newArrival_list .pagingDiv').empty();

            // 상품 개수
            let productCount = '<span>총 ' + data.productCount + ' 개</span>';
            $('#newArrival_list .goods_count').append(productCount);

            // 상품 리스트
            for(let i = 0; i < data.productList.length; i++){
                let productList = '<div class="product_one">';
                productList += '<div class="product_img"><img src="/images/' + data.imageList[i].serial_number + '.jpg" onclick="productDetail(' + data.productList[i].seq_product + ')"></div>';
                productList += '<div class="product_name" onclick="productDetail(' + data.productList[i].seq_product + ')"><span>'+data.productList[i].name +'</span></div>';
                productList += '<div class="product_price">';
                if(data.productList[i].discount_price != 0){
                    productList += '<span class="d_price"><b class="d_ratio">' + data.productList[i].discount_rate + '%</b>' + priceToString(data.productList[i].discount_price) + '원</span>';
                    productList += '<span class="o_price haveDiscount">' + priceToString(data.productList[i].price) + '원</span>';
                } else {
                    productList += '<span class="o_price">' + priceToString(data.productList[i].price) + '원</span>';
                }
                productList += '</div>';
                productList += '<div class="product_state"><span>' + data.productList[i].storage_method + '</span></div>';
                productList += '<div class="product_reviewAndPick"><img class="p_review_icon" src="/icon/review_icon.png" />';
                productList += '<span class="product_review">' + data.reviewCount[i] + '</span>';
                productList += '<img class="p_pick_icon" src="/icon/heart.png" />';
                productList += '<span class="product_pick">' + data.pickCount[i] + '</span></div>';
                productList += '</div>'; // product_one div

                $('#newArrival_list .product_view').append(productList);
            }
            // 페이징
            $('#newArrival_list .pagingDiv').append(data.paging.pagingHTML);
        },
        error: function(err){
            console.log(err);
        }
    });
};

// 정렬 유형 선택
$('#newArrival_list .attr_type ul li a').click(function(){
    console.log($(this).attr('id'));
    newArrList($(this).attr('id'));
    document.querySelector('#newArrival_list .attr_choose').removeAttribute('class');
    $(this).attr('class', 'attr_choose');
})

// 페이징
function newProductPaging(pg2){
    let listType = document.querySelector('#newArrival_list .attr_choose').getAttribute('id');
    newArrListPaging(pg2, listType)
}