$(document).ready(function(){
    $("#tab02Content").last().hide();
    const canWriteReview = $("#tab01Content");
    const wroteReview = $("#tab02Content");

    $("#canWrite").click(function(){
        canWriteReview.show();
        wroteReview.hide();
    });
    $("#wrote").click(function(){
        wroteReview.show();
        canWriteReview.hide();
    });


});

var reviewle = $('input[name=reviewPossibleLength]').val();
console.log(" 시작",reviewle);


//모달 시작!!
const modal = document.getElementById('modalContainer');

$(function(){
    //Hide modal
    window.addEventListener('click', (e) => {
        e.target === modal ? modal.classList.remove('show-modal') : false;
        e.target === modal ? document.getElementById("reviewForm").reset() : false
        e.target === modal ? $(".radioStar[aria-checked='true']").attr("aria-checked",false) : false
        e.target === modal ? document.querySelector(".radioStar").classList.remove("choiceStar") : false
        e.target === modal ? $("input[name='u_file']").attr('src' , ''): false;
        e.target === modal ? document.getElementById('addReview').removeAttribute("data-seqno"): false;
    })
});

//Open modal
$(document).on('click','.btnReviewWrite',function(){
    console.log("click");
    var newSrc = '/images/'+$(this).data('serial_num')+'.jpg';
    document.querySelector('#dataImg').setAttribute('src',newSrc);
    document.getElementById('dataName').innerText =$(this).data('name');
    document.getElementById('seq_order_pdt').value =$(this).data('seq_order_pdt');

    modal.classList.add('show-modal');
});

$(function(){
    $("#closeBtn").click(function(){
        modal.classList.remove('show-modal');
        document.getElementById("reviewForm").reset();
        $(".radioStar[aria-checked='true']").attr("aria-checked",false);
        document.querySelector(".radioStar").classList.remove("choiceStar");
        $("input[name='u_file']").attr('src' , '');
        document.getElementById('addReview').removeAttribute("data-seqno");
    });

});/*모달 레이어 팝업 끝*/

//Open modal 수정 버튼 클릭
/*수정버튼 클릭시 -> 모달 레이어 팝업 시작*/
$(document).on('click','.btnModifyFormReview',function(){
    //상품이미지
    var newSrc = '/images/'+$(this).data('serial')+'.jpg';
    document.querySelector('#dataImg').setAttribute('src',newSrc);
    document.getElementById('dataName').innerText =$(this).data('name');
    document.getElementById('seq_order_pdt').value =$(this).data('seq_order_pdt');

    //리뷰내용
    document.getElementById('seq_review').value = $(this).data('seq_review');
    document.getElementById('score').value =$(this).data('score');
    document.getElementById('content').value =$(this).data('content');

    document.getElementById('addReview').setAttribute("data-seqno",$(this).data('seq_review')) ;
    //별점
    $(".radioStar").attr("aria-checked",false);

    var scoreVal = $(this).data('score');
    var starIs= document.getElementsByClassName("radioStar");
    //별점 식별
    console.log(" 별점은 ");

/*
    //별점 식별
    $(".radioStar").attr("aria-checked",false);

    for (var i = 0; i < starList.length ; i++) {
        if ( starList[i].getAttribute("data-score") < scoreValue){
            starList[i].classList.remove("choiceStar");
        }else if(starList[i].getAttribute("data-score") == scoreValue){
            $(this).attr("aria-checked",true);
            document.querySelector(".radioStar[aria-checked='true']").classList.add("choiceStar");
        }else{
            starList[i].classList.add("choiceStar");
        }
    }
*/

    //첨부파일 미리보기
    var imgSrc1 = "";
    var imgSrc2 = "";
    if($(this).data('image1') != ""){
        imgSrc1 ='/review/'+$(this).data('image1');
        //document.getElementById('image2').value =$(this).data('image1');
        let imgText='';
        if($(this).data('image2') != ""){
            imgSrc2 ='/review/'+$(this).data('image2');
        }

       // $('.pickPdArea .pdBoxList').append(pickView);
    }
    modal.classList.add('show-modal');
});





/* =====================작성 수정 삭제=======================*/
//작성



$('#addReview').click(function(){
    var thereIsSeq = document.getElementById('seq_review').value;
    console.log("수정할 시퀀스가 제대로 들어갔는지 ",thereIsSeq);
    var form = $('#reviewForm')[0];
    var formData = new FormData(form);

    if ($('#score').val() == '') {
        alert("별점을 남겨주세요!");
    }else if($('#content').val() == '') {
        alert("내용을 작성해주세요!");
    }else if(thereIsSeq==''){ //등록 시작
        console.log(" =='' 등록시작");
        $.ajax({
            type: 'post',
            enctype: 'multipart/form-data',
            url: '/dangjang/mypage/review/writeReview',
            data: formData,
            processData: false,
            contentType: false,
            dataType : "text",
            success: function() {
                modal.classList.remove('show-modal');
                document.getElementById("reviewForm").reset();
                location.href='/dangjang/mypage/review#wroteHtml';
            },
            error: function(err){
                //alert(err);
                alert(JSON.stringify(err));
            }
        });
        console.log("등록 끝났어욤");
    } else {
        console.log("수정 시작");
        $.ajax({
            type: 'post',
            enctype: 'multipart/form-data',
            url: '/dangjang/mypage/review/updateReview',
            data: formData,
            processData: false,
            contentType: false,
            dataType : "text",
            success: function() {
                modal.classList.remove('show-modal');
                document.getElementById("reviewForm").reset();
                location.href='/dangjang/mypage/review#wroteHtml';
            },
            error: function(err){
                //alert(err);
                alert(JSON.stringify(err));
            }
        });
    }
});


//작성한 후기 삭제
$(document).on('click','.btnDelReview',function(){
    var seqNo = $(this).data('seq_review');
    console.log(seqNo,"삭제 시작")
    $.ajax({
        type: 'get',
        url: '/dangjang/mypage/review/deleteReview',
        data: {'reviewNum' : seqNo},
        dataType: 'text',
        success: function (data) {
            location.href='/dangjang/mypage/review#wroteHtml';
        },
        error: function (err) {
            console.log("실패");
            console.log(err);
        }
    });
});

/* ============================================*/
//작성 가능한 리뷰 목록 갖고오기
$(function(){
    $.ajax({
        type: 'GET',
        url: '/dangjang/mypage/review/getWriteReviewList',
        dataType: 'text',
        success: function(data){
            $('#canWriteHtml').html(data);
        },
        error:  function(err){
            console.log(err);
            alert(JSON.stringify(err));
        }
    });
});

//리뷰 작성한 목록 가져오기
$(function(){
    $.ajax({
        type: 'GET',
        url: '/dangjang/mypage/review/getWritenReviewList',
        dataType: 'text',
        success: function(data){
            $('#wroteHtml').html(data);
        },
        error:  function(err){
            alert(JSON.stringify(err));
        }
    });
});


$(function(){
    $.ajax({
        type: 'GET',
        url: '/dangjang/mypage/review/countReview',
        dataType: 'text',
        success: function(data){
        },
        error:  function(err){
            console.log(err);
            alert(JSON.stringify(err));
        }
    });
});

/*별점 관련 js*/
$(document).on('click','.radioStar',function(){
    //값 저장
    var scoreValue = $(this).data("score");
    $("#score").val(scoreValue);

    var starList= document.getElementsByClassName("radioStar");
    //별점 식별
    $(".radioStar").attr("aria-checked",false);

    for (var i = 0; i < starList.length ; i++) {
        if ( starList[i].getAttribute("data-score") < scoreValue){
            starList[i].classList.remove("choiceStar");
        }else if(starList[i].getAttribute("data-score") == scoreValue){
            $(this).attr("aria-checked",true);
            document.querySelector(".radioStar[aria-checked='true']").classList.add("choiceStar");
        }else{
            starList[i].classList.add("choiceStar");
        }
    }
});





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

