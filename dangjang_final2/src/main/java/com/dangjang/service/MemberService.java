package com.dangjang.service;

import com.dangjang.domain.*;
import com.dangjang.domain.type.Gender;
import com.dangjang.domain.type.Social;
import com.dangjang.dto.*;
import com.dangjang.mapper.*;
import com.dangjang.repository.AddressRepository;
import com.dangjang.repository.LoginHistoryRepository;
import com.dangjang.repository.MemberRepository;
import com.dangjang.repository.RefrigeratorRepository;
import com.dangjang.util.naverSMS;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = false)
@RequiredArgsConstructor
@Log
public class MemberService {
    private final MemberRepository memberRepository;
    private final AddressRepository addressRepository;
    private final HttpSession session;
    private final RefrigeratorRepository refrigeratorRepository;
    private final MemberMapper memberMapper;
    private final CartMapper cartMapper;
    private final FavoriteMapper favoriteMapper;
    private final LoginHistoryMapper loginHistoryMapper;
    private final PasswordEncoder passwordEncoder;
    private final CouponMapper couponMapper;
    private final WithDrawalMapper withDrawalMapper;

    @Transactional
        public void socialregister(Map<String, String> map) { // 간편 회원가입
                Member member = new Member();
                String birth = map.get("j_birth_year");
                birth += map.get("j_birth_month");
                birth += map.get("j_birth_day");
                member.setBirth(birth);  // 생일
                log.info("------------------- sex : " + map.get("sex"));
                if(map.get("sex").equals("m")) {    // 성별
                    member.setGender(Gender.남자);
                }else {
                    member.setGender(Gender.여자);
                } // else 성별

                member.setMemberGrade(MemberGrade.일반회원); // 회원등급
                member.setAgreement(true);                 // 가입시 동의 여부

                String email = map.get("j_email"); // email 1, 2 분리
                int idx = email.indexOf("@");
                String email1 = email.substring(0, idx);
                String email2 = email.substring(idx+1); // 분리 끝

                member.setEmail1(email1);                  // email1
                member.setEmail2(email2);                  // email2
                member.setName(map.get("j_name"));         // 이름
                member.setPlatform(Social.일반);            // platform
                member.setNickname(map.get("j_nickname")); // nickname
                member.setPhone(map.get("j_phone"));       // phone
                member.setMember_status("활동회원");

                if(map.get("kakaojoinForm").equals("kakao")) { // social
                    member.setPlatform(Social.네이버);
                } else {
                    member.setPlatform(Social.카카오);
                } // else

                member.setMemberId(memberMapper.getMemberCount() + 1);

                memberMapper.updateMemberCount(member.getMemberId());

                session.setAttribute("joinseq", member.getMemberId());
                memberRepository.save(member);       // insert into member

                // Address save
                Address address = new Address();
                address.setZipcode(map.get("zipcode"));        // 우편번호
                address.setAddress1(map.get("addr1"));         // 주소
                address.setAddress2(map.get("j_addr_detail")); // 상세주소
                address.setRecipient(map.get("j_name"));       // 수령인 이름 (기본값으로 본인이름)
                address.setRecipient_phone(map.get("j_phone"));// 수령인 전화번호 (기본값으로 본인번호)
                address.setBaseStatus(true);                   // 기본 배송지

                List<Address> list1 = addressRepository.findTop1ByOrderByIdDesc();
                System.out.println("list1 : " + list1 + "list1.get(0).getId() : ");

                if(list1.isEmpty()) {
                    address.setId(1L);
                    log.info("-------------------------- list == null 이므로 1L 삽입");
                } else {
                    address.setId(list1.get(0).getId());
                    log.info("-------------------------- list != null 이므로 " + list1.get(0).getId() + "삽입");
                } // else

                log.info("----------------------------------------------------seq_address : " + address.getId());
                address.setMember(member);

                addressRepository.save(address);         // insert into address

                // refrigerator ( 냉장고 )
                Refrigerator refrigerator = new Refrigerator();
                List<Refrigerator> list2 = refrigeratorRepository.findTop1ByOrderByIdDesc();

                if(list2.isEmpty()) {
                    refrigerator.setId(1L);
                } else {
                    refrigerator.setId(list2.get(0).getId());
                } // else

                refrigerator.setAddressId(address.getId());      // seq_address
                refrigerator.setAddress1(address.getAddress1()); // address1
                refrigerator.setAddress2(address.getAddress2()); // address2
                refrigerator.setZipcode(address.getZipcode());   // address Zipcode
                // 쿠폰 지급
                String status = "미사용";
                Map<String, Object> map2 = new HashMap<>();
                map2.put("status", status);
                map2.put("memId", member.getMemberId());
                couponMapper.wellcomCoupon(map2);

                refrigeratorRepository.save(refrigerator);

    } // 소셜 회원가입

    @Transactional
    public void register(Map<String, String> map) { // 일반 회원가입
        Member member = new Member();
        String birth = map.get("j_birth_year");
        birth += map.get("j_birth_month");
        birth += map.get("j_birth_day");
        member.setBirth(birth);  // 생일

        if(map.get("sex").equals("m")) {    // 성별
            member.setGender(Gender.남자);
        }else {
            member.setGender(Gender.여자);
        } // else 성별

        member.setMemberGrade(MemberGrade.일반회원); // 회원등급
        member.setAgreement(true);                 // 가입시 동의 여부

        String email = map.get("j_email"); // email 1, 2 분리
        int idx = email.indexOf("@");
        String email1 = email.substring(0, idx);
        String email2 = email.substring(idx+1); // 분리 끝

        member.setEmail1(email1);                  // email1
        member.setEmail2(email2);                  // email2
        member.setName(map.get("j_name"));         // 이름
        member.setPlatform(Social.일반);            // platform
        String encodedPassword = passwordEncoder.encode(map.get("j_pwd")); // password security 1
        member.setPassword(encodedPassword);      // pwd security (SET)
        member.setLoginId(map.get("j_id"));        // loginId
        member.setNickname(map.get("j_nickname")); // nickname
        member.setPhone(map.get("j_phone"));         // phone
        member.setMember_status("활동회원");
       /* List<Member> list = memberRepository.findTop1ByOrderByMemberIdDesc();
        System.out.println("--------------------- list.get(0).getMemberId() : " + list.get(0).getMemberId());
        member.setMemberId(list.get(0).getMemberId()+1); */
        member.setMemberId(memberMapper.getMemberCount() + 1);

        memberMapper.updateMemberCount(member.getMemberId());
        session.setAttribute("joinseq", member.getMemberId());
        memberRepository.save(member);       // insert into member



        // Address save
        Address address = new Address();
        address.setZipcode(map.get("zipcode"));        // 우편번호
        address.setAddress1(map.get("addr1"));         // 주소
        address.setAddress2(map.get("j_addr_detail")); // 상세주소
        address.setRecipient(map.get("j_name"));       // 수령인 이름 (기본값으로 본인이름)
        address.setRecipient_phone(map.get("j_phone"));// 수령인 전화번호 (기본값으로 본인번호)
        address.setBaseStatus(true);                   // 기본 배송지

        List<Address> list1 = addressRepository.findTop1ByOrderByIdDesc();
        System.out.println("list1 : " + list1 + "list1.get(0).getId() : ");
        if(list1.isEmpty()) {
            address.setId(1L);
            log.info("-------------------------- list == null 이므로 1L 삽입");
        } else {
            address.setId(list1.get(0).getId());
            log.info("-------------------------- list != null 이므로 " + list1.get(0).getId() + "삽입");
        }
        log.info("----------------------------------------------------seq_address : " + address.getId());
        address.setMember(member);

        addressRepository.save(address);         // insert into address

        // refrigerator ( 냉장고 )
        Refrigerator refrigerator = new Refrigerator();
        List<Refrigerator> list2 = refrigeratorRepository.findTop1ByOrderByIdDesc();
        if(list2.isEmpty()) {
            refrigerator.setId(1L);
        } else {
            refrigerator.setId(list2.get(0).getId());
        } // else
        refrigerator.setAddressId(address.getId());      // seq_address
        refrigerator.setAddress1(address.getAddress1()); // address1
        refrigerator.setAddress2(address.getAddress2()); // address2
        refrigerator.setZipcode(address.getZipcode());   // address Zipcode

        refrigeratorRepository.save(refrigerator);

        // 쿠폰 지급
        log.info("-----------회원가입 member "+ member.getMemberId());
        String status = "미사용";
        Map<String, Object> map2 = new HashMap<>();
        map2.put("status", status);
        map2.put("memId", member.getMemberId());
        couponMapper.wellcomCoupon(map2);
    } ///////////////////////////////// 일반 회원가입

    public boolean overlapCheck(Map<String, String> map) { // true 시 중복되는것 // false 시 사용가능
        Member member = null;
        boolean overlap = false;
        if(map.get("phone") != null) {
            member = memberRepository.findByPhone(map.get("phone"));
        }else if (map.get("id") != null) {
            member = memberRepository.findByLoginId(map.get("id"));
            if(member != null) {
                if(member.getMember_status() != null) {
                    if(member.getMember_status().equals("탈퇴")) {
                        overlap = false;
                        return overlap;
                    }
                }
            }

        } else if (map.get("email") != null) {
            String email = map.get("email");
            int idx = email.indexOf("@");
            String email1 = email.substring(0, idx);
            String email2 = email.substring(idx+1);
            member = memberRepository.findByEmail1AndEmail2(email1, email2);
        } else if (map.get("nickName") != null) {
            member = memberRepository.findByNickname(map.get("nickName"));
        } // else if

        if(member != null) {
            overlap = true;
        } // if

        return overlap;
    }

    @Transactional
    public String loginOk(Map<String, String> map) {
        String encodedPassword = passwordEncoder.encode(map.get("userPwd")); // password security 1
        Member member = memberRepository.findByLoginId(map.get("userId"));
        if(member == null) {
            return "fail";
        } // if

        if(!passwordEncoder.matches(map.get("userPwd"), member.getPassword())){
            log.info("비밀번호 불일치");
            return "fail";
        } // if

        long memId = member.getMemberId();
        loginHistoryMapper.loginLog(memId);
        log.info("-------------------- memId " + memId);

        int cartCount = cartMapper.getUserCartTotalCount(memId);
        int favoriteCount = favoriteMapper.getUserFavoriteTotalCount(memId);

        log.info("memberService / seq_member : " + member.getMemberId());
        session.setAttribute("cartCount", cartCount); // 장바구니 상품 수량
        session.setAttribute("favoriteCount", favoriteCount); // 찜 상품 수량
        session.setAttribute("memId", member.getMemberId()); // 맴버 seq_member
        session.setAttribute("memNickName", member.getNickname()); // memberNickName
        session.setAttribute("memName", member.getName()); // memberName

        return "loginOk";
    }
    @Transactional
    public String socialLogin(String email1, String email2) {
        Member member = memberRepository.socialLogin(email1, email2);

        if(member == null) {
            log.info("-------------------------------member == null");
            return "fail";
        } // if

        long memId = member.getMemberId();
        loginHistoryMapper.loginLog(memId);

        int cartCount = cartMapper.getUserCartTotalCount(memId);
        int favoruteCount = favoriteMapper.getUserFavoriteTotalCount(memId);

        session.setAttribute("cartCount", cartCount); // 장바구니 상품 수량
        session.setAttribute("favoriteCount", favoruteCount); // 찜 상품 수량
        session.setAttribute("memId", member.getMemberId()); // member seq 값
        session.setAttribute("memName", member.getName()); // memberName
        session.setAttribute("memNickName", member.getNickname()); // memberNickName
        return "ok";
    }

    public MemberDTO findId(String phone) {
        return memberRepository.findIdByPhone(phone);
    }


    public String mobile(String phoneNumber) { // 휴대폰 인증
        naverSMS naverSMS = new naverSMS();
        String randomN = naverSMS.randomNum(4);
        naverSMS.sendSMS(phoneNumber, randomN);
        session.setMaxInactiveInterval(3*60);
        session.setAttribute("randomN", randomN);
        log.info("randomN : " + randomN);
        return "sendingOk";
    }

    public boolean precenseCheck(Map<String, String> map) {
        Member member = memberRepository.findByPhone(map.get("idSearch_phone"));

        if(member.getMemberId() == null) {
            return true; // id 없음
        } // if
        session.setAttribute("findIdseq", member.getMemberId());
        return false; // id 있음
    }

    public Member findSuccess() {
        Long memberId = (Long) session.getAttribute("findIdseq");
        Member member = memberRepository.getInformationL(memberId);

        return member;
    }

    public boolean pwdCheck(String loginId) {
        Member member = memberRepository.findByLoginId(loginId);

        if(member.getMemberId() == null) {
            return true;
        } // if

        session.setAttribute("findIdseq", member.getMemberId());
        return false;
    }

//    @Transactional
//    public void pwdResetOk(String d_repwd) {
//        Long memberId = (Long) session.getAttribute("findIdseq");
//        log.info("----------------memberId : " + memberId);
//        memberRepository.modifyPwd(d_repwd, memberId);
//    }

    //시큐리티 적용됨
    @Transactional
    public void pwdResetOk(String d_repwd) {
        Long memberId = (Long) session.getAttribute("findIdseq");
        String encodedPassword = passwordEncoder.encode(d_repwd); // password security 1
        log.info("----------------memberId : " + memberId);
        memberRepository.modifyPwd(encodedPassword, memberId);
    }

    @Transactional
    public void logoutLog(long memId) {

        Long id = loginHistoryMapper.getLoginLog(memId);
        loginHistoryMapper.logoutLog(id);
    }

    public MemberMapperDTO getInformation() {
        long seq_member = (long)session.getAttribute("joinseq");

        MemberMapperDTO memberMapperDTO = memberMapper.getInformation(seq_member);
        return memberMapperDTO;
    }

    public MemberMapperDTO getMemberInformation() {
        long memId = (long) session.getAttribute("memId");
        MemberMapperDTO memberMapperDTO = memberMapper.getMemberInformation(memId);

        return memberMapperDTO;
    }

    public void updateMember(Map<String, String> map) {
        String memberId = session.getAttribute("memId") + "";
        String social = session.getAttribute("social") + "";
        map.put("memberId", memberId);

        //일반 회원인 경우
        if(social.equals("일반")) {
            memberMapper.updateMember(map);
        } else { //소셜 회원인 경우
            memberMapper.updateSocialMember(map);
        } // else
    }

    public MemberMapperDTO checkMember(Map<String, String> map) {
        String memberId = session.getAttribute("memId") + "";
        map.put("memberId", memberId);
        return memberMapper.checkMember(map);
    }

    @Transactional
    public String withdrawal() {
        long memId = (long)session.getAttribute("memId");
        MemberMapperDTO memberMapperDTO = memberMapper.getMemberInformation(memId);
        System.out.println("widthdrawal>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>DTO" + memberMapperDTO);
        withDrawalMapper.withdrawalSave(memberMapperDTO);
        memberMapper.deleteMember(memId);
        session.invalidate();
        return "success";
    }

    public MemberMapperDTO getMemberInfo() {
        String memberId = session.getAttribute("memId") + "";
        return memberMapper.getInformationL(memberId);
    }

    public List<MemberMapperDTO> getMemberByProductReview(List<ReviewPlusMapperDTO> reviewList) {
        return memberMapper.getMemberByProductReview(reviewList);
    }

    //개인 정보 수정
    public String myPagePwdCheck(String pwd) {
        long memId = (long) session.getAttribute("memId");

        MemberMapperDTO memberMapperDTO = memberMapper.myPagePwdCheck(memId);
        if(!passwordEncoder.matches(pwd, memberMapperDTO.getPwd())){
            log.info("비밀번호 불일치");
            return "fail";
        }// if
        return "true";
    }
}
