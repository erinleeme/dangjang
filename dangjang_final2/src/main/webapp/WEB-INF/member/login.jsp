<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="dLoginSection">
    <div class="d_login">
        <!-- form -- method="" action="" -->
        <h1>로그인</h1>
        <div class="login_view" id="login_view">
            <form id="loginForm" class="loginForm" name="loginForm">
                <div class="formArea">
                    <label for="userId" class="blind">아이디</label>
                    <input type="text" name="userId" id="userId" size="15" minlength="5" maxlength="15"
                           class="dangjangLoginID loginFormInput" placeholder="아이디를 입력해주세요"/>
                </div> <!--end c:formArea div -->
                <div class="formArea">
                    <label for="userPwd" class="blind">비밀번호입력</label>
                    <input type="password" name="userPwd" id="userPwd" size="16" minlength="8" maxlength="16"
                           class="dangjangLoginPW loginFormInput" placeholder="비밀번호를 입력해주세요"/>
                </div> <!--end c:formArea div -->
                <div class="findInfo">
                    <a href="/dangjang/shop/member/find/id" class="findInfo_Id">
                        <span>아이디 찾기</span>
                    </a>
                    <a href="/dangjang/shop/member/find/pwd" class="findInfo_Pwd">
                        <span>비밀번호 찾기</span>
                    </a>
                </div> <!-- end c:findInfo div -->
                <div id="loginCheckMsg"></div>
                <div class="btn_login btnSize" >
                    <p>로그인</p>
                </div> <!-- end c:btn_login, btnSize div -->
                <div class="btn_l_join btnSize" >
                    <p>회원가입</p>
                </div> <!-- end c:btn_join, btnSize div -->
                <div class="kakao_Login_btn btnSize" >
                    <p>카카오 로그인</p>
                </div> <!-- end c:socialLogin div -->
            </form>
        </div> <!--end c:login_view i:login_view div -->
    </div> <!-- end c:d_login div -->
</div> <!-- end c:dLoginSection div -->
<!-- 로그인 js -->
<script type="text/javascript" src="/js/login.jsp"></script>