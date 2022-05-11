package com.dangjang.ig.controller;

import com.dangjang.dto.*;
import com.dangjang.paging.OrderPaging;
import com.dangjang.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@Log
public class OrderController {
    private final AddressService addressService;
    private final MemberService memberService;
    private final OrderService orderService;
    private final DeliveryService deliveryService;
    private final OrderProductService orderProductService;
    private final MemberCouponService memberCouponService;
    private final ProductService productService;
    private final CartService cartService;
    private final ImageContentService imageContentService;
    private final PaymentService paymentService;

    // 배송지 추가
    @PostMapping("/dangjang/shop/address/add")
    @ResponseBody
    public String addressAdd(@RequestParam Map<String, String> map){
        return addressService.addressAdd(map);
    }

    // 배송정보 화면 연결
    @GetMapping("/dangjang/shop/delivery")
    public String delivery(Model model) {

        MemberMapperDTO memberMapperDTO = memberService.getMemberInformation(); // 회원정보
        model.addAttribute("orderer_name", memberMapperDTO.getName());
        model.addAttribute("orderer_phone", memberMapperDTO.getPhone());
        model.addAttribute("orderer_email", memberMapperDTO.getEmail1()+'@'+memberMapperDTO.getEmail2());

        model.addAttribute("display", "shop/deliveryList.jsp");
        return "index";
    }

    // 배송 데이터 보내주기
    @PostMapping("/dangjang/shop/delivery/list")
    @ResponseBody
    public Map<String, Object> deliveryList(){
                               // @RequestParam(value ="productSeq[]") List<String> productSeq,

        List<AddressMapperDTO> addressList = addressService.getMemberAddress(); // 배송지 정보 들고옴 1빠따가 기본배송지
        log.info("--------------------------배송정보 주소 " + addressList);
        // 선택 상품 주문 X
        // List<ProductMapperDTO> productList = productService.getCartChoiceProduct(productSeq); // 카트에서 선택한 상품만

        // 장바구니에 담긴 상품 그대로 주문 O
        List<CartMapperDTO> cartProductCount = cartService.getUserCartCount(); // 장바구니에 당겨있는 상품마다의 수량
        List<ProductMapperDTO> cartProduct = cartService.getUserCartList(cartProductCount); // 해당유저의 장바구니 상품 정보
        List<BasicProductMapperDTO> cartProductImages = imageContentService.productImage(cartProduct); // 이미지

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("addressList", addressList);
        map.put("orderProductList", cartProduct);
        map.put("orderProductImageList", cartProductImages);
        map.put("orderProductCount", cartProductCount);

        return map;
    }

    // 주문서 작성 완료 누를시
    @PostMapping("/dangjang/shop/delivery/ok")
    @ResponseBody
    public String deliveryOk(@RequestParam Map<String, Object> map) {
        log.info("------------/delivery/ok" + map);

        return deliveryService.deliveryOk(map);

    }

    // 결제 페이지 뿌려주기
    @GetMapping("/dangjang/shop/payment")
    public String payment(@RequestParam String addr
            ,Model model) {
        MemberMapperDTO memberMapperDTO = memberService.getMemberInformation();

        model.addAttribute("name", memberMapperDTO.getName());
        model.addAttribute("phone", memberMapperDTO.getPhone());
        model.addAttribute("email", memberMapperDTO.getEmail1()+"@"+memberMapperDTO.getEmail2());
        model.addAttribute("orderCount", orderService.getOrderCount());
        model.addAttribute("addr", addr);
        model.addAttribute("display", "shop/payment.jsp");
        return "index";
    }

    @PostMapping("/dangjang/shop/payment/list") // 결제창 진입시
    @ResponseBody
    public Map<String, Object> paymentList(@RequestParam String baseStatus) {
        List<MemberCouponMapperDTO> memberCouponList = memberCouponService.getMemberCouponList(); // 회원이 보유중인 쿠폰 list
        log.info("-----------결제창 " + memberCouponList);
        List<CouponMapperDTO> couponList = memberCouponService.getCouponList(memberCouponList);
        List<ProductMapperDTO> productList = productService.getOrderProduct(); // 카트에 있는 상품 끌
        // 주소
        AddressMapperDTO addressMapperDTO = addressService.getOrderAddress(baseStatus);


        Map<String, Object> map = new HashMap<String, Object>();
        map.put("productList", productList); // 상품 정보
        map.put("couponList", memberCouponList); // 사용 가능한 쿠폰
        map.put("couponName", couponList); // 쿠폰 이름, 정보
        map.put("address", addressMapperDTO);

        return map;
    }

    /////////////////////////////////////////////// 결제
    @PostMapping("/dangjang/shop/payment/ok")
    @ResponseBody
    public String paymentOk(@RequestParam Map<String, Object> map) {
        return orderService.paymentOk(map);
    }


    // 주문완료
    @GetMapping(value="/dangjang/shop/order")
    public String order(Model model){
        MemberMapperDTO memberMapperDTO = memberService.getMemberInfo();
        OrdersMapperDTO ordersMapperDTO = orderService.getOrderNumnDate();
        String orderNum = ordersMapperDTO.getOrder_num(); // 주문번호
        List<ProductMapperDTO> productList = productService.getBuyProductList(ordersMapperDTO); // 상품 리스트

        String date = ordersMapperDTO.getOrder_date().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")); // 날짜 가공

        model.addAttribute("orderName", memberMapperDTO.getName()); // 회원 이름
        model.addAttribute("orderNum", orderNum); // 주문번호
        model.addAttribute("productList", productList); // 구매한 상품 list
        model.addAttribute("date", date); // 날짜
        model.addAttribute("display", "shop/orderComplete.jsp");
        return "index";
    }



    /////////////////////////////////////////////// mypage ///////////////////////////////////////////////
    //전체 주문내역 목록 갖고오기
    @GetMapping(value="/dangjang/mypage/order/getOrderList")
    //@ResponseBody
    public String getOrderList(@RequestParam(required = false, defaultValue = "1") String pg, Model model) {
        //Orders List
        //List<OrdersMapperDTO> ordersMapperDTOList = orderService.getOrderList(pg);
        OrderPaging orderPaging = orderService.paging(pg);

        List<OrderListMapperDTO> orderListMapper = orderService.getOrderListMapper(pg);
        List<OrderListMapperDTO> orderListMapperList = new ArrayList<>();

        for(OrderListMapperDTO orderListMapperDTO : orderListMapper) {
            orderListMapperDTO.setOrderItem(orderService.getOrderItemCount(orderListMapperDTO.getSeq_order()));
            orderListMapperList.add(orderListMapperDTO);
        }

        Map<String, Object> map = new HashMap<>();
        map.put("orderListMapperList", orderListMapperList);
        map.put("orderPaging", orderPaging);

        model.addAttribute("orderListMapperList", orderListMapperList);
        model.addAttribute("orderPaging", orderPaging);

        return "/mypage/xOrderList";
    }

    //주문/배송 개수
    @GetMapping(value="/dangjang/mypage/order/orderCount")
    @ResponseBody
    public int orderCount() {
        return orderService.orderCount();
    }

    //교환/반품 상품 갖고오기
    @GetMapping(value="/dangjang/mypage/order/getOrderClaimList")
    //@ResponseBody
    public String getOrderClaimList(@RequestParam(required = false, defaultValue = "1") String pg, Model model) {
        List<OrderClaimMapperDTO> orderClaimList = orderService.getOrderClaimList(pg);

        OrderPaging orderPaging = orderService.claimPaging(pg);

        Map<String, Object> map = new HashMap<>();
        map.put("orderClaimList", orderClaimList);
        map.put("orderPaging", orderPaging);

        model.addAttribute("orderClaimList", orderClaimList);
        model.addAttribute("orderPaging", orderPaging);

        return "/mypage/xOrderClaimList";
    }

    //상세 주문내역 갖고오기
    @GetMapping(value="/dangjang/mypage/order/orderDetail")
    public String getOrderDetail(@RequestParam Map<String, String> map, Model model) {
        System.out.println("orderDetail>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        //주문한 상품 리스트
        String seq_order = map.get("seq_order");

        System.out.println("seq_order Detail >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + seq_order);

        List<OrderProductMapperDTO> orderProductList = orderProductService.getOrderProductList(seq_order);
        System.out.println("orderProduct>>>>>>>>>>>>>>>>>>>>>>>>>>>"  + orderProductList);

        //상품 리스트
        List<ProductMapperDTO> productList = productService.getOrderProductList(orderProductList);
        System.out.println("productList>>>>>>>>>>>>>>>>>>>>>>>>>>>"  + productList);

        //시리얼 넘버 리스트
        List<BasicProductMapperDTO> serialNumberList = imageContentService.productImage(productList);

        //결제 정보
        OrdersMapperDTO orderMapperDTO = orderService.getOrderDetail(map);
        //결제 일시
        PaymentMapperDTO paymentMapperDTO = paymentService.getPaymentDetail(map);
        //배송 정보
        DeliveryMapperDTO deliveryMapperDTO = deliveryService.getOrderDeliveryDetail(map);
        System.out.println("deliveryMapperDTO>>>>>>>>>>>>>>>>>>>>>>>>>>>"  + deliveryMapperDTO);


        model.addAttribute("orderProductList", orderProductList);
        model.addAttribute("productList", productList);
        model.addAttribute("serialNumberList", serialNumberList);
        model.addAttribute("orderMapperDTO", orderMapperDTO);
        model.addAttribute("paymentMapperDTO", paymentMapperDTO);
        model.addAttribute("deliveryMapperDTO", deliveryMapperDTO);
        model.addAttribute("display", "mypage/xOrderDetail.jsp");

        return "index";
    }

    //주문 취소
    //order_num 보내주기
    @GetMapping(value = "/dangjang/mypage/order/getOrderNum")
    public String getOrderNum(@RequestParam Map<String, String> map, Model model) {
        String orderNum = orderService.getOrderNum(map);
        return orderNum;
    }


    //결제 상태 주문 취소로 변경
    @GetMapping(value = "/dangjang/mypage/order/cancelOrder")
    public void cancelOrder(@RequestParam Map<String, String> map) {
        //주문내역에서 변경
        orderService.cancelOrder(map);

        //결제내역에서 변경
        paymentService.cancelOrder(map);
    }

    //환불 상태로 변경
    @GetMapping(value ="/dangjang/mypage/order/refundOrder")
    public void refundOrder(@RequestParam Map<String, String> map) {
        //주문내역에서 변경
        orderService.refundOrder(map);

        //결제내역에서 변경
        paymentService.refundOrder(map);
    }
}
