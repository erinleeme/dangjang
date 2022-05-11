<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div id="joinWriteSection" class="joinWriteSection">
    <div id="d_join">
        <h1>회원가입</h1>
        <p><b class="must_input">*</b> 필수입력사항</p>
        <div id="joinWriteView">
            <form id="joinWriteForm" class="joinWriteForm">
                <table id="joinWriteTable" class="joinWriteTable" cellspacing="0" cellpadding="5">
                    <tr class="t_id">
                        <th>아이디<b class="must_input">*</b></th>
                        <td>
                            <input type="text" minlength="5" maxlength="15" name="j_id" id="j_id"
                                   class="div_check"
                                   required placeholder="아이디를 입력해 주세요"/>
                            <input type="hidden" name="j_id_check" id="j_id_check">
                            <input type="button" id="j_id_btn" disabled class="j_id_btn" value="중복확인">
                            <div class="j_div" id="j_id_div">
                                <span class="txt_case1">5자 이상의 영문/숫자만 허용하며, 조합 가능</span>
                                <span class="txt_case2">아이디 중복확인</span>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th>비밀번호<b class="must_input">*</b></th>
                        <td>
                            <input type="password" minlength="8" maxlength="16" name="j_pwd" id="j_pwd"
                                   class="div_check"
                                   required placeholder="비밀번호를 입력해 주세요"/>
                            <div class="j_div" id="j_pwd_div">
                                <span class="txt_case1">8자 이상 입력</span>
                                <span class="txt_case2">영문/숫자/특수문자(공백 제외)만 허용하며, 2개 이상 조합</span>
                                <span class="txt_case3">동일한 숫자 3개 이상 연속 사용 불가</span>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th>비밀번호확인<b class="must_input">*</b></th>
                        <td>
                            <input type="password" minlength="8" maxlength="16" name="j_chk_pwd" id="j_chk_pwd"
                                   class="div_check"
                                   required placeholder="비밀번호를 한 번 더 입력해 주세요"/>
                            <div class="j_div" id="j_pwd_check_div">
                                <span class="txt_case1">동일한 비밀번호를 입력해주세요</span>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th>이름<b class="must_input">*</b></th>
                        <td>
                            <input type="text" name="j_name" id="j_name" minlength="2" maxlength="10"
                                   required placeholder="이름을 입력해 주세요"/>
                        </td>
                    </tr>
                    <tr>
                        <th>닉네임<b class="must_input">*</b></th>
                        <td>
                            <input type="text" name="j_nickname" id="j_nickname" minlength="2" maxlength="10"
                                   class="div_check"
                                   required placeholder="닉네임을 입력해 주세요"/>
                            <input type="hidden" name="j_nickname_check" id="j_nickname_check">
                            <input type="button" id="j_nickname_btn" class="j_nickname_btn" disabled
                                   value="중복확인">
                            <div class="j_div" id="j_nickname_div">
                                <span class="txt_case1">한글/영문/숫자만 허용하며, 조합 가능</span>
                                <span class="txt_case2">닉네임 중복확인</span>
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <th>이메일<b class="must_input">*</b></th>
                        <td>
                            <input type="email" name="j_email" id="j_email" class="div_check"
                                   required placeholder="예: dangjang@dangjang.com" maxlength="30"/>
                            <input type="hidden" name="j_email_check" id="j_email_check">
                            <input type="button" id="j_email_btn" class="j_email_btn"
                                   disabled value="중복확인">
                            <div class="j_div" id="j_email_div">
                                <span class="txt_case1">이메일 중복확인</span>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th>휴대폰<b class="must_input">*</b></th>
                        <td>
                            <input type="text" name="j_phone" id="j_phone" minlength="10" maxlength="11"
                                   required placeholder="숫자만 입력해 주세요" />
                            <!--번호 입력 시에만 button 활성화-->
                            <input type="button" id="j_phone_num_btn" disabled value="인증번호 받기">
                        </td>
                    </tr>
                    <tr>
                        <th>인증번호<b class="must_input">*</b></th>
                        <td>
                            <input type="text" name="j_phone_num" id="j_phone_num" minlength="4" maxlength="4"
                                   required placeholder="인증번호 4자리">
                            <input type="button" value="확인" id="j_phone_num_check_btn" disabled>
                            <span id="j_phone_num_count">00:00</span>
                        </td>
                    </tr>
                    <tr>
                        <th>주소<b class="must_input">*</b></th>
                        <td>
                            <input type="button" id="btn_address" value="주소 검색" onclick="checkPost()">
                            <!--click하면 daum 주소 창 open
                                1. 주소 검색
                                2. 리스트 나열
                                3. 본인 주소 선택
                                4. 상세 주소 입력 & 주소입력 버튼 클릭
                                5. modal 창으로 새벽배송 가능 여부 안내
                                6. modal 창은 확인 버튼 눌러야만 close
                                7. 주소 검색 button에서 주소 창으로 변경-->
                            <input type="hidden" name="zipcode" id="zipcode" readonly>
                            <input type="hidden" name="addr1" id="addr1" size="60" placeholder="주소" readonly>
                            <div id="j_selectAddress" style="display: none">
                                <input type="hidden" value name="j_addr" id="j_addr" readonly label="주소"> <!--zipcode-->
                                <input type="text" name="j_address" id="j_address" value required readonly label="주소"><!--도로명주소-->
                                <input type="button" value="재검색" onclick="checkPost()">
                                <input type="text" value name="j_addr_detail" id="j_addr_detail" placeholder="상세 주소를 입력해 주세요">
                            </div>
                        </td>
                    </tr>
                    <tr class="j_select_sex">
                        <th>성별</th>
                        <td>
                            <label class="j_checked">
                                <input type="radio" name="sex" value="m" checked="checked">
                                <span class="j_radio_ico"></span>
                                남자
                            </label>
                            <label class>
                                <input type="radio" name="sex" value="w">
                                <span class="j_radio_ico"></span>
                                여자
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <th>생년월일</th>
                        <td>
                            <!--생년월일 focus 테두리 처리는 js로 class 추가해야 함-->
                            <div class="j_birth">
                                <input type="text" name="j_birth_year" id="j_birth_year"
                                       label="생년월일" size="4" minlength="4" maxlength="4" placeholder="YYYY">
                                <span class="j_b_bar"></span>
                                <input type="text" name="j_birth_month" id="j_birth_month"
                                       label="생년월일" size="2" minlength="2" maxlength="2" placeholder="MM">
                                <span class="j_b_bar"></span>
                                <input type="text" name="j_birth_day" id="j_birth_day"
                                       label="생년월일" size="2" minlength="2" maxlength="2" placeholder="DD">
                            </div>
                            <div class="j_div" id="j_birth_div">
                                <span class="txt_case1">태어난 생년월일을 정확하게 입력해 주세요</span>
                            </div> <!-- end i:j_birth_div div -->
                        </td>
                    </tr>
                    <tr class="j_agree">
                        <th>이용약관동의<b class="must_input">*</b></th>
                        <td>
                            <div class="check_all">
                                <label class="check_agree label_all_check">
                                    <input type="checkbox" name="agree_allCheck" id="j_chk_all">
                                    <span class="j_checkbox_ico"></span>
                                    전체 동의
                                </label>
                            </div> <!-- end c:check_all div -->
                            <div class="check_view">
                                <label class="check_agree label_block">
                                    <input type="checkbox" name="agree" id="j_chk_1"
                                           required label="이용약관">
                                    <span class="j_checkbox_ico"></span>
                                    이용약관 동의
                                    <span class="j_agree_sub">(필수)</span>
                                </label>
                                <a href="#none" class="btn_link btn_agreement">
                                    약관보기 >
                                </a>
                            </div> <!--end c:check_view div -->
                            <div class="check_view">
                                <label class="check_agree label_block">
                                    <input type="checkbox" name="private" id="j_chk_2"
                                           required label="개인정보 수집·이용">
                                    <span class="j_checkbox_ico"></span>
                                    개인정보 수집·이용 동의
                                    <span class="j_agree_sub">(필수)</span>
                                </label>
                                <a href="#none" class="btn_link btn_agreement">
                                    약관보기 >
                                </a>
                            </div> <!--end c:check_view div -->
                        </td>
                    </tr>
                </table>
                <div id="joinWriteFormSubmit">
                    <button type="button" id="btn_join_submit" class="btn_join_submit">가입하기</button>
                </div>
            </form>
        </div> <!--end i:joinWriteView div-->
    </div> <!--end i:d_join div-->
</div><!--end i:joinWriteSection div-->
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>