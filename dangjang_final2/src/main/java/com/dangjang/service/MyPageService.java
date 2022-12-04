package com.dangjang.service;

import com.dangjang.domain.*;
import com.dangjang.domain.type.Gender;
import com.dangjang.dto.MemberMapperDTO;
import com.dangjang.mapper.MemberMapper;
import com.dangjang.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MyPageService {
    @Autowired
    private final MemberRepository memberRepository;
    @Autowired
    private final MemberCouponRepository memberCouponRepository;
    @Autowired
    private final OrderRepository orderRepository;
    @Autowired
    private final DeliveryRepository deliveryRepository;
    @Autowired
    private final OrderProductRepository orderProductRepository;
    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private final FavoriteRepository favoriteRepository;
    @Autowired
    private final RefrigeratorRepository refrigeratorRepository;
    @Autowired
    private final ImageContentRepository imageContentRepository;
    private final MemberMapper memberMapper;

    private HttpSession session;

    public Member getInformation(String memberId) { // 회원정보 가져오기
        Member member = memberRepository.getInformation(memberId);

        return member;
    }

    public MemberMapperDTO getInformation2(String memberId) { // 회원정보 가져오기
        MemberMapperDTO memberMapperDTO = memberMapper.getInformationL(memberId);

        return memberMapperDTO;
    }

    public int getCouponCount(String memberId) { // 마이페이지 진입시 회원 쿠폰수 잡아오기
        int couponCount = memberCouponRepository.getCouponCount(memberId);
        return couponCount;
    }

    public int getDeliveryCount(String memberId) { // 마이페이지 진입시 회원 주문/배송중인 수 잡아오기
        List<Orders> list = orderRepository.getOrders(memberId); // memberId 로 list 를 뽑음

        int deliveryCount = 0;

        for(int i = 0; i < list.size(); i++) {
            Delivery delivery = list.get(i).getDelivery();
            boolean statusCheck = deliveryRepository.getDeliveryStatus(delivery.getId());
            if(statusCheck) {
                deliveryCount++;
            } // if
        } // for

        return deliveryCount;
    }

    public List<Product> getOrderProduct(String memberId) {
        // orders 에서 seq_order 추출 => seq_order list로 order_product에서 seq_product 추출 => seq_product 로 product list잡고 return
        List<Orders> orderList = orderRepository.getOrders(memberId); // memberId 로 list 를 뽑음

        List<Long> ids = new ArrayList<>();
        for(int i = 0; i < orderList.size(); i++) {
            ids.add(orderList.get(i).getId());
        } // for

        List<OrderProduct> orderProductList = orderProductRepository.getOrderProductList(ids); // seq_product 추출

        List<Product> ids2 = new ArrayList<>();
        for(int i=0; i < orderProductList.size(); i++) { // seq_product 값만 저장
            ids2.add(orderProductList.get(i).getProduct());
        } // for

        List<Product> productList = productRepository.getProductInformation(ids2); // 상품 list 뽑아오기

        return productList;
    }

    public int getFavoriteCount(String memberId) {
       // int favoriteCount = favoriteRepository.getFavoriteCount(memberId); // select * from favorite where seq_member = ?1;

        return 0;
    }

    public int getRefrigeratorCount(String memberId) {
       //int refrigeratorCount = refrigeratorRepository.getRefrigeratorCount(memberId); // select count(*) from refrigerator as r
                                                                                       // join address as a
                                                                                       // on r.seq_address = a.seq_address
                                                                                       // where a.seq_member = 56;
        return 0;
    }

//    public List<ImageContent> getImage(List<Product> list) { // product imageList
//        List<Long> ids = new ArrayList<>();
//        for(int i = 0; i < list.size(); i++) { // product seq 값만 추출
//            ids.add(list.get(i).getId());
//        } // for
//        List<ImageContent> imageList = imageContentRepository.getProductImage("상품", ids);
//        return imageList;
//    }

    public void modify(Map<String, String> map) {
        Long memberId = (Long) session.getAttribute("memId");
        if(map.get("name").isEmpty()) {
            memberRepository.modifyPwd(map.get("pwd"), memberId);
        } else {
            Member member = new Member();
            if(map.get("plaform").isEmpty() || map.get("platform") == null) {
                member.setPassword(map.get("pwd"));         // 1
            }
            member.setNickname(map.get("phone"));           // 2
            member.setNickname(map.get("nickName"));        // 3
            if(map.get("sex").equals("m")) {    // 성별      // 4
                member.setGender(Gender.남자);
            }else {
                member.setGender(Gender.여자);
            } // else 성별
            member.setBirth(map.get("birth"));              // 5
            String email = map.get("email"); // email 1, 2 분리
            int idx = email.indexOf("@");
            String email1 = email.substring(0, idx);
            String email2 = email.substring(idx+1); // 분리 끝
            member.setEmail1(email1);
            member.setEmail2(email2);                       // 6

            memberRepository.modifyAll(member, memberId);
        }
    }
}
