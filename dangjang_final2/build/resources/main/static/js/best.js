$(function(){
    $.ajax({
        type: 'post',
        url: '/dangjang/shop/goods/best/list',
        success: function(data){
            // console.log(data);
            // 리뷰 Top 10
            $.each(data.reviewTop10, function(index, items){
                let product_view = '<div class="product_one" data-index="'+ index +'">';
                product_view += '<div class="product_img"><img src="/images/' + data.reviewTop10Images[index].serial_number + '.jpg" onclick="productDetail(' + items.seq_product + ')"></div>';
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
                product_view += '<span class="product_review">' + data.reviewCountWithReviewTop10[index] + '</span>';
                product_view += '<img class="p_pick_icon" src="/icon/heart.png" />';
                product_view += '<span class="product_pick">' + data.pickCountWithReviewTop10[index] + '</span></div>';
                product_view += '</div>';

                $('.best_review_set .product_view').append(product_view);
            });

            // 판매량 Top 10
            $.each(data.sellingTop10, function(index, items){
                let product_view2 = '<div class="product_one" data-index="'+ index +'">';
                product_view2 += '<div class="product_img"><img src="/images/' + data.sellingTop10Images[index].serial_number + '.jpg" onclick="productDetail(' + items.seq_product + ')"></div>';
                product_view2 += '<div class="product_name" onclick="productDetail(' + items.seq_product + ')"><span>' + items.name + '</span></div>';
                product_view2 += '<div class="product_price">';
                if(items.discount_price != 0){
                    product_view2 += '<span class="d_price"><b class="d_ratio">' + items.discount_rate + '%</b>' + priceToString(items.discount_price) + '원</span>';
                    product_view2 += '<span class="o_price haveDiscount">' + priceToString(items.price) + '원</span>';
                } else {
                    product_view2 += '<span class="o_price">' + priceToString(items.price) + '원</span>';
                }
                product_view2 += '</div>';
                product_view2 += '<div class="product_state"><span>' + items.storage_method + '</span></div>';
                product_view2 += '<div class="product_reviewAndPick"><img class="p_review_icon" src="/icon/review_icon.png" />';
                product_view2 += '<span class="product_review">' + data.reviewCountWithSellingTop10[index] + '</span>';
                product_view2 += '<img class="p_pick_icon" src="/icon/heart.png" />';
                product_view2 += '<span class="product_pick">' + data.pickCountWithSellingTop10[index] + '</span></div>';
                product_view2 += '</div>';

                $('.best_top_set .product_view').append(product_view2);
            });

            // MD 추천
            $.each(data.suggestionTop10, function(index, items){
                let product_view3 = '<div class="product_one" data-index="'+ index +'">';
                product_view3 += '<div class="product_img"><img src="/images/' + data.suggestionTop10Images[index].serial_number + '.jpg" onclick="productDetail(' + items.seq_product + ')"></div>';
                product_view3 += '<div class="product_name" onclick="productDetail(' + items.seq_product + ')"><span>' + items.name + '</span></div>';
                product_view3 += '<div class="product_price">';
                if(items.discount_price != 0){
                    product_view3 += '<span class="d_price"><b class="d_ratio">' + items.discount_rate + '%</b>' + priceToString(items.discount_price) + '원</span>';
                    product_view3 += '<span class="o_price haveDiscount">' + priceToString(items.price) + '원</span>';
                } else {
                    product_view3 += '<span class="o_price">' + priceToString(items.price) + '원</span>';
                }
                product_view3 += '</div>';
                product_view3 += '<div class="product_state"><span>' + items.storage_method + '</span></div>';
                product_view3 += '<div class="product_reviewAndPick"><img class="p_review_icon" src="/icon/review_icon.png" />';
                product_view3 += '<span class="product_review">' + data.reviewCountWithSuggestionTop10[index] + '</span>';
                product_view3 += '<img class="p_pick_icon" src="/icon/heart.png" />';
                product_view3 += '<span class="product_pick">' + data.pickCountWithSuggestionTop10[index] + '</span></div>';
                product_view3 += '</div>';

                $('.best_md_set .product_view').append(product_view3);
            });
        },
        error: function (err){
            console.log(err);
        }
    });
})