<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<input type="hidden" value="${fn:length(writtenReviewMapperDTOList)}" id="writtenReviewMapperDTOList">
<c:if test="${fn:length(writtenReviewMapperDTOList) == 0}">
    <li class="list">
        <h5 style="color: #888888; display: inline">작성한 후기가 없습니다.</h5>

    </li>
</c:if>
<c:if test="${fn:length(writtenReviewMapperDTOList) != 0}">
    <li class="list">
        <h5 style="color: #888888; display: inline">작성가능한 리뷰는... ${fn:length(writtenReviewMapperDTOList)}</h5>

    </li>
</c:if>
<c:forEach   items="${writtenReviewMapperDTOList}" var="item" varStatus="status">
    <li class="list reviewList" data-if_del_seq="${item.seq_review}">
        <a class="QnaProdUnit" href="javascript:void(0);">
            <div class="prodUnit">
                <div class="thumb">
                    <div class="img">
                        <img src="/images/${item.serial_number}.jpg"
                             alt="${item.name}">
                    </div>
                </div>
                <div class="info">
                    <div class="name">${item.name}</div>
                </div>
            </div>
        </a>
        <div class="prodReview">
            <ul class="top">
                <li>
                    <span class="date">
                            ${item.create_date}
                    </span>
                </li>
                <li style="text-align: right">
                    <div class="scoreDiv">
                        <img src="/review/score${item.score}.png"/>
                    </div>
                </li>
            </ul>
            <div class="comment">
                <p>${item.content}</p>
            </div>
            <c:if test="${not empty item.image1}" >
                <div class="revImgArea">
                    <ul class="viewImg">
                        <li>
                            <img src="/review/${item.image1}"/>
                        </li>
                        <c:if test="${not empty item.image2 }">
                            <li>
                                <img src="/review/${item.image1}"/>
                            </li>
                        </c:if>
                    </ul>
                </div>
            </c:if>
            <ul class="btn_edit">
                <li>
                    <a href="javascript:void(0);"
                       class="btnModifyFormReview"
                       data-serial="${item.serial_number}"
                       data-seq_review="${item.seq_review}"
                       data-seq_order_pdt="${item.seq_order_pdt}"
                       data-create_date="${item.create_date}"
                       data-name="${item.name}"
                       data-content="${item.content}"
                       data-score="${item.score}"

                            <c:if test="${item.image1 != ''}">
                                data-image1="${item.image1}"
                            </c:if>
                            <c:if test="${item.image2 != ''}">
                                data-image2="${item.image2}"
                            </c:if>
                    >수정</a>
                </li>
                <li>
                    <a href="javascript:void(0);"
                       data-seq_review="${item.seq_review}"
                       class="btnDelReview">삭제</a>
                </li>


            </ul>
        </div>
    </li>

</c:forEach>
