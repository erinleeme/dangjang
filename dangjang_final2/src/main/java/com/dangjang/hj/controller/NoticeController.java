package com.dangjang.hj.controller;

import com.dangjang.dto.NoticeMapperDTO;
import com.dangjang.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Log4j2
@RequiredArgsConstructor
public class NoticeController {
    @Autowired
    private final NoticeService noticeService;

    //최신 4개만
    @PostMapping(value="/dangjang/shop/main/notice")
    @ResponseBody
    public List<NoticeMapperDTO> getNoticeFour(Model model) {
        log.info("----------------main----notice list 4ea");
        return noticeService.find4ForMainList();

    }

    // 고객센터 메인(default) & 공지사항
    @GetMapping(value="/dangjang/shop/cs/notice")
    public String csNotice(@RequestParam(required = false, defaultValue = "1") String pg,
                           Model model){

        model.addAttribute("display", "shop/csMain.jsp");
        model.addAttribute("cs_display", "csNotice.jsp");
        model.addAttribute("noticePg", pg);
        log.info("----------고객센터 메인 뿌리기 pg " + pg);
        return "index";
    }

    //공지사항 전체목록
    @PostMapping(value="/dangjang/shop/cs/noticeList")
    @ResponseBody
    public Map<String, Object> getNoticeList(@RequestParam(required = false, defaultValue = "1") String pg,
                                             Model model) {
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("list", noticeService.getNoticeList(pg));
        map.put("paging", noticeService.paging(pg));
        map.put("pg", pg);
        model.addAttribute("noticePg", pg);

        log.info("----------------cs----notice list----page: " + pg);

        return map;
    }

    // 공지사항 1개만
    @GetMapping(value = "/dangjang/shop/cs/noticeView")
    public String getNoticeView(@RequestParam String pg,
                                @RequestParam String no,
                                Model model){

        NoticeMapperDTO noticeMapperDTO = noticeService.getNotice(no);
        String date = noticeMapperDTO.getCreate_date().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")); // 날짜 가공

        model.addAttribute("pg", pg);
        model.addAttribute("notice", noticeMapperDTO);
        model.addAttribute("date", date);
        model.addAttribute("display", "shop/csMain.jsp");
        model.addAttribute("cs_display", "csNoticeOne.jsp");

        log.info("----------------cs----notice no: "+no);

        return "index";
    };

    // 검색
    @PostMapping(value="/dangjang/shop/cs/notice/search")
    @ResponseBody
    public Map<String, Object> searchNotice(@RequestParam(required = false, defaultValue = "1") String pg,
                                            @RequestParam String keyword,
                                            Model model){
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("list", noticeService.getSearchNoticeList(pg, keyword));
        map.put("paging", noticeService.searchPaging(pg, keyword));
        map.put("pg", pg);
        model.addAttribute("pg", pg);

        log.info("----------------cs----search notice list----page: " + pg + " ----keyword: " + keyword);

        return map;
    }


}
