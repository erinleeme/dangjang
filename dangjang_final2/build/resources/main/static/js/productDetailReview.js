$(
    showProductDetailReview($('#productDetail_seqProduct').val())
)

function showProductDetailReview(seq_product){
    $.ajax({
        type: 'post',
        url: '/dangjang/shop/product/detail/review',
        data: 'seq_product='+seq_product,
        success: function(data){ // reviewScore, reviewCount, reviewList, reviewWriter, pg paging
            console.log(data);
            // 비우기
            $('.totalReview .totalReviewCount').empty();
            $('.reviewBoardTable tbody').empty();

            // 전체 리뷰 수
            $('.totalReview .totalReviewCount').text(data.reviewCount);
            $('.tabList .productReviewTotal').text('('+data.reviewCount+')');

            // 리뷰 테이블 넣기
            $.each(data.reviewList, function(index, items){
                let reviewList = '<tr>';
                if(data.pg == 1){
                    reviewList += '<td>'+ parseInt(index) + 1 + '</td>';
                } else {
                    reviewList += '<td>' + parseInt(data.pg)*10 + parseInt(index) + 1 + '</td>';
                }
                    reviewList += '<td class="reviewBoardTableScore score' + items.score + '">' + items.score + '</td>';
                    reviewList += '<td class="reviewTableContent"><a>' + items.content + '</a>';
                let writer = items.name;
                console.log(writer);
                writerA = writer.substring(0, 1); // 이름 앞 1 글자
                if(writer.length == 2){
                    reviewList += '<td>' + writerA + '*</td>';
                } else {
                    writerB = writer.substring(2);
                    reviewList += '<td>' + writerA + '*' + writerB +'</td>';
                }
                    reviewList += '<td>' + items.member_date + '</td>';
                    reviewList += '</tr>';
                $('.reviewBoardTable tbody').append(reviewList);
            });
            // 페이징
            $('.reviewBoard .pagingDiv').append(data.paging.pagingHTML);
        },
        error: function(err){
            console.log(err);
        }
    });
}

function showProductDetailReviewPaging(seq_product, pg2){
    $.ajax({
        type: 'post',
        url: '/dangjang/shop/product/detail/review',
        data: {
            'seq_product': seq_product,
            'pg': pg2
        },
        success: function(data){
            console.log(data);
            // 비우기
            $('.totalReview .totalReviewCount').empty();
            $('.reviewBoardTable tbody').empty();

            // 전체 리뷰 수
            $('.totalReview .totalReviewCount').text(data.reviewCount);

            // 리뷰 테이블 넣기
            $.each(data.reviewList, function(index, items){
                let reviewList = '<tr>';
                if(data.pg == 1){
                    reviewList += '<td>'+ parseInt(index) + 1 + '</td>';
                } else {
                    reviewList += '<td>' + parseInt(data.pg)*10 + parseInt(index) + 1 + '</td>';
                }
                reviewList += '<td class="reviewBoardTableScore score' + items.score + '">' + items.score + '</td>';
                reviewList += '<td class="reviewTableContent"><a>' + items.content + '</a>';
                let writer = items.name;
                console.log(writer);
                writerA = writer.substring(0, 1); // 이름 앞 1 글자
                if(writer.length == 2){
                    reviewList += '<td>' + writerA + '*</td>';
                } else {
                    writerB = writer.substring(2);
                    reviewList += '<td>' + writerA + '*' + writerB +'</td>';
                }
                reviewList += '<td>' + items.member_date + '</td>';
                reviewList += '</tr>';
                $('.reviewBoardTable tbody').append(reviewList);
            });
            // 페이징
            $('.reviewBoard .pagingDiv').append(data.paging.pagingHTML);
        }
    });
}

function productDetailReviewPaging(pg2){
    showProductDetailReviewPaging($('#productDetail_seqProduct').val(), pg2);
}