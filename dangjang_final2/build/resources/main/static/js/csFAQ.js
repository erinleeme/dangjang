// faq 유형 선택 이벤트
$('.cs_faq_nav nav ul li').click(function () {
    $(this).attr('style', 'border-bottom: 5px solid #1A237E;');
    $(this).siblings().css({'border-bottom': '1px solid #1A237E'});
    let faqType = $(this).children().attr('id');
    console.log(faqType);
    faqType_list(faqType);
})
// faq 기본 설정
$(function () {
    $('.cs_faq_nav nav ul li').addClass('cs_faq_select');
    faqType_list('faq_0');
})

// faq 목록가져오기
function faqType_list(faqType) {
    $.ajax({
        type: 'post',
        url: '/dangjang/shop/cs/faqList',
        data: {
            'faqType': faqType,
            'pg': $('#FaqPg').val()
        },
        dataType: 'json',
        success: function (data) { // faqList, paging 전달
            $('#cs_faq_contents_list').empty();
            $('#faq_paging .pagingDiv').empty();

            $.each(data.faqList, function (index, items) {
                let faqList = '<li >';
                faqList += '<div class="question"><span class="q_mark">Q</span>';
                faqList += '<a class="cs_faq_one " onclick="showAnswer(this)">' + items.content + '</a></div>';
                faqList += '<div style="clear:both"></div>';
                faqList += '<div class="cs_faq_answer"><h4>A</h4>';
                faqList += '<p style=”white-space: pre-line;”>' + items.reply + '</p></div></li>';
                $('#cs_faq_contents_list').append(faqList);
            });
            // 페이징
            $('#faq_paging .pagingDiv').append(data.paging.pagingHTML);
        },
        error: function (err) {
            console.log(err);
        }
    });
};

// faq 목록가져오기
function faqType_list_paging(pg) {
    $.ajax({
        type: 'post',
        url: '/dangjang/shop/cs/faqList',
        data: {
            'faqType': $('#faqType').val(),
            'pg': pg
        },
        dataType: 'json',
        success: function (data) { // faqList, paging 전달
            $('#cs_faq_contents_list').empty();
            $('#faq_paging .pagingDiv').empty();

            $.each(data.faqList, function (index, items) {
                let faqList = '<li >';
                faqList += '<div class="question"><span class="q_mark">Q</span>';
                faqList += '<a class="cs_faq_one " onclick="showAnswer(this)">' + items.content + '</a></div>';
                faqList += '<div style="clear:both"></div>';
                faqList += '<div class="cs_faq_answer"><h4>A</h4>';
                faqList += '<p>' + items.reply + '</p></div></li>';
                $('#cs_faq_contents_list').append(faqList);
            });
            // 페이징
            $('#faq_paging .pagingDiv').append(data.paging.pagingHTML);
        },
        error: function (err) {
            console.log(err);
        }
    });
};
// faq 항목 선택 시 답변 노출
// $('.question a').click(function(){
//     console.log($(this));
//
//     const pLi = $(this).parent().parent();
//     const answer = $(this).parent().next().next();
//     if(pLi.hasClass('answer_open') === true){
//         pLi.removeClass('answer_open');
//         pLi.attr('style', 'display: flex');
//         answer.attr('style', 'display: none');
//     } else {
//         pLi.addClass('answer_open');
//         pLi.attr('style', 'display: block');
//         answer.attr('style', 'display: block');
//     }
// });
function showAnswer(element) {
    const pLi = $(element).parent().parent();
    const answer = $(element).parent().next().next();
    if (pLi.hasClass('answer_open') === true) {
        pLi.removeClass('answer_open');
        pLi.attr('style', 'display: flex');
        answer.attr('style', 'display: none');
    } else {
        pLi.addClass('answer_open');
        pLi.attr('style', 'display: block');
        answer.attr('style', 'display: block');
    }
}

// 검색
$('#faq_search_btn').click(function () {
    if ($('#search_faq_keyword').val() == '') {
        $('#search_faq_keyword').attr('placeholder', '검색어를 입력해주세요.');
    } else {
        console.log($('#search_faq_keyword').val());
        $.ajax({
            type: 'post',
            url: '/dangjang/shop/cs/faq/search',
            data: {
                'pg': $('#FaqPg').val(),
                'keyword': $('#search_faq_keyword').val()
            },
            success: function (data) { // list, paging 전달
                $('#cs_faq_contents_list').empty();
                $('#faq_paging .pagingDiv').empty();

                $.each(data.list, function (index, items) {
                    let faqList = '<li >';
                    faqList += '<div class="question"><span class="q_mark">Q</span>';
                    faqList += '<a class="cs_faq_one " onclick="showAnswer(this)">' + items.content + '</a></div>';
                    faqList += '<div style="clear:both"></div>';
                    faqList += '<div class="cs_faq_answer"><h4>A</h4>';
                    faqList += '<p>' + items.reply + '</p></div></li>';
                    $('#cs_faq_contents_list').append(faqList);
                });
                // 페이징
                $('#faq_paging .pagingDiv').append(data.paging.pagingHTML);
            },
            error: function (err) {
                console.log(err);
            }
        });
    }
});

function moveToOneToOne() {
    location.href = '/dangjang/mypage/qna';
}

function moveToLogin() {
    location.href = '/dangjang/shop/member/login';
}

// faq 페이징
function faqPaging(pg2) {
    faqType_list_paging(pg2);
}