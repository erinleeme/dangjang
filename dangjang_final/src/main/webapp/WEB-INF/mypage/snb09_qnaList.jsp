<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>

</style>
<jsp:include page="minibar.jsp" />
<article class="mypContainer" >
    <jsp:include page="snb.jsp" />
    <section class="mypContent">
        <section class="head_content">
            <h3>고객 문의</h3>
            <span class="tit_sub01">FAQ를 확인하시면 답변을 더 빠르게 찾을 수 있습니다.</span>
            <br>
            <hr color="#1A237E" width="100%" size="2px">
        </section>
        <section class="tabNav">
            <ul>
                <li>
                    <input id="perQna" type="radio" name="tab_item" checked>
                    <label class="tabLabel" for="perQna">1:1 문의</label>
                </li>
                <li>
                    <input id="prodQna" type="radio" name="tab_item">
                    <label class="tabLabel" for="prodQna">상품문의</label>
                </li>
            </ul>
        </section>

        <section id="tab01Content" class="tabContentWrap">
            <div class="otobutton">
                <a class="btn_ty01 add" id="btnPerQuestion"
                        onclick="javascript:qnaOpen();"  href="javascript:void(0);">
                    문의하기
                </a>
            </div>
            <div>
                <div class="qna_area">
                    <ul class="qna_list" id="qnaHtml">
                    </ul>
                </div>
                <div class="paging"></div>
            </div>
        </section>


        <section id="tab02Content" class="tabContentWrap">
            <section class="tab_content" id="pd_content">
                <section class="head_content">
                </section>
                <div class="qna_area">
                    <ul class="qna_list" id="pdQnaHtml">
                    </ul>
                </div>
            </section>
        </section>
        <div class="layout_paging" id="faq_paging">
            <div class="pagingDiv">

            </div>

        </div> <!--paging-->

    </section>
</article>


<%--상품문의 모달--%>
<div class="modalWrap" id="qnaModalContainer">
    <div class="modalArea" id="qnaModalContent">
        <div class="modalHeader">
            <h3>상품문의 수정</h3>
            <span>문의 내용을 작성하세요</span>
        </div>
        <div class="modalBody">
            <form class="modal-form" id="qnaForm">
                <ul>
                    <li>
                        <input type="hidden" id="qnaSeqNo" name="qnaSeqNo" readonly>
                        <%--                        <input type="hidden" id="qnaProdNo" name="qnaProdNo" readonly>--%>
                    </li>
                    <li>
                        <dt>문의내용</dt>
                        <dd>
                            <textarea required id="qnaContent" name="qnaContent"
                                      class="input_ty_modal" >
                            </textarea>

                        </dd>
                    </li>
                </ul>
            </form>
        </div>
        <div class="modalFooter">
            <div class="mybox bg-1">
                <a class="buttonYE button--winona button--border-thin button--round-s"
                   href="javascript:void(0);"   id="qnaCloseBtn" >
                    <span>취소</span>
                </a>
                <a class="buttonYE button--winona button--border-thin button--round-s"
                   href="javascript:void(0);"   id="qnaSubmitBtn" >
                    <span>저장</span>
                </a>
            </div>

        </div>
    </div>
</div>


<%--1:1문의 모달--%>
<div class="modalWrap" id="otoModalContainer">
    <div class="modalArea" id="otoModalContent">
        <div class="modalHeader">
            <h3>1:1문의</h3>
            <h5>반품/환불</h5>
            <span>제품 이상 혹은 하자로 인하여 반품/환불이 필요한 경우 사진과 함께 자세한 설명을 남겨주세요</span>
        </div>
        <div class="modalBody" >
            <form class="modal-form" id="perQnaForm" method="post"
                enctype="multipart/form-data"
                action="/dangjang/mypage/oto/writeOto">
                <ul>
                    <li>
                        <input type="hidden" name="seq_oto_req" id="seq_oto_req" readonly>
                    </li>
                    <li class="displayOff "  id="liOrderNo">
                        <dt>주문번호</dt>
                        <dd>
                            <input class="input_ty_modal"
                                   required id="order_num" name="order_num"
                                   readonly >
                        </dd>
                    </li>
                    <li>
                        <dt>문의유형</dt>
                        <dd>
                            <input type="hidden" required readonly value="주문취소/환불"
                                    id="request_type" name="request_type" >
                            <select name="qtype" id="qtype" required
                                    class="selectTag" onchange="selectRequestTypeChange(this.value);">
                                <option value="주문취소/환불">주문취소/환불</option >
                                <option value="배송관련">배송관련</option>
                                <option value="배송관련">배송관련</option>
                                <option value="주문결제">주문결제</option>
                                <option value="회원정보">회원정보</option>
                                <option value="쿠폰/이벤트">쿠폰/이벤트</option>
                                <option value="기타문의">기타문의</option>
                            </select>
                        </dd>
                    </li>
                    <li>
                        <dt>제목</dt>
                        <dd>
                            <input class="input_ty_modal"
                                   required id="title" name="title"
                                   placeholder="제목을 입력하세요.">
                        </dd>
                    </li>

                    <li>
                        <dt>문의내용</dt>
                        <dd>
                            <textarea required id="content" name="content"
                                      class="input_ty_modal" ></textarea>

                        </dd>
                    </li>
                </ul>
            </form>
            <div class="revImgArea">
                <ul class="viewImg">
                    <li>
                        <div class="modalImgInput">
                            <label for="image2">업로드1</label>
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
        </div>
        <div class="modalFooter">
            <a href="javascript:void(0);" id="otoCloseBtn" class="btn_ty01" >취소</a>
            <input type="submit" id="otoSubmitBtn" class="btn_ty01" value="저장">
        </div>
    </div>
</div>



<script type="text/javascript" src="/js/myp09_qna.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>


