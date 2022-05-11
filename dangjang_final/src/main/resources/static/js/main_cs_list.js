// notice list 가져오기
$(function() {
    $.ajax({
        type: 'post',
        url: '/dangjang/shop/main/notice',
        dataType: 'json',
        success: function (data) {
            $.each(data, function (index, items) {
                let noticeList = '<li>';
                noticeList += '<a href="/dangjang/shop/cs/noticeView?pg=1&no=' + items.seq_notice + '"><span class="cs-inner">' + items.title + '</span></a>';
                noticeList += '<span class="cs-date">' + items.create_date + '</span>';
                noticeList += '</li>';
                $('#main_cs_noticeList').append(noticeList);
            });
        },
        error: function (err) {
            console.log(err);
        }
    });
});

// faq list 가져오기
$(function() {
    $.ajax({
        type: 'post',
        url: '/dangjang/shop/main/faq',
        dataType: 'json',
        success: function (data) {
            $.each(data, function (index, items) {
                let faqlist = '<li>';
                faqlist += '<a href="/dangjang/shop/cs/faqList"><span class="cs-inner">' + items.content + '</span></a>';
                faqlist += '</li>';
                $('#main_cs_faqList').append(faqlist);
            });
        },
        error: function (err) {
            console.log(err);
        }
    });
});