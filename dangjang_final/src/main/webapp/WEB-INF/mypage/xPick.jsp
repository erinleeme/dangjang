<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<%--
List<FavoriteMapperDTO> favoriteList
seq_favorite=11, seq_member=3, product_id=234, create_date=null

List<BasicProductMapperDTO> favoriteProductImages
serial_number=D6J59N22065,

List<ProductMapperDTO> productFavorite
ProductMapperDTO(createDate=null, updateDate=null,
seq_product=234, seq_basic_product=234,
name=[둥구나무:자연그대로] 컬러방울 토마토 피클,
content=null, registerCount=0, discountOnoff=null,
displayOnoff=null, discount_rate=0.0, discount_price=0,
price=9300, storageMethod=null
--%>
<style>

</style>

<div class="filterBox" style="margin-left: 10px">
    <div class="checkYE" style="margin-top: 10px" >
        <input id="checkAll" name="checkAll" type="checkbox" checked="checked"
                data-pdcount = "${fn:length(productFavorite)}">
        <label for="checkAll" style="text-align: center">전체 선택 (${fn:length(productFavorite)})</label>
    </div>
    <div class="checkPdt" style="margin-top: 10px">
        <a href="javascript:void(0);" onclick="checkAddCart();">선택상품 장바구니에 담기</a>
    </div>
</div>
<ul class="pdBoxList">

    <c:forEach items="${productFavorite}" var="item" varStatus="status">
        <li class="list">

            <div class="prodUnit">
                <div class="pickCheckbox" >
                    <div class="checkYE">
                        <input  class="checkProd" name="checkPdt" type="checkbox" checked="checked"
                                data-productno="${item.seq_product}" id="seqProduct${item.seq_product}">
                        <label For="seqProduct${item.seq_product}"></label>
                    </div>
                </div>
                <div class="thumb">
                    <a href="javascript:void(0);" onclick="javascript:productDetail(${item.seq_product})" >
                        <div class="img">
                            <img src="/images/${favoriteProductImages[status.index].serial_number}.jpg"
                                 alt="${item.name}">
                        </div>
                    </a>
                </div>
                <div class="pdInfo" >
                    <div class="name" >
                        <a href="javascript:void(0);" <%--onclick="javascript:productDetail(${item.seq_product})"--%>>
                                ${item.name}
                        </a>
                    </div>
                    <div class="pickPrice">
                        <span class="d_ratio">${item.price}원</span>
                    </div>
                    <div class="pickDiscountPrice">
                        <div class="pickPdtInfo">
                            <c:if test="${item.discount_price != 0}">
                                <span class="d_ratio">${item.discount_rate}%</span>
                                <span class="d_price">${item.discount_price}원</span>
                            </c:if>
                        </div>

                    </div>


                </div>

                <div class="btnAreaInPick">
                    <div>
                        <a href="#none" class="btn_ty01" data-productno="${item.seq_product}"
                           onclick="mypageAddCart(${item.seq_product});">
                            장바구니
                        </a>
                    </div>
                    <div>
                        <a href="javascript:void(0);" class="btn_ty01 deletePickProd"
                           data-pickid="${favoriteList[status.index].seq_favorite}">삭제</a>
                    </div>
                </div>
            </div>
        </li>


        <br>
        <hr color="#999999" width="100%" size="1px">
    </c:forEach>
</ul>





