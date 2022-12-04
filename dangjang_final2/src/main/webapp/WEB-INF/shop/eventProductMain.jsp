<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="eventProductMain">
    <section class="eventBannerSection">
        <div class="category_event">
            <!-- 해당 카테고리에 기획전이 진행되고 있으면 block, 없으면 none -->
        </div>
    </section> <!--end c:eventBannerSection section-->
    <input type="hidden" name="pg" id="eventProductPg" value="${pg}">
    <input type="hidden" name="eventNum" id="eventNum" value="${event_seq}">

    <!-- 하위 카테고리 -->
    <div class="event_title_section">
        <h3 class="event_cat_title">달콤한 디저트와 찰떡궁합 음료</h3>
    </div>

    <!-- 상품 영역 -->
    <div id="event_cat_goods_list" class="eventCategoryGoodsList">
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
                </div>
                <div style="clear:both"></div>
            </div>
        </div>
        <!--상품 리스트-->
        <div class="product_view">
        </div>


        <!-- 페이징 -->
        <div class="layout_paging">
            <div class="pagingDiv">
            </div>
        </div>
    </div>

</div>

<script type="text/javascript" src="/js/event.js"></script>