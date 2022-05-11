$(function(){
    console.log($('#productDetail_seqProduct').val())
    showProductDetail($('#productDetail_seqProduct').val())
});

function showProductDetail(seq_product){
    $.ajax({
        type: 'post',
        url: '/dangjang/shop/product/detail',
        data: 'seq_product='+seq_product,
        success: function (data){
            console.log(data);
            // middleCategory, bigCategory, product, productImage,
            // randomProduct, randomProductImages
            // reviewList, pickCount, reviewCount

            // path
            let currentPath = '<a href="/dangjang/shop/main">홈</a>';
                currentPath += '<a href="/dangjang/shop/goods/category?categoryCode=' + data.bigCategory.code_name + '">' + data.bigCategory.category_name + '</a>';
                currentPath += '<a href="/dangjang/shop/goods/category?categoryCode=' + data.bigCategory.code_name
                                                                + '&subCategoryCode=' + data.middleCategory.id + '"><strong>' + data.middleCategory.category_name + '</strong></a>';
            $('.currentPath').append(currentPath);

            // 이미지 추가
            let productImg = '<img src="/images/' + data.productImage.serial_number + '.jpg" alt="상품이미지">';
            $('.detail_imgWrap').append(productImg);

            // detailStar
            let detailStar = '<a href="#product_reviewSection">' + data.reviewScore + ' (' + data.reviewCount + ')</a>';
            $('.detailStar').append(detailStar);

            // randomProduct
            $.each(data.randomProduct, function(index, items){
                let listItem = '<div class="listItem">';
                    listItem += '<a class="li_item_img" onclick="productDetail(' + items.seq_product + ')">';
                    listItem += '<img src="/images/' + data.randomProductImages[index].serial_number + '.jpg" alt="상품이미지">';
                    listItem += '</a>';
                    listItem += '<span class="li_item_title">' + items.name + '</span>';
                    listItem += '</div>';
                $('.cont_item').append(listItem);
            })

            // 상품 프로필
            let title = '<h3>' + data.product.name + '</h3>';
            $('.textSubject').append(title);

            let detail_price = '<dt>일반가</dt>';
                detail_price += '<dd>' + priceToString(data.product.price)  + '원</dd>';

            if(data.product.discount_price != 0){
                detail_price += '<dt>할인가</dt>';
                detail_price += '<dd>';
                detail_price += '<span class="detail_d_price">';
                detail_price += '<b>' + priceToString(data.product.discount_price) + '</b>원';
                detail_price += '</span>';
                detail_price += '<strong>' + data.product.discount_rate + '%</strong>';
                detail_price += '</dd>';
            }

            $('.detail_price').append(detail_price);

            $('.detail_normal .detail_state').text(data.product.storage_method);
            if(data.product.discount_price != 0){
                $('.detail_num').text(priceToString(data.product.discount_price));
                $('.detail_num').addClass('haveD');
            } else {
                $('.detail_num').text(priceToString(data.product.price));
            }

            // priceToString
        },
        error: function(err){
            console.log(err);
        }
    });

}

// 수량 빼기
onlyPrice = /[^0-9]/g;
function countMinus(element){
    let count = parseInt($(element).next().val());

    // 총 금액 가져오기
    let price = $('.detail_num').text(); // 현재 가격
    let realPrice = parseInt(price.replace(onlyPrice, "")); // , 빼주기

    // count 가 1일 때는 minus 못 함
    if(count != 1){

        realPrice /= count;
        // input value 변경
        count -= 1;
        $(element).next().val(count);

        // 가격 반영
        let totalPrice = realPrice * count;
        $('.detail_num').text(priceToString(totalPrice));
    }
}
// 수량 추가
function countPlus(element){
    let count = parseInt($(element).prev().val());

    // 총 금액 가져오기
    let price = $('.detail_num').text(); // 현재 가격
    let realPrice = parseInt(price.replace(onlyPrice, "")); // , 빼주기
    if(count != 1){
        realPrice /= count;
    }

    // input value 변경
    count += 1;
    $(element).prev().val(count);

    // 가격 반영
    let totalPrice = realPrice * count;
    $('.detail_num').text(priceToString(totalPrice));
}

// 장바구니 담기
const modalCart = document.querySelector('#cart_save_modal');
const modalCartBg = document.querySelector('#cart_modal_background');
$('.inCart_btn').click(function(){
    console.log($('.detail_number .item_detail_count .item_num').val());
    $.ajax({
       type: 'post',
       url: '/dangjang/shop/cart/insert',
       data: {
           'seq_product': $('#productDetail_seqProduct').val(),
           'count': $('.detail_number .item_detail_count .item_num').val()
       },
       success: function(data){
           if(data == 'insertOk'){
               // modal up
               modalCart.style.display = 'block';
               modalCartBg.style.display = 'block';
           }
       }
    });
})

$('#cart_save_modal_close').click(function(){
    modalCart.style.display = 'none';
    modalCartBg.style.display = 'none';
})

$('#cart_save_modal_btn').click(function(){
    location.href='/dangjang/shop/cart';
})

window.addEventListener("keyup", e => {
    if(modalCart.style.display == 'block' && e.key == "Escape"){
        modalCart.style.display = 'none';
        modalCartBg.style.display = 'none';
    }
});

// 찜하기
function productDetailPick(){
    $.ajax({
        type: 'post',
        url: '/dangjang/shop/product/detail/pick',
        data: 'seq_product='+$('#productDetail_seqProduct').val(),
        success: function(data){
            if(data == 'pickOk'){
                console.log('찜 완료~');
                alert('찜 목록에 추가되었습니다.');
            }
        },
        error: function(err){
            console.log(err);
        }
    });
}