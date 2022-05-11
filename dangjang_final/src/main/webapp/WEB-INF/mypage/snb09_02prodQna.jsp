<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/core" %>
<style>



</style>
<c:forEach items="${qnaList}" var="item" varStatus="status">
    <li class="qnaList" seqno="${item.seq_qna}">
        <a class="QnaProdUnit" href="javascript:void(0);"
           onclick="javascript:showProductDetail(${item.seq_product});"         >
            <div class="prodUnit">
                <div class="thumb">
                    <div class="img">
                        <img src="/images/${qnaSerialList[status.index].serial_number}.jpg"
                             alt="${qnaProductList[status.index].name}">
                    </div>
                </div>
                <div class="info">
                    <div class="name">${qnaProductList[status.index].name}</div>
                </div>
            </div>
        </a>
        <div class="QnaContentUnit">
            <a class="pd_unit_box01 div_open" href="javasript:void(0);">
                <div class="qnaInfo">
                    <span class="date">${item.create_date}</span>
                    <c:if test="${item.reply_date == null}">
                        <span class="flagQna">답변대기</span>
                    </c:if>
                    <c:if test="${item.reply_date != null}">
                        <span class="flagQna">답변완료</span>
                    </c:if>
                    <div class="qna">
                        <p class="txt">${item.qna_content}</p>
                    </div>
                </div>
            </a>
            <div class="info_view" style="display: none;">
                <c:if test="${empty item.reply_content}">
                    <ul class="btn_edit">
                        <li>
                            <a href="javascript:void(0);"
                               class="qnaModifyFormBtn"
                               data-seqno="${item.seq_qna}"
                               data-qnacontent="${item.qna_content}"
                               data-prodno="${item.seq_product}"
                            >수정</a>
                        </li>

                        <li>
                            <a href="javascript:void(0);"
                               class="qnaDeleteFormBtn"
                               data-seqno="${item.seq_qna}"
                            >삭제</a>
                        </li>
                    </ul>
                </c:if>
                <c:if test="${not empty item.reply_content}">
                    <div class="answerQna">
                        <span class="date">${item.reply_date}</span>
                        <p class="txt">${item.reply_content}</p>
                    </div>
                </c:if>
            </div>
        </div>
    </li>

</c:forEach>