<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="minibar.jsp" />
<article class="mypContainer" >
    <jsp:include page="snb.jsp" />
    <section class="mypContent" >
        <div class="infoCheck head_content">
            <h3>본인 확인</h3>
            <h5 class="tit_sub01">
                고객님의 소중한 개인 정보 보호를 위해<br>
                비밀번호를 다시 한번 입력해주세요.
            </h5>
            <br>
            <div>
                <label for="pwd">비밀번호</label>
                <input id="pwd" type="password" class="input_ty">
                <button type="button" id="checkMember"
                        class="btn_chkPwd" value = "확인">
                    <span>확인</span>
                </button>
            </div>

        </div>


    </section>
</article>


<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    $('#checkMember').click(function(){
        $.ajax({
            type: 'get',
            url: '/dangjang/mypage/member/checkMember',
            data: {'pwd' : $('#pwd').val()},
            dataType : 'text',
            success: function(data) {
                data = data.trim();
                if(data == 'exist') {
                    location.href = "/dangjang/mypage/myInfo1";
                } else {
                    alert('비밀번호가 일치하지 않습니다.');
                }
            },
            error: function(err){
                alert(err);
            }
        });
    });

</script>