<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="minibar.jsp"/>
<article class="mypContainer">
    <jsp:include page="snb.jsp"/>
    <section class="mypContent">
        <section class="head_content">
            <h3>나의 상품 후기</h3>
            <span class="tit_sub01">주간 베스트 후기를 뽑아 쿠폰을 발송해드립니다.</span>
            <br>
            <hr color="#1A237E" width="100%" size="2px">
        </section>
        <section class="tabNav">
            <ul>
                <li>
                    <input id="canWrite" type="radio" name="tab_item" checked>
                    <label class="tabLabel" for="canWrite" id="testCount1">작성 가능한 후기 <br></label>
                </li>
                <li>
                    <input id="wrote" type="radio" name="tab_item">
                    <label class="tabLabel" for="wrote" id="testCount2">작성한 후기 </label>
                </li>
            </ul>
        </section>
        <section id="tab01Content" class="tabContentWrap">
            <ul class="review" id="canWriteHtml">
            </ul>
            <section class="paging">
               <%-- <span>페이징 공간</span>--%>
            </section>

        </section>
        <section id="tab02Content" class="tabContentWrap">
            <ul class="review" id="wroteHtml">
            </ul>
            <section class="paging">
                <%--<span>페이징 공간</span>--%>
            </section>
        </section>

    </section>
</article>


<script>
    //값 표시하기
/*
    $(function(){
        $.ajax({
            type: 'get',
            url: '/dangjang/mypage/review/countReview',
            data: {"possibleCount": possibleCount},
            contentType: "application/json",
            dataType: 'json',
                success: function(data){
                console.log("success");
                },
                error: function (err){
                    console.log(err);
                }
            });
        });
*/


</script>


<div class="modalWrap" id="modalContainer">
    <div class="modalArea" id="modalContent">
        <div class="modalHeader">
            <h3>리뷰 작성</h3>
            <span>매일 아침, 당신의 냉장고 앞까지</span>
        </div>
        <div class="modalBody" id="reviewBody">
            <a class="QnaProdUnit" href="javascript:void(0);">
                <div class="prodUnit">
                    <div class="thumb">
                        <div class="img">
                            <img id="dataImg">
                        </div>
                    </div>
                    <div class="info">
                        <p class="name" id="dataName"></p>
                    </div>
                </div>
            </a>
            <div style="margin: 10px 0;">
                <div>
                    <span class="modalMiniTit">상품은 어떠셨나요?</span>
                </div>
                <div class="scoreArea">
                    <div class="starBox" role="radiogroup">
                        <a role="radio" class="radioStar" aria-checked="false" id="star5"
                           data-score="5"></a>
                        <a role="radio" class="radioStar" aria-checked="false" id="star4"
                           data-score="4"></a>
                        <a role="radio" class="radioStar" aria-checked="false" id="star3"
                           data-score="3"></a>
                        <a role="radio" class="radioStar" aria-checked="false" id="star2"
                           data-score="2"></a>
                        <a role="radio" class="radioStar choiceStar" aria-checked="false" id="star1"
                           data-score="1"></a>
                    </div>
                </div>
            </div>
            <form class="modal-form" id="reviewForm" enctype="multipart/form-data">

                <textarea required id="content" name="content" placeholder="맛, 신선도, 배송 관련 후기를 남겨주세요."
                          class="textarea_ty" maxlength="2000"></textarea>

                <input type="hidden" name="seq_review" id="seq_review">
                <input type="hidden" name="seq_order_pdt" id="seq_order_pdt" readonly><!--order상품번호-->
                <input type="hidden" name="score" id="score"><!--점수-->



                <div class="revImgArea">
                    <ul class="viewImg">
                        <li>
                            <div class="">
                                <label for="image2">업로드</label>
                                <input type="file" accept="image/*" data-imageid="thumImgArea"
                                       onclick="addThumnail(event);" name="image" id="image2" multiple="true">
                                <label for="image1">업로드2</label>
                                <input type="file" name="image" accept="image/*" data-imageid="thumImgArea"
                                       onclick="addThumnail(event);" name="image" id="image1" multiple="true">

                            </div>
                        </li>
                        <li>
                            <img id="thumImgArea">
                        </li>
                        <li>
                            <img id="thumImgArea2">
                        </li>
                    </ul>
                </div>

            </form>

        </div>
        <div class="modalFooter">
            <a href="javascript:void(0);" id="closeBtn" class="btn_ty01">취소</a>
            <botton href="javascript:void(0);" id="addReview" class="btn_ty01 whatIs">저장</botton>
        </div>
    </div>
</div>
<script type="text/javascript" src="/js/myp05_review.js"></script>