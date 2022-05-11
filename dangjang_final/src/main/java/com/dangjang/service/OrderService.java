package com.dangjang.service;

import com.dangjang.dto.*;
import com.dangjang.mapper.*;
import com.dangjang.paging.OrderPaging;
import com.dangjang.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Log
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final HttpSession session;
    private final DeliveryMapper deliveryMapper;
    private final MemberMapper memberMapper;
    private final OrderProductMapper orderProductMapper;
    private final OrderPaging orderPaging;
    private final CartMapper cartMapper;
    private final MemberCouponMapper memberCouponMapper;

    @Transactional
    public String paymentOk(@RequestParam Map<String, Object> map) { // 결제시
        Long memId = (long) session.getAttribute("memId");
        MemberMapperDTO memberMapperDTO = memberMapper.getInformation(memId);
        String phone = memberMapperDTO.getPhone();
        long seq_delivery = deliveryMapper.getMemberdeliverySeq(phone); // delivery seq 값 가져오기
        OrdersMapperDTO ordersMapperDTO = new OrdersMapperDTO();
        ordersMapperDTO.setSeq_member(memId); // 회원 seq
        ordersMapperDTO.setSeq_delivery(seq_delivery); // 배송정보 seq

        OrdersMapperDTO orderMapperDTO = orderMapper.getLastOrderNum();
        if (orderMapperDTO == null) {
            ordersMapperDTO.setSeq_order(1);
        } else {
            ordersMapperDTO.setSeq_order(orderMapperDTO.getSeq_order() + 1); // 주문 seq
        } // else
        log.info("--------------!! map : " + map);
        log.info("----------------------------- mapmap : " + map.get("imp_uid"));
        ordersMapperDTO.setOrder_num((map.get("merchant_uid") + "")); // merchant_id 이거나 imp_uid
        ordersMapperDTO.setDelivery_type("새벽배송"); // 배송 유형
        ordersMapperDTO.setOriginal_total_price(Integer.parseInt(map.get("originalPrice") + "")); // 기존 총 가격
        if (map.get("amount").equals("30000")) {
            ordersMapperDTO.setDelivery_price(0); // 배송 가격
        } else {
            ordersMapperDTO.setDelivery_price(5000); // 배송 가격
        } // else

        ordersMapperDTO.setDiscount_price(Integer.parseInt(map.get("discountPrice") + "")); // 할인가
        ordersMapperDTO.setFinal_price(Integer.parseInt(map.get("amount") + "")); // 최종가격
        ordersMapperDTO.setPay_status("결제완료");

        if (map.get("seq_coupon") != null) {
            String coupon = (String) map.get("seq_coupon");

            ordersMapperDTO.setSeq_coupon(Integer.parseInt(coupon)); // 사용 쿠폰 번호
            Map<String, Object> cMap = new HashMap<>();
            map.put("memId", memId);
            map.put("seq_coupon", coupon);
            memberCouponMapper.deleteUseCoupon(cMap); // 사용 쿠폰 삭제
        }// if


        ordersMapperDTO.setOrder_status("출고대기");
        session.setAttribute("seq_order", orderMapperDTO.getSeq_order());
        orderMapper.orderInformationInsert(ordersMapperDTO);// orders 저장

        ///////////// order_product start
        OrderProductMapperDTO orderProductMapperDTO = new OrderProductMapperDTO();
        orderProductMapperDTO.setSeq_order(ordersMapperDTO.getSeq_order()); // order seq
        orderProductMapperDTO.setReview_check(0); // 리뷰 작성여부 0 = 작성안함 1 = 작성함 디폴트값 0


        List<CartMapperDTO> cartList = cartMapper.getBuyCartProduct(memId);
        log.info("-------cartList : " + cartList);
        for (int i = 0; i < cartList.size(); i++) {
            orderProductMapperDTO.setSeq_product(cartList.get(i).getSeq_product()); // 상품 seq
            orderProductMapperDTO.setCount(cartList.get(i).getCount()); // 상품 수량

            orderProductMapper.orderProductInsert(orderProductMapperDTO); // order_product 저장
        } // for

        // cart 에 있는 상품 삭제
        cartMapper.buyProductDelete(memId);

        return "success";
    }

    public List<OrdersMapperDTO> getOrderList(String pg) {
        String memberId = session.getAttribute("memId") + "" ;
        //String memberId = "1";

        int endPage = Integer.parseInt(pg) * 10;
        int startPage = endPage - 9;
        log.info("---------------- Order 전체 리스트 / where조건: startPage= " + startPage + " endPage= " + endPage);

        Map<String, Object> map = new HashMap<>();
        map.put("startPage", startPage);
        map.put("endPage", endPage);
        map.put("memberId", memberId);

        System.out.println("orderList >>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + orderMapper.getOrderList(map));
        return orderMapper.getOrderList(map);
    }

    public OrderPaging paging(String pg) {
        String memberId = session.getAttribute("memId") + "";

        int totalRecords = orderMapper.getOrderCount(memberId);
        log.info("----------------paging " + totalRecords);
        orderPaging.setCurrentPage(Integer.parseInt(pg));
        orderPaging.setRecordsPerPage(10);
        orderPaging.setPageSize(10);
        orderPaging.setTotalRecords(totalRecords);
        orderPaging.makePaging();
        return orderPaging;
    }

    public int orderCount() {
        String memberId = session.getAttribute("memId") + "";
        return orderMapper.orderCount(memberId);
    }

    //교환/반품 내역 리스트
    public List<OrderClaimMapperDTO> getOrderClaimList(String pg) {
        String memberId = session.getAttribute("memId") + "" ;
        //String memberId = "1";

        int endPage = Integer.parseInt(pg) * 10;
        int startPage = endPage - 9;
        log.info("---------------- getOrderClaimList 전체 리스트 / where조건: startPage= " + startPage + " endPage= " + endPage);

        Map<String, Object> map = new HashMap<>();
        map.put("startPage", startPage);
        map.put("endPage", endPage);
        map.put("memberId", memberId);

        System.out.println("orderList >>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + orderMapper.getOrderClaimList(map));
        return orderMapper.getOrderClaimList(map);
    }

    public List<OrderListMapperDTO> getOrderListMapper(String pg) {
        String memberId = session.getAttribute("memId") + "" ;
        //String memberId = "1";

        int endPage = Integer.parseInt(pg) * 10;
        int startPage = endPage - 9;
        log.info("---------------- getOrderListMapperList 전체 리스트 / where조건: startPage= " + startPage + " endPage= " + endPage);

        Map<String, Object> map = new HashMap<>();
        map.put("startPage", startPage);
        map.put("endPage", endPage);
        map.put("memberId", memberId);

        System.out.println("orderList >>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + orderMapper.getOrderClaimList(map));
        return orderMapper.getOrderListMapper(map);

    }

    public String getOrderItemCount(String seq_order) {
        return orderMapper.getOrderItemCount(seq_order);
    }

    public OrderPaging claimPaging(String pg) {
        String memberId = session.getAttribute("memId") + "";

        int totalRecords = orderMapper.getOrderClaimCount(memberId);
        log.info("----------------paging " + totalRecords);
        orderPaging.setCurrentPage(Integer.parseInt(pg));
        orderPaging.setRecordsPerPage(10);
        orderPaging.setPageSize(10);
        orderPaging.setTotalRecords(totalRecords);
        orderPaging.makePaging();
        return orderPaging;
    }

    public OrdersMapperDTO getOrderDetail(Map<String, String> map) {
        return orderMapper.getOrderDetail(map);
    }

    public String getOrderNum(Map<String, String> map) {
        return orderMapper.getOrderNum(map);
    }

    public void cancelOrder(Map<String, String> map) {
        orderMapper.cancelOrder(map);

    }

    public void refundOrder(Map<String, String> map) {
        orderMapper.refundOrder(map);
    }

    public Object getOrderCount() {
        long count = orderMapper.getOrderTotalCount();

        return count;
    }

    public OrdersMapperDTO getOrderNumnDate() {
        long memId = (long) session.getAttribute("memId");
        OrdersMapperDTO ordersMapperDTO = orderMapper.getOrderNumnDate(memId);

        return ordersMapperDTO;
    }


}