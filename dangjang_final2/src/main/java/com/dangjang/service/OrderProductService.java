package com.dangjang.service;

import com.dangjang.dto.OrderProductDTO;
import com.dangjang.dto.OrderProductMapperDTO;
import com.dangjang.mapper.OrderProductMapper;
import com.dangjang.repository.OrderProductRepository;
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
public class OrderProductService {
    private final OrderProductRepository orderProductRepository;
    private final OrderProductMapper orderProductMapper;
    private final HttpSession session;

    public List<OrderProductMapperDTO> getOrderProductList(String orderNum) {
        System.out.println("getOrderProductList >>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + orderProductMapper.getOrderProductList(orderNum));

        return orderProductMapper.getOrderProductList(orderNum);
    }

    //작성 가능한 리뷰 상품
    public List<OrderProductDTO> getOrderReviewList(String pg) {
        String memberId = session.getAttribute("memId") + "";
        // String memberId = "2";

        int endPage = Integer.parseInt(pg) * 10;
        int startPage = endPage - 9;
        log.info("---------------- 리뷰가능한 주문 상품 전체 리스트 / where조건: startPage= " + startPage + " endPage= " + endPage);

        Map<String, Object> map = new HashMap<>();
        map.put("startPage", startPage);
        map.put("endPage", endPage);
        map.put("memberId", memberId);

        return orderProductMapper.getOrderReviewList(map);
    }

    //리뷰 상태 바꾸기
    public void changeReviewCheck(Map<String, String> map) {
        orderProductMapper.changeReviewCheck(map);
    }
}
