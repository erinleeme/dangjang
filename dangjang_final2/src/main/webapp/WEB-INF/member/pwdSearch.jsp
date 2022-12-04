<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="dPwdSearchSection">
    <div class="dPwdSearchContainer">
        <div class="d_pwdSearch">
            <h1>비밀번호 찾기</h1>
        </div> <!--end c:d_pwdSearch div-->
        <div class="d_pwdSearch_content">
            <form class="pwdSearchForm">
                <div>
                    <label for="pwdSearch_id" class="blind">아이디</label>
                    <div>
                        <input type="text" id="pwdSearch_id" name="pwdSearch_id" value
                               minlength="5" maxlength="15"
                               placeholder="아이디를 입력해 주세요">
                    </div>
                </div>
                <div>
                    <label for="pwdSearch_phone" class="blind">휴대폰 번호</label>
                    <div>
                        <input type="tel" id="pwdSearch_phone" name="pwdSearch_phone"
                               minlength="10" maxlength="11" placeholder="휴대폰 번호를 입력해 주세요">
                    </div>
                </div>
                <div class="pwdSearch_verification" style="display: flex;">
                    <div>
                        <label for="pwdSearch_number" class="blind">인증번호</label>
                        <div>
                            <input type="text" id="pwdSearch_number" name="pwdSearch_number"
                                   minlength="4" maxlength="4"
                                   placeholder="인증번호 4자리">
                        </div>
                    </div>
                    <button type="button" disabled class="pwdSearchNum_request_btn">
                        <span>재발송</span>
                    </button>
                    <p id="pwdSearch_count">00:00</p>
                </div>
                <div>
                    <button type="button"  disabled class="pwdSearch_btn" id="pwdSearch_btn">
                        <span>인증번호 받기</span>
                    </button>
                    <button type="button" disabled class="pwdSearch_chk_btn" id="pwdSearch_chk_btn">
                        <span>확인</span>
                    </button>
                </div>
            </form>
        </div>
    </div> <!--end c:dPwdSearchContainer div-->
</div> <!--end c:dPwdSearchSection div-->