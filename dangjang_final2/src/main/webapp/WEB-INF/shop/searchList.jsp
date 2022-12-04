<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="searchResultMain">
    <div class="searchResultHeader">
        <h1>상품검색</h1>
    </div>
    <input type="hidden" value="${searchKeyword}" name="searchKeyword" id="searchKeyword">
    <input type="hidden" value="${pg}" name="pg" id="searchListpg">
    <div class="whatItem"> <!--비동기 돌리면서 넣으면 될 듯!-->
        <p>'${searchKeyword}' 검색 결과</p>
    </div>

    <!-- 상품 영역 -->
    <div id="search_goods_list" class="categoryGoodsList">
        <div class="list_attr">
            <div>
                <p class="goods_count"> <!--선택 subCat에 따라 개수 달라짐=js 처리-->
                    <span></span>
                </p>
                <div class="attr_type">
                    <ul>
                        <li><a href="#none" class="attr_choose" id="reco">추천순</a></li>
                        <li><a href="#none" id="new">신상품순</a></li>
                        <li><a href="#none" id="top">베스트순</a></li>
                        <li><a href="#none" id="high">최고가순</a></li>
                        <li><a href="#none" id="low">최저가순</a></li>
                    </ul>
                </div><!--end c:attr_type div-->
                <div style="clear:both"></div>
            </div>
        </div> <!--end c:list_attr div-->
        <!--상품 리스트-->
        <div class="product_view">
        </div>
        <!-- 페이징 -->
        <div class="layout_paging">
            <div class="pagingDiv">

            </div>
        </div> <!--end c:layout_paging div-->
    </div>

</div>

<script type="text/javascript" src="/js/searchList.js"></script>