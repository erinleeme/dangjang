<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="categoryMain">
    <input type="hidden" name="pg" id="categoryPg" value="${pg}">
    <input type="hidden" name="categoryCode" id="categoryCode" value="${categoryCode}">
    <c:if test="${subCategoryNum != null}">
        <input type="hidden" name="categoryCode" id="subCategoryNum" value="${subCategoryNum}">
    </c:if>
    <c:if test="${subCategoryNum == null}">
        <input type="hidden" name="categoryCode" id="subCategoryNum" value="null">
    </c:if>
    <!-- 하위 카테고리 -->
    <div class="cat_subCatList">
        <h3 class="cat_title">${categoryTitle}</h3>
        <ul class="cat_menu">

        </ul>
    </div>

    <!-- 상품 영역 -->
    <div id="cat_goods_list" class="categoryGoodsList">
        <div class="list_attr">
            <div>
                <p class="goods_count">
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

</div> <!--end c:categoryMain div-->

<script type="text/javascript" src="/js/categoryMain.js"></script>