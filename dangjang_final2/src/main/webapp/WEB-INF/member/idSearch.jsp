<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="dIdSearchSection">
    <div class="dIdSearchContainer">
        <div class="d_idSearch">
            <h1>아이디 찾기</h1>
        </div> <!--end c:d_isSearch div-->
        <div class="d_idSearch_content">
            <!-- <div class="d_idSearch_way">
                <button type="button" class="d_idSearch_btn idSearch_select">휴대폰 인증</button>
                <button type="button" class="d_idSearch_btn">이메일 인증</button>
            </div> end c:idSearch_way div -->
            <form class="idSearchForm">
                <div>
                    <label for="idSearch_name" class="blind">이름</label>
                    <div>
                        <input type="text" id="idSearch_name" name="idSearch_name" placeholder="이름을 입력해주세요">
                    </div>
                </div>
                <div>
                    <label for="idSearch_phone" class="blind">휴대폰 번호</label>
                    <div>
                        <input type="tel" id="idSearch_phone" name="idSearch_phone" minlength="11" maxlength="11"
                               placeholder="휴대폰 번호를 입력해주세요">
                    </div>
                </div>
                <div class="idSearch_verification" style="display: flex;">
                    <div>
                        <label for="idSearch_number" class="blind">인증번호</label>
                        <div>
                            <input type="tel" id="idSearch_number" name="idSearch_number"
                                   minlength="4" maxlength="4"
                                   placeholder="인증번호 4자리">
                        </div>
                    </div>
                    <button type="button" disabled class="idSearchNum_request_btn">
                        <span>재발송</span>
                    </button>
                    <p id="idSearch_count">00:00</p>
                </div>
                <div>
                    <button type="button"  disabled class="idSearch_btn" id="idSearch_btn">
                        <span>인증번호 받기</span>
                    </button>
                    <button type="button" disabled class="idSearch_chk_btn" id="idSearch_chk_btn">
                        <span>확인</span>
                    </button>
                </div>
            </form>
        </div>
    </div> <!--end c:dIdSearchContainer div-->
</div> <!--end c:dIdSearchSection div-->