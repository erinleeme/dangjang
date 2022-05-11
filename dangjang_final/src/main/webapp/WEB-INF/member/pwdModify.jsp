<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="d_rePwdSection">
    <div class="d_rePwdContainer">
        <div class="d_repwd_title">
            <h1>비밀번호 재설정</h1>
        </div> <!--end c:d_pwdSearch div-->
        <div class="d_repwd_content">
            <form class="repwdForm">
                <input type="hidden" id="memId" value="${memId}">
                <div>
                    <label for="d_repwd" class="blind">새 비밀번호 등록</label>
                    <div>
                        <input type="password" id="d_repwd" name="d_repwd" class="d_re_div" minlength="8" maxlength="16" placeholder="새 비밀번호를 입력해 주세요">
                    </div>
                    <div class="r_div" id="r_pwd_div">
                        <span class="txt_case1">8자 이상 입력</span>
                        <span class="txt_case2">영문/숫자/특수문자(공백 제외)만 허용하며, 2개 이상 조합</span>
                        <span class="txt_case3">동일한 숫자 3개 이상 연속 사용 불가</span>
                    </div>
                </div>
                <div>
                    <label for="d_repwd_chk" class="blind">새 비밀번호 확인</label>
                    <div>
                        <input type="password" id="d_repwd_chk" name="d_repwd_chk" class="d_re_div" minlength="8" maxlength="16" placeholder="새 비밀번호를 한 번 더 입력해 주세요">
                    </div>
                    <div class="r_div" id="r_pwd_check_div">
                        <span class="txt_case1">동일한 비밀번호를 입력해주세요</span>
                    </div>
                </div>
                <div>
                    <button type="button" disabled class="d_repwd_btn">
                        <span>확인</span>
                    </button>
                </div>
            </form>
        </div>
    </div> <!--end c:dPwdSearchContainer div-->
</div> <!--end c:dPwdSearchSection div-->