//탭
$(document).ready(function(){
    $("#tab02Content").last().hide();
    const perQnaView = $("#tab01Content");
    const prodQnaView = $("#tab02Content");

    $("#perQna").click(function(){
        perQnaView.show();
        prodQnaView.hide();
    });
    $("#prodQna").click(function(){
        prodQnaView.show();
        perQnaView.hide();
    });
});


//content js 토글 열기
$(document).on("click",'.div_open',function(){
    if ($(this).next().css('display') == 'none') {
        $(this).addClass("info_on");
        $(this).next().attr('style', 'display: block');
    } else {
        $(this).removeClass("info_on");
        $(this).next().attr('style', 'display: none');
    }
});

/* ========================== 1.1문의 등록과정================================*/
var selectRequestTypeChange = function (value){
    console.log("requestType",value);
    $("#request_type").val(value);
}
// qna 작성form 보내기~
/*
$('#perQnaSubmitBtn').click(function(){
    console.log("qnaSubmit 버튼 눌렀음");
    if($('#qTitle').val() == ''){
        $('.modal-form #qTitle').focus();
        console.log("제목 빈칸");
    } else if($('#qContent').val() == ''){
        $('.modal-form #qContent').focus();
        console.log("내용 빈칸");
    } else {
        $.ajax({
            type: 'post',
            url: '/dangjang/mypage/oto/writeOto',
            data: $('#perQnaForm').serialize(),
            dataType: 'text',
            success: function(data){
                if(data == 'writeQna'){
                    location.href='/dangjang/mypage/qna';
                } else {
                    alert('실패!');
                };
            },
            error: function(err){
                console.log(err);
            }
        });
    }
})
*/


$('#otoSubmitBtn').click(function(){

    var form = $('#perQnaForm')[0];
    var formData = new FormData(form);

    if ($('#title').val() == '') {
        alert("제목을 입력하세요");
    }else if($('#content').val() == ''){
        alert("내용을 입력하세요");
    }else if( $('#seq_oto_req').val() == '' ){
        $.ajax({
            type: 'post',
            enctype: 'multipart/form-data',
            url: '/dangjang/mypage/oto/writeOto',
            data: formData,
            processData: false,
            contentType: false,
            dataType : "text",
            success: function() {
                alert('문의 내용이 등록되었습니다. ');
                document.getElementById('otoCloseBtn').click();
            },
            error: function(err){
                alert(err);
            }
        });
    } else {
        $.ajax({
            type: 'post',
            enctype: 'multipart/form-data',
            url: '/dangjang/mypage/oto/updateOto',
            data: formData,
            processData: false,
            contentType: false,
            dataType : "text",
            success: function() {
                alert('문의 내용이 수정되었습니다. ');
                document.getElementById('otoCloseBtn').click();
            },
            error: function(err){
                alert(err);
            }
        });
    }


});

$(document).on('click','.btnDelQna',function(){
    var qnaSeqNo = $(this).data('seqno');
    console.log("삭제하기 눌렀음",qnaSeqNo);
    $.ajax({
        type: 'post',
        url: '/dangjang/mypage/oto/deleteOto',
        data: {'otoId' :qnaSeqNo},
        dataType: 'json',
        success: function (data) {
            alert("삭제가 완료되었습니다");
            if(data == 'deleteQnaOk'){
                console.log('삭제가 되었나요!');
                alert("삭제가 완료되었습니다");
            }
        },
        error: function (err) {
            console.log("실패");
            console.log(err);
        }
    });
});

/* ========================== 1.1문의 모달================================*/
//modal Form 1:1
const otoClose =document.getElementById('otoCloseBtn');
const otoModal = document.getElementById('otoModalContainer');

//Hide modal _1:1
window.addEventListener('click', (e) => {
    e.target === otoModal ? otoModal.classList.remove('show-modal') : false;
    e.target === otoModal ? document.getElementById("perQnaForm").reset() : false;
    e.target === otoModal ? $('#liOrderNo').addClass("displayOff"): false;
})


//Open modal 신규 등록 버튼 클릭
function qnaOpen(){
    document.getElementById("perQnaForm").reset();
    otoModal.classList.add('show-modal');
}

$(function(){
/*    document.getElementById("perQnaForm").reset();

    $("#btnPerQuestion").click(function(){
        otoModal.classList.add('show-modal');
    });*/
    $("#otoCloseBtn").click(function(){
        console.log("클로즈");
        otoModal.classList.remove('show-modal');
        document.getElementById("perQnaForm").reset();
        $('#liOrderNo').addClass("displayOff");
    });

});
/*모달 레이어 팝업 끝*/

//Open modal 1:1 수정 버튼 클릭
/*수정버튼 클릭시 -> 모달 레이어 팝업 시작*/
$(document).on('click','.otoModifyFormBtn',function(){
    console.log("수정하기 눌렀음", $(this).data('seqno'));
    console.log("수정하기 눌렀음", $(this).data('title'));
    console.log("수정하기 눌렀음", $(this).data('content'));
    $('#seq_oto_req').val($(this).data('seqno'));
    $('#title').val($(this).data('title'));
    $('#content').val($(this).data('content'));

    //수정불가능 ordernum
    if($(this).data('order_num') != null){
        console.log("???",$(this).data('order_num'));
        $('#liOrderNo').removeClass("displayOff");
        document.getElementById("order_num").value =$(this).data('order_num');
    }
    if($(this).data('image1') != null){
        document.getElementById("image1").value =$(this).data('image1');
    }
    if($(this).data('image2') != null){
        document.getElementById("image2").value =$(this).data('image2');
    }

    otoModal.classList.add('show-modal');
});





function pdQuestionDel(){
    document.getElementById('popup_del_pd_qna').style.display = 'block';
}

// 값 뿌려주기
$(function(){
    $.ajax({
        type: 'GET',
        url: '/dangjang/mypage/oto/getOtoList',
        dataType: 'text',
        success: function(data){
            $('#qnaHtml').html(data);
        },
        error:  function(err){
            alert(JSON.stringify(err));
        }
    });
});










/* ===================상품문의 관련=====================*/
// 값 뿌려주기
$(function(){
    $.ajax({
        type: 'GET',
        url: '/dangjang/mypage/qna/getQnaList',
        dataType: 'text',
        success: function(data){
            $('#pdQnaHtml').html(data);
        },
        error:  function(err){
            alert(JSON.stringify(err));
        }
    });
});


// 삭제하기
$(document).on('click','.qnaDeleteFormBtn',function(){
    var seqQna = $(this).data('seqno');
    console.log("삭제하기 눌렀음",seqQna);
    $.ajax({
        type: 'post',
        url: '/dangjang/mypage/qna/deleteQna',
        data: {'seq_qna' :seqQna},
        dataType: 'json',
        success: function (data) {
            alert("삭제가 완료되었습니다");
        },
        error: function (err) {
            console.log(err);
        }
    });
});

//수정하기
$('#qnaSubmitBtn').click(function(){
    if($('#qnaContent').val() == ''){
        alert("내용을 입력하세요");
    } else{
        $.ajax({
            type: 'post',
            url: '/dangjang/mypage/qna/updateQna',
            data: $('#qnaForm').serialize(),
            dataType: 'text',
            success: function (data) {
                console.log($('#qnaForm').serialize());
                location.href='/dangjang/mypage/qna';
            },
            error: function (err) {
                console.log(err);
            }
        });
    }


});

//Open modal 수정 버튼 클릭
/*수정버튼 클릭시 -> 모달 레이어 팝업 시작*/
$(document).on('click','.qnaModifyFormBtn',function(){
    console.log("상품 수정하기 눌렀음", $(this).data('seqno'));
    console.log("상품 수정하기 눌렀음?", $(this).data('prodno'));
    document.getElementById('qnaSeqNo').value = $(this).data('seqno');
    document.getElementById('qnaContent').value = $(this).data('qnacontent');

    qnaModal.classList.add('show-modal');
});

/* ========================== 상품문의 모달================================*/
//modal Form product Qna
const qnaClose =document.getElementById('qnaCloseBtn');
const qnaModal = document.getElementById('qnaModalContainer');

//Hide modal product Qna
window.addEventListener('click', (e) => {
    e.target === qnaModal ? qnaModal.classList.remove('show-modal') : false;
    e.target === qnaModal ? document.getElementById("qnaForm").reset() : false;
    e.target === qnaModal ? $('#liOrderNo').addClass("displayOff"): false;
})

//modal Form product Qna 테스트용
$(function(){
    $("#btnQna").click(function(){
        console.log("start qnamodify");
        qnaModal.classList.add('show-modal');
    });

    $("#qnaCloseBtn").click(function(){
        qnaModal.classList.remove('show-modal');
        document.getElementById("qnaForm").reset();
        $('#liOrderNo').addClass("displayOff");
    });
    /*모달 레이어 팝업 끝*/
});

/* ========================== 모달 끝================================*/


/*파일 미리보기 */


function setThumbnail(event) {
    var reader = new FileReader();
    reader.onload = function(event) {
        var thumImg = document.createElement("img");

        //thumImg.setAttribute("src", event.target.result);
        //document.querySelector("div#image_container").appendChild(img);
    };
    reader.readAsDataURL(event.target.files[0]);
}

$(":input[name='image']").change(function() {

    if( $(":input[name='u_file']").val() == '' ) {
        $('#thumImgArea').attr('src' , '');
    }
    $('#thumImgViewArea').css({ 'display' : '' });
    readURL(this);
});

// 콘텐츠 수정 :: 사진 수정 시 이미지 미리보기
function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function(e) {
            $('#thumImgArea').attr('src', e.target.result);
        }
        reader.readAsDataURL(input.files[0]);
    }
}

// 이미지 에러 시 미리보기영역 미노출
function imgAreaError(){
    $('#thumImgViewArea').css({ 'display' : 'none' });
}
$(document).ready(function(){
    $('#thumImgViewArea').css({ 'display' : '' });
});

