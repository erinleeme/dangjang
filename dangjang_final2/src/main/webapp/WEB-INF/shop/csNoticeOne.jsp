<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div>
    <section class="cs_container">
        <section class="insidePage">
            <div class="notice_one">
                <input type="hidden" id="noticeOnePg" name="pg" value="${pg}">
                <div class="notice_header">
                    <h2>${notice.title}</h2>
                    <span>${date}</span>
                </div>
                <div class="notice_content">
                    ${notice.content}
                </div>
                <span>
                    <a id="backto_csNoticeList">전체보기</a>
                </span>
            </div>
        </section>
    </section>
</div>
<script type="text/javascript" src="/js/csNoticeOne.js"></script>