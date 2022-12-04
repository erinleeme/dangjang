// notice 목록 가져오기
$(function(){
    console.log($('#noticePg').val());
    $.ajax({
        type: 'post',
        url: '/dangjang/shop/cs/noticeList',
        data: 'pg='+$('#noticePg').val(),
        dataType: 'json',
        success: function(data){
            $('#cs_list_table_notice').empty();
            $('#notice_paging .pagingDiv').empty();

            $.each(data.list, function(index, items){ // list, paging 전달
                // DOM
                if(data.pg == 1){
                    $('<tr/>').append($('<td/>', {
                        text: parseInt(index) + 1
                    })).append($('<td/>', {
                    }).append($('<a/>', {
                        href: '/dangjang/shop/cs/noticeView?pg='+$('#noticePg').val()+'&no='+items.seq_notice,
                        text: items.title,
                        class: "noticeTitle noticeView " + items.seq_notice
                    }))).append($('<td/>', {
                        text: items.create_date
                    })).appendTo($('#cs_list_table_notice'));
                } else {
                    $('<tr/>').append($('<td/>', {
                        text: (parseInt(index) * data.pg) + 1
                    })).append($('<td/>', {
                    }).append($('<a/>', {
                        href: '/dangjang/shop/cs/noticeView?pg='+$('#noticePg').val()+'&no='+items.seq_notice,
                        text: items.title,
                        class: "noticeTitle noticeView " + items.seq_notice
                    }))).append($('<td/>', {
                        text: items.create_date
                    })).appendTo($('#cs_list_table_notice'));
                }
            });
            // paging
            $('#notice_paging .pagingDiv').append(data.paging.pagingHTML);
        },
        error: function(err){
            console.log(err);
        }
    });

});
// 공지사항 상세보기 - 전체보기 클릭
$('#backto_csNoticeList').click(function(){
    location.href='/dangjang/shop/cs/notice?pg='+$('#noticeOnePg').val();
    // $.ajax({
    //     type: 'get',
    //     url: '/dangjang/shop/cs/notice',
    //     data: 'pg='+$('#noticeOnePg').val(),
        // dataType: 'json',
        // success: function(data){
        //     $('#cs_list_table_notice').empty();
        //     $('#notice_paging .pagingDiv').empty();
        //
        //     $.each(data.list, function(index, items){ // list, paging 전달
        //         // DOM
        //         $('<tr/>').append($('<td/>', {
        //             text: items.seq_notice
        //         })).append($('<td/>', {
        //         }).append($('<a/>', {
        //             href: '/dangjang/shop/cs/noticeView?pg='+$('#pg').val()+'&no='+items.seq_notice,
        //             text: items.title,
        //             class: "noticeView " + items.seq_notice
        //         }))).append($('<td/>', {
        //             text: items.create_date
        //         })).appendTo($('#cs_list_table_notice'));
        //     });
        //     // paging
        //     $('#notice_paging .pagingDiv').append(data.paging.pagingHTML);
        // },
        // error: function(err){
        //     console.log(err);
        // }
    // });
});
// 검색
$('#cs_search_btn').click(function(){
   if($('#search_cs_keyword').val() == ''){
       $('#search_cs_keyword').attr('placeholder', '검색어를 입력해주세요.');
   } else {
       $.ajax({
           type: 'post',
           url: '/dangjang/shop/cs/notice/search',
           data: {
               'keyword': $('#search_cs_keyword').val(),
               'pg': $('#noticePg').val()
           },
           dataType: 'json',
           success: function (data){
               $('#cs_list_table_notice').empty();
               $('#notice_paging .pagingDiv').empty();

               $.each(data.list, function(index, items){ // list, paging 전달
                   // DOM
                   if(data.pg == 1){
                       $('<tr/>').append($('<td/>', {
                           text: parseInt(index) + 1
                       })).append($('<td/>', {
                       }).append($('<a/>', {
                           href: '/dangjang/shop/cs/noticeView?pg='+$('#noticePg').val()+'&no='+items.seq_notice,
                           text: items.title,
                           class: "noticeTitle noticeView " + items.seq_notice
                       }))).append($('<td/>', {
                           text: items.create_date
                       })).appendTo($('#cs_list_table_notice'));
                   } else {
                       $('<tr/>').append($('<td/>', {
                           text: (parseInt(index) * data.pg) + 1
                       })).append($('<td/>', {
                       }).append($('<a/>', {
                           href: '/dangjang/shop/cs/noticeView?pg='+$('#noticePg').val()+'&no='+items.seq_notice,
                           text: items.title,
                           class: "noticeTitle noticeView " + items.seq_notice
                       }))).append($('<td/>', {
                           text: items.create_date
                       })).appendTo($('#cs_list_table_notice'));
                   }
               });
               // paging
               $('#notice_paging .pagingDiv').append(data.paging.pagingHTML);
           },
           error: function (err){
               console.log(err);
           }
       });
   };
});
// 페이징
function noticePaging(pg2){
    $.ajax({
        type: 'post',
        url: '/dangjang/shop/cs/noticeList',
        data: 'pg='+pg2,
        dataType: 'json',
        success: function(data){
            $.each(data.list, function(index, items){ // list, paging 전달
                // DOM
                $('<tr/>').append($('<td/>', {
                    text: items.seq_notice
                })).append($('<td/>', {
                }).append($('<a/>', {
                    href: '/dangjang/shop/cs/noticeView?pg='+$('#pg').val()+'&no='+items.seq_notice,
                    text: items.title,
                    class: "noticeView " + items.seq_notice
                }))).append($('<td/>', {
                    text: items.create_date
                })).appendTo($('#cs_list_table_notice'));
            });
            // paging
            $('#notice_paging .pagingDiv').append(data.paging.pagingHTML);
        },
        error: function(err){
            console.log(err);
        }
    });
}

function moveToOneToOne(){
    location.href='/dangjang/mypage/qna';
}

function moveToLogin(){
    location.href='/dangjang/shop/member/login';
}
