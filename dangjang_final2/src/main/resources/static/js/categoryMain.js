$('.mcm').click(function(){
    let categoryCode = $(this).attr('data-cat');
    console.log(categoryCode);
    location.href='/dangjang/shop/goods/category?categoryCode=' + categoryCode;
});

$('.mcs').click(function(){
    let categoryCode = $(this).attr('data-cat');
    console.log(categoryCode);
    location.href='/dangjang/shop/goods/category?categoryCode=' + categoryCode;
})

$(function(){
    categoryList("reco")
})


// 카테고리 상품 리스트 가져오기기
function categoryList(listType){
    console.log($('#categoryCode').val());
    console.log($('#subCategoryNum').val());
    console.log($('#categoryPg').val());
    $.ajax({
        type: 'post',
        url: '/dangjang/shop/goods/category/list',
        data: {
            'categoryCode': $('#categoryCode').val(),
            'subCategoryNum': $('#subCategoryNum').val(),
            'listType': listType,
            'pg': $('#categoryPg').val()
        },
        success: function(data){ // categoryTitle(model), subCategoryList, productList, productImageList
            console.log(data);

            // 비우기
            $('.cat_menu').empty();
            $('.categoryMain #cat_goods_list .goods_count').empty();
            $('#cat_goods_list .product_view').empty();
            $('#cat_goods_list .pagingDiv').empty();

            // 하위 카테고리 메뉴
            let catMenu = '<li>';
            catMenu += '<a class="category_subCat categoryChoose" id="'+data.subCategoryList[0].code_name+'" href="/dangjang/shop/goods/category?categoryCode=' + data.subCategoryList[0].code_name + '">전체보기</a>';
            catMenu += '</li>';
            $('.cat_menu').append(catMenu);

            $.each(data.subCategoryList, function(index, items){
                catMenu = '<li>';
                catMenu += '<a class="category_subCat" id="'+items.id+'" onclick="categoryChoose(this)">'+items.category_name+'</a>';
                catMenu += '</li>';
                $('.cat_menu').append(catMenu);
            });

            // 상품 개수
            let productCout = '<span>총 ' + data.productCount + ' 개</span>';
            $('.categoryMain #cat_goods_list .goods_count').append(productCout);

            // 상품 리스트
            $.each(data.productList, function(index, items){
                let productList = '<div class="product_one">';
                productList += '<div class="product_img"><img src="/images/' + data.imageList[index].serial_number + '.jpg" onclick="productDetail(' + items.seq_product + ')"></div>';
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

                $('#cat_goods_list .product_view').append(productList);
            });

            // 페이징
            $('#cat_goods_list .pagingDiv').append(data.paging.pagingHTML);
        },
        error: function(err){
            console.log(err);
        }
    });
};
// 카테고리 상품 리스트 가져오기기
function subCategoryList(listType, subCategoryNum){
    // console.log($('#categoryCode').val());
    // console.log($('#subCategoryNum').val());
    // console.log($('#categoryPg').val());
    $.ajax({
        type: 'post',
        url: '/dangjang/shop/goods/category/list',
        data: {
            'categoryCode': $('#categoryCode').val(),
            'subCategoryNum': subCategoryNum,
            'listType': listType,
            'pg': $('#categoryPg').val()
        },
        success: function(data){ // categoryTitle(model), subCategoryList, productList, productImageList
            console.log(data);

            // 비우기
            $('.cat_menu').empty();
            $('.categoryMain #cat_goods_list .goods_count').empty();
            $('#cat_goods_list .product_view').empty();
            $('#cat_goods_list .pagingDiv').empty();

            // 하위 카테고리 메뉴
            let catMenu = '<li>';
            catMenu += '<a class="category_subCat" id="'+data.subCategoryList[0].code_name+'" href="/dangjang/shop/goods/category?categoryCode=' + data.subCategoryList[0].code_name + '">전체보기</a>';
            catMenu += '</li>';
            $('.cat_menu').append(catMenu);

            $.each(data.subCategoryList, function(index, items){
                if(subCategoryNum == items.id){
                    catMenu = '<li>';
                    catMenu += '<a class="category_subCat categoryChoose" id="'+items.id+'" onclick="categoryChoose(this)">'+items.category_name+'</a>';
                    catMenu += '</li>';
                } else{
                    catMenu = '<li>';
                    catMenu += '<a class="category_subCat" id="'+items.id+'" onclick="categoryChoose(this)">'+items.category_name+'</a>';
                    catMenu += '</li>';
                }


                $('.cat_menu').append(catMenu);
            });

            // 상품 개수
            let productCout = '<span>총 ' + data.productCount + ' 개</span>';
            $('.categoryMain #cat_goods_list .goods_count').append(productCout);

            // 상품 리스트
            $.each(data.productList, function(index, items){
                let productList = '<div class="product_one">';
                productList += '<div class="product_img"><img src="/images/' + data.imageList[index].serial_number + '.jpg" onclick="productDetail(' + items.seq_product + ')"></div>';
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

                $('#cat_goods_list .product_view').append(productList);
            });

            // 페이징
            $('#cat_goods_list .pagingDiv').append(data.paging.pagingHTML);
        },
        error: function(err){
            console.log(err);
        }
    });
};

// 카테고리 리스트 (페이징)
function categoryListPaging(pg2, listType){
    console.log($('#categoryCode').val());
    console.log($('#subCategoryNum').val());
    console.log($('#categoryPg').val());
    $.ajax({
        type: 'post',
        url: '/dangjang/shop/goods/category/list',
        data: {
            'categoryCode': $('#categoryCode').val(),
            'subCategoryNum': $('#subCategoryNum').val(),
            'listType': listType,
            'pg': pg2
        },
        success: function(data){ // categoryTitle(model), subCategoryList, productList, productImageList
            console.log(data);

            // 비우기
            $('.cat_menu').empty();
            $('.categoryMain #cat_goods_list .goods_count').empty();
            $('#cat_goods_list .product_view').empty();
            $('#cat_goods_list .pagingDiv').empty();

            // 하위 카테고리 메뉴
            let catMenu = '<li>';
            catMenu += '<a class="category_subCat categoryChoose" id="'+data.subCategoryList[0].code_name+'" href="/dangjang/shop/goods/category?categoryCode=' + data.subCategoryList[0].code_name + '">전체보기</a>';
            catMenu += '</li>';
            $('.cat_menu').append(catMenu);

            $.each(data.subCategoryList, function(index, items){
                catMenu = '<li>';
                catMenu += '<a class="category_subCat" id="'+items.id+'" onclick="categoryChoose(this)">'+items.category_name+'</a>';
                catMenu += '</li>';
                $('.cat_menu').append(catMenu);
            });

            // 상품 개수
            let productCout = '<span>총 ' + data.productCount + ' 개</span>';
            $('.categoryMain #cat_goods_list .goods_count').append(productCout);

            // 상품 리스트
            $.each(data.productList, function(index, items){
                let productList = '<div class="product_one">';
                productList += '<div class="product_img"><img src="/images/' + data.imageList[index].serial_number + '.jpg" onclick="productDetail(' + items.seq_product + ')"></div>';
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

                $('#cat_goods_list .product_view').append(productList);
            });

            // 페이징
            $('#cat_goods_list .pagingDiv').append(data.paging.pagingHTML);
        },
        error: function(err){
            console.log(err);
        }
    });
};

// 정렬 유형 선택
$('#cat_goods_list .attr_type ul li a').click(function(){
    console.log($(this).attr('id'));
    // listType
    categoryList($(this).attr('id'));
    // attr_choose 추가해주기
    // 기존 attr_choose 제거
    let preChoice = document.querySelector('#cat_goods_list .attr_choose').removeAttribute('class');
    $(this).attr('class', 'attr_choose');
})

// 페이징
function productPaging(pg2){
    let listType = document.querySelector('#cat_goods_list .attr_choose').getAttribute('id');
    categoryListPaging(pg2, listType)
}


// 하위 카테고리 선택
function categoryChoose(element){
    // let beforeChoice = document.querySelector('.cat_subCatList .cat_menu li a.categoryChoose');
    // beforeChoice.removeAttribute('class');
    // beforeChoice.classList.add('category_subCat');
    // $(element).attr('class', 'categoryChoose');
    subCategoryList('reco', $(element).attr('id'));
}