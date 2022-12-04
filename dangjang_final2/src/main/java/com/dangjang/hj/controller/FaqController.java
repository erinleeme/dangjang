package com.dangjang.hj.controller;

import com.dangjang.domain.FAQ;
import com.dangjang.dto.FAQMapperDTO;
import com.dangjang.service.FAQService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Log4j2
@RequiredArgsConstructor
public class FaqController {
    private final FAQService faqService;

    // 메인 - 최신 4개만 뿌려주기
    @PostMapping(value="/dangjang/shop/main/faq")
    @ResponseBody
    public List<FAQMapperDTO> getFaqFour() {
        log.info("----------------main----faq list 4ea");
        return faqService.getFaqFour();
    }
    // 고객센터 - FAQ
    @GetMapping(value="/dangjang/shop/cs/faq")
    public String csFaq(@RequestParam(required = false, defaultValue = "1") String pg,
                        Model model){
        model.addAttribute("display", "shop/csMain.jsp");
        model.addAttribute("cs_display", "csFaq.jsp");
        model.addAttribute("FaqPg", pg);
        log.info("----------------cs main----고객센터 faq");
        return "index";
    }

    //FAQ 전체목록
    @PostMapping(value="/dangjang/shop/cs/faqList")
    @ResponseBody
    public Map<String, Object> getFaqList(@RequestParam(required = false, defaultValue = "1") String pg,
                                          @RequestParam String faqType,
                                          Model model) {
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("faqList", faqService.getFaqList(pg, faqType));
        map.put("paging", faqService.paging(pg, faqType));

        model.addAttribute("FaqPg", pg);
        model.addAttribute("faqType", faqType);
        log.info("----------------cs----faq list----page: " + pg + " ----faqType: " + faqType);
        return map;
    }

    // 검색
    @PostMapping(value="/dangjang/shop/cs/faq/search")
    @ResponseBody
    public Map<String, Object> searchFaq(@RequestParam(required = false, defaultValue = "1") String pg,
                                         @RequestParam String keyword,
                                         Model model){
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("list", faqService.getSearchList(pg, keyword));
        map.put("paging", faqService.searchPaging(pg, keyword));

        model.addAttribute("FaqPg", pg);

        log.info("----------------cs----search notice list----page: " + pg + " ----keyword: " + keyword);

        return map;
    }



}
