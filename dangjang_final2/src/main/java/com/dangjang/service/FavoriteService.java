package com.dangjang.service;

import com.dangjang.dto.FavoriteMapperDTO;
import com.dangjang.mapper.FavoriteMapper;
import com.dangjang.paging.FavoritePaging;
import com.dangjang.repository.FavoriteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = false)
@RequiredArgsConstructor
@Log
public class FavoriteService {
    private final FavoriteRepository favoriteRepository;
    private final FavoriteMapper favoriteMapper;
    private final HttpSession session;
    private final FavoritePaging favoritePaging;

    public int getFavoriteCount() {
        String memberId = session.getAttribute("memId") + "";
        return favoriteMapper.getFavoriteCount(memberId);
    }

    public int getFavoriteCount(String memberId) {
        return favoriteMapper.getFavoriteCount(memberId);
    }

    public List<FavoriteMapperDTO> getFavoriteList(String pg) {
        String memberId = session.getAttribute("memId") + "";
        //String memberId = "1";

        int endPage = Integer.parseInt(pg) * 10;
        int startPage = endPage - 9;
        log.info("---------------- 찜 전체 리스트 / where조건: startPage= " + startPage + " endPage= " + endPage);

        Map<String, Object> map = new HashMap<>();
        map.put("startPage", startPage);
        map.put("endPage", endPage);
        map.put("memberId", memberId);

        System.out.println("getFavoriteList List >>>>>>>>>>>>>>>>>>>>>>> " + favoriteMapper.getFavoriteList(map));
        return favoriteMapper.getFavoriteList(map);
    }

    //페이징
    public FavoritePaging paging(String pg) {
        String memberId = session.getAttribute("memId") + "";

        int totalRecords = favoriteMapper.getFavoriteCount(memberId);
        log.info("----------------paging " + totalRecords);
        favoritePaging.setCurrentPage(Integer.parseInt(pg));
        favoritePaging.setRecordsPerPage(10);
        favoritePaging.setPageSize(10);
        favoritePaging.setTotalRecords(totalRecords);
        favoritePaging.makePaging();
        return favoritePaging;
    }

    public void deleteFavorite(String favoriteId) {
        favoriteMapper.deleteFavorite(favoriteId);
    }

    @Transactional(readOnly = false)
    public String productDetailPick(String seq_product) {
        long memId = (long)session.getAttribute("memId");
        favoriteMapper.productDetailPick(seq_product, memId);

        // 회원 장바구니 수량 다시 보내주기기
        session.removeAttribute("favoriteCount");
        int favoriteCount = favoriteMapper.getUserFavoriteTotalCount(memId);
        session.setAttribute("favoriteCount", favoriteCount);

        return "pickOk";
    }
}
