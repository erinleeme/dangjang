// 장바구니 상품 리스트 뿌려주기
$(function(){
    $.ajax({
       type: 'post',
        url: '/dangjang/shop/cart/list',
        dataType: 'json',
        success: function(data){ // cartProductCount, cartProduct, cartProductImages
           console.log(data);
           // 비우기
            $('.cart_sel_check').empty();
            $('.cart_cold ul').empty();
            $('.cart_frozen ul').empty();
            $('.cart_room ul').empty();
            $('#totalPrice').empty();
            $('#discountPrice').empty();
            $('#shipPrice').empty();
            $('#payPrice').empty();

            // 상품 수 count (처음엔 default로 다 선택되어 있음)
            let checkAll = '<input type="checkbox" name="checkAll" id="cart_chk_all">';
                checkAll += '<span class="chk_ico"></span>';
            $('.cart_sel_check_all').append(checkAll);
            let selectCount = '<span id="cart_select_count">'+data.cartProductCount.length+'</span>';
            let totalCount = '<span id="cart_total_count">'+data.cartProductCount.length+'</span>'
            $('.cart_sel_check_all').append('전체선택 (' + selectCount + '/' + totalCount + ')');

            // 총 가격
            let productTotalPrice = 0;
            let discountTotalPrice = 0;
            let shipFee = 0;
            let total = 0;
            $.each(data.cartProduct, function(index, items){
                productTotalPrice += parseInt(items.price) * parseInt(data.cartProductCount[index].count);
                if(items.discount_price != 0){
                    discountTotalPrice += ((parseInt(items.price) - parseInt(items.discount_price) ) * parseInt(data.cartProductCount[index].count));
                }
                total = productTotalPrice - discountTotalPrice;
            });
            if(total < 30000){
                shipFee = 5000;
            }
            total += shipFee;

            $('#totalPrice').text(priceToString(productTotalPrice));
            $('#discountPrice').text(priceToString(discountTotalPrice));
            $('#shipPrice').text(priceToString(shipFee));
            $('#payPrice').text(priceToString(total));

            // 상품 리스트
            $.each(data.cartProduct, function(index, items){
               if(items.storage_method == '냉장'){
                   let cartItem_cold = '<li class="cart_item">';
                       cartItem_cold += '<div class="item_1 cart_id_'+index+'">';
                       cartItem_cold += '<label class="cart_sel_check" for="'+ items.seq_product +'">';
                       cartItem_cold += '<input type="checkbox" id="' + items.seq_product + '" name="checkItem" class="checkItem" >';
                       cartItem_cold += '<span class="chk_ico"></span>';
                       cartItem_cold += '</label>';
                       cartItem_cold += '<div class="c_item_name">';
                       cartItem_cold += '<div class="inner_name">';
                       cartItem_cold += '<a href="javascript:void(0)" class="c_package" onclick="productDetail(' + items.seq_product + ')">' + items.name + '</a>';
                       cartItem_cold += '<div class="c_item_state">';
                       cartItem_cold += '<span>' + items.storage_method + '</span>';
                       cartItem_cold += '</div>';
                       cartItem_cold += '</div>';
                       cartItem_cold += '<div class="c_item_goods" >';
                   let bgimgpath_cold = "'/images/"+ data.cartProductImages[index].serial_number +".jpg'"
                       cartItem_cold += '<a class="c_img" style="background-image: url(' + bgimgpath_cold + ');" onclick="productDetail(' + items.seq_product + ')">상품이미지</a>';
                       cartItem_cold += '<div class="price">';
                       cartItem_cold += '<div class="in_price">';
                   if(items.discount_price != 0){
                       cartItem_cold += '<span class="d_price"><b class="d_ratio">' + items.discount_rate + '%</b>' + priceToString(parseInt(items.discount_price) * parseInt(data.cartProductCount[index].count)) + '<span class="won">원</span></span>';
                       cartItem_cold += '<span class="o_price haveDiscount">' + priceToString(parseInt(items.price) * parseInt(data.cartProductCount[index].count)) + '<span class="won">원</span></span>';
                   } else {

                       cartItem_cold += '<span class="o_price">' + priceToString(parseInt(items.price) * parseInt(data.cartProductCount[index].count)) + '<span class="won">원</span></span>';
                   }
                       cartItem_cold += '</div>';
                       cartItem_cold += '<div class="item_count">';
                       cartItem_cold += '<button type="button" class="item_minus" onclick="itemMinus(this)">감소</button>';
                       cartItem_cold += '<input type="type" class="item_num stepperCounter" data-seq="' + items.seq_product + '" readonly value="' + data.cartProductCount[index].count + '">';
                       cartItem_cold += '<button type="button" class="item_plus" onclick="itemPlus(this)">증가</button>';
                       cartItem_cold += '</div>';
                       cartItem_cold += '</div>';
                       cartItem_cold += '</div>';
                       cartItem_cold += '<button type="button" class="item_delete" onclick="deleteItem(this)" data-seq="' + items.seq_product + '" data-count="' + data.cartProductCount[index].count + '">X</button>';
                       cartItem_cold += '</div>';
                       cartItem_cold += '</li>';

                   $('.cart_cold ul').append(cartItem_cold);

               } else if(items.storage_method == '냉동'){
                   let cartItem_frozen = '<li class="cart_item">';
                   cartItem_frozen += '<div class="item_1 cart_id_'+index+'">';
                   cartItem_frozen += '<label class="cart_sel_check" for="'+ items.seq_product +'">';
                   cartItem_frozen += '<input type="checkbox" id="' + items.seq_product + '" name="checkItem" class="checkItem" >';
                   cartItem_frozen += '<span class="chk_ico"></span>';
                   cartItem_frozen += '</label>';
                   cartItem_frozen += '<div class="c_item_name">';
                   cartItem_frozen += '<div class="inner_name">';
                   cartItem_frozen += '<a href="javascript:void(0)" class="c_package" onclick="productDetail(' + items.seq_product + ')">' + items.name + '</a>';
                   cartItem_frozen += '<div class="c_item_state">';
                   cartItem_frozen += '<span>' + items.storage_method + '</span>';
                   cartItem_frozen += '</div>';
                   cartItem_frozen += '</div>';
                   cartItem_frozen += '<div class="c_item_goods" >';
                   let bgimgpath_frozen = "'/images/"+ data.cartProductImages[index].serial_number +".jpg'"
                   cartItem_frozen += '<a class="c_img" style="background-image: url(' + bgimgpath_frozen + ');" onclick="productDetail(' + items.seq_product + ')">상품이미지</a>';
                   cartItem_frozen += '<div class="price">';
                   cartItem_frozen += '<div class="in_price">';
                   if(items.discount_price != 0){
                       cartItem_frozen += '<span class="d_price"><b class="d_ratio">' + items.discount_rate + '%</b>' + priceToString(parseInt(items.discount_price) * parseInt(data.cartProductCount[index].count)) + '<span class="won">원</span></span>';
                       cartItem_frozen += '<span class="o_price haveDiscount">' + priceToString(parseInt(items.price) * parseInt(data.cartProductCount[index].count)) + '<span class="won">원</span></span>';
                   } else {
                       cartItem_frozen += '<span class="o_price">' + priceToString(parseInt(items.price) * parseInt(data.cartProductCount[index].count)) + '<span class="won">원</span></span>';
                   }
                   cartItem_frozen += '</div>';
                   cartItem_frozen += '<div class="item_count">';
                   cartItem_frozen += '<button type="button" class="item_minus" onclick="itemMinus(this)">감소</button>';
                   cartItem_frozen += '<input type="type" class="item_num stepperCounter" data-seq="' + items.seq_product + '" readonly value="' + data.cartProductCount[index].count + '">';
                   cartItem_frozen += '<button type="button" class="item_plus" onclick="itemPlus(this)">증가</button>';
                   cartItem_frozen += '</div>';
                   cartItem_frozen += '</div>';
                   cartItem_frozen += '</div>';
                   cartItem_frozen += '<button type="button" class="item_delete" onclick="deleteItem(this)" data-seq="' + items.seq_product + '" data-count="' + data.cartProductCount[index].count + '">X</button>';
                   cartItem_frozen += '</div>';
                   cartItem_frozen += '</li>';

                   $('.cart_frozen ul').append(cartItem_frozen);

               } else if(items.storage_method == '상온'){
                   let cartItem_room = '<li class="cart_item">';
                   cartItem_room += '<div class="item_1 cart_id_'+index+'">';
                   cartItem_room += '<label class="cart_sel_check" for="'+ items.seq_product +'">';
                   cartItem_room += '<input type="checkbox" id="' + items.seq_product + '" name="checkItem" class="checkItem" >';
                   cartItem_room += '<span class="chk_ico"></span>';
                   cartItem_room += '</label>';
                   cartItem_room += '<div class="c_item_name">';
                   cartItem_room += '<div class="inner_name">';
                   cartItem_room += '<a href="javascript:void(0)" class="c_package" onclick="productDetail(' + items.seq_product + ')">' + items.name + '</a>';
                   cartItem_room += '<div class="c_item_state">';
                   cartItem_room += '<span>' + items.storage_method + '</span>';
                   cartItem_room += '</div>';
                   cartItem_room += '</div>';
                   cartItem_room += '<div class="c_item_goods" >';
                   let bgimgpath_room = "'/images/"+ data.cartProductImages[index].serial_number +".jpg'"
                   cartItem_room += '<a class="c_img" style="background-image: url(' + bgimgpath_room + ');" onclick="productDetail(' + items.seq_product + ')">상품이미지</a>';
                   cartItem_room += '<div class="price">';
                   cartItem_room += '<div class="in_price">';
                   if(items.discount_price != 0){
                       cartItem_room += '<span class="d_price"><b class="d_ratio">' + items.discount_rate + '%</b>' + priceToString(parseInt(items.discount_price) * parseInt(data.cartProductCount[index].count)) + '<span class="won">원</span></span>';
                       cartItem_room += '<span class="o_price haveDiscount">' + priceToString(parseInt(items.price) * parseInt(data.cartProductCount[index].count)) + '<span class="won">원</span></span>';
                   } else {
                       cartItem_room += '<span class="o_price">' + priceToString(parseInt(items.price) * parseInt(data.cartProductCount[index].count)) + '<span class="won">원</span></span>';
                   }
                   cartItem_room += '</div>';
                   cartItem_room += '<div class="item_count">';
                   cartItem_room += '<button type="button" class="item_minus" onclick="itemMinus(this)">감소</button>';
                   cartItem_room += '<input type="type" class="item_num stepperCounter" data-seq="' + items.seq_product + '" readonly value="' + data.cartProductCount[index].count + '">';
                   cartItem_room += '<button type="button" class="item_plus" onclick="itemPlus(this)">증가</button>';
                   cartItem_room += '</div>';
                   cartItem_room += '</div>';
                   cartItem_room += '</div>';
                   cartItem_room += '<button type="button" class="item_delete" onclick="deleteItem(this)" data-seq="' + items.seq_product + '" data-count="' + data.cartProductCount[index].count + '">X</button>';
                   cartItem_room += '</div>';
                   cartItem_room += '</li>';

                   $('.cart_room ul').append(cartItem_room);

               }
            });
            // checkbox 체크화 하기
            $('.cart_sel_check_all input[type=checkbox]').prop("checked", true);
            $('#cartProductList input[type=checkbox]').prop("checked", true);

            // 상태에 해당되는 상품 미존재 할 경우 보이지 않게 처리
            if($('.cart_cold ul li').length == 0){
                $('.cart_cold').css('display', 'none');
            }
            if($('.cart_frozen ul li').length == 0){
                $('.cart_frozen').css('display', 'none');
            }
            if($('.cart_room ul li').length == 0){
                $('.cart_room').css('display', 'none');
            }
       },
        error: function(err){
           console.log(err);
        }
    });
})

// 상품 선택 - 해제 시 가격 변동 해줘야 함!
$(document).ready(function(){
    // 전체 동의
    $('.cart_sel_check_all #cart_chk_all').change(function(){
        console.log('변화 감지!');
        if($('.cart_sel_check_all #cart_chk_all').is(":checked")){
            $('#cartProductList').find('input[type=checkbox]').prop("checked", true);
            console.log($('#cartProductList').find('input[type=checkbox]'));
        } else {
            $('#cartProductList').find('input[type=checkbox]').prop("checked", false);
        }
    })

    // 개별 동의
    // $('#cartProductList #j_chk_1, .joinWriteSection #j_chk_2').change(function(){
    //     if($('.joinWriteSection #j_chk_1').is(":checked") && $('.joinWriteSection #j_chk_2').is(":checked")){
    //         $('.joinWriteSection #j_chk_all').prop("checked", true);
    //     } else {
    //         $('.joinWriteSection #j_chk_all').prop("checked", false);
    //     }
    // })
});

// 상품 수량 변경
var onlyPrice = /[^0-9]/g;// 숫자가 아닌 문자열을 선택하는 정규식
function itemMinus(element){

    let count = parseInt($(element).next().val());

    // 총 금액 가져오기
    let totalPriceAll = $('#totalPrice').text(); // o_price 만큼 빼주기
    let totalPrice = parseInt(totalPriceAll.replace(onlyPrice, "")); // , 빼주기
    let discountPriceAll = $('#discountPrice').text(); // 할인 중이면 o_price에서 d_price 뺀 만큼 빼기
    let discountPrice = parseInt(discountPriceAll.replace(onlyPrice, "")); // , 빼주기
    let shipPriceAll = $('#shipPrice').text(); // payPrice가 3만콩 밑이면 오천원 추가
    let shipPrice = parseInt(shipPriceAll.replace(onlyPrice, "")); // , 빼주기
    let payPriceAll = $('#payPrice').text(); // 할인 중이면 d_price만큼 빼고, 아니면 o_price만큼 빼기 + 삼만콩 밑이면 오천콩 추가
    let payPrice = parseInt(payPriceAll.replace(onlyPrice, "")); // , 빼주기

    // count 가 1일 때는 minus 못 함
    if(count != 1){
        // input value 변경
        count -= 1;
        let seq_product = $(element).next().attr('data-seq');
        $(element).next().val(count);

        // db 전달
        $.ajax({
            type: 'post',
            url: '/dangjang/shop/cart/itemCountModify',
            data: {
                'seq_product': seq_product,
                'count': count
            },
            error: function(err){
                console.log(err);
            }
        });

        // 가격 반영
        let parent = $(element).parent().prev();

        if(parent.children().hasClass('haveDiscount')){
            console.log('할인 중인 상품~');
            // 할인률, 할인가 구하기
            let discount = parent.children().first().text();
            let d_ratio = discount.substring(0, discount.indexOf('%')+1);
            let d_priceAll = discount.substring(d_ratio.length, discount.indexOf('원'));
            let d_price = parseInt(d_priceAll.replace(onlyPrice, "")) / (count + 1);

            // 정상가 구하기
            let original = parent.children().last().text();
            let o_priceAll = original.substring(0, original.indexOf('원'));
            let o_price = parseInt(o_priceAll.replace(onlyPrice, "")) / (count + 1);

            // 비우기 & 채우기
            parent.empty();
            let d_tag = '<span class="d_price"><b class="d_ratio">' + d_ratio + '</b>';
                d_tag += priceToString(d_price * count);
                d_tag += '<span class="won">원</span></span>';
            parent.append(d_tag);
            let o_tag = '<span class="o_price haveDiscount">';
                o_tag += priceToString(o_price * count);
                o_tag += '<span class="won">원</span></span>';
            parent.append(o_tag);

            // 총합 계산 및 텍스트 추가
            totalPrice -= o_price;
            $('#totalPrice').text(priceToString(totalPrice));
            discountPrice -= (o_price - d_price);
            $('#discountPrice').text(priceToString(discountPrice));
            payPrice -= d_price;
            // 배송비
            if(payPrice < 30000 && shipPrice != 5000){
                shipPrice = 5000;
            }
            $('#payPrice').text(priceToString(payPrice));
            $('#shipPrice').text(priceToString(shipPrice));

        } else {
            console.log('정가만 찾으면 됨~');
            let original = parent.children().text();
            let o_priceAll = original.substring(0, original.indexOf('원'));
            let o_price = parseInt(o_priceAll.replace(onlyPrice, "")) / (count + 1);

            // 비우기 & 채우기
            parent.empty();
            let o_tag = '<span class="o_price">';
            o_tag += priceToString(o_price * count);
            o_tag += '<span class="won">원</span></span>';
            parent.append(o_tag);

            // 총합 계산 및 텍스트 추가
            totalPrice -= o_price;
            $('#totalPrice').text(priceToString(totalPrice));
            payPrice -= o_price;
            // 배송비
            if(payPrice < 30000 && shipPrice != 5000){
                shipPrice = 5000;
            }
            $('#payPrice').text(priceToString(payPrice));
            $('#shipPrice').text(priceToString(shipPrice));
        }
    }
}

function itemPlus(element){
    // input value 변경
    let count = parseInt($(element).prev().val()) + 1;
    $(element).prev().val(count);

    // 총 금액 가져오기
    let totalPriceAll = $('#totalPrice').text(); // o_price 만큼 빼주기
    let totalPrice = parseInt(totalPriceAll.replace(onlyPrice, "")); // , 빼주기
    let discountPriceAll = $('#discountPrice').text(); // 할인 중이면 o_price에서 d_price 뺀 만큼 빼기
    let discountPrice = parseInt(discountPriceAll.replace(onlyPrice, "")); // , 빼주기
    let shipPriceAll = $('#shipPrice').text(); // payPrice가 3만콩 밑이면 오천원 추가
    let shipPrice = parseInt(shipPriceAll.replace(onlyPrice, "")); // , 빼주기
    let payPriceAll = $('#payPrice').text(); // 할인 중이면 d_price만큼 빼고, 아니면 o_price만큼 빼기 + 삼만콩 밑이면 오천콩 추가
    let payPrice = parseInt(payPriceAll.replace(onlyPrice, "")); // , 빼주기

    let seq_product = $(element).prev().attr('data-seq');

    // db 전달
    $.ajax({
        type: 'post',
        url: '/dangjang/shop/cart/itemCountModify',
        data: {
            'seq_product': seq_product,
            'count': count
        },
        error: function(err){
            console.log(err);
        }
    });

    // 가격 반영
    let parent = $(element).parent().prev();

    if(parent.children().hasClass('haveDiscount')){
        console.log('할인 중인 상품~');
        // 할인률, 할인가 구하기
        let discount = parent.children().first().text();
        let d_ratio = discount.substring(0, discount.indexOf('%')+1);
        let d_priceAll = discount.substring(d_ratio.length, discount.indexOf('원'));
        let d_price = parseInt(d_priceAll.replace(onlyPrice, "")) / (count - 1);

        // 정상가 구하기
        let original = parent.children().last().text();
        let o_priceAll = original.substring(0, original.indexOf('원'));
        let o_price = parseInt(o_priceAll.replace(onlyPrice, "")) / (count - 1);

        // 비우기 & 채우기
        parent.empty();
        let d_tag = '<span class="d_price"><b class="d_ratio">' + d_ratio + '</b>';
        d_tag += priceToString(d_price * count);
        d_tag += '<span class="won">원</span></span>';
        parent.append(d_tag);
        let o_tag = '<span class="o_price haveDiscount">';
        o_tag += priceToString(o_price * count);
        o_tag += '<span class="won">원</span></span>';
        parent.append(o_tag);

        // 총합 계산 및 텍스트 추가
        totalPrice += o_price;
        $('#totalPrice').text(priceToString(totalPrice));
        discountPrice += (o_price - d_price);
        $('#discountPrice').text(priceToString(discountPrice));
        payPrice += d_price;
        // 배송비
        if(payPrice >= 30000 && shipPrice == 5000){
            shipPrice = 0;
        }
        $('#payPrice').text(priceToString(payPrice));
        $('#shipPrice').text(priceToString(shipPrice));

    } else {
        console.log('정가만 찾으면 됨~');
        let original = parent.children().text();
        let o_priceAll = original.substring(0, original.indexOf('원'));
        let o_price = parseInt(o_priceAll.replace(onlyPrice, "")) / (count - 1);

        // 비우기 & 채우기
        parent.empty();
        let o_tag = '<span class="o_price">';
        o_tag += priceToString(o_price * count);
        o_tag += '<span class="won">원</span></span>';
        parent.append(o_tag);

        // 총합 계산 및 텍스트 추가
        console.log(totalPrice);
        totalPrice += o_price;
        console.log(totalPrice);
        $('#totalPrice').text(priceToString(totalPrice));
        payPrice += o_price;
        // 배송비
        if(payPrice >= 30000 && shipPrice == 5000){
            shipPrice = 0;
        }
        $('#payPrice').text(priceToString(payPrice));
        $('#shipPrice').text(priceToString(shipPrice));
    }

}

// 상품 삭제 (직접)
function deleteItem(element){
    // 상품 seq_product 가져오기
    let seq_product = $(element).attr('data-seq');

    // db 전달
    $.ajax({
        type: 'post',
        url: '/dangjang/shop/cart/delete',
        data: 'seq_product='+seq_product,
        success: function(data){
            if(data == 'deleteOk'){
                console.log('삭제 완료');
            } else {
                console.log('삭제 실패');
            }
        },
        error: function(err){
            console.log(err);
        }
    });

    // 전체 수량 변경
    let selectCount = parseInt($('#cart_select_count').text()) - 1;
    let totalCount = parseInt($('#cart_total_count').text()) - 1;
    $('#cart_select_count').text(selectCount);
    $('#cart_total_count').text(totalCount);

    // 가격 변경
    let count = $(element).attr('data-count'); // 상품 수량

    // 총 금액 가져오기
    let totalPriceAll = $('#totalPrice').text(); // o_price 만큼 빼주기
    let totalPrice = parseInt(totalPriceAll.replace(onlyPrice, "")); // , 빼주기
    let discountPriceAll = $('#discountPrice').text(); // 할인 중이면 o_price에서 d_price 뺀 만큼 빼기
    let discountPrice = parseInt(discountPriceAll.replace(onlyPrice, "")); // , 빼주기
    let shipPriceAll = $('#shipPrice').text(); // payPrice가 3만콩 밑이면 오천원 추가
    let shipPrice = parseInt(shipPriceAll.replace(onlyPrice, "")); // , 빼주기
    let payPriceAll = $('#payPrice').text(); // 할인 중이면 d_price만큼 빼고, 아니면 o_price만큼 빼기 + 삼만콩 밑이면 오천콩 추가
    let payPrice = parseInt(payPriceAll.replace(onlyPrice, "")); // , 빼주기

    // 정가, 할인가 가져오기
    let priceSection = $(element).prev().children().last().children().first();

    if(priceSection.children().hasClass('haveDiscount')){
        console.log('할인 중인 상품~');
        // 할인률, 할인가 구하기
        let discount = priceSection.children().first().text();
        let d_ratio = discount.substring(0, discount.indexOf('%')+1);
        let d_priceAll = discount.substring(d_ratio.length, discount.indexOf('원'));
        let d_price = parseInt(d_priceAll.replace(onlyPrice, "")) / count;

        // 정상가 구하기
        let original = priceSection.children().last().text();
        let o_priceAll = original.substring(0, original.indexOf('원'));
        let o_price = parseInt(o_priceAll.replace(onlyPrice, "")) / count;

        // 총합 계산 및 텍스트 추가
        totalPrice -= o_price;
        $('#totalPrice').text(priceToString(totalPrice));
        discountPrice -= (o_price - d_price);
        $('#discountPrice').text(priceToString(discountPrice));
        payPrice -= d_price;
        // 배송비
        if(payPrice < 30000 && shipPrice == 0){
            shipPrice = 5000;
        }
        $('#payPrice').text(priceToString(payPrice));
        $('#shipPrice').text(priceToString(shipPrice));

    } else {
        console.log('정가만 찾으면 됨~');
        let original = priceSection.children().text();
        let o_priceAll = original.substring(0, original.indexOf('원'));
        let o_price = parseInt(o_priceAll.replace(onlyPrice, "")) / count;

        // 총합 계산 및 텍스트 추가
        totalPrice -= o_price;
        $('#totalPrice').text(priceToString(totalPrice));
        payPrice -= o_price;
        // 배송비
        if(payPrice < 30000 && shipPrice == 0){
            shipPrice = 5000;
        }
        $('#payPrice').text(priceToString(payPrice));
        $('#shipPrice').text(priceToString(shipPrice));
    }

    // li 지우기
    $(element).parent().parent().parent().remove();

    // 상태에 해당되는 상품 미존재 할 경우 보이지 않게 처리
    if($('.cart_cold ul li').length == 0){
        $('.cart_cold').css('display', 'none');
    }
    if($('.cart_frozen ul li').length == 0){
        $('.cart_frozen').css('display', 'none');
    }
    if($('.cart_room ul li').length == 0){
        $('.cart_room').css('display', 'none');
    }

}