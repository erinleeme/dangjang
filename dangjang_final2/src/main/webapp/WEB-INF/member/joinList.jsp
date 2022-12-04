<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div id="joinList">
    <div class="joinListSection">
        <!-- 버튼은 a태그로 변경 예정 -->
        <h1>회원가입</h1>
        <div class="joinList_view">
            <div class="btn_d_join btnSize" >
                <p>일반 회원가입</p>
            </div>
            <div class="joinSocial">
                <div class="btn_join_social btnSize" id="joinByKakao">
                    <p class="kakao">카카오로 회원가입</p>
                </div>
            </div>
            <div class="login_msg">
                <a href="/dangjang/shop/member/login">이미 가입하셨나요? <b>로그인하기</b> > </a>
            </div>
        </div><!--end c:joinList_view-->
    </div><!--end c:joinListSection div-->
</div><!--end i:joinList div-->