package com.dangjang.mapper;

import com.dangjang.dto.CartMapperDTO;
import com.dangjang.dto.ProductMapperDTO;
import com.dangjang.dto.SellCountMapperDTO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface CartMapper {
    List<ProductMapperDTO> getUserCartList(List<CartMapperDTO> cartProductCount); // 해당 유저의 장바구니 상품 정보

    List<CartMapperDTO> getCartProductCount(Long memId); // 해당 유저의 장바구니 상품들 각 수량

    int getUserCartTotalCount(Long memId); // 로그인 하는 유저의 장바구니에 담긴 상품 총 수량

    int getProductCount(Map<String, Object> map); // 해당 상품의 기존 수량

    void cartProductUpdate(Map<String, Object> map); // 해당 상품의 수량 Update

    void productInsert(Map<String, Object> map); // 장바구니에 처음 담을때

    void productDelete(Map<String, Object> map); // 선택 삭제

    void soldOutDelete(Map<String, Object> map); // 품절상품 삭제

    List<SellCountMapperDTO> getSellCountProduct(long memId); // 장바구니 상품 재고 수량 - 품절 여부

    // mypage
    void productInsertList(Map<String, Object> map);

    @Delete("delete from cart where seq_member = #{memId}")
    void buyProductDelete(@Param("memId") Long memId); // 결제 후 장바구니에 있는 상품 삭제

    List<CartMapperDTO> getBuyCartProduct(Long memId);
}
