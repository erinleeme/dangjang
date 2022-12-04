package com.dangjang.ha.controller;

import com.dangjang.dto.BasicProductMapperDTO;
import com.dangjang.dto.FavoriteMapperDTO;
import com.dangjang.dto.ProductMapperDTO;
import com.dangjang.service.FavoriteService;
import com.dangjang.service.ImageContentService;
import com.dangjang.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/dangjang/mypage/favorite")
@RequiredArgsConstructor
@Log
public class FavoriteController {
    private final FavoriteService favoriteService;
    private final HttpSession session;
    private final ImageContentService imageContentService;
    private final ProductService productService;


    //현재 찜 상품 개수 -> 세션으로 보내줘서 필요없음
    @PostMapping(value="/count")
    public int getFavoriteCount() {
        return favoriteService.getFavoriteCount();
    }

    //찜 paging해서 보여주기
    @GetMapping(value="/myFavoriteList")
//@ResponseBody
    public String getFavoriteList(@RequestParam(required = false, defaultValue = "1") String pg,
                                  Model model) {
        System.out.println("getFavoriteList--------------------------------------");

        Map<String, Object> map = new HashMap<>();

        //찜한 목록
        List<FavoriteMapperDTO> favoriteList = favoriteService.getFavoriteList(pg);

        //찜한 상품 목록
        List<ProductMapperDTO> productFavorite = productService.getFavoriteProduct(favoriteList);

        System.out.println("favoriteList ------------------- " + favoriteList);
        System.out.println("productFavorite ----------------- " + productFavorite);

        //시리얼 넘버 갖고오기
        List<BasicProductMapperDTO> favoriteProductImages = imageContentService.productImage(productFavorite);

        System.out.println("favoriteProductImages ------------------------ " + favoriteProductImages);

        map.put("favoriteList", favoriteList);
        map.put("productFavorite", productFavorite);
        map.put("favoriteProductImages", favoriteProductImages);
        map.put("paging", favoriteService.paging(pg));

        model.addAttribute("favoriteList",favoriteList);
        model.addAttribute("productFavorite", productFavorite);
        model.addAttribute("favoriteProductImages", favoriteProductImages);
        model.addAttribute("paging", favoriteService.paging(pg));

        //model.addAttribute("map", map);

        return "/mypage/xPick";
    }

    //찜 삭제
    @PostMapping(value="/deleteFavorite")
    @ResponseBody
    public String deleteFavorite(@RequestParam Map<String, String> map) {
        String favoriteId = map.get("id");
        System.out.println("favoriteId -------------------------------------" + favoriteId);
        favoriteService.deleteFavorite(favoriteId);

        return "deletePickPd";
    }


}
