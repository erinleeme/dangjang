package com.dangjang.ha.controller;

import com.dangjang.dto.BasicProductMapperDTO;
import com.dangjang.dto.OrderProductMapperDTO;
import com.dangjang.dto.ProductMapperDTO;
import com.dangjang.mapper.ProductMapper;
import com.dangjang.service.ImageContentService;
import com.dangjang.service.OrderProductService;
import com.dangjang.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/orderProduct")
@RequiredArgsConstructor
@Log
public class OrderProductController {
    private final OrderProductService orderProductService;
    private final ProductService productService;
    private final ImageContentService imageContentService;

    //특정 주문의 상품 리스트
    @GetMapping("/getList")
    public String getList(@RequestParam Map<String, String> map, Model model) {
        String orderNum = map.get("seq_orders");

        //OrderProduct 리스트
        List<OrderProductMapperDTO> orderProductList = orderProductService.getOrderProductList(orderNum);

        //해당 주문 상품 정보 리스트
        List<ProductMapperDTO> productList = productService.getOrderProductList(orderProductList);

        //시리얼 넘버
        List<BasicProductMapperDTO> orderProductSerialList = imageContentService.productImage(productList);

        model.addAttribute("orderProductList", orderProductList);
        model.addAttribute("productList", productList);
        model.addAttribute("orderProductSerialList", orderProductSerialList);

        return "orders";
    }

}
