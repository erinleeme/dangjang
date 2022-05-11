<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="eventMain">
    <section class="eventBannerSection">
        <div class="event_one">
            <img src="/img/eventbannerSMPL.JPG">
        </div>
    </section> <!--end c:eventBannerSection section-->

    <!-- 하위 카테고리 -->
    <div class="evt_CatList">
        <h3 class="evt_title">기획전 이름</h3> <!--기획전 이름을 선택되는 것에 따라 달라진다-->
        <ul> <!--이건 여러 카테고리 포함된 기획전일 경우에만 보여주기-->
            <li>
                <a class="category_subCat cat_list_choose">
                    전체보기
                </a>
            </li>
            <li>
                <a class="category_subCat">
                    고구마·감자·당근
                </a>
            </li>
            <li>
                <a class="category_subCat">
                    시금치·쌈채소·나물
                </a>
            </li>
            <li>
                <a class="category_subCat">
                    브로콜리·파프리카·양배추
                </a>
            </li>
            <li>
                <a class="category_subCat">
                    양파·대파·마늘·배추
                </a>
            </li>
        </ul>
    </div>

    <!-- 상품 영역 -->
    <div id="evt_goods_list" class="evt_goods_list">
        <div class="list_attr">
            <div>
                <p class="goods_count"> <!--선택 subCat에 따라 개수 달라짐=js 처리-->
                    <span>총 30개</span>
                </p>
                <div class="attr_type">
                    <ul>
                        <li><a class="attr_choose">추천순</a></li>
                        <li><a>신상품순</a></li>
                        <li><a>베스트순</a></li>
                        <li><a>최고가순</a></li>
                        <li><a>최저가순</a></li>
                    </ul>
                </div><!--end c:attr_type div-->
                <div style="clear:both"></div>
            </div>
        </div> <!--end c:list_attr div-->
        <!--상품 리스트-->
        <div class="product_view">
            <div class="product_one p_first">
                <div class="product_img">
                    <img>
                </div>
                <div class="product_name">
                    <span>[서울우유] 체다 슬라이스치즈(20매입)</span>
                </div>
                <div class="product_price">
                    <span><b>23%</b> 11,850원</span><span></span>
                </div>
                <div class="product_state">
                    <span>상온</span>
                </div>
                <div class="product_reviewAndPick">
                    <img class="p_review_icon" src="/icon/review_icon.png" />
                    <span class="product_review">619</span>
                    <img class="p_pick_icon" src="/icon/heart.png" />
                    <span class="product_pick">172</span>
                </div>
            </div>
            <div class="product_one p_second">
                <div class="product_img">
                    <img>
                </div>
                <div class="product_name">
                    <span>[서울우유] 체다 슬라이스치즈(20매입)</span>
                </div>
                <div class="product_price">
                    <span><b>23%</b> 11,850원</span>
                </div>
                <div class="product_state">
                    <span>상온</span>
                </div>
                <div class="product_reviewAndPick">
                    <img class="p_review_icon" src="/icon/review_icon.png" />
                    <span class="product_review">619</span>
                    <img class="p_pick_icon" src="/icon/heart.png" />
                    <span class="product_pick">172</span>
                </div>
            </div>
            <div class="product_one p_third">
                <div class="product_img">
                    <img>
                </div>
                <div class="product_name">
                    <span>[서울우유] 체다 슬라이스치즈(20매입)</span>
                </div>
                <div class="product_price">
                    <span><b>23%</b> 11,850원</span>
                </div>
                <div class="product_state">
                    <span>상온</span>
                </div>
                <div class="product_reviewAndPick">
                    <img class="p_review_icon" src="/icon/review_icon.png" />
                    <span class="product_review">619</span>
                    <img class="p_pick_icon" src="/icon/heart.png" />
                    <span class="product_pick">172</span>
                </div>
            </div>
            <div class="product_one p_last">
                <div class="product_img">
                    <img>
                </div>
                <div class="product_name">
                    <span>[서울우유] 체다 슬라이스치즈(20매입)</span>
                </div>
                <div class="product_price">
                    <span><b>23%</b> 11,850원</span>
                </div>
                <div class="product_state">
                    <span>상온</span>
                </div>
                <div class="product_reviewAndPick">
                    <img class="p_review_icon" src="/icon/review_icon.png" />
                    <span class="product_review">619</span>
                    <img class="p_pick_icon" src="/icon/heart.png" />
                    <span class="product_pick">172</span>
                </div>
            </div>
        </div>
        <div class="product_view">
            <div class="product_one p_first">
                <div class="product_img">
                    <img>
                </div>
                <div class="product_name">
                    <span>[서울우유] 체다 슬라이스치즈(20매입)</span>
                </div>
                <div class="product_price">
                    <span><b>23%</b> 11,850원</span><span></span>
                </div>
                <div class="product_state">
                    <span>상온</span>
                </div>
                <div class="product_reviewAndPick">
                    <img class="p_review_icon" src="/icon/review_icon.png" />
                    <span class="product_review">619</span>
                    <img class="p_pick_icon" src="/icon/heart.png" />
                    <span class="product_pick">172</span>
                </div>
            </div>
            <div class="product_one p_second">
                <div class="product_img">
                    <img>
                </div>
                <div class="product_name">
                    <span>[서울우유] 체다 슬라이스치즈(20매입)</span>
                </div>
                <div class="product_price">
                    <span><b>23%</b> 11,850원</span>
                </div>
                <div class="product_state">
                    <span>상온</span>
                </div>
                <div class="product_reviewAndPick">
                    <img class="p_review_icon" src="/icon/review_icon.png" />
                    <span class="product_review">619</span>
                    <img class="p_pick_icon" src="/icon/heart.png" />
                    <span class="product_pick">172</span>
                </div>
            </div>
            <div class="product_one p_third">
                <div class="product_img">
                    <img>
                </div>
                <div class="product_name">
                    <span>[서울우유] 체다 슬라이스치즈(20매입)</span>
                </div>
                <div class="product_price">
                    <span><b>23%</b> 11,850원</span>
                </div>
                <div class="product_state">
                    <span>상온</span>
                </div>
                <div class="product_reviewAndPick">
                    <img class="p_review_icon" src="/icon/review_icon.png" />
                    <span class="product_review">619</span>
                    <img class="p_pick_icon" src="/icon/heart.png" />
                    <span class="product_pick">172</span>
                </div>
            </div>
            <div class="product_one p_last">
                <div class="product_img">
                    <img>
                </div>
                <div class="product_name">
                    <span>[서울우유] 체다 슬라이스치즈(20매입)</span>
                </div>
                <div class="product_price">
                    <span><b>23%</b> 11,850원</span>
                </div>
                <div class="product_state">
                    <span>상온</span>
                </div>
                <div class="product_reviewAndPick">
                    <img class="p_review_icon" src="/icon/review_icon.png" />
                    <span class="product_review">619</span>
                    <img class="p_pick_icon" src="/icon/heart.png" />
                    <span class="product_pick">172</span>
                </div>
            </div>
        </div>
        <div class="product_view">
            <div class="product_one p_first">
                <div class="product_img">
                    <img>
                </div>
                <div class="product_name">
                    <span>[서울우유] 체다 슬라이스치즈(20매입)</span>
                </div>
                <div class="product_price">
                    <span><b>23%</b> 11,850원</span><span></span>
                </div>
                <div class="product_state">
                    <span>상온</span>
                </div>
                <div class="product_reviewAndPick">
                    <img class="p_review_icon" src="/icon/review_icon.png" />
                    <span class="product_review">619</span>
                    <img class="p_pick_icon" src="/icon/heart.png" />
                    <span class="product_pick">172</span>
                </div>
            </div>
            <div class="product_one p_second">
                <div class="product_img">
                    <img>
                </div>
                <div class="product_name">
                    <span>[서울우유] 체다 슬라이스치즈(20매입)</span>
                </div>
                <div class="product_price">
                    <span><b>23%</b> 11,850원</span>
                </div>
                <div class="product_state">
                    <span>상온</span>
                </div>
                <div class="product_reviewAndPick">
                    <img class="p_review_icon" src="/icon/review_icon.png" />
                    <span class="product_review">619</span>
                    <img class="p_pick_icon" src="/icon/heart.png" />
                    <span class="product_pick">172</span>
                </div>
            </div>
            <div class="product_one p_third">
                <div class="product_img">
                    <img>
                </div>
                <div class="product_name">
                    <span>[서울우유] 체다 슬라이스치즈(20매입)</span>
                </div>
                <div class="product_price">
                    <span><b>23%</b> 11,850원</span>
                </div>
                <div class="product_state">
                    <span>상온</span>
                </div>
                <div class="product_reviewAndPick">
                    <img class="p_review_icon" src="/icon/review_icon.png" />
                    <span class="product_review">619</span>
                    <img class="p_pick_icon" src="/icon/heart.png" />
                    <span class="product_pick">172</span>
                </div>
            </div>
            <div class="product_one p_last">
                <div class="product_img">
                    <img>
                </div>
                <div class="product_name">
                    <span>[서울우유] 체다 슬라이스치즈(20매입)</span>
                </div>
                <div class="product_price">
                    <span><b>23%</b> 11,850원</span>
                </div>
                <div class="product_state">
                    <span>상온</span>
                </div>
                <div class="product_reviewAndPick">
                    <img class="p_review_icon" src="/icon/review_icon.png" />
                    <span class="product_review">619</span>
                    <img class="p_pick_icon" src="/icon/heart.png" />
                    <span class="product_pick">172</span>
                </div>
            </div>
        </div>
        <div class="product_view">
            <div class="product_one p_first">
                <div class="product_img">
                    <img>
                </div>
                <div class="product_name">
                    <span>[서울우유] 체다 슬라이스치즈(20매입)</span>
                </div>
                <div class="product_price">
                    <span><b>23%</b> 11,850원</span><span></span>
                </div>
                <div class="product_state">
                    <span>상온</span>
                </div>
                <div class="product_reviewAndPick">
                    <img class="p_review_icon" src="/icon/review_icon.png" />
                    <span class="product_review">619</span>
                    <img class="p_pick_icon" src="/icon/heart.png" />
                    <span class="product_pick">172</span>
                </div>
            </div>
            <div class="product_one p_second">
                <div class="product_img">
                    <img>
                </div>
                <div class="product_name">
                    <span>[서울우유] 체다 슬라이스치즈(20매입)</span>
                </div>
                <div class="product_price">
                    <span><b>23%</b> 11,850원</span>
                </div>
                <div class="product_state">
                    <span>상온</span>
                </div>
                <div class="product_reviewAndPick">
                    <img class="p_review_icon" src="/icon/review_icon.png" />
                    <span class="product_review">619</span>
                    <img class="p_pick_icon" src="/icon/heart.png" />
                    <span class="product_pick">172</span>
                </div>
            </div>
            <div class="product_one p_third">
                <div class="product_img">
                    <img>
                </div>
                <div class="product_name">
                    <span>[서울우유] 체다 슬라이스치즈(20매입)</span>
                </div>
                <div class="product_price">
                    <span><b>23%</b> 11,850원</span>
                </div>
                <div class="product_state">
                    <span>상온</span>
                </div>
                <div class="product_reviewAndPick">
                    <img class="p_review_icon" src="/icon/review_icon.png" />
                    <span class="product_review">619</span>
                    <img class="p_pick_icon" src="/icon/heart.png" />
                    <span class="product_pick">172</span>
                </div>
            </div>
            <div class="product_one p_last">
                <div class="product_img">
                    <img>
                </div>
                <div class="product_name">
                    <span>[서울우유] 체다 슬라이스치즈(20매입)</span>
                </div>
                <div class="product_price">
                    <span><b>23%</b> 11,850원</span>
                </div>
                <div class="product_state">
                    <span>상온</span>
                </div>
                <div class="product_reviewAndPick">
                    <img class="p_review_icon" src="/icon/review_icon.png" />
                    <span class="product_review">619</span>
                    <img class="p_pick_icon" src="/icon/heart.png" />
                    <span class="product_pick">172</span>
                </div>
            </div>
        </div>

        <!-- 페이징 -->
        <div class="layout_paging">
            <div class="pagingDiv">
                <a class="layout_paging_button layout_paging_firstPage">맨 처음 페이지로 가기</a>
                <a class="layout_paging_button layout_paging_prevPage">이전 페이지로 가기</a>
                <a class="layout_paging_button layout_paging_number">1</a>
                <a class="layout_paging_button layout_paging_number">2</a>
                <a class="layout_paging_button layout_paging_number">3</a>
                <a class="layout_paging_button layout_paging_number">4</a>
                <a class="layout_paging_button layout_paging_number">5</a>
                <a class="layout_paging_button layout_paging_number">6</a>
                <a class="layout_paging_button layout_paging_number">7</a>
                <a class="layout_paging_button layout_paging_number">8</a>
                <a class="layout_paging_button layout_paging_number">9</a>
                <a class="layout_paging_button layout_paging_number">10</a>
                <a class="layout_paging_button layout_paging_nextPage">맨 처음 페이지로 가기</a>
                <a class="layout_paging_button layout_paging_lastPage">맨 마지막 페이지로 가기</a>
            </div>
        </div> <!--end c:layout_paging div-->
    </div>

</div> <!--end c:categoryMain div-->