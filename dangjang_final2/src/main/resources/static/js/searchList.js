$(searchList('reco'));

function priceToString(price) {
    return price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
}

// 검색 상품 리스트
function searchList(listType){
    $.ajax({
        type: 'post',
        url: '/dangjang/shop/search/list',
        data: {
            'keyword': $('#searchKeyword').val(),
            'listType': listType,
            'pg': $('#searchListpg').val()
        },
        dataType: 'json',
        success: function(data){
            // searchList, searchImageList, searchCount, reviewCount, pickCount, paging 전달
            //console.log(data);
            // 비우기
            $('.searchResultMain .goods_count').empty();
            $('.searchResultMain .product_view').empty();
            $('.searchResultMain .pagingDiv').empty();

            // 총 상품 개수
            let productCount = '<span>총 ' + data.searchCount + ' 개</span>';
            $('#search_goods_list .goods_count').append(productCount);

            // 상품 리스트
            $.each(data.searchList, function(index, items){
                let productList = '<div class="product_one">';
                productList += '<div class="product_img"><img src="/images/' + data.searchImageList[index].serial_number + '.jpg" onclick="productDetail(' + items.seq_product + ')"></div>';
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

                $('#search_goods_list .product_view').append(productList);
            });

            // 페이징
            $('#search_goods_list .pagingDiv').append(data.paging.pagingHTML);
        },
        error: function (err){
            console.log(err);
        }
    });
};

// 검색 상품 리스트 페이징
function searchListPaging(listType, pg2){
    $.ajax({
        type: 'post',
        url: '/dangjang/shop/search/list',
        data: {
            'keyword': $('#searchKeyword').val(),
            'listType': listType,
            'pg': pg2
        },
        dataType: 'json',
        success: function(data){
            // searchList, searchImageList, searchCount, reviewCount, pickCount, paging 전달
            //console.log(data);
            // 비우기
            $('.searchResultMain .goods_count').empty();
            $('.searchResultMain .product_view').empty();
            $('.searchResultMain .pagingDiv').empty();

            // 총 상품 개수
            let productCount = '<span>총 ' + data.searchCount + ' 개</span>';
            $('#search_goods_list .goods_count').append(productCount);

            // 상품 리스트
            $.each(data.searchList, function(index, items){
                let productList = '<div class="product_one">';
                productList += '<div class="product_img"><img src="/images/' + data.searchImageList[index].serial_number + '.jpg" onclick="productDetail(' + items.seq_product + ')"></div>';
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

                $('#search_goods_list .product_view').append(productList);
            });

            // 페이징
            $('#search_goods_list .pagingDiv').append(data.paging.pagingHTML);
        },
        error: function (err){
            console.log(err);
        }
    });
};

// 정렬 유형 선택
$('#search_goods_list .attr_type ul li a').click(function(){
    console.log($(this).attr('id'));
    searchList($(this).attr('id'));
    document.querySelector('#search_goods_list .attr_choose').removeAttribute('class');
    $(this).attr('class', 'attr_choose');
})

function searchListPaging(pg2){
    let listType = document.querySelector('#search_goods_list .attr_choose').getAttribute('id');
    searchListPaging(pg2, listType);
}