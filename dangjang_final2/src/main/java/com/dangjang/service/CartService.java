package com.dangjang.service;

import com.dangjang.dto.CartMapperDTO;
import com.dangjang.dto.ProductMapperDTO;
import com.dangjang.dto.SellCountMapperDTO;
import com.dangjang.mapper.CartMapper;
import com.dangjang.mapper.ProductMapper;
import com.dangjang.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Log
public class CartService {
    private final ProductMapper productMapper;
    private final CartMapper cartMapper;
    private final HttpSession session;

    public List<ProductMapperDTO> getUserCartList(List<CartMapperDTO> cartProductCount) {
        List<ProductMapperDTO> cartProduct = cartMapper.getUserCartList(cartProductCount);
        log.info("----------- 장바구니 리스트 " + cartProduct);
        return cartProduct;
    }

    public List<CartMapperDTO> getUserCartCount() {
        Long memId = (Long) session.getAttribute("memId");
        List<CartMapperDTO> cartProductCount = cartMapper.getCartProductCount(memId);

        return cartProductCount;
    }

    @Transactional
    public void cartProductUpdate(String seq_product, String count) {
        Long memId = (Long) session.getAttribute("memId");

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("memId", memId);
        map.put("seq_product", seq_product);
        map.put("count", Integer.parseInt(count));

        cartMapper.cartProductUpdate(map);// 수량 update
    }

    @Transactional
    public String productInsert(Map<String, Object> map) {
        Long memId = (Long)session.getAttribute("memId");
        map.put("memId", memId);

        cartMapper.productInsert(map);

        // 회원 장바구니 수량 다시 보내주기기
        session.removeAttribute("cartCount");
        int cartCount = cartMapper.getUserCartTotalCount(memId);
        session.setAttribute("cartCount", cartCount);

        return "insertOk";
    }

    @Transactional
    public String productDelete(Map<String, Object> map) {
        Long memId = (Long)session.getAttribute("memId");
        map.put("memId", memId);

        cartMapper.productDelete(map);

        // 회원 장바구니 수량 다시 보내주기기
        session.removeAttribute("cartCount");
        int cartCount = cartMapper.getUserCartTotalCount(memId);
        session.setAttribute("cartCount", cartCount);

        return "deleteOk";
    }
    @Transactional
    public String soldOutDelete(Map<String, Object> map) {
        Long memId = (Long)session.getAttribute("memId");
        map.put("memId", memId);

        cartMapper.soldOutDelete(map);

        return "deleteOk";
    }

    public List<SellCountMapperDTO> getSellCountProduct() { // 품절인 상품들만 솎
        long memId = (long) session.getAttribute("memId");
        List<SellCountMapperDTO> sellCountList = cartMapper.getSellCountProduct(memId);
        log.info("---------장바구니 상품 재고 수량" + sellCountList);
        return sellCountList;
    }

    @Transactional
    public String productInsertList(List<String> productSeq) { // 장바구니 여러개 추가
        String memId = session.getAttribute("memId")+"";
        Map<String, Object> map = new HashMap<>();

        for (int i = 0; i <productSeq.size(); i ++) {
            map.put("memId", memId);
            map.put("seq_product", productSeq.get(i));
            cartMapper.productInsertList(map);
        }
        return "success";
    }
}
