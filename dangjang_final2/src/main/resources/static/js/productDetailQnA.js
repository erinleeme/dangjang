$(
    showProductDetailQnA($('#productDetail_seqProduct').val())
)

function showProductDetailQnA(seq_product){
    $.ajax({
        type: 'post',
        url: '/dangjang/shop/product/detail/qna',
        data: 'seq_product='+seq_product,
        success: function(data){ // qnaList, reviewList, reviewWriter, pg,  paging
            console.log(data);
            // 비우기
            $('.qnaBoardTable tbody').empty();

            // 문의 수
            $('.pViewTab .tabList .productQnaTotal').text('('+data.qnaCount+')');

            // 문의 테이블 넣기
            $.each(data.qnaList, function(index, items){
                let qnaList = '<tr>';
                if(data.pg == 1){
                    qnaList += '<td>'+ parseInt(index) + 1 + '</td>';
                } else {
                    qnaList += '<td>' + parseInt(data.pg)*10 + parseInt(index) + 1 + '</td>';
                }
                if(items.reply_content == null){
                    qnaList += '<td>[답변대기]</td>';
                } else {
                    qnaList += '<td>[답변완료]</td>';
                }
                qnaList += '<td class="qnaTableContent"><a>' + items.qna_content + '</a>'
                let writer = items.name;
                console.log(writer);
                writerA = writer.substring(0, 1); // 이름 앞 1 글자
                if(writer.length == 2){
                    qnaList += '<td>' + writerA + '*</td>';
                } else {
                    writerB = writer.substring(2);
                    qnaList += '<td>' + writerA + '*' + writerB +'</td>';
                }
                qnaList += '<td>' + items.create_date + '</td>';
                qnaList += '</tr>';
                $('.qnaBoardTable tbody').append(qnaList);
            });
            // 페이징
            $('.qnaBoard .pagingDiv').append(data.paging.pagingHTML);
        },
        error: function(err){
            console.log(err);
        }
    });
}

function showProductDetailQnAPaging(seq_product, pg2){
    $.ajax({
        type: 'post',
        url: '/dangjang/shop/product/detail/qna',
        data: {
            'seq_product': seq_product,
            'pg': pg2
        },
        success: function(data){
            console.log(data);
            // 비우기
            $('.qnaBoardTable tbody').empty();

            // 문의 테이블 넣기
            $.each(data.qnaList, function(index, items){
                let qnaList = '<tr>';
                if(data.pg == 1){
                    qnaList += '<td>'+ index + 1 + '</td>';
                } else {
                    qnaList += '<td>' + parseInt(data.pg)*10 + index + 1 + '</td>';
                }
                if(items.reply_content == null){
                    qnaList += '<td>[답변대기]</td>';
                } else {
                    qnaList += '<td>[답변완료]</td>';
                }
                qnaList += '<td class="qnaTableContent"><a>' + items.qna_content + '</a>'
                let writer = items.name;
                console.log(writer);
                writerA = writer.substring(0, 1); // 이름 앞 1 글자
                if(writer.length == 2){
                    qnaList += '<td>' + writerA + '*</td>';
                } else {
                    writerB = writer.substring(2);
                    qnaList += '<td>' + writerA + '*' + writerB +'</td>';
                }
                qnaList += '<td>' + items.create_date + '</td>';
                qnaList += '</tr>';
                $('.qnaBoardTable tbody').append(qnaList);
            });
            // 페이징
            $('.qnaBoard .pagingDiv').append(data.paging.pagingHTML);

        }
    });
}

function productDetailQnAPaging(pg2){
    showProductDetailQnAPaging($('#productDetail_seqProduct').val(), pg2);
}