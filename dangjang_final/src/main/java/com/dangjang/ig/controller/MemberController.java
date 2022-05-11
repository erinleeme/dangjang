package com.dangjang.ig.controller;

import com.dangjang.domain.Member;
import com.dangjang.domain.type.Social;
import com.dangjang.dto.MemberMapperDTO;
import com.dangjang.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Controller
@RequestMapping(value="/dangjang/shop")
@RequiredArgsConstructor
@Log
public class MemberController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private HttpSession session;

    @GetMapping("/main")
    public String index(){
        log.info("----------------main / index start");
        return "index";
    }

    @GetMapping("/member/join/list") // 회원가임 list 폼 이동
    public String registerForm(Model model) {
        log.info("---------------join/list");
        model.addAttribute("display", "member/joinList.jsp");
        return "index";
    }

    @GetMapping("/member/join") // 일반 회원가입 폼 이동
    public String join(Model model){
        log.info("---------------joinForm");
        model.addAttribute("display", "member/join.jsp");
        return "index";
    }

    @PostMapping("/member/join/kakaoSession")
    @ResponseBody
    public String kakaoSession(@RequestParam Map<String, String> map) {
        log.info("----------------------- kakaoSession");
        session.setAttribute("kakaoName",map.get("kakao_account[profile][nickname]"));
        session.setAttribute("kakaoEmail", map.get("kakao_account[email]"));
        return "Ok";
    }

    @GetMapping("/member/join/kakao")
    public String kakaoJoin(Model model) {
        log.info("-------------------------join/ kakao");
        model.addAttribute("display", "member/joinkakao.jsp");
        return "index";
    }

    @PostMapping("/member/join/joinOk") // 회원가입 정보 저장
    @ResponseBody
    public String joinOk(@RequestParam Map<String, String> map) {
        log.info("----------join/Ok  map : " + map);

        if(map.get("kakaojoinForm") != null) { // 간편 회원가입
            memberService.socialregister(map);
            return "joinOk";
        } else { // 일반 회원가입
            memberService.register(map);
            return "joinOk";
        }
    }

    @PostMapping("/member/join/overlapCheck") // 중복체크 ( id, phone, (email) )
    @ResponseBody
    public boolean overlapCheck(@RequestParam Map<String, String> map) {
        log.info("map : " + map + "  id : " + map.get("id"));
        log.info("phone : " + map.get("phone"));
        log.info("email : " + map.get("email"));
        log.info("nickName : " + map.get("nickName"));

        return memberService.overlapCheck(map);
    }

    @PostMapping("/member/mobile") // 인증번호 발송
    @ResponseBody
    public String mobile(@RequestParam String phoneNumber) {
        log.info("---------------------mobile    phoneNumber = " + phoneNumber);
        return memberService.mobile(phoneNumber);
    }

    @PostMapping("/member/certify") // 인증번호 일치확인
    @ResponseBody
    public String certify(@RequestParam Map<String, String> map) {
        log.info("------------------certify : " + map);
        log.info("randomN : " + map.get("certifyNum"));
        String randomN = (String)session.getAttribute("randomN");
        log.info("randomN2 : " + randomN);
        if(randomN.equals(map.get("certifyNum"))) {
            return "Ok";
        }
        return "fail";
    }

    @GetMapping("/member/login") // 로그인 폼 이동
    public String loginForm(Model model) {
        model.addAttribute("display", "member/login.jsp");

        log.info("---------login Form 이동");
        return "index";
    }

    @PostMapping("/member/loginOk") // 로그인 return 값 : loginOk or fail
    @ResponseBody
    public String loginOk(@RequestParam Map<String, String> map) {
        log.info("---------login" + map);
        return memberService.loginOk(map);
    }

    @PostMapping("/member/kakaoLogin") // social login // db 정보가 null일시 socialregister 로 이동
    @ResponseBody
    public String socialLogin(@RequestParam Map<String, String> map) {
        log.info("map : " + map);
        String email = map.get("kakao_account[email]");
        int idx = email.indexOf("@");
        String email1 = email.substring(0, idx);
        String email2 = email.substring(idx+1);
        String name = map.get("kakao_account[profile][nickname]");

        session.setAttribute("kakaoEmail", email);
        session.setAttribute("kakaoName", name);

        log.info(map.get("platForm"));
        return memberService.socialLogin(email1, email2);
    }

    @RequestMapping("/member/logout")
    public String logout() { // session값 삭제
        long memId = (Long) session.getAttribute("memId");
        session.invalidate();
        memberService.logoutLog(memId);
        return index();
    }

    @GetMapping("/member/find/id") // id찾기 form 이동
    public String findIdForm(Model model) {
        log.info("---------------find/id Form ");
        model.addAttribute("display", "member/idSearch.jsp");
        return "index";
    }
    @PostMapping("/member/join/precenseCheck") // id 찾기 시 유/무 확인
    @ResponseBody
    public boolean precenseCheck(@RequestParam Map<String, String> map) {
        log.info("-----------precenseCheck       map : " + map);
        log.info(("------------- idSearch_name : " + map.get("idSearch_name")));

        return memberService.precenseCheck(map);
    }

    @GetMapping("/member/find/id/success")
    public String findSuccess(Model model) {
        log.info("-----------------------------------findSuccess");
        Member member = memberService.findSuccess();
        if(member.getPlatform() != Social.일반) {
            model.addAttribute("memId", member.getPlatform() + " 가입회원 입니다.");
        } else {
            model.addAttribute("memId", member.getLoginId());
        }// else
        String yyyyMMdd = member.getCreateDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        log.info("------------------------ date : " + yyyyMMdd);
        model.addAttribute("joinDate", yyyyMMdd);
        model.addAttribute("display", "member/idResult.jsp");
        return "index";
    }

    @GetMapping("/member/find/pwd") // pwd 찾기 form 이동
    public String findPwdForm(Model model) {
        model.addAttribute("display", "member/pwdSearch.jsp");
        return "index";
    }

    @PostMapping("/member/find/pwdCheck") // id, pwd 일치하는 데이터가 있는지
    @ResponseBody
    public boolean pwdCheck(@RequestParam Map<String, String> map) {
        log.info("-------------------pwdCheck        searchID : " + map.get("pwdSearch_id"));
        return memberService.pwdCheck(map.get("pwdSearch_id"));
    }

    @GetMapping("/member/find/pwd/reset")
    public String pwdResetForm(Model model) {
        log.info("-------------pwdResetForm");

        model.addAttribute("display", "member/pwdModify.jsp");
        return "index";
    }

    @PostMapping("/member/pwd/resetOk")
    @ResponseBody
    public void pwdResetOk(@RequestParam Map<String, String> map) {
        log.info("-------------------- pwdResetOk   map : " + map);
        log.info("------------------ pwd : " + map.get("d_repwd"));
        memberService.pwdResetOk(map.get("d_repwd"));
    }

    @GetMapping("/member/join/success")
    public String joinOk(@RequestParam String l
                        ,Model model) {
        MemberMapperDTO MemberMapperDTO = memberService.getInformation();
        log.info("memberDTO : " + MemberMapperDTO);
        String yyyyMMdd = MemberMapperDTO.getCreate_date().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        model.addAttribute("id", MemberMapperDTO.getLogin_id());
        model.addAttribute("name", MemberMapperDTO.getName());
        model.addAttribute("email", MemberMapperDTO.getEmail1()+'@'+MemberMapperDTO.getEmail2());
        model.addAttribute("memberDTO", MemberMapperDTO);
        model.addAttribute("joinDate", yyyyMMdd);
        if(l.equals("d")){
            model.addAttribute("social", "nope");
        } else if(l.equals("k")) {
            model.addAttribute("social", "kakao");
        }
        model.addAttribute("display", "member/joinResult.jsp");
        return "index";
    }

    @PostMapping("/pwdCheck")
    @ResponseBody
    public String pwdCheck(@RequestParam String pwd) {
        return memberService.myPagePwdCheck(pwd);
    }

}
