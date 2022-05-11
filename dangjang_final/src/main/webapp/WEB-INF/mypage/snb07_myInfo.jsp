<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html lang="ko">
<head>
    <title>myInfoEdit</title>
    <!-- styles -->
    <link rel="stylesheet" type="text/css" href="/css/myp_toggle_switchy.css">
</head>
<style>


</style>

<body>

<jsp:include page="minibar.jsp"/>
<article class="mypContainer">
    <jsp:include page="snb.jsp"/>
    <section class="mypContent">
        <section class="head_content">
            <h2 class="tit_02">개인 정보 수정 </h2>
            <br>
            <hr color="#1A237E" width="100%" size="2px">
        </section>
        <article id="infoModify">
            <section class="myConstInfo">
                <input id="platformType" type="hidden" readonly value="${member.platform}"/>
                <c:if test="${member.platform == '일반'}">
                    <ul class="form_list">
                        <li>
                            <dl>
                                <dt>아이디</dt>
                                <dd>${member.login_id}</dd>
                            </dl>
                            <dl>
                                <dt>이름</dt>
                                <dd>${member.name}</dd>
                            </dl>
                            <dl>
                                <dt>가입정보</dt>
                                <dd> ${fn:substring(member.create_date,0,10)} (${member.platform})</dd>
                            </dl>
                        </li>
                    </ul>
                </c:if>
                <c:if test="${member.platform != '일반'}">
                    <ul class="form_list">
                        <li>
                            <dl>
                                <dt>가입정보</dt>
                                <dd> ${fn:substring(member.create_date,0,10)} (${member.platform})</dd>
                            </dl>
                            <dl>
                                <dt>이름</dt>
                                <dd>${memName}</dd>
                            </dl>
                        </li>
                    </ul>
                </c:if>
            </section>

            <form name="modifyForm" id="modifyForm">
                <ul class="form_list">

                    <li>
                        <dl>
                            <dt>휴대전화번호
                                <c:if test="${member.platform != '일반'}">
                                    인증<span style="color: #F50057;">*</span>
                                </c:if>
                            </dt>
                            <dd>
                                <input type="text" name="m_phone" id="m_phone" minlength="10" maxlength="11"
                                       value="${member.phone}"
                                       class="input_ty infoInput" placeholder="새로운 휴대전화번호를 입력해주세요">
                            </dd>

                            <div class="checkBtnArea">
                                <a class="btn_infoEdit"
                                   id="m_phone_btn" href="javascript:void(0);">변경</a>
                            </div>

                        </dl>
                        <dl class="m_chk_tel_Area">
                            <dt>인증번호</dt>
                            <!--번호 입력 시에만 button 활성화-->
                            <dd>
                                <input type="text" name="m_phone_num" id="m_phone_num" minlength="4" maxlength="4"
                                       class="input_ty infoInput" placeholder="인증번호 4자리">
                                <span id="m_phone_num_count">00:00</span>
                            </dd>
                            <div class="checkBtnArea">
                                <a href="javascript:void(0);" id="m_phone_num_check_btn"
                                   data-possible="false"
                                   class="btn_infoEdit">확인</a>
                            </div>

                        </dl>

                    </li>

                    <%-- 일반회원만 보임 : 비밀번호 변경 --%>
                    <c:if test="${member.platform == '일반'}">
                        <li class="insertPwd">
                            <dl>
                                <dt>기존 비밀번호<span style="color: #F50057;">*</span></dt>
                                <dd>
                                    <input placeholder="기존 비밀번호를 입력해주세요."
                                           type="password" name="pastPwdIs" id="pastPwdIs"
                                           size="16" minlength="8" maxlength="16"
                                           class="input_ty infoInput"/>
                                </dd>
                            </dl>
                            <dl>
                                <dt>신규 비밀번호</dt>
                                <dd>
                                    <input readonly="true"
                                           type="password" name="m_pwd" id="m_pwd"
                                           size="16" minlength="8" maxlength="16"
                                           class="input_ty infoInput"/>
                                </dd>
                                <div class="checkBtnArea">
                                    <a class="switchArea">
                                        <label class="toggle-switchy" for="example_default_4" data-size="sm">
                                            <input type="checkbox" id="example_default_4" name="pwdSwitch">
                                            <span class="toggle">
									            <span class="switch"></span>
								            </span>
                                        </label>
                                    </a>
                                </div>
                            </dl>
                            <dl style="margin: 0; padding: 0;" c>
                                <dt></dt>
                                <dd>
                                    <div class="hint_txt" id="m_pwd_div">
                                        <span class="txt_case1">최소 8자 이상</span>
                                        <span class="txt_case2">동일한 숫자 3개 이상 연속 사용 불가, 영문/숫자/특수문자(공백 제외)를 2개 이상 조합</span>

                                    </div>
                                </dd>
                            </dl>

                            <dl class="m_chk_pwd_Area">
                                <dt>비밀번호 확인</dt>
                                <dd>
                                    <input type="password" name="m_chk_pwd" id="m_chk_pwd" size="16" minlength="8"
                                           maxlength="16"
                                           class="input_ty infoInput" placeholder="비밀번호를 동일하게 입력해주세요"/>
                                </dd>
                            </dl>
                            <dl style="margin: 0; padding: 0;">
                                <dt></dt>
                                <dd>
                                    <div class="hint_txt" id="m_chk_pwd_div">
                                        <span class="txt_case1">동일한 비밀번호를 입력해주세요</span>
                                    </div>
                                </dd>
                            </dl>
                        </li>
                    </c:if>

                    <li>
                        <dl>
                            <dt>닉네임</dt>
                            <dd>
                                <input type="text" name="m_nickname" id="m_nickname" minlength="2" maxlength="10"
                                       value="${member.nickname}"
                                       class="input_ty infoInput" placeholder="새로운 닉네임을 입력해주세요">
                            </dd>
                            <div class="checkBtnArea">
                                <a class="btn_infoEdit" id="m_nickname_btn"
                                   data-check="false" data-possible="false"
                                   href="javascript:void(0);"
                                >중복확인</a>
                            </div>

                        </dl>
                        <dl style="margin: 0; padding: 0;">
                            <dt></dt>
                            <dd>
                                <div class="hint_txt " id="m_nickname_div">
                                    <span class="txt_case1">한글/영문/숫자만 허용하며, 조합 가능</span>
                                    <span class="txt_case2">닉네임 중복확인</span>
                                    <span class="nick_txt_case" style="display: none;">현재 닉네임 입니다.</span>
                                </div>
                            </dd>
                        </dl>
                        <dl>
                            <dt>이메일</dt>
                            <dd>
                                <input type="email" name="m_email" id="m_email"
                                       value="${member.email1}@${member.email2}"
                                       class="input_ty infoInput" placeholder="새로운 이메일을 입력해주세요">
                            </dd>
                            <div class="checkBtnArea">
                                <a class="btn_infoEdit" data-possible="false"
                                   id="m_email_btn" href="javascript:void(0);">중복확인</a>
                            </div>
                        </dl>
                        <dl style="margin: 0; padding: 0;">
                            <dt></dt>
                            <dd>
                                <div class="hint_txt" id="m_email_div">
                                    <span class="txt_case1">이메일 중복확인</span>
                                </div>
                            </dd>
                        </dl>
                    </li>
                    <li>
                        <dl class="j_select_sex">
                            <dt>성별</dt>
                            <dd>
                                <div>
                                    <input type="radio" name="sex" value="m" checked="checked">
                                    <span class="j_radio_ico"></span>
                                    남자
                                </div>
                                <div>
                                    <input type="radio" name="sex" value="w">
                                    <span class="j_radio_ico"></span>
                                    여자
                                </div>
                            </dd>
                        </dl>
                    </li>
                    <li>
                        <dl>
                            <dt>생년월일</dt>
                            <dd>
                                <div class="j_birth">
                                    <input value="${fn:substring(member.birth,0,4)*1}"
                                           type="text" name="m_birth_year" id="m_birth_year"
                                           label="생년월일" size="4" minlength="4" maxlength="4" placeholder="YYYY">
                                    <span class="j_b_bar"></span>
                                    <input value="${fn:substring(member.birth,4,6)*1}"
                                           type="text" name="m_birth_month" id="m_birth_month"
                                           label="생년월일" size="1" minlength="2" maxlength="2" placeholder="MM">
                                    <span class="j_b_bar"></span>
                                    <input value="${fn:substring(member.birth,6,8)*1}"
                                           type="text" name="m_birth_day" id="m_birth_day"
                                           label="생년월일" size="1" minlength="2" maxlength="2" placeholder="DD">
                                </div>
                            </dd>
                        </dl>
                        <dl>
                            <dt></dt>
                            <!--생년월일 focus 테두리 처리는 js로 class 추가해야 함-->
                            <dd>
                                <div class="j_div" id="m_birth_div">
                                    <span class="txt_case1">태어난 생년월일을 정확하게 입력해 주세요</span>
                                </div> <!-- end i:j_birth_div div -->
                            </dd>
                        </dl>
                    </li>
                </ul>
            </form>

            <section style="display: flex;">
                <div class="drawalBtn">
                    <a href="javascript:void(0);" id="deleteMember"
                       data-seq_member="${member.seq_member}">회원탈퇴</a>
                </div>
                <div style="width: 40px;"></div>
                <div class="myInfoBtn">
                    <a href="javascript:void(0);" id="summitCheck"
                       data-platform="${member.platform}"
                       data-seq_member="${member.seq_member}">회원정보수정</a>
                </div>
            </section>


        </article>

    </section>
</article>


<script>
    if ('<c:out value="${member.gender}"/>' == '여자') {
        $('input:radio[name=sex]:input[value="w"]').attr("checked", true);
    }


</script>


<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<script type="text/javascript" src="/js/myp07_myInf.js"></script>
<script async src="https://googletagmanager.com/gtag/js?id=UA-450952-13"></script>
<script>
    window.dataLayer = window.dataLayer || [];

    function gtag() {
        dataLayer.push(arguments);
    }

    gtag('js', new Date());
    gtag('config', 'UA-450952-13');
</script>
</body>
</html>