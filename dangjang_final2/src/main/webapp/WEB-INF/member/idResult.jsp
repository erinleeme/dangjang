<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="resultIdSection">
    <div class="resultIdView">
        <div class="resultIdHeader">
            <h4>고객님의 당장가게 계정</h4>
            <p>아이디 확인 후 로그인해 주세요.</p>
        </div> <!--end c:resultIdHeader div-->
        <div class="resultIdContent">
            <ul>
                <li id="resultIdContent_li">
                    <c:if test="${social != 'kakao'}">
                        <img class="member_profile" src="/icon/heartface.png">
                        <div>
                            <!--일반 회원은 아이디 보여주고, 소셜 로그인자는 소셜명 + 간편로그인-->
                            <div class="member_id">${memIdResult}</div>
                            <div class="member_joinDate">가입일자 ${joinDate}</div>
                        </div>
                    </c:if>
                    <c:if test="${social == 'kakao'}">
                        <img class="member_profile" src="/icon/heartface.png">
                        <div>
                            <div class="member_id">카카오로 가입한 계정</div>
                            <div class="member_joinDate">가입일자 ${joinDate}</div>
                        </div>
                    </c:if>
                </li>
            </ul>
        </div> <!--end c:resultIdContent-->
        <div class="resultIdBtn">
            <button type="button" class="searchPwd_btn btnSize">
                <span>비밀번호 찾기</span>
            </button>
            <button type="button" class="btn_login btnSize">
                <span>로그인</span>
            </button>
        </div> <!--end c:resultIdBtn div-->
    </div> <!--end c:resultIdView div-->
</div> <!--end c:resultIdSection div-->