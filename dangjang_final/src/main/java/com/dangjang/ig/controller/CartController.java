package com.dangjang.ig.controller;

import com.dangjang.dto.BasicProductMapperDTO;
import com.dangjang.dto.CartMapperDTO;
import com.dangjang.dto.ProductMapperDTO;
import com.dangjang.dto.SellCountMapperDTO;
import com.dangjang.service.CartService;
import com.dangjang.service.FavoriteService;
import com.dangjang.service.ImageContentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/dangjang/shop")
@RequiredArgsConstructor
@Log
public class CartController {
    private final CartService cartService;
    private final ImageContentService imageContentService;
    private final FavoriteService favoriteService;

    // 장바구니 페이지 연결해주기
    @GetMapping("/cart")
    public String cart(Model model){
        model.addAttribute("display", "shop/cartList.jsp");
        return "index";
    }

    // 장바구니 리스트 뿌려주기
    @PostMapping("/cart/list")
    @ResponseBody
    public Map<String, Object> cartList() {
        List<CartMapperDTO> cartProductCount = cartService.getUserCartCount(); // 장바구니에 당겨있는 상품마다의 수량
        List<SellCountMapperDTO> sellCountList = cartService.getSellCountProduct(); // 상품 품절 여부
        List<ProductMapperDTO> cartProduct = cartService.getUserCartList(cartProductCount); // 해당유저의 장바구니 상품 정보
        List<BasicProductMapperDTO> cartProductImages = imageContentService.productImage(cartProduct); // 이미지

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("cartProductCount", cartProductCount);
        map.put("cartProduct", cartProduct);
        map.put("cartProductImages", cartProductImages);
        map.put("sellCountList", sellCountList);
        return map;
    }

    // 상품 수량 변경
    @PostMapping("/cart/itemCountModify")
    @ResponseBody
    public void productCountUpdate(@RequestParam String seq_product,
                                   @RequestParam String count) { // seq_product, count 전달
        log.info("-----------상품 수량 조정----seq_product: " + seq_product + " count: " + count);
        cartService.cartProductUpdate(seq_product, count);
    }

    // 장바구니 담기
    @PostMapping("/cart/insert")
    @ResponseBody
    public String productInsert(@RequestParam Map<String, Object> map) {
        log.info("------------상품 장바구니에 담기" + map);
        return cartService.productInsert(map);
    }

    // 장바구니 상품 삭제
    @PostMapping("/cart/delete")
    @ResponseBody
    public String productDelete(@RequestParam Map<String, Object> map) {
        log.info("-----------상품 삭제----seq_product: " + map.get("seq_product"));
        return cartService.productDelete(map);
    }

    // 품절 상품 삭제
    @PostMapping("/cart/deleteSoldOut")
    @ResponseBody
    public String soldOutDelete(@RequestParam Map<String, Object> map) {
        return cartService.soldOutDelete(map);
    }

    @PostMapping("/cart/insertList") // 장바구니에 여러개 담을때
    @ResponseBody
    public String productInsertList(@RequestParam(value ="productSeq[]") List<String> productSeq) {

        return cartService.productInsertList(productSeq);
    }

    // 좋아요 클릭
    @PostMapping(value = "/product/detail/pick")
    @ResponseBody
    public String productDetailPick(@RequestParam String seq_product){
        return favoriteService.productDetailPick(seq_product);
    }

}
