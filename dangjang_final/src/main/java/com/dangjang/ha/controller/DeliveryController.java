package com.dangjang.ha.controller;

import com.dangjang.dto.DeliveryMapperDTO;
import com.dangjang.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@Log4j2
@RequestMapping(value="/dangjang/mypage/delivery")
@RequiredArgsConstructor
public class DeliveryController {
    private DeliveryService deliveryService;

    //특정 주문내역의 배송정보 갖고오기
    @GetMapping(value="/getDelivery")
    public String getDelivery(@RequestParam Map<String, String> map, Model model) {
        String deliveryNum = map.get("deliveryNum");
        DeliveryMapperDTO deliveryMapperDTO = deliveryService.getOrderDelivery(deliveryNum);

        model.addAttribute("deliveryMapperDTO", deliveryMapperDTO);
        return "orders";
    }

}
