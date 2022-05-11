<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="cs_container_header">
    <h2>
        공지사항
        <span>당장가게의 새로운 소식들과 유용한 정보들을 한곳에서 확인하세요.</span>
    </h2>
</div>
<div class="cs_container_list">
    <form class="cs_notice_form">
        <div class="cs_search">
            <a href="#none" id="cs_search_btn"><img src="/icon/search_white.png"></a>
            <input type="text" name="search_cs_keyword" id="search_cs_keyword" required>
        </div>
        <div style="clear: both;"></div>
        <table class="cs_list_table">
            <thead >
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성일</th>
            </tr>
            </thead><tbody id="cs_list_table_notice">
            </tbody>
        </table>
        <input type="hidden" value="${noticePg}" name="noticePg" id="noticePg">
        <div class="layout_paging" id="notice_paging">
            <div class="pagingDiv">

            </div>
        </div> <!--paging-->
    </form>
</div>
<script type="text/javascript" src="/js/csMain.js"></script>