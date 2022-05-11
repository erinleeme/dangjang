<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:forEach var="item" items="${addressList}" varStatus="status">
    <li class="addr_item line">
        <div class="addr_div">
            <div class="addr_info">
                <div class="name">
                    <div class="txt">
                        <div class="title">
                            <span>${item.address_title}</span>
                        </div>
                        <c:if test="${item.base_status == '1'}">
                            <div class="flag" style="align-content: center; padding-bottom: 10px">
                                <span>기본</span>
                            </div>
                        </c:if>
                        <div class="update">
                            <c:if test="${item.base_status == '1'}">
                                <div class="btn_edit">
                                    <a href="javascript:void(0);" class="modifyForm"
                                       data-recipient_phone="${item.recipient_phone}"
                                       data-seq_address="${item.seq_address}"
                                       data-address1="${item.address1}"
                                       data-address2="${item.address2}"
                                       data-zipcode="${item.zipcode}"
                                       data-base_status="${item.base_status}"
                                       data-reception_name="${item.receptionName}"
                                       data-address_title="${item.address_title}"
                                       data-address_content="${item.addressContent}">수정</a>
                                </div>
                            </c:if>
                            <c:if test="${item.base_status == '0'}">
                                <div class="btn_edit">
                                    <a href="javascript:void(0);" class="modifyForm"
                                       data-recipient_phone="${item.recipient_phone}"
                                       data-seq_address="${item.seq_address}"
                                       data-address1="${item.address1}"
                                       data-address2="${item.address2}"
                                       data-zipcode="${item.zipcode}"
                                       data-base_status="${item.base_status}"
                                       data-reception_name="${item.receptionName}"
                                       data-address_title="${item.address_title}"
                                       data-address_content="${item.addressContent}">수정</a>
                                    |
                                    <a href="javascript:void(0);" class="deleteAddress"
                                       data-addressno="${item.seq_address}"> 삭제
                                    </a>
                                </div>
                            </c:if>
                        </div>
                    </div>
                </div>
                <div class="infoAddr">
                    <span>${item.receptionName}</span><br>
                    <span>T. ${item.recipient_phone}</span><br>
                    <span>[${item.zipcode}]${item.address1} ${item.address2}</span>
                </div>
                <c:if test="${not empty item.addressContent}">
                    <hr <%--color="#00ACC1" width="100%" size="2px"--%>>
                    <div class="messageAddr">
                        <span>메세지</span>
                    </div>
                    <div class="address">
                        <span>${item.addressContent}</span>
                    </div>
                </c:if>
            </div>
        </div>
    </li>
</c:forEach>