<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<style>


</style>
<c:forEach items="${otoList}" var="item">
    <li class="list" seqno="${item.seq_oto_req}">
        <a href="javascript:void(0);" class="div_open">
            <div class="rep_yet">
                <div class="ico"></div>
                <span class="status_tg">${item.oto_status}</span>
            </div>
            <div class="info">
                <p class="date">
                        ${item.create_date}
                </p>
                <p class="type_tg">${item.request_type}</p>
                <p class="tit">${item.title}</p>
            </div>
        </a>
        <div class="info_view" style="display: none;">
            <div class="info_detail">
                <c:if test="${item.order_num != '0'}">
                    <div class="od_num">
                        <dl>
                            <dt>주문번호</dt>
                            <dd>${item.order_num}</dd>
                        </dl>
                    </div>
                </c:if>
                <p class="q_content">${item.content} </p>

                <c:if test="${not empty item.image1}">
                    <ul class="otoImgArea">
                        <li>
                            <div class="img">
                                <img src="/storage/${item.image1}">
                            </div>
                        </li>
                        <c:if test="${not empty item.image2}">
                            <li>
                                <div class="img">
                                    <img src="/storage/${item.image2}">
                                </div>
                            </li>
                        </c:if>
                    </ul>
                </c:if>

                <c:if test="${item.reply_content == null }">
                    <ul class="btn_edit">
                        <li>
                            <a href="javascript:void(0);"
                               class="otoModifyFormBtn"
                               data-seqno="${item.seq_oto_req}"
                               data-title="${item.title}"
                               data-content="${item.content}"
                               data-qnatype="${item.request_type}"

                                    <c:if test="${item.order_num != '0'}">
                                        data-orderno="${item.order_num}"
                                    </c:if>
                                    <c:if test="${not empty item.image1}">
                                        data-image1="${item.image1}"
                                    </c:if>
                                    <c:if test="${not empty item.image2}">
                                        data-image2="${item.image2}"
                                    </c:if>
                            >수정</a>
                        </li>
                        <li>
                            <a href="javascript:void(0);"
                               data-seqno="${item.seq_oto_req}"
                               class="btnDelQna">삭제</a>
                        </li>

                    </ul>
                </c:if>
            </div>
            <c:if test="${item.reply_content != null}">
                <div class="answer">
                    <p class="date">${item.complete_date}</p>
                    <p class="txt">${item.reply_content}</p>
                </div>
            </c:if>


        </div>
    </li>

</c:forEach>

