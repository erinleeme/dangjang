<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="minibar.jsp" />
<article class="mypContainer" >
    <jsp:include page="snb.jsp" />
    <section class="mypContent">
        <section class="head_content">
            <h3>배송지 관리</h3>
            <span class="tit_sub01">자주 배송하는 주소를 저장해보세요!</span>
            <br>
            <hr color="#1A237E" width="100%" size="2px">
        </section>

        <section class="container on_addr" id="addr_view">
            <div class="addr_header">
                <a class="btn_ty01 add" href="javascript:void(0);" onclick="plusAddress();">
                    배송지 추가
                </a>
            </div>
            <div class="myAddrs">
                <ul id="addr_list">

                </ul>
            </div>

        </section>
        <%--<a class="popPoint" href="javascript:void(0);">test모달열기</a>--%>
    </section>
</article>


<div class="modalWrap" id="modalContainer">
    <div class="modalArea" id="modalContent">
        <div class="modalHeader">
            <h3>배송지 등록</h3>
            <span>매일 아침, 당신의 냉장고 앞까지</span>
        </div>
        <div class="modalBody">
            <form class="modal-form" id="addrForm">
                <div>
                    <div class="checkYE">
                        <input type="checkbox" id="isDefault" name="isDefault">
                        <label for="isDefault">기본 배송지로 저장</label>
                    </div>
               </div>
                <ul id="a_selectAddress">
                    <li>
                        <dt>배송지명</dt>
                        <dd><input class="input_ty_modal" required id="addrName" name="addrName"
                                   maxlength="15" minlength="1"
                                   placeholder="집, 회사 등 배송지 별명을 입력해주세요.">
                        </dd>
                    </li>
                    <li>
                        <dt>받는 사람</dt>
                        <dd>
                            <input class="input_ty_modal" maxlength="15" minlength="1"
                                   required id="receptionName" name="receptionName"
                                   placeholder="받는 사람의 이름을 입력해주세요.">
                        </dd>
                    </li>
                    <li>
                        <dt>연락처</dt>
                        <dd>
                            <input class="input_ty_modal" maxlength="15" minlength="1"
                                   required id="recipient_phone" name="recipient_phone"
                                   placeholder="휴대전화를 입력해주세요.">
                        </dd>
                    </li>

                    <li>
                        <input type="text" class="input_ty_modal" name="a_address" id="a_address" value required readonly label="주소"><!--도로명주소-->
                        <input type="button" class="btn_ty01" id="btn_searchAddr" value="재검색" onclick="checkPost()">
                    </li>
                    <li >
                        <input type="text" class="input_ty_modal" value name="a_addr_detail" id="a_addr_detail" placeholder="상세 주소를 입력해 주세요">
                    </li>
                    <li>
                        <dt>배송 요청사항</dt>
                        <dd>
                            <input class="input_ty_modal"
                                   required id="addressContent" name="addressContent"
                                   placeholder="공동현관이 있을경우 출입 비밀번호를 알려주세요.">
                        </dd>
                    </li>
                    <li>
                        <input type="hidden" name="seq_address" id="seq_address" readonly>
                        <input type="hidden" name="defaultStatus" id="defaultStatus" readonly>
                        <input type="hidden" name="zipcode" id="zipcode" readonly><!--zipcode-->
                        <input type="hidden" name="addr1" id="addr1" size="60" placeholder="주소" readonly><!--address1-->
                        <input type="hidden" value name="a_addr" id="a_addr" readonly label="주소"> <!--zipcode-->
                    </li>
                </ul>

            </form>
        </div>
        <div class="modalFooter">
            <a href="javascript:void(0);" id="closeBtn" class="btn_ty01" >취소</a>
            <a href="javascript:void(0);" id="addAddress" class="btn_ty01 whatIs" >저장</a>
<%--            <a href="javascript:void(0);" class="btn_ty01 whatIs" id="modifyAddress">저장</a>--%>
        </div>
    </div>
</div>

<script>
    /*Test 모달 레이어 팝업 시작*/
    $(function(){
        $(".popPoint").on('click',function(){
            modal.classList.add('show-modal');
        });

    });
</script>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="/js/myp10_addr.js"></script>