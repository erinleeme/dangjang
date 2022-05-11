<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="joinClearSection">
    <div class="joinClearContent">
        <div class="joinTitle">
            <h1>회원가입 완료</h1>
        </div> <!--end c:d_pwdSearch div-->
        <div class="joinClearView">
            <c:if test="${social != 'kakao'}">
                <div id="basicMember">
                    <p class="j_c_id">
                        <span class="b_h">아이디</span><span>${id}</span>
                    </p>
                    <p class="j_c_name">
                        <span class="b_h">이름</span><span>${name}</span>
                    </p>
                    <p class="j_c_email">
                        <span class="b_h">이메일</span><span>${email}</span>
                    </p>
                    <p class="j_c_date">
                        <span class="b_h">가입일자</span><time>${joinDate}</time>
                    </p>
                </div>
            </c:if>
            <c:if test="${social == 'kakao'}">
                <div id="socialMember">
                    <p class="j_c_social">
                        <span class="b_h">카카오로 가입한 계정</span>
                    </p>
                    <p class="j_c_name">
                        <span class="b_h">이름</span><span>${name}</span>
                    </p>
                    <p class="j_c_date">
                        <span class="b_h">가입일자</span><time>${joinDate}</time>
                    </p>
                </div>
            </c:if>
        </div>
        <div>
            <button type="button" id="j_c_login_btn">로그인</button>
        </div>
        <script>
            $('#j_c_login_btn').click(function(){
                location.href='/dangjang/shop/member/login';
            });
        </script>
    </div>
</div>