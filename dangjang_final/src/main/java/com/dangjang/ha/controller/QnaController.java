package com.dangjang.ha.controller;

import com.dangjang.dto.*;
import com.dangjang.mapper.QnaMapper;
import com.dangjang.service.ImageContentService;
import com.dangjang.service.ProductService;
import com.dangjang.service.QnaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@Log4j2
@RequestMapping(value="/dangjang/mypage/qna")
@RequiredArgsConstructor
public class QnaController {
    private final QnaService qnaService;
    private final ProductService productService;
    private final ImageContentService imageContentService;

    //qna 목록 갖고오기
    @GetMapping("/getQnaList")
    //@ResponseBody
    public String getQnaList(@RequestParam(required = false, defaultValue = "1") String pg, Model model) {
        List<QnAMapperSDTO> qnaList = qnaService.getQnsList(pg);
        System.out.println("qnaList-----------------------------------------" + qnaList);

        List<ProductMapperDTO> qnaProductList = productService.getQnaProductList(qnaList);
        System.out.println("qnaProductList------------------------------------" + qnaProductList.size());

        List<BasicProductMapperDTO> qnaSerialList = imageContentService.productImage(qnaProductList);
        System.out.println("qnaSerialList------------------------------------" + qnaSerialList);

        Map<String, Object> map = new HashMap<>();
        map.put("qnaList", qnaList);
        map.put("qnaSerialList", qnaSerialList);
        map.put("qnaPaging", qnaService.paging(pg));
        map.put("qnaProductList",qnaProductList);

        model.addAttribute("qnaList", qnaList);
        model.addAttribute("qnaProductList", qnaProductList);
        model.addAttribute("qnaSerialList", qnaSerialList);

        return "/mypage/snb09_02prodQna";
    }

    //qna 삭제
    @PostMapping(value="/deleteQna")
    @ResponseBody
    public void deleteOto(@RequestParam Map<String, String> map) {
        //해당 상품문의에 답변이 달렸는지 아닌지 확인
        //QnAMapperDTO qnaMapperDTO = qnaService.checkReplyQna(map);
        qnaService.deleteQna(map);
    }

    //qna 수정
    @PostMapping(value="/updateQna")
    @ResponseBody
    public void updateQna(@RequestParam Map<String, String> map) {
        System.out.println("updateQna >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + map);
        qnaService.updateQna(map);
    }

    //Qna 등록
    @GetMapping(value="/writeQna")
    @ResponseBody
    public void writeQna(@RequestParam Map<String, String> map) {
        qnaService.writeQna(map);
    }

}
